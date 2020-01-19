package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 拍摄需求单对象 actor_shot_demand
 * 
 * @author ruoyi
 * @date 2020-01-06
 */
public class ActorShotDemand extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 组长 */
    @Excel(name = "组长")
    private String groupLeader;

    /** 组别 */
    @Excel(name = "组别")
    private String groupType;

    /** 成员 */
    @Excel(name = "成员")
    private String member;

    /** 客户签约方 */
    @Excel(name = "客户签约方")
    private String contractParty;

    /** 客户广告主 */
    @Excel(name = "客户广告主")
    private String advertiser;

    /** 客户简称 */
    @Excel(name = "客户简称")
    private String customerName;

    /** 需求对接人 */
    @Excel(name = "需求对接人")
    private String demandName;

    /** 销售经理 */
    @Excel(name = "销售经理")
    private String salesManager;

    /** 投放平台 */
    @Excel(name = "投放平台")
    private String delivery;

    /** 销售类型 */
    @Excel(name = "销售类型")
    private String salesType;

    /** 情景剧 */
    @Excel(name = "情景剧")
    private Long sitcom;

    /** 纯剪辑 */
    @Excel(name = "纯剪辑")
    private Long clip;

    /** 合计 */
    @Excel(name = "合计")
    private Long total;

    /** 拍摄时间 */
    @Excel(name = "拍摄时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date shotTime;

    /** 成本类型 */
    @Excel(name = "成本类型")
    private String costType;

    /** 创建时间 */
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startTime;

    /** 创建人 */
    @Excel(name = "创建人")
    private String username;

    /** 修改人 */
    @Excel(name = "修改人")
    private String updatename;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setGroupLeader(String groupLeader) 
    {
        this.groupLeader = groupLeader;
    }

    public String getGroupLeader() 
    {
        return groupLeader;
    }
    public void setGroupType(String groupType) 
    {
        this.groupType = groupType;
    }

    public String getGroupType() 
    {
        return groupType;
    }
    public void setMember(String member) 
    {
        this.member = member;
    }

    public String getMember() 
    {
        return member;
    }
    public void setContractParty(String contractParty) 
    {
        this.contractParty = contractParty;
    }

    public String getContractParty() 
    {
        return contractParty;
    }
    public void setAdvertiser(String advertiser) 
    {
        this.advertiser = advertiser;
    }

    public String getAdvertiser() 
    {
        return advertiser;
    }
    public void setCustomerName(String customerName) 
    {
        this.customerName = customerName;
    }

    public String getCustomerName() 
    {
        return customerName;
    }
    public void setDemandName(String demandName) 
    {
        this.demandName = demandName;
    }

    public String getDemandName() 
    {
        return demandName;
    }
    public void setSalesManager(String salesManager) 
    {
        this.salesManager = salesManager;
    }

    public String getSalesManager() 
    {
        return salesManager;
    }
    public void setDelivery(String delivery) 
    {
        this.delivery = delivery;
    }

    public String getDelivery() 
    {
        return delivery;
    }
    public void setSalesType(String salesType) 
    {
        this.salesType = salesType;
    }

    public String getSalesType() 
    {
        return salesType;
    }
    public void setSitcom(Long sitcom) 
    {
        this.sitcom = sitcom;
    }

    public Long getSitcom() 
    {
        return sitcom;
    }
    public void setClip(Long clip) 
    {
        this.clip = clip;
    }

    public Long getClip() 
    {
        return clip;
    }
    public void setTotal(Long total) 
    {
        this.total = total;
    }

    public Long getTotal() 
    {
        return total;
    }
    public void setShotTime(Date shotTime) 
    {
        this.shotTime = shotTime;
    }

    public Date getShotTime() 
    {
        return shotTime;
    }
    public void setCostType(String costType) 
    {
        this.costType = costType;
    }

    public String getCostType() 
    {
        return costType;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("groupLeader", getGroupLeader())
            .append("groupType", getGroupType())
            .append("member", getMember())
            .append("contractParty", getContractParty())
            .append("advertiser", getAdvertiser())
            .append("customerName", getCustomerName())
            .append("demandName", getDemandName())
            .append("salesManager", getSalesManager())
            .append("delivery", getDelivery())
            .append("salesType", getSalesType())
            .append("sitcom", getSitcom())
            .append("clip", getClip())
            .append("total", getTotal())
            .append("shotTime", getShotTime())
            .append("costType", getCostType())
            .append("startTime", getStartTime())
            .append("updateTime", getUpdateTime())
            .append("username", getUsername())
            .append("updatename", getUpdatename())
            .toString();
    }
}
