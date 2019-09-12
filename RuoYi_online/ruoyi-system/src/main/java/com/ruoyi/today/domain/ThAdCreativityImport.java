package com.ruoyi.today.domain;

import com.alibaba.fastjson.annotation.JSONField;
import com.ruoyi.common.annotation.Excel;

public class ThAdCreativityImport {

    /**
     * 广告主ID
     */
    @Excel(name = "广告主ID", type = Excel.Type.ALL)
    private Long advertiserId;

    /**
     * 广告主名称
     */
    @Excel(name = "广告主名称", type = Excel.Type.ALL)
    private String advertiserName;

    /**
     * 广告组ID
     */
    @Excel(name = "广告组ID", type = Excel.Type.ALL)
    private Long campaignId;

    /**
     * 广告组名称
     */
    @Excel(name = "广告组名称", type = Excel.Type.ALL)
    private String campaignName;

    /**
     * 广告ID
     */
    @Excel(name = "广告ID", type = Excel.Type.ALL)
    private Long adId;

    /**
     * 广告名称
     */
    @Excel(name = "广告名称", type = Excel.Type.ALL)
    private String name;

    /**
     * 投放范围（DEFAULT默认 UNION穿山甲）
     */
    @Excel(name = "投放范围", readConverterExp = "DEFAULT=默认,UNION=穿山甲", type = Excel.Type.EXPORT)
    private String deliveryRange;

    /**
     * 预算类型（BUDGET_MODE_INFINITE不限 BUDGET_MODE_DAY日预算 BUDGET_MODE_TOTAL总预算）
     */
    @Excel(name = "预算类型", readConverterExp = "NONE=不限,BUDGET_MODE_DAY=日预算,BUDGET_MODE_TOTAL=总预算", type = Excel.Type.ALL)
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
    private String startTime;

    /**
     * 结束时间（形式如：2018-01-01 00:00）
     */
    @Excel(name = "结束时间", dateFormat = "yyyy-MM-dd HH-mm-ss", type = Excel.Type.ALL)
    private String endTime;

    /**
     * 出价类型（PRICING_CPC PRICING_CPM PRICING_OCPM PRICING_CPV）
     */
    @Excel(name = "出价类型", readConverterExp = "P=RICING_CPC,P=RICING_CPM,P=RICING_OCPM,P=RICING_CPV", type = Excel.Type.EXPORT)
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
    private String scheduleType;

    /**
     * 广告投放时段
     */
    @Excel(name = "广告投放时段", type = Excel.Type.ALL)
    private String scheduleTime;

    /**
     * 投放速度类型（FLOW_CONTROL_MODE_FAST优先跑量 FLOW_CONTROL_MODE_SMOOTH优先低成本 FLOW_CONTROL_MODE_BALANCE均衡投放）
     */
    @Excel(name = "投放速度类型", readConverterExp = "FLOW_CONTROL_MODE_FAST=优先跑量,FLOW_CONTROL_MODE_SMOOTH=优先低成本,FLOW_CONTROL_MODE_BALANCE=均衡投放", type = Excel.Type.ALL)
    private String flowControlMode;

    /**
     * 应用直达链接
     */
    @Excel(name = "应用直达链接", type = Excel.Type.ALL)
    private String openUrl;

    /**
     * 应用下载方式
     */
    @Excel(name = "应用下载方式", readConverterExp = "DOWNLOAD_URL=下载链接,EXTERNAL_URL=落地页链接", type = Excel.Type.EXPORT)
    private String downloadType;

    /**
     * 广告落地页链接
     */
    @Excel(name = "广告落地页链接", type = Excel.Type.ALL)
    private String externalUrl;

    /**
     * 广告应用下载链接
     */
    @Excel(name = "广告应用下载链接", type = Excel.Type.ALL)
    private String downloadUrl;

    /**
     * 应用下载类型
     */
    @Excel(name = "应用下载类型", readConverterExp = "APP_ANDROID=Android,APP_IOS=IOS", type = Excel.Type.ALL)
    private String appType;

    /**
     * 广告应用下载包名
     */
    @Excel(name = "广告应用下载包名", type = Excel.Type.ALL)
    private String adPackage;

    /**
     * 过滤已转化用户类型（NO_EXCLUDE不过滤 AD广告计划 CAMPAIGN广告组 ADVERTISER广告账户 APP应用 CUSTOMER公司账户）
     */
    @Excel(name = "过滤已转化用户类型", readConverterExp = "NO_EXCLUDE=不过滤,AD=广告计划,CAMPAIGN=广告组,ADVERTISER=广告账户,APP=APP,CUSTOMER=公司账户", type = Excel.Type.ALL)
    private String hideIfConverted;

