package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 演员信息对象 actor_information
 * 
 * @author ruoyi
 * @date 2020-01-03
 */
public class ActorInformation extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 演员姓名 */
    @Excel(name = "演员姓名")
    private String name;

    /** 演员银行卡号 */
    @Excel(name = "演员银行卡号")
    private String number;

    /** 银行卡验证 */
    @Excel(name = "银行卡验证")
    private String verification;

    /** 身份证号 */
    @Excel(name = "身份证号")
    private String idnumber;

    /** 手机号 */
    @Excel(name = "手机号")
    private String telephone;

    /** 演出金额 */
    @Excel(name = "演出金额")
    private Double amount;

    /** 所属银行 */
    @Excel(name = "所属银行")
    private String affiliatedbank;

    /** 证件类型 */
    @Excel(name = "证件类型")
    private String documenttype;

    /** 备注 */
    @Excel(name = "备注")
    private String remarks;

    /** 添加时间 */
    @Excel(name = "添加时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date addTime;

    /** 修改时间 */
    @Excel(name = "修改时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updateTime;

    /** 添加人 */
    @Excel(name = "添加人")
    private String addUser;

    /** 修改人 */
    @Excel(name = "修改人")
    private String updateUser;

    /** 协议编号 */
    @Excel(name = "协议编号")
    private String num;


    /** 是否归档 */
    @Excel(name = "是否归档")
    private String isfile;


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

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setNumber(String number) 
    {
        this.number = number;
    }

    public String getNumber() 
    {
        return number;
    }
    public void setVerification(String verification) 
    {
        this.verification = verification;
    }

    public String getVerification() 
    {
        return verification;
    }
    public void setIdnumber(String idnumber) 
    {
        this.idnumber = idnumber;
    }

    public String getIdnumber() 
    {
        return idnumber;
    }
    public void setTelephone(String telephone) 
    {
        this.telephone = telephone;
    }

    public String getTelephone() 
    {
        return telephone;
    }
    public void setAmount(Double amount) 
    {
        this.amount = amount;
    }

    public Double getAmount() 
    {
        return amount;
    }
    public void setAffiliatedbank(String affiliatedbank) 
    {
        this.affiliatedbank = affiliatedbank;
    }

    public String getAffiliatedbank() 
    {
        return affiliatedbank;
    }
    public void setDocumenttype(String documenttype) 
    {
        this.documenttype = documenttype;
    }

    public String getDocumenttype() 
    {
        return documenttype;
    }
    public void setRemarks(String remarks) 
    {
        this.remarks = remarks;
    }

    public String getRemarks()
    {
        return remarks;
    }

    public void setAddTime(Date addTime)
    {
        this.addTime = addTime;
    }

    public Date getAddTime() 
    {
        return addTime;
    }
    public void setAddUser(String addUser) 
    {
        this.addUser = addUser;
    }

    public String getAddUser() 
    {
        return addUser;
    }
    public void setUpdateUser(String updateUser) 
    {
        this.updateUser = updateUser;
    }

    public String getUpdateUser() 
    {
        return updateUser;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("number", getNumber())
            .append("verification", getVerification())
            .append("idnumber", getIdnumber())
            .append("telephone", getTelephone())
            .append("amount", getAmount())
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
