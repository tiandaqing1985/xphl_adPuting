package com.ruoyi.today.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * 头条广告主对应素材的id对象 th_today_matter
 * 
 * @author ruoyi
 * @date 2020-04-02
 */
public class ThTodayMatter extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 广告主id */
    @Excel(name = "广告主id")
    private String advertiserId;

    /** 素材md5 */
    @Excel(name = "素材md5")
    private String signature;

    /** 素材类型 */
    @Excel(name = "素材类型")
    private String type;

    //头条素材id
    private String todayId;

    //创建时间
    private Date createTime;

    @Override
    public Date getCreateTime() {
        return createTime;
    }

    @Override
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getTodayId() {
        return todayId;
    }

    public void setTodayId(String todayId) {
        this.todayId = todayId;
    }

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
    public void setSignature(String signature) 
    {
        this.signature = signature;
    }

    public String getSignature() 
    {
        return signature;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("advertiserId", getAdvertiserId())
            .append("signature", getSignature())
            .append("type", getType())
            .toString();
    }
}
