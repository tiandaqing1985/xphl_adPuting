package com.ruoyi.today.domain.request;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class PlanSyncRequest {

    private String advertiser_id;//广告主ID
    private Integer page;//页数 默认1
    private Integer page_size;//页面大小 默认10
    private Map<String, Object> filtering;//过滤条件
    private String[] ids;//【过滤条件】按广告计划ID过滤，数组
    private String ad_name;//【过滤条件】按广告计划名称过滤，支持模糊搜索
    private String[] pricing_list;//过滤条件】按出价方式过滤，数组
    private String status;//过滤条件】按计划状态过滤
    private String campaign_id;//【过滤条件】按广告组id过滤
    private String ad_create_time;//广告计划创建时间，格式yyyy-mm-dd
    private String ad_modify_time;//广告计划更新时间，格式yyyy-mm-dd
    private String[] fields;

    //当是get请求时 使用Map传参
    public Map<String, Object> requestMap() {
        this.filtering = new HashMap<>();
        Map<String, Object> request = new HashMap<>();
        if (getAdvertiser_id() != null) {
            request.put("advertiser_id", getAdvertiser_id());
        }
        if (getPage() != null) {
            request.put("page", getPage());
        }
        if (getPage_size() != null) {
            request.put("page_size", getPage_size());
        }
        if (getFields() != null) {
            request.put("fields", getFields());
        }
        JSONObject filtering = new JSONObject();
        if (getIds() != null) {
            filtering.put("ids", getIds());
        }
        if (getAd_name() != null) {
            filtering.put("ad_name", getAd_name());
        }
        if (getPricing_list() != null) {
            filtering.put("pricing_list", getPricing_list());
        }
        if (getStatus() != null) {
            filtering.put("status", getStatus());
        }
        if (getCampaign_id() != null) {
            filtering.put("campaign_id", getCampaign_id());
        }
        if (getAd_create_time() != null) {
            filtering.put("ad_create_time", getAd_create_time());
        }
        if (getAd_modify_time() != null) {
            filtering.put("ad_modify_time", getAd_modify_time());
        }
        if (!filtering.isEmpty()) {
            request.put("filtering", "{filtering}");
            this.filtering.put("filtering", filtering.toJSONString());
        }
        return request;
    }

    public void setFiltering(Map<String, Object> filtering) {
        this.filtering = filtering;
    }

    public String[] getIds() {
        return ids;
    }

    public void setIds(String[] ids) {
        this.ids = ids;
    }

    public String getAd_name() {
        return ad_name;
    }

    public void setAd_name(String ad_name) {
        this.ad_name = ad_name;
    }

    public String[] getPricing_list() {
        return pricing_list;
    }

    public void setPricing_list(String[] pricing_list) {
        this.pricing_list = pricing_list;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCampaign_id() {
        return campaign_id;
    }

    public void setCampaign_id(String campaign_id) {
        this.campaign_id = campaign_id;
    }

    public String getAd_create_time() {
        return ad_create_time;
    }

    public void setAd_create_time(String ad_create_time) {
        this.ad_create_time = ad_create_time;
    }

    public String getAd_modify_time() {
        return ad_modify_time;
    }

    public void setAd_modify_time(String ad_modify_time) {
        this.ad_modify_time = ad_modify_time;
    }

    public String getAdvertiser_id() {
        return advertiser_id;
    }

    public void setAdvertiser_id(String advertiser_id) {
        this.advertiser_id = advertiser_id;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPage_size() {
        return page_size;
    }

    public void setPage_size(Integer page_size) {
        this.page_size = page_size;
    }

    public Map<String, Object> getFiltering() {
        return filtering;
    }

    public String[] getFields() {
        return fields;
    }

    public void setFields(String[] fields) {
        this.fields = fields;
    }
}