    /**
     * ocpm广告转化出价
     */
    @Excel(name = "ocpm广告转化出价", type = Excel.Type.ALL)
    private Double cpaBid;

    /**
     * 转化ID
     */
    @Excel(name = "转化ID")
    private Long convertId;

    /**
     * 定向人群包列表
     */
    @Excel(name = "定向人群包列表", type = Excel.Type.ALL)
    private String retargetingTagsInclude;

    /**
     * 排除人群包列表
     */
    @Excel(name = "排除人群包列表", type = Excel.Type.ALL)
    private String retargetingTagsExclude;

    /**
     * 受众性别（NONE不限 GENDER_MALE男 GENDER_FEMALE女）
     */
    @Excel(name = "受众性别", readConverterExp = "NONE=不限,GENDER_MALE=男,GENDER_FEMALE=女", type = Excel.Type.ALL)
    private String gender;

    /**
     * 受众年龄区间（AGE_BELOW_18小于18岁 AGE_BETWEEN_18_23等于18-23岁 AGE_BETWEEN_24_30等于24-30岁 AGE_BETWEEN_31_40等于31-40岁 AGE_BETWEEN_41_49等于41-49岁 AGE_ABOVE_50大于等于50岁）
     */
    @Excel(name = "受众年龄区间", readConverterExp = "AGE_BELOW_18=小于18岁,AGE_BETWEEN_18_23=18-23岁,AGE_BETWEEN_24_30=24-30岁,AGE_BETWEEN_31_40=31-40岁,AGE_BETWEEN_41_49=41-49岁,AGE_ABOVE_50=大于等于50岁", type = Excel.Type.ALL)
    private String age;

    /**
     * 运营商（MOBILE移动 UNICOM联通 TELCOM电信）
     */
    @Excel(name = "运营商", readConverterExp = "MOBILE=移动,UNICOM=联通,TELCOM=电信", type = Excel.Type.ALL)
    private String carrier;

    /**
     * 网络类型（WIFI 2G 3G 4G）
     */
    @Excel(name = "网络类型", readConverterExp = "WIFI=wifi,2G=2G,3G=3G,4G=4G", type = Excel.Type.ALL)
    private String ac;

    /**
     * 受众文章分类
     */
    @Excel(name = "受众文章分类", readConverterExp = "ENTERTAINMENT=娱乐,SOCIETY=社会,CARS=汽车,INTERNATIONAL=国际,HISTORY=历史,SPORTS=体育,HEALTH=健康,MILITARY=军事,EMOTION=情感,FASHION=时尚,PARENTING=育儿,FINANCE=财经,AMUSEMENT=搞笑,DIGITAL=数码,EXPLORE=探索,TRAVEL=旅游,CONSTELLATION=星座,STORIES=故事,TECHNOLOGY=科技,GOURMET=美食,CULTURE=文化,HOME=家居,MOVIE=电影,PETS=宠物,GAMES=游戏,WEIGHT_LOSING=瘦身,FREAK=奇葩,EDUCATION=教育,ESTATE=房产,SCIENCE=科学,PHOTOGRAPHY=摄影,REGIMEN=养生,ESSAY=美文,COLLECTION=收藏,ANIMATION=动漫,COMICS=漫画,TIPS=小窍门,DESIGN=设计,LOCAL=本地,LAWS=法制,GOVERNMENT=政务,BUSINESS=商业,WORKPLACE=职场,RUMOR_CRACKER=辟谣,GRADUATES=毕业生", type = Excel.Type.ALL)
    private String articleCategory;

    /**
     * 受众平台（IOS ANDROID PC）
     */
    @Excel(name = "受众平台", readConverterExp = "ANDROID=android,IOS=iOS,PC=PC", type = Excel.Type.ALL)
    private String platform;

    /**
     * 地域类型
     */
    @Excel(name = "地域类型", readConverterExp = "CITY=按省市,COUNTY=按区县,BUSINESS_DISTRICT=按商圈,NONE=不限", type = Excel.Type.ALL)
    private String district;

    /**
     * 地域定向城市或者区县列表
     */
    @Excel(name = "地域定向城市或者区县列表", type = Excel.Type.ALL)
    private String city;

    /**
     * 兴趣分类
     */
    @Excel(name = "兴趣分类", type = Excel.Type.ALL)
    private String adTag;

