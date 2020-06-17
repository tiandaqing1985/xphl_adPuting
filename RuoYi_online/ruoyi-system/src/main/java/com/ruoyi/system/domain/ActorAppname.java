package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 拍摄app数量统计对象 actor_appName
 *
 * @author ruoyi
 * @date 2020-01-07
 */
public class ActorAppname extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * 会总表id
     */
    @Excel(name = "会总表id")
    private Long applyId;

    /**
     * 组别
     */
    @Excel(name = "组别")
    private String type;


    /**
     * app名称
     */
    @Excel(name = "app名称")
    private String appName;

    /**
     * app数量
     */
    @Excel(name = "app数量")
    private Long appNumber;



    /** 演员姓名 */
    @Excel(name = "演员姓名")
    private String actorName;

    /** 金额 */
    @Excel(name = "金额")
    private Double amount;


    /** 身份证号 */
    @Excel(name = "身份证号")
    private String idNumber;

    /** 是否演员协议已经归档 */
    @Excel(name = "是否演员协议已经归档")
    private String isfile;

    /** 添加时间 */
    @Excel(name = "添加时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date addTime;

    /** 修改时间 */
    @Excel(name = "修改时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updateTime;

    /** 详情表id */
    @Excel(name = "详情表id")
    private Long detailid;


    public Long getDetailid() {
        return detailid;
    }

    public void setDetailid(Long detailid) {
        this.detailid = detailid;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getIsfile() {
        return isfile;
    }

    public void setIsfile(String isfile) {
        this.isfile = isfile;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    @Override
    public Date getUpdateTime() {
        return updateTime;
    }

    @Override
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getApplyId() {
        return applyId;
    }

    public void setApplyId(Long applyId) {
        this.applyId = applyId;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public Long getAppNumber() {
        return appNumber;
    }

    public void setAppNumber(Long appNumber) {
        this.appNumber = appNumber;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("applyId", getApplyId())
                .append("appName", getAppName())
                .append("appNumber", getAppNumber())
                .toString();
    }
}
