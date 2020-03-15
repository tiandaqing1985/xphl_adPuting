package com.ruoyi.today.domain;

public class MatterReportVO {

    private String orderId;
    private String matterId;
    private String rangeTime;
    private String reportTime;
    private String reportCost;

    public MatterReportVO() {

    }

    public MatterReportVO(String reportTime) {
        this.reportTime = reportTime;
    }

    public String getMatterId() {
        return matterId;
    }

    public void setMatterId(String matterId) {
        this.matterId = matterId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getRangeTime() {
        return rangeTime;
    }

    public void setRangeTime(String rangeTime) {
        this.rangeTime = rangeTime;
    }

    public String getReportTime() {
        return reportTime;
    }

    public void setReportTime(String reportTime) {
        this.reportTime = reportTime;
    }

    public String getReportCost() {
        return reportCost;
    }

    public void setReportCost(String reportCost) {
        this.reportCost = reportCost;
    }
}
