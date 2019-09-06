package com.ruoyi.today.domain;

import com.alibaba.fastjson.annotation.JSONField;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 广告计划对象 th_ad
 *
 * @author ruoyi
 * @date 2019-08-15
 */
public class ThAd extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    private Long id;

    /**
     * 广告主ID
     */
    @Excel(name = "广告主ID", type = Excel.Type.ALL)
    @JSONField(name = "advertiser_id")
    private Long advertiserId;

    /**
     * 广告主名称
     */
    @Excel(name = "广告主名称", type = Excel.Type.ALL)
    @JSONField(serialize = false)
    private String advertiserName;

    /**
     * 广告组ID
     */
    @Excel(name = "广告组ID", type = Excel.Type.ALL)
    @JSONField(name = "campaign_id")
    private Long campaignId;

    /**
     * 广告组名称
     */
    @Excel(name = "广告组名称", type = Excel.Type.ALL)
    @JSONField(serialize = false)
    private String campaignName;

    /**
     * 广告ID
     */
    @Excel(name = "广告ID", type = Excel.Type.ALL)
    @JSONField(serialize = false)
    private Long adId;

    /**
     * 广告名称
     */
    @Excel(name = "广告名称", type = Excel.Type.ALL)
    private String name;

    /**
     * 投放范围（DEFAULT默认 UNION穿山甲）
     */
    @Excel(name = "投放范围", readConverterExp = "DEFAULT=默认,UNION=穿山甲", type = Excel.Type.ALL)
    @JSONField(name = "delivery_range")
    private String deliveryRange;

    /**
     * 预算类型（BUDGET_MODE_INFINITE不限 BUDGET_MODE_DAY日预算 BUDGET_MODE_TOTAL总预算）
     */
    @Excel(name = "预算类型", readConverterExp = "NONE=不限,BUDGET_MODE_DAY=日预算,BUDGET_MODE_TOTAL=总预算", type = Excel.Type.ALL)
    @JSONField(name = "budget_mode")
    private String budgetMode;

    /**
     * 预算金额
     */
    @Excel(name = "预算金额", type = Excel.Type.ALL)
    private Double budget;

    /**
     * 开始时间（形式如：2018-01-01 00:00）
     */
    @Excel(name = "开始时间", dateFormat = "yyyy-MM-dd HH-mm-ss", type = Excel.Type.ALL)
    @JSONField(name = "start_time")
    private String startTime;

    /**
     * 结束时间（形式如：2018-01-01 00:00）
     */
    @Excel(name = "结束时间", dateFormat = "yyyy-MM-dd HH-mm-ss", type = Excel.Type.ALL)
    @JSONField(name = "end_time")
    private String endTime;

    /**
     * 出价类型（PRICING_CPC PRICING_CPM PRICING_OCPM PRICING_CPV）
     */
    @Excel(name = "出价类型", readConverterExp = "P=RICING_CPC,P=RICING_CPM,P=RICING_OCPM,P=RICING_CPV", type = Excel.Type.ALL)
    private String pricing;

    /**
     * 出价金额（CPC、CPM在此填）
     */
    @Excel(name = "出价金额", type = Excel.Type.ALL)
    private Double bid;

    /**
     * 广告投放类型（SCHEDULE_FROM_NOW从现在开始一直投放 SCHEDULE_START_END选择起始时间）
     */
    @Excel(name = "广告投放类型", readConverterExp = "SCHEDULE_FROM_NOW=从现在开始一直投放,SCHEDULE_START_END=选择起始时间", type = Excel.Type.ALL)
    @JSONField(name = "schedule_type")
    private String scheduleType;

    /**
     * 广告投放时段
     */
    @Excel(name = "广告投放时段", type = Excel.Type.ALL)
    @JSONField(name = "schedule_time")
    private String scheduleTime;

    /**
     * 投放速度类型（FLOW_CONTROL_MODE_FAST优先跑量 FLOW_CONTROL_MODE_SMOOTH优先低成本 FLOW_CONTROL_MODE_BALANCE均衡投放）
     */
    @Excel(name = "投放速度类型", readConverterExp = "FLOW_CONTROL_MODE_FAST=优先跑量,FLOW_CONTROL_MODE_SMOOTH=优先低成本,FLOW_CONTROL_MODE_BALANCE=均衡投放", type = Excel.Type.ALL)
    @JSONField(name = "flow_control_mode")
    private String flowControlMode;

    /**
     * 应用直达链接
     */
    @Excel(name = "应用直达链接", type = Excel.Type.ALL)
    @JSONField(name = "open_url")
    private String openUrl;

    /**
     * 应用下载方式
     */
    @Excel(name = "应用下载方式", readConverterExp = "DOWNLOAD_URL=下载链接,EXTERNAL_URL=落地页链接", type = Excel.Type.ALL)
    @JSONField(name = "download_type")
    private String downloadType;

    /**
     * 广告落地页链接
     */
    @Excel(name = "广告落地页链接", type = Excel.Type.ALL)
    @JSONField(name = "external_url")
    private String externalUrl;

    /**
     * 广告应用下载链接
     */
    @Excel(name = "广告应用下载链接", type = Excel.Type.ALL)
    @JSONField(name = "download_url")
    private String downloadUrl;

    /**
     * 应用下载类型
     */
    @Excel(name = "应用下载类型", readConverterExp = "APP_ANDROID=Android,APP_IOS=IOS", type = Excel.Type.ALL)
    @JSONField(name = "app_type")
    private String appType;

    /**
     * 广告应用下载包名
     */
    @Excel(name = "广告应用下载包名", type = Excel.Type.ALL)
    @JSONField(name = "package")
    private String adPackage;

    /**
     * 过滤已转化用户类型（NO_EXCLUDE不过滤 AD广告计划 CAMPAIGN广告组 ADVERTISER广告账户 APP应用 CUSTOMER公司账户）
     */
    @Excel(name = "过滤已转化用户类型", readConverterExp = "NO_EXCLUDE=不过滤,AD=广告计划,CAMPAIGN=广告组,ADVERTISER=广告账户,APP=APP,CUSTOMER=公司账户", type = Excel.Type.ALL)
    @JSONField(name = "hide_if_converted")
    private String hideIfConverted;

    /**
     * ocpm广告转化出价
     */
    @Excel(name = "ocpm广告转化出价", type = Excel.Type.ALL)
    @JSONField(name = "cpa_bid")
    private Double cpaBid;

    /**
     * 转化ID
     */
    @Excel(name = "转化ID")
    @JSONField(name = "convert_id")
    private Long convertId;

    /**
     * 定向人群包列表
     */
    @Excel(name = "定向人群包列表", type = Excel.Type.ALL)
    @JSONField(serialize = false)
    private String retargetingTagsInclude;

    //api
    private String[] retargeting_tags_include;

    /**
     * 排除人群包列表
     */
    @Excel(name = "排除人群包列表", type = Excel.Type.ALL)
    @JSONField(serialize = false)
    private String retargetingTagsExclude;

    //api
    private String[] retargeting_tags_exclude;

    /**
     * 受众性别（NONE不限 GENDER_MALE男 GENDER_FEMALE女）
     */
    @Excel(name = "受众性别", readConverterExp = "NONE=不限,GENDER_MALE=男,GENDER_FEMALE=女", type = Excel.Type.ALL)
    private String gender;

    //此处有问题
    /**
     * 受众年龄区间（AGE_BELOW_18小于18岁 AGE_BETWEEN_18_23等于18-23岁 AGE_BETWEEN_24_30等于24-30岁 AGE_BETWEEN_31_40等于31-40岁 AGE_BETWEEN_41_49等于41-49岁 AGE_ABOVE_50大于等于50岁）
     */
    @Excel(name = "受众年龄区间", readConverterExp = "AGE_BELOW_18=小于18岁,AGE_BETWEEN_18_23=18-23岁,AGE_BETWEEN_24_30=24-30岁,AGE_BETWEEN_31_40=31-40岁,AGE_BETWEEN_41_49=41-49岁,AGE_ABOVE_50=大于等于50岁", type = Excel.Type.ALL)
    @JSONField(serialize = false)
    private String age;
    //发送头条创建广告计划时使用
    @JSONField(name = "age")
    private String[] ages;

    //此处有问题
    /**
     * 运营商（MOBILE移动 UNICOM联通 TELCOM电信）
     */
    @Excel(name = "运营商", readConverterExp = "MOBILE=移动,UNICOM=联通,TELCOM=电信", type = Excel.Type.ALL)
    @JSONField(serialize = false)
    private String carrier;
    //发送头条创建广告计划时使用
    @JSONField(name = "carrier")
    private String[] carriers;

    /**
     * 网络类型（WIFI 2G 3G 4G）
     */
    @Excel(name = "网络类型", readConverterExp = "WIFI=wifi,2G=2G,3G=3G,4G=4G", type = Excel.Type.ALL)
    @JSONField(serialize = false)
    private String ac;

    //发送头条创建广告计划时使用
    private String[] acs;

    /**
     * 受众文章分类
     */
    @Excel(name = "受众文章分类", readConverterExp = "ENTERTAINMENT=娱乐,SOCIETY=社会,CARS=汽车,INTERNATIONAL=国际,HISTORY=历史,SPORTS=体育,HEALTH=健康,MILITARY=军事,EMOTION=情感,FASHION=时尚,PARENTING=育儿,FINANCE=财经,AMUSEMENT=搞笑,DIGITAL=数码,EXPLORE=探索,TRAVEL=旅游,CONSTELLATION=星座,STORIES=故事,TECHNOLOGY=科技,GOURMET=美食,CULTURE=文化,HOME=家居,MOVIE=电影,PETS=宠物,GAMES=游戏,WEIGHT_LOSING=瘦身,FREAK=奇葩,EDUCATION=教育,ESTATE=房产,SCIENCE=科学,PHOTOGRAPHY=摄影,REGIMEN=养生,ESSAY=美文,COLLECTION=收藏,ANIMATION=动漫,COMICS=漫画,TIPS=小窍门,DESIGN=设计,LOCAL=本地,LAWS=法制,GOVERNMENT=政务,BUSINESS=商业,WORKPLACE=职场,RUMOR_CRACKER=辟谣,GRADUATES=毕业生", type = Excel.Type.ALL)
    @JSONField(serialize = false)
    private String articleCategory;

    //发送api时用
    private String[] article_category;

    /**
     * 受众平台（IOS ANDROID PC）
     */
    @Excel(name = "受众平台", readConverterExp = "ANDROID=android,IOS=iOS,PC=PC", type = Excel.Type.ALL)
    @JSONField(serialize = false)
    private String platform;

    //发送api时用
    @JSONField(name = "platform")
    private String[] platforms;

    /**
     * 地域类型
     */
    @Excel(name = "地域类型", readConverterExp = "CITY=按省市,COUNTY=按区县,BUSINESS_DISTRICT=按商圈,NONE=不限", type = Excel.Type.ALL)
    private String district;

    /**
     * 地域定向城市或者区县列表
     */
    @Excel(name = "地域定向城市或者区县列表", type = Excel.Type.ALL)
    @JSONField(serialize = false)
    private String city;

    //发送api时用
    @JSONField(name = "city")
    private String[] citys;

    /**
     * 兴趣分类
     */
    @Excel(name = "兴趣分类", type = Excel.Type.ALL)
    @JSONField(serialize = false)
    private String adTag;

    //发api时用
    private String[] ad_tag;

    /**
     * 兴趣关键词
     */
    @Excel(name = "兴趣关键词", type = Excel.Type.ALL)
    @JSONField(serialize = false)
    private String interestTags;

    //api用
    private String[] interest_tags;

    /**
     * APP行为定向
     */
    @Excel(name = "APP行为定向", readConverterExp = "NONE=不限,CATEGORY=按分类,APP=按APP", type = Excel.Type.ALL)
    @JSONField(name = "app_behavior_target")
    private String appBehaviorTarget;

    /**
     * APP行为按分类集合
     */
    @Excel(name = "APP行为按分类集合", type = Excel.Type.ALL)
    @JSONField(serialize = false)
    private String appCategory;

    //api用
    private String[] app_category;

    /**
     * APP行为定向,APP集合
     */
    @Excel(name = "APP行为定向,APP集合", type = Excel.Type.ALL)
    @JSONField(serialize = false)
    private String appIds;

    //api用
    private String[] app_ids;

    /**
     * 状态（0正常 1停用）
     */
    @JSONField(serialize = false)
    private String status;

    @Excel(name = "广告组预算类型", readConverterExp = "BUDGET_MODE_INFINITE=不限,BUDGET_MODE_DAY=日预算,BUDGET_MODE_TOTAL=总预算", type = Excel.Type.IMPORT)
    @JSONField(serialize = false)
    private String groupBudgetMode;

    @Excel(name = "广告组预算", type = Excel.Type.IMPORT)
    @JSONField(serialize = false)
    private Long groupBudget;

    @Excel(name = "广告组推广目的", readConverterExp = "LINK=销售线索收集,APP=应用推广,DPA=产品目录推广,GOODS=商品推广（鲁班）,STORE=门店推广,AWEME=抖音号推广,SHOP=电商店铺推广", type = Excel.Type.IMPORT)
    @JSONField(serialize = false)
    private String landingType;

    /**
     * 删除标志（0代表存在 2代表删除）
     */
    @JSONField(serialize = false)
    private String delFlag;

    @JSONField(serialize = false)
    private Date start;
    @JSONField(serialize = false)
    private Date end;
    //批量更新时使用
    @JSONField(serialize = false)
    private String ids;

    //更新标志
    private String updateFlag;

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public String getUpdateFlag() {
        return updateFlag;
    }

    public void setUpdateFlag(String updateFlag) {
        this.updateFlag = updateFlag;
    }

    public String getLandingType() {
        return landingType;
    }

    public void setLandingType(String landingType) {
        this.landingType = landingType;
    }

    public Long getGroupBudget() {
        return groupBudget;
    }

    public void setGroupBudget(Long groupBudget) {
        this.groupBudget = groupBudget;
    }

    public String getGroupBudgetMode() {
        return groupBudgetMode;
    }

    public void setGroupBudgetMode(String groupBudgetMode) {
        this.groupBudgetMode = groupBudgetMode;
    }

    public String[] getAcs() {
        return acs;
    }

    public void setAcs(String[] acs) {
        this.acs = acs;
    }

    public String[] getArticle_category() {
        return article_category;
    }

    public void setArticle_category(String[] article_category) {
        this.article_category = article_category;
    }

    public String[] getPlatforms() {
        return platforms;
    }

    public void setPlatforms(String[] platforms) {
        this.platforms = platforms;
    }

    public String[] getCitys() {
        return citys;
    }

    public void setCitys(String[] citys) {
        this.citys = citys;
    }

    public String[] getAd_tag() {
        return ad_tag;
    }

    public void setAd_tag(String[] ad_tag) {
        this.ad_tag = ad_tag;
    }

    public String[] getInterest_tags() {
        return interest_tags;
    }

    public void setInterest_tags(String[] interest_tags) {
        this.interest_tags = interest_tags;
    }

    public String[] getApp_category() {
        return app_category;
    }

    public void setApp_category(String[] app_category) {
        this.app_category = app_category;
    }

    public String[] getApp_ids() {
        return app_ids;
    }

    public void setApp_ids(String[] app_ids) {
        this.app_ids = app_ids;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setAdvertiserId(Long advertiserId) {
        this.advertiserId = advertiserId;
    }

    public String[] getAges() {
        return ages;
    }

    public void setAges(String[] ages) {
        this.ages = ages;
    }

    public String[] getCarriers() {
        return carriers;
    }

    public void setCarriers(String[] carriers) {
        this.carriers = carriers;
    }

    public Long getAdvertiserId() {
        return advertiserId;
    }

    public void setAdvertiserName(String advertiserName) {
        this.advertiserName = advertiserName;
    }

    public String getAdvertiserName() {
        return advertiserName;
    }

    public void setCampaignId(Long campaignId) {
        this.campaignId = campaignId;
    }

    public Long getCampaignId() {
        return campaignId;
    }

    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName;
    }

    public String getCampaignName() {
        return campaignName;
    }

    public void setAdId(Long adId) {
        this.adId = adId;
    }

    public Long getAdId() {
        return adId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDeliveryRange(String deliveryRange) {
        this.deliveryRange = deliveryRange;
    }

    public String getDeliveryRange() {
        return deliveryRange;
    }

    public void setBudgetMode(String budgetMode) {
        this.budgetMode = budgetMode;
    }

    public String getBudgetMode() {
        return budgetMode;
    }

    public void setBudget(Double budget) {
        this.budget = budget;
    }

    public Double getBudget() {
        return budget;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setPricing(String pricing) {
        this.pricing = pricing;
    }

    public String getPricing() {
        return pricing;
    }

    public void setBid(Double bid) {
        this.bid = bid;
    }

    public Double getBid() {
        return bid;
    }

    public void setScheduleType(String scheduleType) {
        this.scheduleType = scheduleType;
    }

    public String getScheduleType() {
        return scheduleType;
    }

    public void setScheduleTime(String scheduleTime) {
        this.scheduleTime = scheduleTime;
    }

    public String getScheduleTime() {
        return scheduleTime;
    }

    public void setFlowControlMode(String flowControlMode) {
        this.flowControlMode = flowControlMode;
    }

    public String getFlowControlMode() {
        return flowControlMode;
    }

    public void setOpenUrl(String openUrl) {
        this.openUrl = openUrl;
    }

    public String getOpenUrl() {
        return openUrl;
    }

    public void setDownloadType(String downloadType) {
        this.downloadType = downloadType;
    }

    public String getDownloadType() {
        return downloadType;
    }

    public void setExternalUrl(String externalUrl) {
        this.externalUrl = externalUrl;
    }

    public String getExternalUrl() {
        return externalUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setAppType(String appType) {
        this.appType = appType;
    }

    public String getAppType() {
        return appType;
    }

    public void setAdPackage(String adPackage) {
        this.adPackage = adPackage;
    }

    public String getAdPackage() {
        return adPackage;
    }

    public void setHideIfConverted(String hideIfConverted) {
        this.hideIfConverted = hideIfConverted;
    }

    public String getHideIfConverted() {
        return hideIfConverted;
    }

    public void setCpaBid(Double cpaBid) {
        this.cpaBid = cpaBid;
    }

    public Double getCpaBid() {
        return cpaBid;
    }

    public void setConvertId(Long convertId) {
        this.convertId = convertId;
    }

    public Long getConvertId() {
        return convertId;
    }

    public void setRetargetingTagsInclude(String retargetingTagsInclude) {
        this.retargetingTagsInclude = retargetingTagsInclude;
    }

    public String getRetargetingTagsInclude() {
        return retargetingTagsInclude;
    }

    public void setRetargetingTagsExclude(String retargetingTagsExclude) {
        this.retargetingTagsExclude = retargetingTagsExclude;
    }

    public String getRetargetingTagsExclude() {
        return retargetingTagsExclude;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAge() {
        return age;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setAc(String ac) {
        this.ac = ac;
    }

    public String getAc() {
        return ac;
    }

    public void setArticleCategory(String articleCategory) {
        this.articleCategory = articleCategory;
    }

    public String getArticleCategory() {
        return articleCategory;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getPlatform() {
        return platform;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getDistrict() {
        return district;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setAdTag(String adTag) {
        this.adTag = adTag;
    }

    public String getAdTag() {
        return adTag;
    }

    public void setInterestTags(String interestTags) {
        this.interestTags = interestTags;
    }

    public String getInterestTags() {
        return interestTags;
    }

    public void setAppBehaviorTarget(String appBehaviorTarget) {
        this.appBehaviorTarget = appBehaviorTarget;
    }

    public String getAppBehaviorTarget() {
        return appBehaviorTarget;
    }

    public void setAppCategory(String appCategory) {
        this.appCategory = appCategory;
    }

    public String getAppCategory() {
        return appCategory;
    }

    public void setAppIds(String appIds) {
        this.appIds = appIds;
    }

    public String getAppIds() {
        return appIds;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public String[] getRetargeting_tags_include() {
        return retargeting_tags_include;
    }

    public void setRetargeting_tags_include(String[] retargeting_tags_include) {
        this.retargeting_tags_include = retargeting_tags_include;
    }

    public String[] getRetargeting_tags_exclude() {
        return retargeting_tags_exclude;
    }

    public void setRetargeting_tags_exclude(String[] retargeting_tags_exclude) {
        this.retargeting_tags_exclude = retargeting_tags_exclude;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("advertiserId", getAdvertiserId())
                .append("advertiserName", getAdvertiserName())
                .append("campaignId", getCampaignId())
                .append("campaignName", getCampaignName())
                .append("adId", getAdId())
                .append("name", getName())
                .append("deliveryRange", getDeliveryRange())
                .append("budgetMode", getBudgetMode())
                .append("budget", getBudget())
                .append("startTime", getStartTime())
                .append("endTime", getEndTime())
                .append("pricing", getPricing())
                .append("bid", getBid())
                .append("scheduleType", getScheduleType())
                .append("scheduleTime", getScheduleTime())
                .append("flowControlMode", getFlowControlMode())
                .append("openUrl", getOpenUrl())
                .append("downloadType", getDownloadType())
                .append("externalUrl", getExternalUrl())
                .append("downloadUrl", getDownloadUrl())
                .append("appType", getAppType())
                .append("adPackage", getAdPackage())
                .append("hideIfConverted", getHideIfConverted())
                .append("cpaBid", getCpaBid())
                .append("convertId", getConvertId())
                .append("retargetingTagsInclude", getRetargetingTagsInclude())
                .append("retargetingTagsExclude", getRetargetingTagsExclude())
                .append("gender", getGender())
                .append("age", getAge())
                .append("carrier", getCarrier())
                .append("ac", getAc())
                .append("articleCategory", getArticleCategory())
                .append("platform", getPlatform())
                .append("district", getDistrict())
                .append("city", getCity())
                .append("adTag", getAdTag())
                .append("interestTags", getInterestTags())
                .append("appBehaviorTarget", getAppBehaviorTarget())
                .append("appCategory", getAppCategory())
                .append("appIds", getAppIds())
                .append("status", getStatus())
                .append("delFlag", getDelFlag())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .toString();
    }
}
