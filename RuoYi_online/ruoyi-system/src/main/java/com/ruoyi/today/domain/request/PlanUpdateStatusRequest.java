package com.ruoyi.today.domain.request;

//头条 更新广告计划状态
public class PlanUpdateStatusRequest {

    private String advertiser_id;//广告主ID
    private String[] ad_ids;//计划ID集合
    private String opt_status;//操作, "enable"表示启用, "delete"表示删除, "disable"表示暂停

    public String getAdvertiser_id() {
        return advertiser_id;
    }

    public void setAdvertiser_id(String advertiser_id) {
        this.advertiser_id = advertiser_id;
    }

    public String[] getAd_ids() {
        return ad_ids;
    }

    public void setAd_ids(String[] ad_ids) {
        this.ad_ids = ad_ids;
    }

    public String getOpt_status() {
        return opt_status;
    }

    public void setOpt_status(String opt_status) {
        this.opt_status = opt_status;
    }
}
