package com.ruoyi.today.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 操作历史对象 th_video_operation_history
 * 
 * @author ruoyi
 * @date 2020-03-05
 */
public class ThVideoOperationHistory extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 订单编号 */
    @Excel(name = "订单编号")
    private Long orderId;

    /** 状态 */
    @Excel(name = "状态")
    private String status;

    /** 操作时间 */
    @Excel(name = "操作时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date operationTime;

    /** 操作者 */
    @Excel(name = "操作者")
    private String operationBy;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setOrderId(Long orderId) 
    {
        this.orderId = orderId;
    }

    public Long getOrderId() 
    {
        return orderId;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setOperationTime(Date operationTime) 
    {
        this.operationTime = operationTime;
    }

    public Date getOperationTime() 
    {
        return operationTime;
    }
    public void setOperationBy(String operationBy) 
    {
        this.operationBy = operationBy;
    }

    public String getOperationBy() 
    {
        return operationBy;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("orderId", getOrderId())
            .append("status", getStatus())
            .append("operationTime", getOperationTime())
            .append("operationBy", getOperationBy())
            .toString();
    }
}
