package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 视频拍摄详情对象 actor_details
 * 
 * @author ruoyi
 * @date 2020-05-18
 */
public class ActorDetails extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 拍摄app数量统计表id */
    @Excel(name = "拍摄app数量统计表id")
    private Long applyId;

    /** 组别 */
    @Excel(name = "组别")
    private String groups;

    /** 拍摄广告主 */
    @Excel(name = "拍摄广告主")
    private String advertiser;

    /** 拍摄条数 */
    @Excel(name = "拍摄条数")
    private Long appNumber;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setApplyId(Long applyId) 
    {
        this.applyId = applyId;
    }

    public Long getApplyId() 
    {
        return applyId;
    }

    public String getGroups() {
        return groups;
    }

    public void setGroups(String groups) {
        this.groups = groups;
    }

    public void setAdvertiser(String advertiser)
    {
        this.advertiser = advertiser;
    }

    public String getAdvertiser() 
    {
        return advertiser;
    }
    public void setAppNumber(Long appNumber) 
    {
        this.appNumber = appNumber;
    }

    public Long getAppNumber() 
    {
        return appNumber;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("applyId", getApplyId())
            .append("advertiser", getAdvertiser())
            .append("appNumber", getAppNumber())
            .toString();
    }
}
