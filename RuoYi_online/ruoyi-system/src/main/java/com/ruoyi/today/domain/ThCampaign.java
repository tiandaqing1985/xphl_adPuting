package com.ruoyi.today.domain;

import com.alibaba.fastjson.annotation.JSONField;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.List;

/**
 * 广告组对象 th_campaign
 * 
 * @author ruoyi
 * @date 2019-08-14
 */
public class ThCampaign extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 广告组ID */
    @JSONField(name = "campaign_id")
    private Long campaignId;

    /** 广告主ID */
    @JSONField(name = "advertiser_id")
    private Long advertiserId;

    /** 广告组名称 */
    @Excel(name = "广告组名称")
    @JSONField(name = "name")
    private String campaignName;

    /** 广告组预算类型 */
    @Excel(name = "广告组预算类型")
    @JSONField(name = "budget_mode")
    private String budgetMode;

    /** 广告组预算 */
    @Excel(name = "广告组预算")
    @JSONField(name = "budget")
    private Long budget;

    /** 广告组推广目的 */
    @Excel(name = "广告组推广目的")
    @JSONField(name = "landing_type")
    private String landingType;

    /** 状态 */
    @Excel(name = "状态")
    private String status;

    /** 广告组状态
     允许值: "enable","disable"
     默认值：enable开启状态 */
    private String operation;

    private List<String> advertiesIds;

    public List<String> getAdvertiesIds() {
        return advertiesIds;
    }

    public void setAdvertiesIds(List<String> advertiesIds) {
        this.advertiesIds = advertiesIds;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public void setCampaignId(Long campaignId)
    {
        this.campaignId = campaignId;
    }

    public Long getCampaignId() 
    {
        return campaignId;
    }
    public void setAdvertiserId(Long advertiserId) 
    {
        this.advertiserId = advertiserId;
    }

    public Long getAdvertiserId() 
    {
        return advertiserId;
    }
    public void setCampaignName(String campaignName) 
    {
        this.campaignName = campaignName;
    }

    public String getCampaignName() 
    {
        return campaignName;
    }
    public void setBudgetMode(String budgetMode) 
    {
        this.budgetMode = budgetMode;
    }

    public String getBudgetMode() 
    {
        return budgetMode;
    }
    public void setBudget(Long budget) 
    {
        this.budget = budget;
    }

    public Long getBudget() 
    {
        return budget;
    }
    public void setLandingType(String landingType) 
    {
        this.landingType = landingType;
    }

    public String getLandingType() 
    {
        return landingType;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("campaignId", getCampaignId())
            .append("advertiserId", getAdvertiserId())
            .append("campaignName", getCampaignName())
            .append("budgetMode", getBudgetMode())
            .append("budget", getBudget())
            .append("landingType", getLandingType())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
