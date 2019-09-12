package com.ruoyi.today.domain;

import com.alibaba.fastjson.annotation.JSONField;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 行业列对象 th_ad_industry
 * 
 * @author ruoyi
 * @date 2019-09-11
 */
public class ThAdIndustry extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 所在级别，1：一级行业、2：二级行业、3：三级行业 */
    private String level;

    /** 行业ID */
    @JSONField(name = "industry_id")
    private String industryId;

    /** 行业名称 */
    @JSONField(name = "industry_name")
    private String industryName;

    /** 该行业的一级行业ID */
    @JSONField(name = "first_industry_id")
    private String firstIndustryId;

    /** 该行业的一级行业名称 */
    @JSONField(name = "first_industry_name")
    private String firstIndustryName;

    /** 该行业的二级行业ID */
    @JSONField(name = "second_industry_id")
    private String secondIndustryId;

    /** 该行业的二级行业名称 */
    @JSONField(name = "second_industry_name")
    private String secondIndustryName;

    /** 该行业的三级行业ID */
    @JSONField(name = "third_industry_id")
    private String thirdIndustryId;

    /** 该行业的三级行业名称 */
    @JSONField(name = "third_industry_name")
    private String thirdIndustryName;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setLevel(String level) 
    {
        this.level = level;
    }

    public String getLevel() 
    {
        return level;
    }
    public void setIndustryId(String industryId) 
    {
        this.industryId = industryId;
    }

    public String getIndustryId() 
    {
        return industryId;
    }
    public void setIndustryName(String industryName) 
    {
        this.industryName = industryName;
    }

    public String getIndustryName() 
    {
        return industryName;
    }
    public void setFirstIndustryId(String firstIndustryId) 
    {
        this.firstIndustryId = firstIndustryId;
    }

    public String getFirstIndustryId() 
    {
        return firstIndustryId;
    }
    public void setFirstIndustryName(String firstIndustryName) 
    {
        this.firstIndustryName = firstIndustryName;
    }

    public String getFirstIndustryName() 
    {
        return firstIndustryName;
    }
    public void setSecondIndustryId(String secondIndustryId) 
    {
        this.secondIndustryId = secondIndustryId;
    }

    public String getSecondIndustryId() 
    {
        return secondIndustryId;
    }
    public void setSecondIndustryName(String secondIndustryName) 
    {
        this.secondIndustryName = secondIndustryName;
    }

    public String getSecondIndustryName() 
    {
        return secondIndustryName;
    }
    public void setThirdIndustryId(String thirdIndustryId) 
    {
        this.thirdIndustryId = thirdIndustryId;
    }

    public String getThirdIndustryId() 
    {
        return thirdIndustryId;
    }
    public void setThirdIndustryName(String thirdIndustryName) 
    {
        this.thirdIndustryName = thirdIndustryName;
    }

    public String getThirdIndustryName() 
    {
        return thirdIndustryName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("level", getLevel())
            .append("industryId", getIndustryId())
            .append("industryName", getIndustryName())
            .append("firstIndustryId", getFirstIndustryId())
            .append("firstIndustryName", getFirstIndustryName())
            .append("secondIndustryId", getSecondIndustryId())
            .append("secondIndustryName", getSecondIndustryName())
            .append("thirdIndustryId", getThirdIndustryId())
            .append("thirdIndustryName", getThirdIndustryName())
            .toString();
    }
}
