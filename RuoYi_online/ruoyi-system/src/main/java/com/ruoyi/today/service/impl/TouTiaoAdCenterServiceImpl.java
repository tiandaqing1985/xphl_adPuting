package com.ruoyi.today.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.today.TouTiaoApiConfig;
import com.ruoyi.today.domain.ThAdMateria;
import com.ruoyi.today.domain.ThCreativity;
import com.ruoyi.today.domain.request.*;
import com.ruoyi.today.domain.response.*;
import com.ruoyi.today.http.HttpBuilder;
import com.ruoyi.today.service.AdCenterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

@Service("touTiaoAdCenterService")
public class TouTiaoAdCenterServiceImpl implements AdCenterService {

    @Autowired
    TouTiaoApiConfig touTiaoApiConfig;
    @Autowired
    HttpBuilder httpBuilder;

    private static Logger logger = LoggerFactory.getLogger(TouTiaoAdCenterServiceImpl.class);

    public Object getIndustry() {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(touTiaoApiConfig.getTools().get("getIndustry"));

        HttpHeaders headers = httpBuilder.buildTouTiaoHeader();
        // 获取单例RestTemplate
        RestTemplate restTemplate = httpBuilder.buildRestTemplate();
        HttpEntity request = new HttpEntity(headers);
        // 构造execute()执行所需要的参数。
        RequestCallback requestCallback = restTemplate.httpEntityCallback(request, JSONObject.class);
        ResponseExtractor<ResponseEntity<JSONObject>> responseExtractor = restTemplate.responseEntityExtractor(JSONObject.class);
        // 执行execute()，发送请求
        ResponseEntity<JSONObject> responseObject = restTemplate.execute(builder.build().toUriString(), HttpMethod.GET, requestCallback, responseExtractor);
        logger.info("同步头条行业列表响应报文：" + responseObject.getBody().toJSONString());
        ResponseVO response = JSON.parseObject(responseObject.getBody().toJSONString(), ResponseVO.class);
        return response;
    }

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

        return response;

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
        logger.info("创建广告组请求报文：" + JSON.toJSONString(request));
        AdGroupCreateResponse response = httpBuilder.buildRestTemplate().postForObject(touTiaoApiConfig.getAdGroupAPIUrls().get("createGroup"), request, AdGroupCreateResponse.class);
        logger.info("创建广告组响应报文：" + JSON.toJSONString(response));

