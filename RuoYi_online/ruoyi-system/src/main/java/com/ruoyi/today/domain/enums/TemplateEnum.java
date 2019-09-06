package com.ruoyi.today.domain.enums;

public enum TemplateEnum {

    模板一("PRICING_CPC", "DEFAULT", "DOWNLOAD_URL"),
    模板二("PRICING_CPC", "DEFAULT", "EXTERNAL_URL"),
    模板三("PRICING_CPM", "DEFAULT", "DOWNLOAD_URL"),
    模板四("PRICING_CPM", "DEFAULT", "EXTERNAL_URL"),
    模板五("PRICING_OCPM", "DEFAULT", "DOWNLOAD_URL"),
    模板六("PRICING_OCPM", "DEFAULT", "EXTERNAL_URL");


    private String pricing;//出价类型-投放目标  CPC-点击量  CPM-展示量 OCPM-转化量
    private String deliveryRange;//投放范围  DEFAULT-默认 UNION-穿山甲
    private String downloadType;//下载方式 DOWNLOAD_URL-下载链接  EXTERNAL_URL-落地页链接

    TemplateEnum(String pricing, String deliveryRange, String downloadType) {
        this.pricing = pricing;
        this.deliveryRange = deliveryRange;
        this.downloadType = downloadType;
    }

    public String getPricing() {
        return pricing;
    }

    public void setPricing(String pricing) {
        this.pricing = pricing;
    }

    public String getDeliveryRange() {
        return deliveryRange;
    }

    public void setDeliveryRange(String deliveryRange) {
        this.deliveryRange = deliveryRange;
    }

    public String getDownloadType() {
        return downloadType;
    }

    public void setDownloadType(String downloadType) {
        this.downloadType = downloadType;
    }

}
