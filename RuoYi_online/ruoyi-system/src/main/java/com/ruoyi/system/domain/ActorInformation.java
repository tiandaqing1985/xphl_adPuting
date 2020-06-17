package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 演员信息对象 actor_information
 *
 * @author ruoyi
 * @date 2020-01-03
 */
public class ActorInformation extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * 演员姓名
     */
    @Excel(name = "演员姓名")
    private String name;

    /**
     * 演员银行卡号
     */
    @Excel(name = "演员银行卡号")
    private String number;

    /**
     * 银行卡验证
     */
    @Excel(name = "银行卡验证")
    private String verification;

    /**
     * 身份证号
     */
    @Excel(name = "身份证号")
    private String idnumber;

    /**
     * 手机号
     */
    @Excel(name = "手机号(银行)")
    private String telephone;

    /**
     * 手机号
     */
    @Excel(name = "手机号（日常联系）")
    private String telephones;

    /**
     * 所属银行
     */
    @Excel(name = "所属银行")
    private String affiliatedbank;

    /**
     * 证件类型
     */
    @Excel(name = "证件类型")
    private String documenttype;

    /**
     * 备注
     */
    @Excel(name = "备注")
    private String remarks;

    /**
     * 添加时间
     */
    @Excel(name = "添加时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date addTime;

    /**
     * 修改时间
     */
    @Excel(name = "修改时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updateTime;

    /**
     * 添加人
     */
    @Excel(name = "添加人")
    private String addUser;

    /**
     * 修改人
     */
    @Excel(name = "修改人")
    private String updateUser;

    /**
     * 协议编号
     */
    @Excel(name = "协议编号")
    private String num;


    /**
     * 是否归档
     */
    @Excel(name = "是否归档")
    private String isfile;

    /**
     * 归档展示
     * */
    private String display;

    /** 实际收款人姓名 */
    @Excel(name = "实际收款人姓名")
    private String amountPayee;

    /** 实际收款人手机号 */
    @Excel(name = "实际收款人手机号")
    private String amountTelephone;

    /** 实际收款人与演员关系 */
    @Excel(name = "实际收款人与演员关系")
    private String relationship;

    /** 实际收款人身份证号 */
    @Excel(name = "实际收款人身份证号")
    private String amountIdnumber;


    public String getAmountPayee() {
        return amountPayee;
    }

    public void setAmountPayee(String amountPayee) {
        this.amountPayee = amountPayee;
    }

    public String getAmountTelephone() {
        return amountTelephone;
    }

    public void setAmountTelephone(String amountTelephone) {
        this.amountTelephone = amountTelephone;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getAmountIdnumber() {
        return amountIdnumber;
    }

    public void setAmountIdnumber(String amountIdnumber) {
        this.amountIdnumber = amountIdnumber;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getIsfile() {
        return isfile;
    }

    public void setIsfile(String isfile) {
        this.isfile = isfile;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    @Override
    public Date getUpdateTime() {
        return updateTime;
    }

    @Override
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getVerification() {
        return verification;
    }

    public void setVerification(String verification) {
        this.verification = verification;
    }

    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getTelephones() {
        return telephones;
    }

    public void setTelephones(String telephones) {
        this.telephones = telephones;
    }

    public String getAffiliatedbank() {
        return affiliatedbank;
    }

    public void setAffiliatedbank(String affiliatedbank) {
        this.affiliatedbank = affiliatedbank;
    }

    public String getDocumenttype() {
        return documenttype;
    }

    public void setDocumenttype(String documenttype) {
        this.documenttype = documenttype;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getAddUser() {
        return addUser;
    }

    public void setAddUser(String addUser) {
        this.addUser = addUser;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("name", getName())
                .append("number", getNumber())
                .append("verification", getVerification())
                .append("idnumber", getIdnumber())
                .append("telephone", getTelephone())
                .append("affiliatedbank", getAffiliatedbank())
                .append("documenttype", getDocumenttype())
                .append("remarks", getRemarks())
                .append("addTime", getAddTime())
                .append("updateTime", getUpdateTime())
                .append("addUser", getAddUser())
                .append("updateUser", getUpdateUser())
                .toString();
    }
}