        return response;
    }

    /**
     * 上传视频
     */
    @Override
    public Object uploadVideoFile(Object object) {
        ThAdMateria materia = (ThAdMateria) object;
        //设置请求头
        HttpHeaders headers = httpBuilder.buildTouTiaoHeader();
        MediaType type = MediaType.parseMediaType("multipart/form-data");
        headers.setContentType(type);

        //设置请求体，注意是LinkedMultiValueMap
//        File reNameFile = new File(materia.getLocalPath().substring(0, materia.getLocalPath().lastIndexOf("/")) + "/" + materia.getFileName());
        File file = new File(materia.getLocalPath());
//        file.renameTo(reNameFile);
        FileSystemResource fileSystemResource = new FileSystemResource(file);
        MultiValueMap<String, Object> form = new LinkedMultiValueMap<>();
        form.add("video_file", fileSystemResource);
        form.add("advertiser_id", materia.getAdvertiserId());
        form.add("video_signature", materia.getMd5());

        //用HttpEntity封装整个请求报文
        HttpEntity<MultiValueMap<String, Object>> files = new HttpEntity<>(form, headers);

        RestTemplate restTemplate = new RestTemplate();
        long l1 = System.currentTimeMillis();
        ResponseVO response = restTemplate.postForObject(touTiaoApiConfig.getTools().get("uploadVideo"), files, ResponseVO.class);
        long l2 = System.currentTimeMillis();
        logger.info("耗时：" + (l2 - l1) + "ms");
        logger.info("上传视频响应报文：" + JSON.toJSONString(response));
        return response;
    }

    @Override
    public Object uploadImageFile(Object image) {
        ThAdMateria materia = (ThAdMateria) image;
        //设置请求头
        HttpHeaders headers = httpBuilder.buildTouTiaoHeader();
        MediaType type = MediaType.parseMediaType("multipart/form-data");
        headers.setContentType(type);

        //设置请求体，注意是LinkedMultiValueMap
//        File reNameFile = new File(materia.getLocalPath().substring(0, materia.getLocalPath().lastIndexOf("/")) + "/" + materia.getFileName());
        File file = new File(materia.getLocalPath());
//        file.renameTo(reNameFile);
        FileSystemResource fileSystemResource = new FileSystemResource(file);
        MultiValueMap<String, Object> form = new LinkedMultiValueMap<>();
        form.add("image_file", fileSystemResource);
        form.add("advertiser_id", materia.getAdvertiserId());
        form.add("image_signature", materia.getMd5());

        //用HttpEntity封装整个请求报文
        HttpEntity<MultiValueMap<String, Object>> files = new HttpEntity<>(form, headers);

        RestTemplate restTemplate = new RestTemplate();
        long l1 = System.currentTimeMillis();
        ResponseVO response = restTemplate.postForObject(touTiaoApiConfig.getTools().get("uploadImage"), files, ResponseVO.class);
        long l2 = System.currentTimeMillis();
        logger.info("耗时：" + (l2 - l1) + "ms");
        logger.info("上传视频响应报文：" + JSON.toJSONString(response));
        return response;
    }

    @Override
    public Object createCreativity(Object creativity) {

        HttpHeaders headers = httpBuilder.buildTouTiaoHeader();
        HttpEntity<String> request = new HttpEntity<>(JSON.toJSONString(creativity), headers);
        logger.info("创建广告创意请求报文：" + JSON.toJSONString(request));
        ResponseVO response = httpBuilder.buildRestTemplate().postForObject(touTiaoApiConfig.getAdCreativityAPIUrls().get("createCreativity"), request, ResponseVO.class);
        logger.info("创建广告创意响应报文：" + JSON.toJSONString(response));

        return response;
    }

    //查询创意
    public Object selectCreativity(Object creativity) {

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(touTiaoApiConfig.getAdCreativityAPIUrls().get("readCreativityDetail"));

        HttpHeaders headers = httpBuilder.buildTouTiaoHeader();
        // 获取单例RestTemplate
        RestTemplate restTemplate = httpBuilder.buildRestTemplate();
        HttpEntity request = new HttpEntity(headers);
        // 构造execute()执行所需要的参数。
        RequestCallback requestCallback = restTemplate.httpEntityCallback(request, JSONObject.class);
        ResponseExtractor<ResponseEntity<JSONObject>> responseExtractor = restTemplate.responseEntityExtractor(JSONObject.class);
        //查询条件
        AdCreativitySelectRequest syncRequest = (AdCreativitySelectRequest) creativity;
        Map<String, Object> params = syncRequest.requestMap();
        params.entrySet().stream().forEach(o -> builder.queryParam(o.getKey(), o.getValue()));
        // 执行execute()，发送请求
        logger.info("查询创意详情请求报文：" + JSON.toJSONString(creativity));
        ResponseEntity<JSONObject> responseObject = restTemplate.execute(builder.build().toUriString(), HttpMethod.GET, requestCallback, responseExtractor);
        logger.info("查询创意详情响应报文：" + responseObject.getBody().toJSONString());
        ResponseVO response = JSON.parseObject(responseObject.getBody().toJSONString(), ResponseVO.class);
        return response;

    }

    @Override
    public Object updateCreativity(Object thCreativity) {
        HttpHeaders headers = httpBuilder.buildTouTiaoHeader();
        HttpEntity<String> request = new HttpEntity<>(JSON.toJSONString(thCreativity), headers);
        logger.info("更新创意信息请求报文：" + JSON.toJSONString(request));
        ResponseVO response = httpBuilder.buildRestTemplate().postForObject(touTiaoApiConfig.getAdGroupAPIUrls().get("updateCreativity"), request, ResponseVO.class);
        logger.info("更新创意信息响应报文：" + JSON.toJSONString(response));
        return response;
    }

    @Override
    public Object reportPlan(Object reportRequest) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(touTiaoApiConfig.getAdPlanAPIUrls().get("reportPlan"));

        HttpHeaders headers = httpBuilder.buildTouTiaoHeader();
        // 获取单例RestTemplate
        RestTemplate restTemplate = httpBuilder.buildRestTemplate();
        HttpEntity request = new HttpEntity(headers);
        // 构造execute()执行所需要的参数。
        RequestCallback requestCallback = restTemplate.httpEntityCallback(request, JSONObject.class);
        ResponseExtractor<ResponseEntity<JSONObject>> responseExtractor = restTemplate.responseEntityExtractor(JSONObject.class);
        //查询条件
        PlanReportSyncRequest syncRequest = (PlanReportSyncRequest) reportRequest;
        Map<String, Object> params = syncRequest.requestMap();
        params.entrySet().stream().forEach(o -> builder.queryParam(o.getKey(), o.getValue()));
        // 执行execute()，发送请求
        logger.info("同步广告计划报表信息请求报文：" + JSON.toJSONString(reportRequest));
        ResponseEntity<JSONObject> responseObject = restTemplate.execute(builder.build().toUriString(), HttpMethod.GET, requestCallback, responseExtractor, syncRequest.getFiltering());
        logger.info("同步广告计划报表信息响应报文：" + responseObject.getBody().toJSONString());
        ResponseVO response = JSON.parseObject(responseObject.getBody().toJSONString(), ResponseVO.class);
        return response;
    }

    @Override
    public Object getImages(Object etImagesRequest) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(touTiaoApiConfig.getTools().get("getImages"));

        HttpHeaders headers = httpBuilder.buildTouTiaoHeader();
        // 获取单例RestTemplate
        RestTemplate restTemplate = httpBuilder.buildRestTemplate();
        HttpEntity request = new HttpEntity(headers);
        // 构造execute()执行所需要的参数。
        RequestCallback requestCallback = restTemplate.httpEntityCallback(request, JSONObject.class);
        ResponseExtractor<ResponseEntity<JSONObject>> responseExtractor = restTemplate.responseEntityExtractor(JSONObject.class);
        //查询条件
        GetImagesRequest syncRequest = (GetImagesRequest) etImagesRequest;
        Map<String, Object> params = syncRequest.requestMap();
        params.entrySet().stream().forEach(o -> builder.queryParam(o.getKey(), o.getValue()));
        // 执行execute()，发送请求
        logger.info("同步广告主图片素材库信息请求报文：" + JSON.toJSONString(etImagesRequest));
        ResponseEntity<JSONObject> responseObject = restTemplate.execute(builder.build().toUriString(), HttpMethod.GET, requestCallback, responseExtractor, new HashMap<>());
        logger.info("同步广告主图片素材库信息响应报文：" + responseObject.getBody().toJSONString());
        ResponseVO response = JSON.parseObject(responseObject.getBody().toJSONString(), ResponseVO.class);
        return response;
    }
}
