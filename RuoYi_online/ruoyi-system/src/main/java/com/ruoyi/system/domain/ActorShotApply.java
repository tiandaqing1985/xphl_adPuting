package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * 演员拍摄汇总对象 actor_shot_apply
 *
 * @author ruoyi
 * @date 2020-01-06
 */
public class ActorShotApply extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * 协议编号
     */
    @Excel(name = "协议编号")
    private String num;

    /**
     * 拍摄时间
     */
    @Excel(name = "拍摄时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date shotTime;

    /**
     * 实际支付时间
     */
    @Excel(name = "实际支付时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date actualPaymentTime;

    /**
     * 组别
     */
    @Excel(name = "组别")
    private String type;

    /**
     * 演员姓名
     */
    @Excel(name = "演员姓名")
    private String actorName;

    /**
     * 价格
     */
    @Excel(name = "价格")
    private Double amount;

    /**
     * 联系方式
     */
    @Excel(name = "联系方式")
    private Long phoneNumber;

    /**
     * 是哪个领导
     */
    @Excel(name = "是否有收据")
    private String isReceipt;

    /**
     * 是否报销/支付
     */
    @Excel(name = "是否报销/支付")
    private String isReimbur;

    /**
     * 总拍摄条数
     */
    @Excel(name = "总拍摄条数")
    private Long shotsNumber;

    /**
     * 单条金额
     */
    @Excel(name = "单条金额")
    private Double singleAmount;

    /**
     * 拍摄条数核对
     */
    @Excel(name = "拍摄条数核对")
    private Long shotTruenumber;

    /**
     * 创建时间
     */
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startTime;

    /**
     * 创建人
     */
    @Excel(name = "创建人")
    private String username;

    /**
     * 修改人
     */
    @Excel(name = "修改人")
    private String updatename;

    /**
     * app名称id
     */
    @Excel(name = "app名称id")
    private Long appnameId;


    /**
     * 审批状态
     */
    @Excel(name = "审批状态")
    private String start;


    /**
     * 是否本人
     */
    private String istart;

    /**
     * 税率（7%）
     */
    @Excel(name = "税率", readConverterExp = "7=%")
    private Double taxRate;

    /**
     * 含税金额=演员费用*（1+7%）
     */
    @Excel(name = "含税金额=演员费用*", readConverterExp = "1=+7%")
    private Double taxAmount;

    /**
     * 演员人数
     */
    @Excel(name = "演员人数")
    private Long actornumber;


    public Double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(Double taxRate) {
        this.taxRate = taxRate;
    }

    public Double getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(Double taxAmount) {
        this.taxAmount = taxAmount;
    }

    public Long getActornumber() {
        return actornumber;
    }

    public void setActornumber(Long actornumber) {
        this.actornumber = actornumber;
    }

    public String getIstart() {
        return istart;
    }

    public void setIstart(String istart) {
        this.istart = istart;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public Date getShotTime() {
        return shotTime;
    }

    public void setShotTime(Date shotTime) {
        this.shotTime = shotTime;
    }

    public Date getActualPaymentTime() {
        return actualPaymentTime;
    }

    public void setActualPaymentTime(Date actualPaymentTime) {
        this.actualPaymentTime = actualPaymentTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getIsReceipt() {
        return isReceipt;
    }

    public void setIsReceipt(String isReceipt) {
        this.isReceipt = isReceipt;
    }

    public String getIsReimbur() {
        return isReimbur;
    }

    public void setIsReimbur(String isReimbur) {
        this.isReimbur = isReimbur;
    }

    public Long getShotsNumber() {
        return shotsNumber;
    }

    public void setShotsNumber(Long shotsNumber) {
        this.shotsNumber = shotsNumber;
    }

    public Double getSingleAmount() {
        return singleAmount;
    }

    public void setSingleAmount(Double singleAmount) {
        this.singleAmount = singleAmount;
    }

    public Long getShotTruenumber() {
        return shotTruenumber;
    }

    public void setShotTruenumber(Long shotTruenumber) {
        this.shotTruenumber = shotTruenumber;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUpdatename() {
        return updatename;
    }

    public void setUpdatename(String updatename) {
        this.updatename = updatename;
    }

    public Long getAppnameId() {
        return appnameId;
    }

    public void setAppnameId(Long appnameId) {
        this.appnameId = appnameId;
    }


}
