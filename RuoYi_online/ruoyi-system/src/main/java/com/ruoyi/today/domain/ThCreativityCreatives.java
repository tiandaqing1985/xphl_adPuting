package com.ruoyi.today.domain;

import com.alibaba.fastjson.annotation.JSONField;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 创意对象 th_creativity_creatives
 * 
 * @author ruoyi
 * @date 2019-09-09
 */
public class ThCreativityCreatives extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 创意主键 */
    @JSONField(serialize = false)
    private Long id;

    /** 头条创意ID */
    @JSONField(serialize = false)
    private String creativeId;

    /** 创意标题 */
    private String title;

    /** 程序化创意标题ID */
    @JSONField(serialize = false)
    private Long titleId;

    /** 动态词包ID */
    @JSONField(serialize = false)
    private String creativeWordIds;

    //动态词包 数组
    private String[] creative_word_ids;

    /** 素材类型 */
    private String imageMode;

    /** 图片ID列表（图片创意） */
    @JSONField(serialize = false)
    private String imageIds;

    //图片列表 数组
    private String[] image_ids;

    /** 图片ID（视频创意） */
    private String imageId;


    /** 视频ID（视频创意） */
    private String videoId;

    private String filesUrl;

    /** 创意自定义参数（图片创意） */
    @JSONField(name = "third_party_id")
    private String thirdPartyId;

    /** 是否将视频的封面和标题同步到图片创意（视频创意） */
    @JSONField(name = "derive_poster_cid")
    private String derivePosterCid;

    /** 使用商品库视频模版（视频创意） */
    @JSONField(name = "dpa_template")
    private String dpaTemplate;

    /** 创意公共属性ID */
    @JSONField(serialize = false)
    private Long creativityId;

    public String getFilesUrl() {
        return filesUrl;
    }

    public void setFilesUrl(String filesUrl) {
        this.filesUrl = filesUrl;
    }

    public String[] getCreative_word_ids() {
        return creative_word_ids;
    }

    public void setCreative_word_ids(String[] creative_word_ids) {
        this.creative_word_ids = creative_word_ids;
    }

    public String[] getImage_ids() {
        return image_ids;
    }

    public void setImage_ids(String[] image_ids) {
        this.image_ids = image_ids;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCreativeId(String creativeId) 
    {
        this.creativeId = creativeId;
    }

    public String getCreativeId() 
    {
        return creativeId;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setTitleId(Long titleId) 
    {
        this.titleId = titleId;
    }

    public Long getTitleId() 
    {
        return titleId;
    }
    public void setCreativeWordIds(String creativeWordIds) 
    {
        this.creativeWordIds = creativeWordIds;
    }

    public String getCreativeWordIds() 
    {
        return creativeWordIds;
    }
    public void setImageMode(String imageMode) 
    {
        this.imageMode = imageMode;
    }

    public String getImageMode() 
    {
        return imageMode;
    }
    public void setImageIds(String imageIds) 
    {
        this.imageIds = imageIds;
    }

    public String getImageIds() 
    {
        return imageIds;
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
    public void setThirdPartyId(String thirdPartyId) 
    {
        this.thirdPartyId = thirdPartyId;
    }

    public String getThirdPartyId() 
    {
        return thirdPartyId;
    }
    public void setDerivePosterCid(String derivePosterCid) 
    {
        this.derivePosterCid = derivePosterCid;
    }

    public String getDerivePosterCid() 
    {
        return derivePosterCid;
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
            .append("creativeId", getCreativeId())
            .append("title", getTitle())
            .append("titleId", getTitleId())
            .append("creativeWordIds", getCreativeWordIds())
            .append("imageMode", getImageMode())
            .append("imageIds", getImageIds())
            .append("imageId", getImageId())
            .append("videoId", getVideoId())
            .append("thirdPartyId", getThirdPartyId())
            .append("derivePosterCid", getDerivePosterCid())
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
