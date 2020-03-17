package com.ruoyi.today.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.sql.Date;

/**
 * 订单交付素材关联对象 th_video_matter
 *
 * @author ruoyi
 * @date 2020-03-09
 */
public class ThMatterManage
{

    private String videoGroup;

    private String videoDept;

    private String reportCost;

    private String reportShow;

    /** 主键 */
    private Long id;

    private Long orderId;

    private String orderName;

    private String needName;

    //平均单词播放时长
    private String averagePlayTimePerPlay;

    private String fileName;

    //总播放数
    private String totalPlay;

    /** 素材url */
    private String matter;

    private String videoCover;

    private String status;

    private String timeRange;

    private String productName;

    private String sql;

    private Date createTime;

    private Integer page;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public String getVideoDept() {
        return videoDept;
    }

    public void setVideoDept(String videoDept) {
        this.videoDept = videoDept;
    }

    public String getTimeRange() {
        return timeRange;
    }

    public void setTimeRange(String timeRange) {
        this.timeRange = timeRange;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getVideoGroup() {
        return videoGroup;
    }

    public void setVideoGroup(String videoGroup) {
        this.videoGroup = videoGroup;
    }

    public String getReportCost() {
        return reportCost;
    }

    public void setReportCost(String reportCost) {
        this.reportCost = reportCost;
    }

    public String getReportShow() {
        return reportShow;
    }

    public void setReportShow(String reportShow) {
        this.reportShow = reportShow;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getNeedName() {
        return needName;
    }

    public void setNeedName(String needName) {
        this.needName = needName;
    }

    public String getAveragePlayTimePerPlay() {
        return averagePlayTimePerPlay;
    }

    public void setAveragePlayTimePerPlay(String averagePlayTimePerPlay) {
        this.averagePlayTimePerPlay = averagePlayTimePerPlay;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getTotalPlay() {
        return totalPlay;
    }

    public void setTotalPlay(String totalPlay) {
        this.totalPlay = totalPlay;
    }

    public String getMatter() {
        return matter;
    }

    public void setMatter(String matter) {
        this.matter = matter;
    }

    public String getVideoCover() {
        return videoCover;
    }

    public void setVideoCover(String videoCover) {
        this.videoCover = videoCover;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
