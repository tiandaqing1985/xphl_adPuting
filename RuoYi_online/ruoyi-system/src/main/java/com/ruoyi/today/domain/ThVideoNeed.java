package com.ruoyi.today.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.sql.Date;

/**
 * 视频需求对象 th_video_need
 *
 * @author ruoyi
 * @date 2020-03-02
 */
public class ThVideoNeed extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * $column.columnComment
     */
    private Long id;

    /**
     * 需求名称
     */
    @Excel(name = "需求名称")
    private String needName;

    /**
     * 订单号
     */
    @Excel(name = "订单号")
    private String orderId;

    /**
     * 产品名称
     */
    @Excel(name = "产品名称")
    private String productName;

    /**
     * 投放链接
     */
    @Excel(name = "投放链接")
    private String putUrl;

    /**
     * 产品logo文件路径
     */
    @Excel(name = "产品logo文件路径")
    private String logoUrl;

    /**
     * 产品说明
     */
    @Excel(name = "产品说明")
    private String productDetail;

    /**
     * 优化组长
     */
    @Excel(name = "优化组长")
    private String optimizeGroupLeader;

    /**
     * 下单类型
     */
    @Excel(name = "下单类型")
    private String orderType;

    /**
     * 投放媒体
     */
    @Excel(name = "投放媒体")
    private String putMedia;

    /**
     * 截止日期
     */
    @Excel(name = "截止日期", width = 30, dateFormat = "yyyy-MM-dd")
    private java.sql.Date endTime;

    /**
     * 接单团队
     */
    @Excel(name = "接单团队")
    private String group;

    //接单部门
    private String videoDept;

    //产品行业
    private String productTrade;

    public String getVideoDept() {
        return videoDept;
    }

    public void setVideoDept(String videoDept) {
        this.videoDept = videoDept;
    }

    public String getProductTrade() {
        return productTrade;
    }

    public void setProductTrade(String productTrade) {
        this.productTrade = productTrade;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setNeedName(String needName) {
        this.needName = needName;
    }

    public String getNeedName() {
        return needName;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public void setPutUrl(String putUrl) {
        this.putUrl = putUrl;
    }

    public String getPutUrl() {
        return putUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setProductDetail(String productDetail) {
        this.productDetail = productDetail;
    }

    public String getProductDetail() {
        return productDetail;
    }

    public void setOptimizeGroupLeader(String optimizeGroupLeader) {
        this.optimizeGroupLeader = optimizeGroupLeader;
    }

    public String getOptimizeGroupLeader() {
        return optimizeGroupLeader;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setPutMedia(String putMedia) {
        this.putMedia = putMedia;
    }

    public String getPutMedia() {
        return putMedia;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getGroup() {
        return group;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("needName", getNeedName())
                .append("orderId", getOrderId())
                .append("productName", getProductName())
                .append("putUrl", getPutUrl())
                .append("logoUrl", getLogoUrl())
                .append("productDetail", getProductDetail())
                .append(" optimizeGroupLeader", getOptimizeGroupLeader())
                .append("orderType", getOrderType())
                .append("putMedia", getPutMedia())
                .append("endTime", getEndTime())
                .append("group", getGroup())
                .append("createTime", getCreateTime())
                .append("createBy", getCreateBy())
                .append("updateTime", getUpdateTime())
                .append("updateBy", getUpdateBy())
                .toString();
    }
}
