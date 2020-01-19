package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 演员拍摄汇总对象 actor_shot_apply
 * 
 * @author ruoyi
 * @date 2020-01-06
 */
public class ActorShotApply extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 协议编号 */
    @Excel(name = "协议编号")
    private String num;

    /** 拍摄时间 */
    @Excel(name = "拍摄时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date shotTime;

    /** 实际支付时间 */
    @Excel(name = "实际支付时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date actualPaymentTime;

    /** 组别 */
    @Excel(name = "组别")
    private String type;

    /** 演员姓名 */
    @Excel(name = "演员姓名")
    private String actorName;

    /** 价格 */
    @Excel(name = "价格")
    private Double amount;

    /** 联系方式 */
    @Excel(name = "联系方式")
    private Long phoneNumber;

    /** 是否有收据 */
    @Excel(name = "是否有收据")
    private String isReceipt;

    /** 是否报销/支付 */
    @Excel(name = "是否报销/支付")
    private String isReimbur;

    /** 总拍摄条数 */
    @Excel(name = "总拍摄条数")
    private Long shotsNumber;

    /** 单条金额 */
    @Excel(name = "单条金额")
    private Double singleAmount;

    /** 拍摄条数核对 */
    @Excel(name = "拍摄条数核对")
    private Long shotTruenumber;

    /** 创建时间 */
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startTime;

    /** 创建人 */
    @Excel(name = "创建人")
    private String username;

    /** 修改人 */
    @Excel(name = "修改人")
    private String updatename;

    /** app名称id */
    @Excel(name = "app名称id")
    private Long appNameId;


    /** 审批状态 */
    @Excel(name = "审批状态")
    private String start;

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setNum(String num) 
    {
        this.num = num;
    }

    public String getNum() 
    {
        return num;
    }
    public void setShotTime(Date shotTime) 
    {
        this.shotTime = shotTime;
    }

    public Date getShotTime() 
    {
        return shotTime;
    }
    public void setActualPaymentTime(Date actualPaymentTime) 
    {
        this.actualPaymentTime = actualPaymentTime;
    }

    public Date getActualPaymentTime() 
    {
        return actualPaymentTime;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setActorName(String actorName) 
    {
        this.actorName = actorName;
    }

    public String getActorName() 
    {
        return actorName;
    }
    public void setAmount(Double amount) 
    {
        this.amount = amount;
    }

    public Double getAmount() 
    {
        return amount;
    }
    public void setPhoneNumber(Long phoneNumber) 
    {
        this.phoneNumber = phoneNumber;
    }

    public Long getPhoneNumber() 
    {
        return phoneNumber;
    }
    public void setIsReceipt(String isReceipt) 
    {
        this.isReceipt = isReceipt;
    }

    public String getIsReceipt() 
    {
        return isReceipt;
    }
    public void setIsReimbur(String isReimbur) 
    {
        this.isReimbur = isReimbur;
    }

    public String getIsReimbur() 
    {
        return isReimbur;
    }
    public void setShotsNumber(Long shotsNumber) 
    {
        this.shotsNumber = shotsNumber;
    }

    public Long getShotsNumber() 
    {
        return shotsNumber;
    }
    public void setSingleAmount(Double singleAmount) 
    {
        this.singleAmount = singleAmount;
    }

    public Double getSingleAmount() 
    {
        return singleAmount;
    }
    public void setShotTruenumber(Long shotTruenumber) 
    {
        this.shotTruenumber = shotTruenumber;
    }

    public Long getShotTruenumber() 
    {
        return shotTruenumber;
    }
    public void setStartTime(Date startTime) 
    {
        this.startTime = startTime;
    }

    public Date getStartTime() 
    {
        return startTime;
    }
    public void setUsername(String username) 
    {
        this.username = username;
    }

    public String getUsername() 
    {
        return username;
    }
    public void setUpdatename(String updatename) 
    {
        this.updatename = updatename;
    }

    public String getUpdatename() 
    {
        return updatename;
    }

    public Long getAppNameId() {
        return appNameId;
    }

    public void setAppNameId(Long appNameId) {
        this.appNameId = appNameId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("num", getNum())
            .append("shotTime", getShotTime())
            .append("actualPaymentTime", getActualPaymentTime())
            .append("type", getType())
            .append("actorName", getActorName())
            .append("amount", getAmount())
            .append("phoneNumber", getPhoneNumber())
            .append("isReceipt", getIsReceipt())
            .append("isReimbur", getIsReimbur())
            .append("shotsNumber", getShotsNumber())
            .append("singleAmount", getSingleAmount())
            .append("shotTruenumber", getShotTruenumber())
            .append("startTime", getStartTime())
            .append("updateTime", getUpdateTime())
            .append("username", getUsername())
            .append("updatename", getUpdatename())
                .append("appNameId", getAppNameId())
            .toString();
    }
}
