package com.ruoyi.today.domain.request;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class PlanReportSyncRequest {

    private String advertiser_id;//广告主ID
    private String start_date;
    private String end_date;
    private Integer page;//页数 默认1
    private Integer page_size;//页面大小 默认10
    private String[] group_by;
    private String[] ad_ids;

    private Map<String, Object> filtering;//过滤条件

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
        if (getStart_date() != null) {
            request.put("start_date", getStart_date());
        }
        if (getEnd_date() != null) {
            request.put("end_date", getEnd_date());
        }
        if (getGroup_by() != null) {
            request.put("group_by", getGroup_by());
        }
        JSONObject filtering = new JSONObject();
        if (getAd_ids() != null) {
            filtering.put("ad_ids", getAd_ids());
        }
        if (!filtering.isEmpty()) {
            request.put("filtering", "{filtering}");
            this.filtering.put("filtering", filtering.toJSONString());
        }
        return request;
    }

    public String getAdvertiser_id() {
        return advertiser_id;
    }

    public void setAdvertiser_id(String advertiser_id) {
        this.advertiser_id = advertiser_id;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
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

    public String[] getGroup_by() {
        return group_by;
    }

    public void setGroup_by(String[] group_by) {
        this.group_by = group_by;
    }

    public String[] getAd_ids() {
        return ad_ids;
    }

    public void setAd_ids(String[] ad_ids) {
        this.ad_ids = ad_ids;
    }

    public Map<String, Object> getFiltering() {
        return filtering;
    }

    public void setFiltering(Map<String, Object> filtering) {
        this.filtering = filtering;
    }
}
