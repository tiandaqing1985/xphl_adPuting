package com.ruoyi.today.domain;

import com.alibaba.fastjson.annotation.JSONField;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 视频订单对象 th_video_order
 * 
 * @author ruoyi
 * @date 2020-03-02
 */
public class ThVideoOrder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id主键 */
    private Long id;

    /** 订单名称 */
    @Excel(name = "订单名称")
    private String orderName;

    /** 视频脚本路径 */
    @Excel(name = "视频脚本路径")
    private String videoScript;

    /** 素材类型  */
    @Excel(name = "素材类型 ")
    private String type;

    /** 特殊需求 */
    @Excel(name = "特殊需求")
    private String specialNeed;

    /** 风险提示语 */
    @Excel(name = "风险提示语")
    private String riskWord;
    //视频需求
    private ThVideoNeed need;

    //交付的视频素材
    private List<ThVideoMatter> matters;

    private String timeRange;

    private Long createDept;

    //素材
    private String matter;

    private ThVideoMatterReport report;

    //订单状态
    private String status;

    private String process;

    public ThVideoMatterReport getReport() {
        return report;
    }

    public void setReport(ThVideoMatterReport report) {
        this.report = report;
    }

    public Long getCreateDept() {
        return createDept;
    }

    public void setCreateDept(Long createDept) {
        this.createDept = createDept;
    }

    public List<ThVideoMatter> getMatters() {
        return matters;
    }

    public void setMatters(List<ThVideoMatter> matters) {
        this.matters = matters;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public String getMatter() {
        return matter;
    }

    public void setMatter(String matter) {
        this.matter = matter;
    }

    public String getTimeRange() {
        return timeRange;
    }

    public void setTimeRange(String timeRange) {
        this.timeRange = timeRange;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @JSONField(serialize = false)
    private MultipartFile logo;

    @JSONField(serialize = false)
    private MultipartFile script;

    public MultipartFile getLogo() {
        return logo;
    }

    public void setLogo(MultipartFile logo) {
        this.logo = logo;
    }

    public MultipartFile getScript() {
        return script;
    }

    public void setScript(MultipartFile script) {
        this.script = script;
    }

    public ThVideoNeed getNeed() {
        return need;
    }

    public void setNeed(ThVideoNeed need) {
        this.need = need;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setOrderName(String orderName)
    {
        this.orderName = orderName;
    }

    public String getOrderName() 
    {
        return orderName;
    }
    public void setVideoScript(String videoScript) 
    {
        this.videoScript = videoScript;
    }

    public String getVideoScript() 
    {
        return videoScript;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setSpecialNeed(String specialNeed) 
    {
        this.specialNeed = specialNeed;
    }

    public String getSpecialNeed() 
    {
        return specialNeed;
    }
    public void setRiskWord(String riskWord) 
    {
        this.riskWord = riskWord;
    }

    public String getRiskWord() 
    {
        return riskWord;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("orderName", getOrderName())
            .append("videoScript", getVideoScript())
            .append("type", getType())
            .append("specialNeed", getSpecialNeed())
            .append("riskWord", getRiskWord())
            .append("createTime", getCreateTime())
            .append("createBy", getCreateBy())
            .append("updateTime", getUpdateTime())
            .append("updateBy", getUpdateBy())
            .toString();
    }
}
