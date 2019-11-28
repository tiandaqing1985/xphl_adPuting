package com.ruoyi.today.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.List;

/**
 * 广告主对象 th_advertiser
 *
 * @author ruoyi
 * @date 2019-08-12
 */
public class ThAdvertiser extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 广告主ID
     */
    private Long id;

    /**
     * 广告主名称
     */
    @Excel(name = "广告主名称", type = Excel.Type.IMPORT)
    private String name;

    /**
     * 状态
     */
    @Excel(name = "状态", type = Excel.Type.IMPORT)
    private String status;

    //同步广告计划时使用的字段
    private Long campaignId;

    private List<String> advertiesIds;

    public List<String> getAdvertiesIds() {
        return advertiesIds;
    }

    public void setAdvertiesIds(List<String> advertiesIds) {
        this.advertiesIds = advertiesIds;
    }

    public Long getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(Long campaignId) {
        this.campaignId = campaignId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("name", getName())
                .append("status", getStatus())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .toString();
    }
}
