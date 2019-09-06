package com.ruoyi.today.domain.request;

import com.alibaba.fastjson.annotation.JSONField;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 广告计划对象 th_ad
 *
 * @author ruoyi
 * @date 2019-08-15
 */
public class PlanUpdateRequest extends BaseEntity {
    private static final long serialVersionUID = 1L;

    private String modify_time;//时间戳

    /**
     * 广告主ID
     */
    @JSONField(name = "advertiser_id")
    private Long advertiserId;


    /**
     * 广告ID
     */
    @JSONField(name = "ad_id")
    private Long adId;

    /**
     * 投放范围（DEFAULT默认 UNION穿山甲）
     */
    @JSONField(name = "delivery_range")
    private String deliveryRange;

    /**
     * 预算类型（BUDGET_MODE_INFINITE不限 BUDGET_MODE_DAY日预算 BUDGET_MODE_TOTAL总预算）
     */
    @JSONField(name = "budget_mode")
    private String budgetMode;

    /**
     * 预算金额
     */
    private Double budget;

    /**
     * 开始时间（形式如：2018-01-01 00:00）
     */
    @JSONField(name = "start_time")
    private String startTime;

    /**
     * 结束时间（形式如：2018-01-01 00:00）
     */
    @JSONField(name = "end_time")
    private String endTime;

    /**
     * 出价金额（CPC、CPM在此填）
     */
    private Double bid;

    /**
     * 出价类型（PRICING_CPC PRICING_CPM PRICING_OCPM PRICING_CPV）
     */
    private String pricing;

    /**
     * 广告投放类型（SCHEDULE_FROM_NOW从现在开始一直投放 SCHEDULE_START_END选择起始时间）
     */
    @JSONField(name = "schedule_type")
    private String scheduleType;

    /**
     * 广告投放时段
     */
    @JSONField(name = "schedule_time")
    private String scheduleTime;

    /**
     * 投放速度类型（FLOW_CONTROL_MODE_FAST优先跑量 FLOW_CONTROL_MODE_SMOOTH优先低成本 FLOW_CONTROL_MODE_BALANCE均衡投放）
     */
    @JSONField(name = "flow_control_mode")
    private String flowControlMode;

    /**
     * 应用直达链接
     */
    @JSONField(name = "open_url")
    private String openUrl;

    /**
     * 应用下载方式
     */
    @JSONField(name = "download_type")
    private String downloadType;

    /**
     * 广告落地页链接
     */
    @JSONField(name = "external_url")
    private String externalUrl;

    /**
     * 广告应用下载链接
     */
    @JSONField(name = "download_url")
    private String downloadUrl;

    /**
     * 广告名称
     */
    private String name;

    /**
     * 应用下载类型
     */
    @JSONField(name = "app_type")
    private String appType;

    /**
     * 广告应用下载包名
     */
    @JSONField(name = "package")
    private String adPackage;

    /**
     * ocpm广告转化出价
     */
    @JSONField(name = "cpa_bid")
    private Double cpaBid;

    /**
     * 过滤已转化用户类型（NO_EXCLUDE不过滤 AD广告计划 CAMPAIGN广告组 ADVERTISER广告账户 APP应用 CUSTOMER公司账户）
     */
    @JSONField(name = "hide_if_converted")
    private String hideIfConverted;

    /**
     * 定向人群包列表
     */
    @JSONField(serialize = false)
    private String retargetingTagsInclude;

    //api
    private String[] retargeting_tags_include;

    /**
     * 排除人群包列表
     */
    @JSONField(serialize = false)
    private String retargetingTagsExclude;

    //api
    private String[] retargeting_tags_exclude;

    /**
     * 受众性别（NONE不限 GENDER_MALE男 GENDER_FEMALE女）
     */
    private String gender;

    //此处有问题
    /**
     * 受众年龄区间（AGE_BELOW_18小于18岁 AGE_BETWEEN_18_23等于18-23岁 AGE_BETWEEN_24_30等于24-30岁 AGE_BETWEEN_31_40等于31-40岁 AGE_BETWEEN_41_49等于41-49岁 AGE_ABOVE_50大于等于50岁）
     */
    @JSONField(serialize = false)
    private String age;
    //发送头条创建广告计划时使用
    @JSONField(name = "age")
    private String[] ages;

