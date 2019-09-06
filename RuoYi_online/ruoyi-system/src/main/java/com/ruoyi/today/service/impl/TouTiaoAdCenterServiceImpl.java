package com.ruoyi.today.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.today.TouTiaoApiConfig;
import com.ruoyi.today.domain.request.AdGroupCreateRequest;
import com.ruoyi.today.domain.request.AdGroupSelectRequest;
import com.ruoyi.today.domain.request.PlanSyncRequest;
import com.ruoyi.today.domain.response.*;
import com.ruoyi.today.http.HttpBuilder;
import com.ruoyi.today.service.AdCenterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

@Service("touTiaoAdCenterService")
public class TouTiaoAdCenterServiceImpl implements AdCenterService {

    @Autowired
    TouTiaoApiConfig touTiaoApiConfig;
    @Autowired
    HttpBuilder httpBuilder;

    private static Logger logger = LoggerFactory.getLogger(TouTiaoAdCenterServiceImpl.class);

    @Override
    public Object createAdPlan(Object plan) {

        HttpHeaders headers = httpBuilder.buildTouTiaoHeader();
        HttpEntity<String> request = new HttpEntity<>(JSON.toJSONString(plan), headers);
        logger.info("创建广告计划请求报文：" + JSON.toJSONString(request));
        PlanCreateResponse response = httpBuilder.buildRestTemplate().postForObject(touTiaoApiConfig.getAdPlanAPIUrls().get("createPlan"), request, PlanCreateResponse.class);
        logger.info("创建广告计划响应报文：" + JSON.toJSONString(response));
        return response;
    }

    @Override
    public Object updateAdPlanStatus(Object plan) {

        HttpHeaders headers = httpBuilder.buildTouTiaoHeader();
        HttpEntity<String> request = new HttpEntity<>(JSON.toJSONString(plan), headers);
        logger.info("更新广告计划请求报文：" + JSON.toJSONString(request));
        PlanUpdateStatusResponse response = httpBuilder.buildRestTemplate().postForObject(touTiaoApiConfig.getAdPlanAPIUrls().get("updateStatusPlan"), request, PlanUpdateStatusResponse.class);
        logger.info("更新广告计划响应报文：" + JSON.toJSONString(response));
        return response;

    }

    @Override
    public Object updateAdPlan(Object plan) {


        HttpHeaders headers = httpBuilder.buildTouTiaoHeader();
        HttpEntity<String> request = new HttpEntity<>(JSON.toJSONString(plan), headers);
        logger.info("更新广告计划请求报文：" + JSON.toJSONString(request));
        PlanUpdateResponse response = httpBuilder.buildRestTemplate().postForObject(touTiaoApiConfig.getAdPlanAPIUrls().get("updatePlan"), request, PlanUpdateResponse.class);
        logger.info("更新广告计划响应报文：" + JSON.toJSONString(response));

        return  response;

    }

    /**
     * 查询广告计划
     *
     * @param plan
     * @return
     */
    @Override
    public Object selectPlan(Object plan) {

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(touTiaoApiConfig.getAdPlanAPIUrls().get("getPlan"));

        HttpHeaders headers = httpBuilder.buildTouTiaoHeader();
        // 获取单例RestTemplate
        RestTemplate restTemplate = httpBuilder.buildRestTemplate();
        HttpEntity request = new HttpEntity(headers);
        // 构造execute()执行所需要的参数。
        RequestCallback requestCallback = restTemplate.httpEntityCallback(request, JSONObject.class);
        ResponseExtractor<ResponseEntity<JSONObject>> responseExtractor = restTemplate.responseEntityExtractor(JSONObject.class);
        //查询条件
        PlanSyncRequest syncRequest = (PlanSyncRequest) plan;
        Map<String, Object> params = syncRequest.requestMap();
        params.entrySet().stream().forEach(o -> builder.queryParam(o.getKey(), o.getValue()));
        // 执行execute()，发送请求
        logger.info("同步广告计划请求报文：" + JSON.toJSONString(plan));
        ResponseEntity<JSONObject> responseObject = restTemplate.execute(builder.build().toUriString(), HttpMethod.GET, requestCallback, responseExtractor, syncRequest.getFiltering());
        logger.info("同步广告计划响应报文：" + responseObject.getBody().toJSONString());
        PlanSyncResponse response = JSON.parseObject(responseObject.getBody().toJSONString(), PlanSyncResponse.class);
        return response;
    }

    /**
     * 查询广告组
     *
     * @param plan
     * @return
     */
    @Override
    public Object selectGroup(Object plan) {

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(touTiaoApiConfig.getAdGroupAPIUrls().get("getGroup"));

        HttpHeaders headers = httpBuilder.buildTouTiaoHeader();
        // 获取单例RestTemplate
        RestTemplate restTemplate = httpBuilder.buildRestTemplate();
        HttpEntity request = new HttpEntity(headers);
        // 构造execute()执行所需要的参数。
        RequestCallback requestCallback = restTemplate.httpEntityCallback(request, JSONObject.class);
        ResponseExtractor<ResponseEntity<JSONObject>> responseExtractor = restTemplate.responseEntityExtractor(JSONObject.class);
        //查询条件
        AdGroupSelectRequest syncRequest = (AdGroupSelectRequest) plan;
        Map<String, Object> params = syncRequest.requestMap();
        params.entrySet().stream().forEach(o -> builder.queryParam(o.getKey(), o.getValue()));
        // 执行execute()，发送请求
        logger.info("同步广告计划请求报文：" + JSON.toJSONString(plan));
        ResponseEntity<JSONObject> responseObject = restTemplate.execute(builder.build().toUriString(), HttpMethod.GET, requestCallback, responseExtractor, syncRequest.getFiltering());
        logger.info("同步广告计划响应报文：" + responseObject.getBody().toJSONString());
        AdGroupSelectResponse response = JSON.parseObject(responseObject.getBody().toJSONString(), AdGroupSelectResponse.class);
        return response;
    }

    /**
     * 创建广告组
     *
     * @param group
     * @return
     */
    @Override
    public Object createGroup(Object group) {

        HttpHeaders headers = httpBuilder.buildTouTiaoHeader();
        HttpEntity<String> request = new HttpEntity<>(JSON.toJSONString(group), headers);
        logger.info("创建广告计划请求报文：" + JSON.toJSONString(request));
        AdGroupCreateResponse response = httpBuilder.buildRestTemplate().postForObject(touTiaoApiConfig.getAdGroupAPIUrls().get("createGroup"), request, AdGroupCreateResponse.class);
        logger.info("创建广告计划响应报文：" + JSON.toJSONString(response));

        return response;
    }


}
