package com.ruoyi.today.domain.response;

import com.ruoyi.today.domain.ThAd;

import java.util.List;

public class PlanSyncThAdVO extends ThAd {

    private String ad_modify_time;

    private String modify_time;

    private AudienceVO audience;

    private String opt_status;//api广告计划操作状态

    public String getAd_modify_time() {
        return ad_modify_time;
    }

    public void setAd_modify_time(String ad_modify_time) {
        this.ad_modify_time = ad_modify_time;
    }

    public String getOpt_status() {
        return opt_status;
    }

    public void setOpt_status(String opt_status) {
        this.opt_status = opt_status;
    }

    public AudienceVO getAudience() {
        return audience;
    }

    public void setAudience(AudienceVO audience) {
        this.audience = audience;
    }

    public String getModify_time() {
        return modify_time;
    }

    public void setModify_time(String modify_time) {
        this.modify_time = modify_time;
    }
}
