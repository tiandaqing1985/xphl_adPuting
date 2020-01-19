package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 演员审批对象 actor_sysUserApproval
 * 
 * @author ruoyi
 * @date 2020-01-09
 */
public class ActorSysuserapproval extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** apply表的id */
    @Excel(name = "apply表的id")
    private Long applyId;

    /** 审批人姓名 */
    @Excel(name = "审批人姓名")
    private String approverName;

    /** 申请人姓名 */
    @Excel(name = "申请人姓名")
    private String applicantName;

    /** 可见性（1可见 0不可见） */
    @Excel(name = "可见性", readConverterExp = "1=可见,0=不可见")
    private String approvalSight;

    /** 审批等级 */
    @Excel(name = "审批等级")
    private Integer approvalLevel;

    /** 审批操作时间 */
    @Excel(name = "审批操作时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date approvalTime;

    /** 审批意见（3同意，2驳回 ，1未操作） */
    @Excel(name = "审批意见", readConverterExp = "3=同意，2驳回,，=1未操作")
    private String approvalState;

    /** 备注 */
    @Excel(name = "备注")
    private String opi;

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
    public void setApproverName(String approverName) 
    {
        this.approverName = approverName;
    }

    public String getApproverName() 
    {
        return approverName;
    }
    public void setApplicantName(String applicantName) 
    {
        this.applicantName = applicantName;
    }

    public String getApplicantName() 
    {
        return applicantName;
    }
    public void setApprovalSight(String approvalSight) 
    {
        this.approvalSight = approvalSight;
    }

    public String getApprovalSight() 
    {
        return approvalSight;
    }
    public void setApprovalLevel(Integer approvalLevel) 
    {
        this.approvalLevel = approvalLevel;
    }

    public Integer getApprovalLevel() 
    {
        return approvalLevel;
    }
    public void setApprovalTime(Date approvalTime) 
    {
        this.approvalTime = approvalTime;
    }

    public Date getApprovalTime() 
    {
        return approvalTime;
    }
    public void setApprovalState(String approvalState) 
    {
        this.approvalState = approvalState;
    }

    public String getApprovalState() 
    {
        return approvalState;
    }
    public void setOpi(String opi) 
    {
        this.opi = opi;
    }

    public String getOpi() 
    {
        return opi;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("applyId", getApplyId())
            .append("approverName", getApproverName())
            .append("applicantName", getApplicantName())
            .append("approvalSight", getApprovalSight())
            .append("approvalLevel", getApprovalLevel())
            .append("createTime", getCreateTime())
            .append("approvalTime", getApprovalTime())
            .append("approvalState", getApprovalState())
            .append("opi", getOpi())
            .toString();
    }
}
