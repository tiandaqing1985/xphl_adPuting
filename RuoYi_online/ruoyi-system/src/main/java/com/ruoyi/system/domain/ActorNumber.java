package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * app名称id生成对象 actor_number
 * 
 * @author ruoyi
 * @date 2020-01-08
 */
public class ActorNumber extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** app名称id */
    private Long appnameId;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setAppnameId(Long appnameId) 
    {
        this.appnameId = appnameId;
    }

    public Long getAppnameId() 
    {
        return appnameId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("appnameId", getAppnameId())
            .toString();
    }
}
