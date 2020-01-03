package com.ruoyi.web.task;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.yiche.domain.Yiche;
import com.ruoyi.yiche.service.IYicheService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

//解析易车网页从上面爬取数据
@Component("yiCheTask")
public class YiCheTask {

    private static Logger logger = LoggerFactory.getLogger(YiCheTask.class);
    @Autowired
    private IYicheService yicheService;

    private BlockingQueue<Integer> numQueue;
    private BlockingQueue<Yiche> yiCheQueue;

    public void init() {
        this.numQueue = new LinkedBlockingQueue<>();
        this.yiCheQueue = new LinkedBlockingQueue<>();
    }

    public boolean crawlDataFromYiChe(int num) throws IOException, ParseException {
        try {
            System.out.println("----------------------------------------" + num);
            SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy/MM");
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy/MM/dd");
            SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("yyyy");

            RestTemplate restTemplate = new RestTemplate();
            String carListUrl = "http://select.car.yiche.com/selectcartool/searchresult?page={pageNum}&external=Car&v=20171011";
            String carDetailListUrl = "http://car.bitauto.com/{type}/m{carid}/";

            String targetUrlH5Url = "https://link.yiche.com/searchOrder/{id}/{carId}/?lg=0&tele=1&leads_source=H001005&ad=0&ly=xxj";
            String mpUrl = "baiduboxapp://swan/ajZbRijsUAMR5Il4I8oHOZptNixsev9k/pages/summaryNew/summaryNew?serialid={id}&carid={carId}&subordertype=0";
            String mtgurl = "https://link.yiche.com/multiordertg3/{}/{id}/?carid={carId}";


            int pageNum = num;
            String result = restTemplate.getForObject(carListUrl.replace("{pageNum}", String.valueOf(pageNum)), String.class);
            JSONObject data = JSON.parseObject(result);
            JSONArray resList = data.getJSONArray("ResList");
            if (resList.size() == 0) {
                return false;
            }
            String carId = null;
            String id = null;
            String text = null;
            String showName = null;
            for (int i = 0; i < resList.size(); i++) {
                JSONObject resData = resList.getJSONObject(i);
                showName = resData.getString("ShowName");
                String type = resData.getString("AllSpell");
                String carIdList = resData.getString("CarIdList");
                String[] carIds = carIdList.split(",");
                id = resData.getString("SerialId");


                for (int j = 0; j < carIds.length; j++) {
                    try {
                        carId = carIds[j];
                        Yiche yiche = new Yiche();
                        String carDetailListUrlStr = carDetailListUrl.replace("{type}", type);
                        carDetailListUrlStr = carDetailListUrlStr.replace("{carid}", carId);
                        Document document = Jsoup.connect(carDetailListUrlStr).get();
                        Elements header = document.getElementsByTag("header");
                        Elements select = header.select("div[class=crumbs-txt]");
                        Elements a = select.select("a");
                        List<String> strings = a.eachText();
                        List<String> hrefs = a.eachAttr("href");
                        if (strings.size() >= 3) {
                            yiche.setBrand(strings.get(2));
                        }
                        if (strings.size() >= 4) {
                            yiche.setManufacturer(strings.get(3));
                        }
                        yiche.setType(showName);
                        yiche.setSellername("易车");
                        Elements detail = document.select("div[class=layout-2 config-section]");
                        detail = detail.select("td");

                        text = detail.select("td:contains(车型级别)").next().text();//级别
                        yiche.setGrade(text);

                        text = detail.select("td:contains(厂商指导价)").next().text();//厂商指导价
                        if (text != null && !text.equals("")) {
                            yiche.setMsrp(text.substring(0, text.length() - 1));
                        }
                        yiche.setPriceunit("RMB");
                        yiche.setUnit("万元");

                        text = detail.select("td:contains(商家报价)").next().text();//商家报价
                        if (text != null && !text.equals("")) {
                            yiche.setPrice(text.substring(0, text.length() - 1));
                        }

                        text = detail.select("td:contains(上市日期)").next().text();//上市日期
                        if (text != null && !text.equals("")) {
                            yiche.setTimetomarket(simpleDateFormat1.format(simpleDateFormat2.parse(text)));
                        }

                        text = detail.select("td:contains(排气量)").next().text();//排气量
                        if (text != null && !text.equals("")) {
                            String volumeStr = text.substring(0, text.length() - 2);
                            double volumeNum = Double.parseDouble(volumeStr) / 1000;
                            yiche.setVolume(volumeNum + "");
                        }
                        yiche.setVolumeunit("L");

                        text = detail.select("td:contains(混合工况油耗)").next().text();//混合工况油耗
                        if (text != null && !text.equals("")) {
                            yiche.setIntegratedfuelconsumption(text.substring(0, text.length() - 7));
                        }

                        text = detail.select("td:contains(发动机：)").next().text();//发动机：
                        yiche.setEngine(text);
                        if (detail.select("td:contains(变速箱类型)").next().size() != 0) {
                            text = detail.select("td:contains(变速箱类型)").next().first().text();//变速箱类型
                            yiche.setGearbox(text);
                        }

                        text = detail.select("td:contains(最高车速)").next().text();//最高车速
                        if (text != null && !text.equals("")) {
                            yiche.setSpeed(text.substring(0, text.length() - 4));
                        }

                        text = detail.select("td:contains(车身型式)").next().text();//车身型式
                        yiche.setStructure(text);

                        text = detail.select("td:contains(加速时间)").next().text();//加速时间
                        if (text != null && !text.equals("")) {
                            yiche.setAccelerationtime(text.substring(0, text.length() - 1));
                        }

                        text = detail.select("td:contains(座位数)").next().text();//座位数
                        if (text != null && !text.equals("")) {
                            yiche.setSeatcapacity(text.substring(0, text.length() - 1));
                        }

                        text = detail.select("td:contains(动力类型)").next().text();//动力类型
                        yiche.setFuel(text);

                        text = detail.select("td:contains(环保标准)").next().text();//环保标准
                        yiche.setEnvironmentalstandard(text);

                        text = detail.select("td:contains(保修政策)").next().text();//保修政策
                        yiche.setQualityassurance(text);
                        //一
                        if (strings.size() >= 3) {
                            yiche.setCategory(strings.get(2));
                        }
                        if (hrefs.size() >= 3) {
                            yiche.setCategoryurl("http://car.m.yiche.com/brandlist" + hrefs.get(2));
                            yiche.setCategorypcurl("http://car.bitauto.com" + hrefs.get(2));
                        }
                        //二
                        if (strings.size() >= 4) {
                            yiche.setSubcategory(strings.get(3));
                        }
                        if (hrefs.size() >= 4) {
                            if (hrefs.size() == 4) {
                                String[] split = hrefs.get(3).split("/");
                                yiche.setSubcategoryurl("http://car.m.yiche.com/" + split[split.length - 1]);
                                yiche.setSubcategorypcurl(hrefs.get(3));
                            } else {
                                String[] split = hrefs.get(3).split("/");
                                yiche.setSubcategoryurl("http://car.m.yiche.com/" + split[split.length - 1]);
                                yiche.setSubcategorypcurl("http://car.bitauto.com" + hrefs.get(3));
                            }
                        }
                        //三
                        yiche.setThirdcategory(type);
                        yiche.setThirdcategorypcurl("https://dealer.bitauto.com/zuidijia/nb" + id + "/nc" + carId + "/?leads_source=p013006");
                        yiche.setThirdcategoryurl("http://price.m.yiche.com/zuidijia/nb" + id + "/");

                        yiche.setKey1("targetUrlH5");
                        yiche.setValue1(targetUrlH5Url.replace("{id}", id).replace("{carId}", carId));
                        yiche.setKey2("mpUrl");
                        yiche.setValue2(mpUrl.replace("{id}", id).replace("{carId}", carId));
//                yiche.setKey3("mtgurl");
//                yiche.setValue3(mtgurl.replace("{id}", id).replace("{carId}", carId));

                        yiche.setLoc("https://price.m.yiche.com/zuidijia/nc" + carId + "/");
                        yiche.setPcloc("https://dealer.bitauto.com/zuidijia/nb" + id + "/nc" + carId + "/?leads_source=p013006");
                        Elements carPop = document.select("a[id=car-pop]");
                        yiche.setName(type + " " + carPop.text());
                        yiche.setOuterid(carId);
                        yiche.setBizcategory("新车");
                        Elements color = document.select("ul[id=color-listbox]");
                        List<String> title = color.select("a").eachAttr("title");
                        yiche.setExteriorcolor(String.join(";", title));//外观颜色

                        text = detail.select("td:contains(上市日期)").next().text();//上市日期
                        if (text != null && !text.equals("")) {
                            yiche.setModelyear(simpleDateFormat3.format(simpleDateFormat2.parse(text)) + "款");
                        }
                        List<String> pictureHelf = document.select("div[class=content clearfix]").select("a").eachAttr("href");
                        Document prictureDoc = Jsoup.connect(pictureHelf.get(0)).get();
                        List<String> pictureSrc = prictureDoc.select("ul[id=smallimgswrapper]").select("img").eachAttr("src");
                        yiche.setImage(document.select("div[class=content clearfix]").select("a").first().select("img").attr("src"));
                        if (pictureSrc.size() > 4) {
                            yiche.setMoreimages1(pictureSrc.get(1));
                            yiche.setMoreimages2(pictureSrc.get(2));
                            yiche.setMoreimages3(pictureSrc.get(3));
                        }
                        yicheService.insertYiche(yiche);
//                        yiCheQueue.put(yiche);
//                yiche.setInteriorcolor();//内饰颜色
//                yiche.setNationality();//国别
//                yiche.setEnbrand();//英文品牌

                    } catch (Exception e) {
                        throw e;
                    }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            return true;
        }
    }

    public void start() throws Exception {

//        init();

        for (int i = 1; i <= 100; i++) {
//            numQueue.put(i);
            crawlDataFromYiChe(i);
        }
//        for (int i = 0; i < 1; i++) {
//            Runnable runnable = new Runnable() {
//                @Override
//                public void run() {
//                    try {
//
//                        int num = numQueue.take();
//                        while (crawlDataFromYiChe(num)) {
//                            num = numQueue.take();
//                        }
//
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//            };
//            Thread thread = new Thread(runnable);
//            thread.start();
//        }
//        try {
//            while (true) {
//                Yiche yiche = yiCheQueue.poll(10, TimeUnit.SECONDS);
//                yicheService.insertYiche(yiche);
//            }
//        }catch (Exception e){
//
//        }
        System.out.println("数据获取完成");
    }


}
