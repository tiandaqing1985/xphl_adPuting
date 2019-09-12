package com.ruoyi.today.domain;

import com.alibaba.fastjson.annotation.JSONField;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 程序化创意标题对象 th_creativity_title
 * 
 * @author ruoyi
 * @date 2019-09-09
 */
public class ThCreativityTitle extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    @JSONField(serialize = false)
    private Long id;

    /** 创意公共属性id */
    @JSONField(serialize = false)
    private Long creativityId;

    /** 创意标题 */
    private String title;

    /** 动态词包id */
    @JSONField(serialize = false)
    private String creativeWordIds;

    //动态词包id 数组
    private String[] creative_word_ids;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setCreativityId(Long creativityId)
    {
        this.creativityId = creativityId;
    }

    public Long getCreativityId()
    {
        return creativityId;
    }
    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getTitle()
    {
        return title;
    }
    public void setCreativeWordIds(String creativeWordIds)
    {
        this.creativeWordIds = creativeWordIds;
    }

    public String getCreativeWordIds()
    {
        return creativeWordIds;
    }

    public String[] getCreative_word_ids() {
        return creative_word_ids;
    }

    public void setCreative_word_ids(String[] creative_word_ids) {
        this.creative_word_ids = creative_word_ids;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("creativityId", getCreativityId())
            .append("title", getTitle())
            .append("creativeWordIds", getCreativeWordIds())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