    /**
     * 兴趣关键词
     */
    @Excel(name = "兴趣关键词", type = Excel.Type.ALL)
    private String interestTags;

    /**
     * APP行为定向
     */
    @Excel(name = "APP行为定向", readConverterExp = "NONE=不限,CATEGORY=按分类,APP=按APP", type = Excel.Type.ALL)
    private String appBehaviorTarget;

    /**
     * APP行为按分类集合
     */
    @Excel(name = "APP行为按分类集合", type = Excel.Type.ALL)
    private String appCategory;

    /**
     * APP行为定向,APP集合
     */
    @Excel(name = "APP行为定向,APP集合", type = Excel.Type.ALL)
    private String appIds;


    @Excel(name = "广告组预算类型", readConverterExp = "BUDGET_MODE_INFINITE=不限,BUDGET_MODE_DAY=日预算,BUDGET_MODE_TOTAL=总预算", type = Excel.Type.IMPORT)
    private String groupBudgetMode;

    @Excel(name = "广告组预算", type = Excel.Type.IMPORT)
    private Long groupBudget;

    @Excel(name = "广告组推广目的", readConverterExp = "LINK=销售线索收集,APP=应用推广,DPA=产品目录推广,GOODS=商品推广（鲁班）,STORE=门店推广,AWEME=抖音号推广,SHOP=电商店铺推广", type = Excel.Type.IMPORT)
    private String landingType;

    /**
     * 展示监测链接
     */
    @Excel(name = "展示监测链接")
    private String trackUrl;

    /**
     * 点击监测链接
     */
    @Excel(name = "点击监测链接")
    private String actionTrackUrl;

    /**
     * 视频有效播放监测链接
     */
    @Excel(name = "视频有效播放监测链接")
    private String videoPlayEffectiveTrackUrl;

    /**
     * 视频播放完毕监测链接
     */
    @Excel(name = "视频播放完毕监测链接")
    private String videoPlayDoneTrackUrl;

    /**
     * 视频播放监测链接
     */
    @Excel(name = "视频播放监测链接")
    private String videoPlayTrackUrl;

    /**
     * 是否关闭评论
     */
    @Excel(name = "是否关闭评论",readConverterExp = "0=否,1=是")
    private String isCommentDisable;

    /**
     * 是否关闭视频详情页落地页
     */
    @Excel(name = "是否关闭视频详情页落地页",readConverterExp = "0=否,1=是")
    private String closeVideoDetail;

    /**
     * 创意展现方式
     */
    @Excel(name = "创意展现方式",readConverterExp = "CREATIVE_DISPLAY_MODE_CTR=优选,CREATIVE_DISPLAY_MODE_RANDOM=轮播")
    private String creativeDisplayMode;

    /**
     * 是否使用优选广告位
     */
    @Excel(name = "是否使用优选广告位",readConverterExp = "0=否,1=是")
    private String smartInventory;

    /**
     * 场景广告位
     */
    @Excel(name = "场景广告位",readConverterExp = "VIDEO_SCENE=沉浸式竖版视频,FEED_SCENE=信息流,TAIL_SCENE=视频后贴和尾帧")
    private String sceneInventory;

    /**
     * 是否开启衍生计划
     */
    @Excel(name = "是否开启衍生计划",readConverterExp = "0=否,1=是")
    private String generateDerivedAd;

    /**
     * 创意投放位置
     */
    @Excel(name = "创意投放位置",readConverterExp = "INVENTORY_FEED=头条系,INVENTORY_VIDEO_FEED=西瓜信息流,INVENTORY_HOTSOON_FEED=火山信息流,INVENTORY_AWEME_FEED=抖音信息流,INVENTORY_UNION_SLOT=穿山甲")
    private String inventoryType;

    /**
     * 文章来源
     */
    @Excel(name = "文章来源")
    private String source;

    /**
     * 应用名
     */
    @Excel(name = "应用名")
    private String appName;

    /**
     * Android应用下载详情页
     */
    @Excel(name = "Android应用下载详情页")
    private String webUrl;

    /**
     * 创意标签
     */
    @Excel(name = "创意标签")
    private String adKeywords;

    /**
     * 创意分类
     */
    @Excel(name = "创意分类")
    private String thirdIndustryId;

    /**
     * 附加创意类型
     */
    @Excel(name = "附加创意类型",readConverterExp = "ATTACHED_CREATIVE_NONE=无,ATTACHED_CREATIVE_PHONE=电话拨打,ATTACHED_CREATIVE_FORM=表单收集,ATTACHED_CREATIVE_COMMERCE_CARD=电商卡片")
    private String advancedCreativeType;

