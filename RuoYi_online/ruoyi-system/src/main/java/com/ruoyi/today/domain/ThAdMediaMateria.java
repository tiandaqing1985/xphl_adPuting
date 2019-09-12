package com.ruoyi.today.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 媒体素材对象 th_ad_media_materia
 * 
 * @author ruoyi
 * @date 2019-09-11
 */
public class ThAdMediaMateria extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long id;

    /** 广告主id */
    @Excel(name = "广告主id")
    private Long advertiserId;

    /** 媒体素材id */
    @Excel(name = "媒体素材id")
    private String mediaMateriaId;

    /** 素材表id */
    @Excel(name = "素材表id")
    private String materiaId;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setAdvertiserId(Long advertiserId) 
    {
        this.advertiserId = advertiserId;
    }

    public Long getAdvertiserId() 
    {
        return advertiserId;
    }
    public void setMediaMateriaId(String mediaMateriaId) 
    {
        this.mediaMateriaId = mediaMateriaId;
    }

    public String getMediaMateriaId() 
    {
        return mediaMateriaId;
    }
    public void setMateriaId(String materiaId) 
    {
        this.materiaId = materiaId;
    }

    public String getMateriaId() 
    {
        return materiaId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("advertiserId", getAdvertiserId())
            .append("mediaMateriaId", getMediaMateriaId())
            .append("materiaId", getMateriaId())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
