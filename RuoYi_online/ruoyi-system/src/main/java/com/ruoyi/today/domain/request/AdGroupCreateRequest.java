package com.ruoyi.today.domain.request;

/**
 * 创建广告组
 */
public class AdGroupCreateRequest {

    private String advertiser_id;//广告主ID

    private String campaign_name;//广告组名称

    private String budget_mode;//广告组预算类型

    private String budget;//广告组预算

    private String landing_type;//广告组推广目的

    private String unique_fk;//第三方唯一键

    /** 广告组状态
     允许值: "enable","disable"
     默认值：enable开启状态 */
    private String operation;

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getAdvertiser_id() {
        return advertiser_id;
    }

    public void setAdvertiser_id(String advertiser_id) {
        this.advertiser_id = advertiser_id;
    }

    public String getCampaign_name() {
        return campaign_name;
    }

    public void setCampaign_name(String campaign_name) {
        this.campaign_name = campaign_name;
    }

    public String getBudget_mode() {
        return budget_mode;
    }

    public void setBudget_mode(String budget_mode) {
        this.budget_mode = budget_mode;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public String getLanding_type() {
        return landing_type;
    }

    public void setLanding_type(String landing_type) {
        this.landing_type = landing_type;
    }

    public String getUnique_fk() {
        return unique_fk;
    }

    public void setUnique_fk(String unique_fk) {
        this.unique_fk = unique_fk;
    }
}
