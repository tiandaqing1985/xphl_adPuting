package com.ruoyi.web.task;

import com.alibaba.fastjson.JSONArray;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.today.domain.ThAdvertiser;
import com.ruoyi.today.domain.ThTodayMatter;
import com.ruoyi.today.domain.request.GetImagesRequest;
import com.ruoyi.today.domain.response.ResponseVO;
import com.ruoyi.today.service.AdCenterService;
import com.ruoyi.today.service.IThAdvertiserService;
import com.ruoyi.today.service.IThTodayMatterService;
import com.ruoyi.today.tools.MultiThreadExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;

@Component("syncTodayMatterTask")
public class SyncTodayMatterTask extends MultiThreadExecutor<ThTodayMatter> {

    private static Logger logger = LoggerFactory.getLogger(SyncTodayMatterTask.class);

    @Autowired
    private IThAdvertiserService thAdvertiserService;
    @Autowired
    private AdCenterService touTiaoAdCenterService;
    @Autowired
    private IThTodayMatterService thTodayMatterService;

    private StringBuffer productExceptionMsg;
    private StringBuffer comsumeExceptionMsg;
    private LinkedBlockingQueue<String> advertieserQueue;

    @Override
    protected void product(LinkedBlockingQueue<ThTodayMatter> storage) {

        logger.info("生产者线程" + Thread.currentThread().getName() + "开始");
        String advertieserId = null;
        try {
            advertieserId = advertieserQueue.take();
            while (!advertieserId.equals("")) {
                int page = 1;
                int pageSize = 100;
                int totalPage = -1;
                GetImagesRequest request = new GetImagesRequest();
                request.setAdvertiser_id(advertieserId);
                request.setPage_size(pageSize);
                ThTodayMatter thTodayMatter = new ThTodayMatter();
                while (totalPage < 0 || page <= totalPage) {
                    request.setPage(page);
                    ResponseVO resp = (ResponseVO) touTiaoAdCenterService.getVideo(request);
                    if (resp.getCode().equals("0")) {
                        totalPage = resp.getData().getJSONObject("page_info").getIntValue("total_page");
                        page++;
                        JSONArray list = resp.getData().getJSONArray("list");
                        for (int i = 0; i < list.size(); i++) {
                            thTodayMatter = new ThTodayMatter();
                            thTodayMatter.setAdvertiserId(advertieserId);
                            thTodayMatter.setType("video");
                            thTodayMatter.setSignature(list.getJSONObject(i).getString("signature"));
                            thTodayMatter.setTodayId(list.getJSONObject(i).getString("material_id"));
                            thTodayMatter.setCreateTime(DateUtils.getNowDate());
                            storage.put(thTodayMatter);
                        }
                    } else if (resp.getCode().equals("40100")) {
                        continue;
                    } else {
                        throw new Exception(advertieserId + ":" + resp.getCode() + resp.getMessage());
                    }
                }
                advertieserId = advertieserQueue.take();
            }
            advertieserQueue.put("");
        } catch (Exception e) {
            logger.error("出现错误", e);
            productExceptionMsg.append(e.getMessage() + "\n");
        }
    }

    @Override
    protected void productEnd(LinkedBlockingQueue<ThTodayMatter> storage, CountDownLatch countDownLatch) {

        if (countDownLatch.getCount() == 1) {
            try {
                storage.put(new ThTodayMatter());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        logger.info("生产者线程" + Thread.currentThread().getName() + "结束");
    }

    @Override
    protected void consume(LinkedBlockingQueue<ThTodayMatter> storage) {
        logger.info("消费者线程" + Thread.currentThread().getName() + "开始");
        ThTodayMatter thTodayMatter = null;
        try {
            thTodayMatter = storage.take();
            while (thTodayMatter.getAdvertiserId() != null) {
                thTodayMatterService.insertThTodayMatter(thTodayMatter);
                thTodayMatter = storage.take();
            }
            storage.put(thTodayMatter);
        } catch (Exception e) {
            logger.error("消费者线程出现错误" + thTodayMatter.getAdvertiserId() + "：", e);
            comsumeExceptionMsg.append(e.getMessage() + "\n");
        } finally {
            logger.info("消费者线程" + Thread.currentThread().getName() + "结束");
        }

    }

    public void syncAdvertieserMatter(ThAdvertiser thAdvertiser) throws Exception {
        int page = 1;
        int pageSize = 100;
        int totalPage = -1;
        GetImagesRequest request = new GetImagesRequest();
        request.setAdvertiser_id(thAdvertiser.getId().toString());
        request.setPage_size(pageSize);
        ThTodayMatter thTodayMatter = new ThTodayMatter();
        thTodayMatter.setAdvertiserId(thAdvertiser.getId().toString());
        thTodayMatter.setType("image");
        while (totalPage < 0 || page <= totalPage) {
            request.setPage(page);
            ResponseVO resp = (ResponseVO) touTiaoAdCenterService.getImages(request);
            if (resp.getCode().equals("0")) {
                totalPage = resp.getData().getJSONObject("page_info").getIntValue("total_page");
                page++;
                JSONArray list = resp.getData().getJSONArray("list");
                for (int i = 0; i < list.size(); i++) {
                    thTodayMatter.setId(null);
                    thTodayMatter.setSignature(list.getJSONObject(i).getString("signature"));
                    thTodayMatter.setTodayId(list.getJSONObject(i).getString("id"));
                    thTodayMatter.setCreateTime(DateUtils.getNowDate());
                    thTodayMatterService.insertThTodayMatter(thTodayMatter);
                }
            } else {
                throw new Exception(resp.getCode() + resp.getMessage());
            }
        }

    }

    public void syncMatter() throws Exception {

        logger.info("开始同步广告主图片素材" + DateUtils.getDate());
        thTodayMatterService.deleteAllThTodayMatter();
        productExceptionMsg = new StringBuffer();
        comsumeExceptionMsg = new StringBuffer();
        advertieserQueue = new LinkedBlockingQueue<>();
        List<ThAdvertiser> thAdvertisers = thAdvertiserService.selectThAdvertiserList(new ThAdvertiser());

        start(6, 5, 600);
        for (ThAdvertiser thAdvertiser : thAdvertisers) {
            advertieserQueue.put(thAdvertiser.getId().toString());
        }
        advertieserQueue.put("");

        await();
        if (productExceptionMsg.length() != 0) {
            throw new Exception(productExceptionMsg.toString());
        }
        if (comsumeExceptionMsg.length() != 0) {
            throw new Exception(comsumeExceptionMsg.toString());
        }

        logger.info("同步广告主图片素材结束" + DateUtils.getDate());

    }

}
