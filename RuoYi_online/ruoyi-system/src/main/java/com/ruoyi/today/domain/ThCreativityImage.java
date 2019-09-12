package com.ruoyi.today.domain;

import com.alibaba.fastjson.annotation.JSONField;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 程序化创意素材对象 th_creativity_image
 * 
 * @author ruoyi
 * @date 2019-09-09
 */
public class ThCreativityImage extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    @JSONField(serialize = false)
    private Long id;

    /** 素材类型 */
    @JSONField(name = "image_mode")
    private String imageMode;

    /** 图片id */
    @JSONField(name = "image_id")
    private String imageId;

    /** 视频id */
    @JSONField(name = "video_id")
    private String videoId;

    /** 图片id列表 */
    @JSONField(serialize = false)
    private String imageIds;

    //图片id列表 数组
    private String[] image_ids;

    /** 使用商品库视频模版 */
    @JSONField(serialize = false)
    private String dpaTemplate;

    //使用商品库视频模版 数组
    private String[] dpa_template;

    /** 创意公共属性id */
    @JSONField(serialize = false)
    private Long creativityId;

    public String[] getImage_ids() {
        return image_ids;
    }

    public void setImage_ids(String[] image_ids) {
        this.image_ids = image_ids;
    }

    public String[] getDpa_template() {
        return dpa_template;
    }

    public void setDpa_template(String[] dpa_template) {
        this.dpa_template = dpa_template;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setImageMode(String imageMode) 
    {
        this.imageMode = imageMode;
    }

    public String getImageMode() 
    {
        return imageMode;
    }
    public void setImageId(String imageId) 
    {
        this.imageId = imageId;
    }

    public String getImageId() 
    {
        return imageId;
    }
    public void setVideoId(String videoId) 
    {
        this.videoId = videoId;
    }

    public String getVideoId() 
    {
        return videoId;
    }
    public void setImageIds(String imageIds) 
    {
        this.imageIds = imageIds;
    }

    public String getImageIds() 
    {
        return imageIds;
    }
    public void setDpaTemplate(String dpaTemplate) 
    {
        this.dpaTemplate = dpaTemplate;
    }

    public String getDpaTemplate() 
    {
        return dpaTemplate;
    }
    public void setCreativityId(Long creativityId) 
    {
        this.creativityId = creativityId;
    }

    public Long getCreativityId() 
    {
        return creativityId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("imageMode", getImageMode())
            .append("imageId", getImageId())
            .append("videoId", getVideoId())
            .append("imageIds", getImageIds())
            .append("dpaTemplate", getDpaTemplate())
            .append("creativityId", getCreativityId())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