    /**
     * 副标题
     */
    @Excel(name = "副标题")
    private String advancedCreativeTitle;

    /**
     * 电话号码
     */
    @Excel(name = "电话号码")
    private String phoneNumber;

    /**
     * 按钮文本
     */
    @Excel(name = "按钮文本")
    private String buttonText;

    /**
     * 表单提交链接
     */
    @Excel(name = "表单提交链接")
    private String formUrl;

    /**
     * 创意类型
     */
    @Excel(name = "创意类型",readConverterExp = "STATIC_ASSEMBLE=程序化创意")
    private String creativeMaterialMode;

    /**
     * 是否隐藏抖音主页
     */
    @Excel(name = "是否隐藏抖音主页",readConverterExp = "0=否,1=是")
    private String isFeedAndFavSee;

    /**
     * 试玩素材url
     */
    @Excel(name = "试玩素材url")
    private String playableUrl;

    //标题信息
    @Excel(name = "程序化标题信息", type = Excel.Type.IMPORT)
    private String titleStr;

    //素材信息
    @Excel(name = "程序化素材信息", type = Excel.Type.IMPORT)
    private String imageStr;

    //自定义创意
    @Excel(name = "自定义创意", type = Excel.Type.IMPORT)
    private String creativesStr;

    public Long getAdvertiserId() {
        return advertiserId;
    }

    public void setAdvertiserId(Long advertiserId) {
        this.advertiserId = advertiserId;
    }

    public String getAdvertiserName() {
        return advertiserName;
    }

    public void setAdvertiserName(String advertiserName) {
        this.advertiserName = advertiserName;
    }

    public Long getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(Long campaignId) {
        this.campaignId = campaignId;
    }

