package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 财务查看对象 actor_facExhibition
 * 
 * @author ruoyi
 * @date 2020-01-13
 */
public class ActorFacSys extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 演员姓名 */
    @Excel(name = "演员姓名")
    private String actorName;

    /** 银行卡号 */
    @Excel(name = "银行卡号")
    private Long number;

    /** 身份证号 */
    @Excel(name = "身份证号")
    private String idnumber;

    /** 手机号 */
    @Excel(name = "手机号")
    private Long telephone;

    /** 金额 */
    @Excel(name = "金额")
    private Double amount;

    /** 所属银行 */
    @Excel(name = "所属银行")
    private String documenttype;

    /** 证件类型 */
    @Excel(name = "证件类型")
    private String opi;

    /** 拍摄时间 */
    @Excel(name = "拍摄时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date shotTime;



    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setActorName(String actorName) 
    {
        this.actorName = actorName;
    }

    public String getActorName() 
    {
        return actorName;
    }
    public void setNumber(Long number) 
    {
        this.number = number;
    }

    public Long getNumber() 
    {
        return number;
    }

    public void setTelephone(Long telephone) 
    {
        this.telephone = telephone;
    }

    public Long getTelephone() 
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
    public void setDocumenttype(String documenttype) 
    {
        this.documenttype = documenttype;
    }

    public String getDocumenttype() 
    {
        return documenttype;
    }
    public void setOpi(String opi) 
    {
        this.opi = opi;
    }

    public String getOpi() 
    {
        return opi;
    }
    public void setShotTime(Date shotTime) 
    {
        this.shotTime = shotTime;
    }

    public Date getShotTime() 
    {
        return shotTime;
    }


    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }



    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("actorName", getActorName())
            .append("number", getNumber())
            .append("idnumber", getIdnumber())
            .append("telephone", getTelephone())
            .append("amount", getAmount())
            .append("documenttype", getDocumenttype())
            .append("opi", getOpi())
            .append("shotTime", getShotTime())

            .toString();
    }
}
