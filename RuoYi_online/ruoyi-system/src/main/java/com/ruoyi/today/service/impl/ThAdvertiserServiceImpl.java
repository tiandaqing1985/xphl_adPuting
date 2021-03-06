package com.ruoyi.today.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.*;

import com.ruoyi.common.utils.DateUtils;

import com.ruoyi.today.domain.ThToken;
import com.ruoyi.today.service.AdCenterService;
import com.ruoyi.today.service.IThTokenService;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ruoyi.today.mapper.ThAdvertiserMapper;
import com.ruoyi.today.domain.ThAdvertiser;
import com.ruoyi.today.service.IThAdvertiserService;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.core.text.Convert;

/**
 * 广告主Service业务层处理
 *
 * @author ruoyi
 * @date 2019-08-12
 */
@Service
public class ThAdvertiserServiceImpl implements IThAdvertiserService {
    @Autowired
    private ThAdvertiserMapper thAdvertiserMapper;
    @Autowired
    private IThTokenService thTokenService;

    private Logger logger = LoggerFactory.getLogger(ThAdvertiserServiceImpl.class);

    /**
     * 查询广告主
     *
     * @param id 广告主ID
     * @return 广告主
     */
    @Override
    public ThAdvertiser selectThAdvertiserById(Long id) {
        return thAdvertiserMapper.selectThAdvertiserById(id);
    }

    /**
     * 查询广告主列表
     *
     * @param thAdvertiser 广告主
     * @return 广告主
     */
    @Override
    public List<ThAdvertiser> selectThAdvertiserList(ThAdvertiser thAdvertiser) {
        return thAdvertiserMapper.selectThAdvertiserList(thAdvertiser);
    }

    /**
     * 新增广告主
     *
     * @param thAdvertiser 广告主
     * @return 结果
     */
    @Override
    public int insertThAdvertiser(ThAdvertiser thAdvertiser) {
        thAdvertiser.setCreateTime(DateUtils.getNowDate());
        return thAdvertiserMapper.insertThAdvertiser(thAdvertiser);
    }

    /**
     * 修改广告主
     *
     * @param thAdvertiser 广告主
     * @return 结果
     */
    @Override
    public int updateThAdvertiser(ThAdvertiser thAdvertiser) {
        thAdvertiser.setUpdateTime(DateUtils.getNowDate());
        return thAdvertiserMapper.updateThAdvertiser(thAdvertiser);
    }

    /**
     * 删除广告主对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteThAdvertiserByIds(String ids) {
        return thAdvertiserMapper.deleteThAdvertiserByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除广告主信息
     *
     * @param id 广告主ID
     * @return 结果
     */
    public int deleteThAdvertiserById(Long id) {
        return thAdvertiserMapper.deleteThAdvertiserById(id);
    }

    @Override
    public int adMutual(String createBy) throws Exception {
        List<ThToken> thTokens = thTokenService.selectThTokenList(new ThToken());

        String access_token = thTokens.get(0).getAccessToken();
        StringBuffer error = new StringBuffer();
        thAdvertiserMapper.deleteThAdvertiserById(null);
        int page = 1;
        int totalPage = 1;
        int totalNum = 0;
        while (page <= totalPage) {

            JSONObject object = (JSONObject) selectAgentAdvertiser(access_token, page).get("data");
            totalPage = object.getJSONObject("page_info").getIntValue("total_page");
            JSONArray list = (JSONArray) object.get("list");
            page++;
            totalNum = totalNum + list.size();
            List<ThAdvertiser> thAdvertisers = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                try {
                    Long id = list.getLong(i);
//                    JSONObject object1 = getAdvertiserInfo(access_token, id);

//                    if(!object1.getString("code").equals("0")){
//                        continue;
//                    }
//                    JSONArray object2 = (JSONArray) object1.get("data");
//                    JSONObject object3 = (JSONObject) object2.get(0);

                    ThAdvertiser ta = new ThAdvertiser();

                    ta.setId(id);
                    ta.setCreateBy(createBy);
                    ta.setCreateTime(new Date());
                    thAdvertisers.add(ta);
                } catch (Exception e) {
                    logger.error(list.getLong(i) + "出现错误：", e);
                    error.append(list.getLong(i) + ":" + e.getMessage() + "\n");
                }
            }
            thAdvertiserMapper.insertThAdvertiserList(thAdvertisers);
        }
        if (error.length() != 0) {
            throw new Exception(error.toString());
        }
        return totalNum;
    }


    /**
     * 获取广告主列表
     *
     * @return
     */
    public JSONObject selectAgentAdvertiser(String access_token, int page) {
        final Long advertiser_id = 1630607157951491L;

        // 请求地址 https://ad.toutiao.com/open_api/2/agent/advertiser/select/
        String open_api_url_prefix = "https://ad.toutiao.com/open_api/2/";
        String uri = "agent/advertiser/select/";
        // 请求参数
        Map<String, Object> data = new HashMap<String, Object>() {
            {
                put("advertiser_id", advertiser_id);
                put("page", page);
                put("page_size", 1000);
            }
        };

        // 构造请求
        HttpEntityEnclosingRequestBase httpEntity = new HttpEntityEnclosingRequestBase() {
            @Override
            public String getMethod() {
                return "GET";
            }
        };

        httpEntity.setHeader("Access-Token", access_token);

        CloseableHttpResponse response = null;
        CloseableHttpClient client = null;

        try {
            client = HttpClientBuilder.create().build();
            httpEntity.setURI(URI.create(open_api_url_prefix + uri));
            httpEntity.setEntity(new StringEntity(JSONObject.toJSONString(data), ContentType.APPLICATION_JSON));

            response = client.execute(httpEntity);
            if (response != null && response.getStatusLine().getStatusCode() == 200) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
                StringBuffer result = new StringBuffer();
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    result.append(line);
                }
                bufferedReader.close();
                return JSONObject.parseObject(result.toString());
            }

        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 获取广告主信息
     *
     * @return
     */
    public static JSONObject getAdvertiserInfo(String access_token, Long advertiser_id) {

        // 请求地址
        String open_api_url_prefix = "https://ad.toutiao.com/open_api/2/";
        String uri = "advertiser/info/";

        // 请求参数
        Map<String, Object> data = new HashMap<String, Object>() {
            {
                put("advertiser_ids", new Long[]{advertiser_id});
                put("fields", new String[]{"id", "name", "email", "status"});
            }
        };

        // 构造请求
        HttpEntityEnclosingRequestBase httpEntity = new HttpEntityEnclosingRequestBase() {
            @Override
            public String getMethod() {
                return "GET";
            }
        };

        httpEntity.setHeader("Access-Token", access_token);

        CloseableHttpResponse response = null;
        CloseableHttpClient client = null;

        try {
            client = HttpClientBuilder.create().build();
            httpEntity.setURI(URI.create(open_api_url_prefix + uri));
            httpEntity.setEntity(new StringEntity(JSONObject.toJSONString(data), ContentType.APPLICATION_JSON));

            response = client.execute(httpEntity);
            if (response != null && response.getStatusLine().getStatusCode() == 200) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
                StringBuffer result = new StringBuffer();
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    result.append(line);
                }
                bufferedReader.close();
                return JSONObject.parseObject(result.toString());
            }

        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 根据广告主名称查询广告主
     *
     * @param advertiser
     * @return
     */
    public ThAdvertiser selectThAdvertiserByName(ThAdvertiser advertiser) {

        return thAdvertiserMapper.selectThAdvertiserByName(advertiser);

    }

}