    /**
     * 网络类型（WIFI 2G 3G 4G）
     */
    @JSONField(serialize = false)
    private String ac;

    //发送头条创建广告计划时使用
    private String[] acs;

    /**
     * 受众文章分类
     */
    @JSONField(serialize = false)
    private String articleCategory;

    //发送api时用
    private String[] article_category;

    /**
     * 受众平台（IOS ANDROID PC）
     */
    @JSONField(serialize = false)
    private String platform;

    //发送api时用
    private String[] platforms;

//此处有问题
    /**
     * 运营商（MOBILE移动 UNICOM联通 TELCOM电信）
     */
    @JSONField(serialize = false)
    private String carrier;
    //发送头条创建广告计划时使用
    @JSONField(name = "carrier")
    private String[] carriers;

    /**
     * 地域定向城市或者区县列表
     */
    @JSONField(serialize = false)
    private String city;

    //发送api时用
    @JSONField(name = "city")
    private String[] citys;

    /**
     * 地域类型
     */
    private String district;

    /**
     * 兴趣分类
     */
    @JSONField(serialize = false)
    private String adTag;

    //发api时用
    private String[] ad_tag;

    /**
     * 兴趣关键词
     */
    @JSONField(serialize = false)
    private String interestTags;

    //api用
    private String[] interest_tags;

    /**
     * APP行为定向
     */
    @JSONField(name = "app_behavior_target")
    private String appBehaviorTarget;

    /**
     * APP行为按分类集合
     */
    @JSONField(serialize = false)
    private String appCategory;

    //api用
    private String[] app_category;

    /**
     * APP行为定向,APP集合
     */
    @JSONField(serialize = false)
    private String appIds;

    //api用
    private String[] app_ids;

    public Long getAdvertiserId() {
        return advertiserId;
    }

    public void setAdvertiserId(Long advertiserId) {
        this.advertiserId = advertiserId;
    }

    public Long getAdId() {
        return adId;
    }

    public void setAdId(Long adId) {
        this.adId = adId;
    }

    public String getDeliveryRange() {
        return deliveryRange;
    }

    public void setDeliveryRange(String deliveryRange) {
        this.deliveryRange = deliveryRange;
    }

    public String getBudgetMode() {
        return budgetMode;
    }

    public void setBudgetMode(String budgetMode) {
        this.budgetMode = budgetMode;
    }

    public Double getBudget() {
        return budget;
    }

