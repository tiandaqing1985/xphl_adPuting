package com.ruoyi.today.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 素材在每个广告主的素材id对象 th_video_matter_today
 * 
 * @author ruoyi
 * @date 2020-03-10
 */
public class ThVideoMatterToday extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 广告主id */
    @Excel(name = "广告主id")
    private String advertiserId;

    /** 素材表主键 */
    @Excel(name = "素材表主键")
    private Long matterId;

    /** 头条素材id */
    @Excel(name = "头条素材id")
    private String todayMatterIdId;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setAdvertiserId(String advertiserId) 
    {
        this.advertiserId = advertiserId;
    }

    public String getAdvertiserId() 
    {
        return advertiserId;
    }
    public void setMatterId(Long matterId) 
    {
        this.matterId = matterId;
    }

    public Long getMatterId() 
    {
        return matterId;
    }
    public void setTodayMatterIdId(String todayMatterIdId) 
    {
        this.todayMatterIdId = todayMatterIdId;
    }

    public String getTodayMatterIdId() 
    {
        return todayMatterIdId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("advertiserId", getAdvertiserId())
            .append("matterId", getMatterId())
            .append("todayMatterIdId", getTodayMatterIdId())
            .toString();
    }
}
