package com.ruoyi.today.domain.response;

//头条 更新广告计划状态
public class PlanUpdateStatusResponse extends ResponseVO {

    private String[] ad_ids;//广告计划ID集合

    public String[] getAd_ids() {
        return ad_ids;
    }

    public void setAd_ids(String[] ad_ids) {
        this.ad_ids = ad_ids;
    }
}
