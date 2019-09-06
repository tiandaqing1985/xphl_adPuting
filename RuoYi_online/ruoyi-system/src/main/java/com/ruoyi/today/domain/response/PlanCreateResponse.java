package com.ruoyi.today.domain.response;

public class PlanCreateResponse extends ResponseVO {

    private String request_id;
    private String ad_id;

    public String getAd_id() {
        return ad_id;
    }

    public void setAd_id(String ad_id) {
        this.ad_id = ad_id;
    }

    public String getRequest_id() {
        return request_id;
    }

    public void setRequest_id(String request_id) {
        this.request_id = request_id;
    }
}