    public void setBudget(Double budget) {
        this.budget = budget;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Double getBid() {
        return bid;
    }

    public void setBid(Double bid) {
        this.bid = bid;
    }

    public String getPricing() {
        return pricing;
    }

    public void setPricing(String pricing) {
        this.pricing = pricing;
    }

    public String getScheduleType() {
        return scheduleType;
    }

    public void setScheduleType(String scheduleType) {
        this.scheduleType = scheduleType;
    }

    public String getScheduleTime() {
        return scheduleTime;
    }

    public void setScheduleTime(String scheduleTime) {
        this.scheduleTime = scheduleTime;
    }

    public String getFlowControlMode() {
        return flowControlMode;
    }

    public void setFlowControlMode(String flowControlMode) {
        this.flowControlMode = flowControlMode;
    }

    public String getOpenUrl() {
        return openUrl;
    }

    public void setOpenUrl(String openUrl) {
        this.openUrl = openUrl;
    }

    public String getDownloadType() {
        return downloadType;
    }

    public void setDownloadType(String downloadType) {
        this.downloadType = downloadType;
    }

    public String getExternalUrl() {
        return externalUrl;
    }

    public void setExternalUrl(String externalUrl) {
        this.externalUrl = externalUrl;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAppType() {
        return appType;
    }

    public void setAppType(String appType) {
        this.appType = appType;
    }

    public String getAdPackage() {
        return adPackage;
    }

    public void setAdPackage(String adPackage) {
        this.adPackage = adPackage;
    }

    public Double getCpaBid() {
        return cpaBid;
    }

    public void setCpaBid(Double cpaBid) {
        this.cpaBid = cpaBid;
    }

    public String getHideIfConverted() {
        return hideIfConverted;
    }

    public void setHideIfConverted(String hideIfConverted) {
        this.hideIfConverted = hideIfConverted;
    }

    public String getRetargetingTagsInclude() {
        return retargetingTagsInclude;
    }

    public void setRetargetingTagsInclude(String retargetingTagsInclude) {
        this.retargetingTagsInclude = retargetingTagsInclude;
    }

    public String[] getRetargeting_tags_include() {
        return retargeting_tags_include;
    }

    public void setRetargeting_tags_include(String[] retargeting_tags_include) {
        this.retargeting_tags_include = retargeting_tags_include;
    }

    public String getRetargetingTagsExclude() {
        return retargetingTagsExclude;
    }

    public void setRetargetingTagsExclude(String retargetingTagsExclude) {
        this.retargetingTagsExclude = retargetingTagsExclude;
    }

    public String[] getRetargeting_tags_exclude() {
        return retargeting_tags_exclude;
    }

    public void setRetargeting_tags_exclude(String[] retargeting_tags_exclude) {
        this.retargeting_tags_exclude = retargeting_tags_exclude;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String[] getAges() {
        return ages;
    }

    public void setAges(String[] ages) {
        this.ages = ages;
    }

    public String getAc() {
        return ac;
    }

    public void setAc(String ac) {
        this.ac = ac;
    }

    public String[] getAcs() {
        return acs;
    }

    public void setAcs(String[] acs) {
        this.acs = acs;
    }

    public String getArticleCategory() {
        return articleCategory;
    }

    public void setArticleCategory(String articleCategory) {
        this.articleCategory = articleCategory;
    }

    public String[] getArticle_category() {
        return article_category;
    }

    public void setArticle_category(String[] article_category) {
        this.article_category = article_category;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String[] getPlatforms() {
        return platforms;
    }

    public void setPlatforms(String[] platforms) {
        this.platforms = platforms;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public String[] getCarriers() {
        return carriers;
    }

    public void setCarriers(String[] carriers) {
        this.carriers = carriers;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String[] getCitys() {
        return citys;
    }

    public void setCitys(String[] citys) {
        this.citys = citys;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getAdTag() {
        return adTag;
    }

    public void setAdTag(String adTag) {
        this.adTag = adTag;
    }

    public String[] getAd_tag() {
        return ad_tag;
    }

    public void setAd_tag(String[] ad_tag) {
        this.ad_tag = ad_tag;
    }

    public String getInterestTags() {
        return interestTags;
    }

    public void setInterestTags(String interestTags) {
        this.interestTags = interestTags;
    }

    public String[] getInterest_tags() {
        return interest_tags;
    }

    public void setInterest_tags(String[] interest_tags) {
        this.interest_tags = interest_tags;
    }

    public String getAppBehaviorTarget() {
        return appBehaviorTarget;
    }

    public void setAppBehaviorTarget(String appBehaviorTarget) {
        this.appBehaviorTarget = appBehaviorTarget;
    }

    public String getAppCategory() {
        return appCategory;
    }

    public void setAppCategory(String appCategory) {
        this.appCategory = appCategory;
    }

    public String[] getApp_category() {
        return app_category;
    }

    public void setApp_category(String[] app_category) {
        this.app_category = app_category;
    }

    public String getAppIds() {
        return appIds;
    }

    public void setAppIds(String appIds) {
        this.appIds = appIds;
    }

    public String[] getApp_ids() {
        return app_ids;
    }

    public void setApp_ids(String[] app_ids) {
        this.app_ids = app_ids;
    }

    public String getModify_time() {
        return modify_time;
    }

    public void setModify_time(String modify_time) {
        this.modify_time = modify_time;
    }
}