    public String getCampaignName() {
        return campaignName;
    }

    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName;
    }

    public Long getAdId() {
        return adId;
    }

    public void setAdId(Long adId) {
        this.adId = adId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getPricing() {
        return pricing;
    }

    public void setPricing(String pricing) {
        this.pricing = pricing;
    }

    public Double getBid() {
        return bid;
    }

    public void setBid(Double bid) {
        this.bid = bid;
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

    public String getHideIfConverted() {
        return hideIfConverted;
    }

    public void setHideIfConverted(String hideIfConverted) {
        this.hideIfConverted = hideIfConverted;
    }

    public Double getCpaBid() {
        return cpaBid;
    }

    public void setCpaBid(Double cpaBid) {
        this.cpaBid = cpaBid;
    }

    public Long getConvertId() {
        return convertId;
    }

    public void setConvertId(Long convertId) {
        this.convertId = convertId;
    }

    public String getRetargetingTagsInclude() {
        return retargetingTagsInclude;
    }

    public void setRetargetingTagsInclude(String retargetingTagsInclude) {
        this.retargetingTagsInclude = retargetingTagsInclude;
    }

    public String getRetargetingTagsExclude() {
        return retargetingTagsExclude;
    }

    public void setRetargetingTagsExclude(String retargetingTagsExclude) {
        this.retargetingTagsExclude = retargetingTagsExclude;
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

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public String getAc() {
        return ac;
    }

    public void setAc(String ac) {
        this.ac = ac;
    }

    public String getArticleCategory() {
        return articleCategory;
    }

    public void setArticleCategory(String articleCategory) {
        this.articleCategory = articleCategory;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAdTag() {
        return adTag;
    }

    public void setAdTag(String adTag) {
        this.adTag = adTag;
    }

    public String getInterestTags() {
        return interestTags;
    }

    public void setInterestTags(String interestTags) {
        this.interestTags = interestTags;
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

    public String getAppIds() {
        return appIds;
    }

    public void setAppIds(String appIds) {
        this.appIds = appIds;
    }

    public String getGroupBudgetMode() {
        return groupBudgetMode;
    }

    public void setGroupBudgetMode(String groupBudgetMode) {
        this.groupBudgetMode = groupBudgetMode;
    }

    public Long getGroupBudget() {
        return groupBudget;
    }

    public void setGroupBudget(Long groupBudget) {
        this.groupBudget = groupBudget;
    }

    public String getLandingType() {
        return landingType;
    }

    public void setLandingType(String landingType) {
        this.landingType = landingType;
    }

    public String getTrackUrl() {
        return trackUrl;
    }

    public void setTrackUrl(String trackUrl) {
        this.trackUrl = trackUrl;
    }

    public String getActionTrackUrl() {
        return actionTrackUrl;
    }

    public void setActionTrackUrl(String actionTrackUrl) {
        this.actionTrackUrl = actionTrackUrl;
    }

    public String getVideoPlayEffectiveTrackUrl() {
        return videoPlayEffectiveTrackUrl;
    }

    public void setVideoPlayEffectiveTrackUrl(String videoPlayEffectiveTrackUrl) {
        this.videoPlayEffectiveTrackUrl = videoPlayEffectiveTrackUrl;
    }

    public String getVideoPlayDoneTrackUrl() {
        return videoPlayDoneTrackUrl;
    }

    public void setVideoPlayDoneTrackUrl(String videoPlayDoneTrackUrl) {
        this.videoPlayDoneTrackUrl = videoPlayDoneTrackUrl;
    }

    public String getVideoPlayTrackUrl() {
        return videoPlayTrackUrl;
    }

    public void setVideoPlayTrackUrl(String videoPlayTrackUrl) {
        this.videoPlayTrackUrl = videoPlayTrackUrl;
    }

    public String getIsCommentDisable() {
        return isCommentDisable;
    }

    public void setIsCommentDisable(String isCommentDisable) {
        this.isCommentDisable = isCommentDisable;
    }

    public String getCloseVideoDetail() {
        return closeVideoDetail;
    }

    public void setCloseVideoDetail(String closeVideoDetail) {
        this.closeVideoDetail = closeVideoDetail;
    }

    public String getCreativeDisplayMode() {
        return creativeDisplayMode;
    }

    public void setCreativeDisplayMode(String creativeDisplayMode) {
        this.creativeDisplayMode = creativeDisplayMode;
    }

    public String getSmartInventory() {
        return smartInventory;
    }

    public void setSmartInventory(String smartInventory) {
        this.smartInventory = smartInventory;
    }

    public String getSceneInventory() {
        return sceneInventory;
    }

    public void setSceneInventory(String sceneInventory) {
        this.sceneInventory = sceneInventory;
    }

    public String getGenerateDerivedAd() {
        return generateDerivedAd;
    }

    public void setGenerateDerivedAd(String generateDerivedAd) {
        this.generateDerivedAd = generateDerivedAd;
    }

    public String getInventoryType() {
        return inventoryType;
    }

    public void setInventoryType(String inventoryType) {
        this.inventoryType = inventoryType;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public String getAdKeywords() {
        return adKeywords;
    }

    public void setAdKeywords(String adKeywords) {
        this.adKeywords = adKeywords;
    }

    public String getThirdIndustryId() {
        return thirdIndustryId;
    }

    public void setThirdIndustryId(String thirdIndustryId) {
        this.thirdIndustryId = thirdIndustryId;
    }

    public String getAdvancedCreativeType() {
        return advancedCreativeType;
    }

    public void setAdvancedCreativeType(String advancedCreativeType) {
        this.advancedCreativeType = advancedCreativeType;
    }

    public String getAdvancedCreativeTitle() {
        return advancedCreativeTitle;
    }

    public void setAdvancedCreativeTitle(String advancedCreativeTitle) {
        this.advancedCreativeTitle = advancedCreativeTitle;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getButtonText() {
        return buttonText;
    }

    public void setButtonText(String buttonText) {
        this.buttonText = buttonText;
    }

    public String getFormUrl() {
        return formUrl;
    }

    public void setFormUrl(String formUrl) {
        this.formUrl = formUrl;
    }

    public String getCreativeMaterialMode() {
        return creativeMaterialMode;
    }

    public void setCreativeMaterialMode(String creativeMaterialMode) {
        this.creativeMaterialMode = creativeMaterialMode;
    }

    public String getIsFeedAndFavSee() {
        return isFeedAndFavSee;
    }

    public void setIsFeedAndFavSee(String isFeedAndFavSee) {
        this.isFeedAndFavSee = isFeedAndFavSee;
    }

    public String getPlayableUrl() {
        return playableUrl;
    }

    public void setPlayableUrl(String playableUrl) {
        this.playableUrl = playableUrl;
    }

    public String getTitleStr() {
        return titleStr;
    }

    public void setTitleStr(String titleStr) {
        this.titleStr = titleStr;
    }

    public String getImageStr() {
        return imageStr;
    }

    public void setImageStr(String imageStr) {
        this.imageStr = imageStr;
    }

    public String getCreativesStr() {
        return creativesStr;
    }

    public void setCreativesStr(String creativesStr) {
        this.creativesStr = creativesStr;
    }
}
