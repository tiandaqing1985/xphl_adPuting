package com.ruoyi.today.domain.request;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

/**
 * 查询广告组请求类
 */
public class AdGroupSelectRequest {
    private String advertiser_id;//广告主ID
    private String page;//页数
    private String page_size;//页面大小
    private String[] ids;//【过滤条件】广告组ID过滤
    private String campaign_name;//【过滤条件】广告组名称过滤
    private String landing_type;//过滤条件】广告组推广目的过滤
    private String status;//【过滤条件】广告组状态过滤
    private String campaign_create_time;//广告组创建时间，
    private String[] fields;//查询字段集合
    private Map<String, Object> filtering;

    public Map<String, Object> getFiltering() {
        return filtering;
    }

    private void setFiltering(Map<String, Object> filtering) {
        this.filtering = filtering;
    }

    public String getAdvertiser_id() {
        return advertiser_id;
    }

    public void setAdvertiser_id(String advertiser_id) {
        this.advertiser_id = advertiser_id;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getPage_size() {
        return page_size;
    }

    public void setPage_size(String page_size) {
        this.page_size = page_size;
    }

    public String[] getIds() {
        return ids;
    }

    public void setIds(String[] ids) {
        this.ids = ids;
    }

    public String getCampaign_name() {
        return campaign_name;
    }

    public void setCampaign_name(String campaign_name) {
        this.campaign_name = campaign_name;
    }

    public String getLanding_type() {
        return landing_type;
    }

    public void setLanding_type(String landing_type) {
        this.landing_type = landing_type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCampaign_create_time() {
        return campaign_create_time;
    }

    public void setCampaign_create_time(String campaign_create_time) {
        this.campaign_create_time = campaign_create_time;
    }

    public String[] getFields() {
        return fields;
    }

    public void setFields(String[] fields) {
        this.fields = fields;
    }

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
        if (getCampaign_name() != null) {
            filtering.put("campaign_name", getCampaign_name());
        }
        if (getLanding_type() != null) {
            filtering.put("landing_type", getLanding_type());
        }
        if (getStatus() != null) {
            filtering.put("status", getStatus());
        }
        if (getCampaign_create_time() != null) {
            filtering.put("campaign_create_time", getCampaign_create_time());
        }
        if (!filtering.isEmpty()) {
            request.put("filtering", "{filtering}");
            this.filtering.put("filtering", filtering.toJSONString());
        }
        return request;
    }

}
