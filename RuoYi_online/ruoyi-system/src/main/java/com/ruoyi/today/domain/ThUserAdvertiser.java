package com.ruoyi.today.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 th_user_advertiser
 * 
 * @author ruoyi
 * @date 2019-11-07
 */
public class ThUserAdvertiser extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 用户名 */
    @Excel(name = "用户名")
    private String userName;

    /** 广告主名称 */
    @Excel(name = "广告主名称")
    private String advertiserId;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setUserName(String userName) 
    {
        this.userName = userName;
    }

    public String getUserName() 
    {
        return userName;
    }
    public void setAdvertiserId(String advertiserId) 
    {
        this.advertiserId = advertiserId;
    }

    public String getAdvertiserId() 
    {
        return advertiserId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userName", getUserName())
            .append("advertiserId", getAdvertiserId())
            .toString();
    }
}
