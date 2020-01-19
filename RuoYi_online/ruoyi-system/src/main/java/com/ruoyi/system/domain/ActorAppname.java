package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 拍摄app数量统计对象 actor_appName
 * 
 * @author ruoyi
 * @date 2020-01-07
 */
public class ActorAppname extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 会总表id */
    @Excel(name = "会总表id")
    private Long applyId;

    /** 组别 */
    @Excel(name = "组别")
    private String type;


    /** app名称 */
    @Excel(name = "app名称")
    private String appName;

    /** app数量 */
    @Excel(name = "app数量")
    private Long appNumber;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

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
    public void setAppName(String appName) 
    {
        this.appName = appName;
    }

    public String getAppName() 
    {
        return appName;
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
            .append("appName", getAppName())
            .append("appNumber", getAppNumber())
            .toString();
    }
}
