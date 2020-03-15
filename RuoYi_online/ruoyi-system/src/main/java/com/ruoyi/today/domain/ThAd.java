package com.ruoyi.today.domain;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.annotation.JSONField;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Date;
import java.util.List;

/**
 * 广告计划对象 th_ad
 *
 * @author ruoyi
 * @date 2019-08-15
 */
public class ThAd extends BaseEntity {
    private static final long serialVersionUID = 1L;

    private String matterId;

    /**
     * ID
     */
    private Long id;

    /**
     * 状态
     */
    private String operation;

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

    //过滤已安装
    @JSONField(name = "hide_if_exists")
    private String hideIfExists;

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

    //定向包id
    @JSONField(name = "audience_package_id")
    private String audiencePackageId;

    //手机价格定向
    @JSONField(serialize = false)
    private String launchPrice;

    //api 手机价格定向
    private String[] launch_price;

    //兴趣行为选择
    @JSONField(name = "interest_action_mode")
    private String interestActionMode;

    //行为场景
    @JSONField(serialize = false)
    private String actionScene;

    //api
    @JSONField(name = "action_scene")
    private String[] action_scene;

    //行为天数
    @JSONField(name = "action_days")
    private String actionDays;
    //行为类目
    @JSONField(serialize = false)
    private String actionCategories;

    //行为类目 api
    @JSONField(name = "action_categories")
    private String[] action_categories;

    //行为关键词
    @JSONField(serialize = false)
    private String actionWords;

    //行为关键词 api
    @JSONField(name = "action_words")
    private String[] action_words;

    //兴趣分类
    @JSONField(serialize = false)
    private String interestCategories;

    //兴趣分类 api
    @JSONField(name = "interest_categories")
    private String[] interest_categories;

    //兴趣关键词
    @JSONField(serialize = false)
    private String interestWords;

    //兴趣关键词 api
    @JSONField(name = "interest_words")
    private String[] interest_words;

    //地图位置
    @JSONField(serialize = false)
    private String geolocations;

    //地图位置 api
    @JSONField(name = "geolocation")
    private JSONArray geolocation;

    //账号粉丝相似人群
    @JSONField(serialize = false)
    private String awemeFansNumbers;

    //账号粉丝相似人群 api
    @JSONField(name = "aweme_fans_numbers")
    private String[] aweme_fans_numbers;

    //过滤高活跃用户，抖音特有
    @JSONField(name = "filter_aweme_abnormal_active")
    private String filterAwemeAbnormalActive;

    //过滤高关注数用户
    @JSONField(name = "filter_aweme_fans_count")
    private String filterAwemeFansCount;

    @JSONField(name = "filter_own_aweme_number")
    private String filterOwnAwemeNumber;

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
    @JSONField(name = "ac")
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

    //产品目录ID
    @JSONField(name = "product_platform_id")
    private String productPlatformId;

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
     * 受众位置类型
     */
    @JSONField(name = "location_type")
    private String locationType;

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

    //商圈
    @JSONField(serialize = false)
    private String businessIds;
    //商圈
    private String[] business_ids;

    //定向人群包类型
    @JSONField(name = "retargeting_type")
    private String retargetingType;

    //门店ids
    @JSONField(serialize = false)
    private String advertiserStoreIds;

    //门店ids api
    @JSONField(name = "advertiser_store_ids")
    private String[] advertiser_store_ids;

    //受众最低android版本
    @JSONField(name = "android_osv")
    private String androidOsv;

    //受众最低ios版本
    @JSONField(name = "ios_osv")
    private String iosOsv;

    //受众手机品牌
    @JSONField(serialize = false)
    private String deviceBrand;

    //受众手机品牌 api
    @JSONField(name = "device_brand")
    private String[] device_brand;

    //用户首次激活时间
    @JSONField(serialize = false)
    private String activateType;

    //用户首次激活时间 API
    @JSONField(name = "activate_type")
    private String[] activate_type;

    //dpa广告类型
    @JSONField(serialize = false)
    private String dpaAdtype;

    //dpa广告类型 api
    @JSONField(name = "dpa_adtype")
    private String[] dpa_adtype;

    //DPA落地页类型广告落地页链接
    @JSONField(serialize = false)
    private String dpaExternalUrls;

    //DPA落地页类型广告落地页链接 api
    @JSONField(name = "dpa_external_urls")
    private String[] dpa_external_urls;

    //DPA直达链接
    @JSONField(serialize = false)
    private String dpaOpenUrls;

    //DPA直达链接 api
    @JSONField(name = "dpa_open_urls")
    private String[] dpa_open_urls;

    //DPA投放范围
    @JSONField(name = "category_type")
//    @JSONField(serialize = false)
    private String categoryType;

    //DPA投放范围api
//    @JSONField(name = "category_type")
    @JSONField(serialize = false)
    private String[] category_type;

    //类别
    @JSONField(serialize = false)
    private String dpaCategories;

    //类别 api
    @JSONField(name = "dpa_categories")
    private String[] dpa_categories;

    //商品列表
    @JSONField(serialize = false)
    private String dpaProducts;

    //商品列表 api
    @JSONField(name = "dpa_products")
    private String[] dpa_products;

    //H5地址参数
    @JSONField(name = "external_url_params")
    private String externalUrlParams;

    //DPA直达链接参数
    @JSONField(name = "open_url_params")
    private String openUrlParams;

    //DPA人群定向
    @JSONField(name = "dpa_local_audience")
    private String dpaLocalAudience;

    //包含人群包
    @JSONField(serialize = false)
    private String includeCustomActions;

    //包含人群包 api
    @JSONField(name = "include_custom_actions")
    private String[] include_custom_actions;

    //排除人群包
    @JSONField(serialize = false)
    private String excludeCustomActions;

    //排除人群包 api
    @JSONField(name = "exclude_custom_actions")
    private String[] exclude_custom_actions;

    //穿山甲视频创意类型
    @JSONField(name = "union_video_type")
    private String unionVideoType;

    //精选流量包
    @JSONField(name = "superior_popularity_type")
    private String superiorPopularityType;

    //定向流量包ID数组
    @JSONField(serialize = false)
    private String flowPackage;

    //定向流量包ID数组 api
    @JSONField(name = "flow_package")
    private String[] flow_package;

    //排除流量包ID数组
    @JSONField(serialize = false)
    private String excludeFlowPackage;

    //排除流量包ID数组 api
    @JSONField(name = "exclude_flow_package")
    private String[] exclude_flow_package;

    //设备类型
    @JSONField(serialize = false)
    private String deviceType;

    //设备类型 api
    @JSONField(name = "device_type")
    private String[] device_type;

    //可放开定向
    @JSONField(serialize = false)
    private String autoExtendTargets;

    //可放开定向 api
    @JSONField(name = "auto_extend_targets")
    private String[] auto_extend_targets;

    //创意投放位置
    @JSONField(serialize = false)
    private String inventoryType;

    //创意投放位置 api
    @JSONField(name = "inventory_type")
    private String[] inventory_type;

    //转化类型
    @JSONField(serialize = false)
    private String externalActions;

    //转化类型 api
    @JSONField(name = "external_actions")
    private String[] external_actions;

    //是否启用智能放量。
    @JSONField(name = "auto_extend_enabled")
    private String autoExtendEnabled;

    //深度优化方式
    @JSONField(name = "deep_bid_type")
    private String deepBidType;

    //深度优化出价
    @JSONField(name = "deep_cpabid")
    private String deepCpabid;

    //深度转化ROI系数
    @JSONField(name = "roi_goal")
    private String roiGoal;

    @JSONField(serialize = false)
    private List<String> advertiesIds;

    public List<String> getAdvertiesIds() {
        return advertiesIds;
    }

    public void setAdvertiesIds(List<String> advertiesIds) {
        this.advertiesIds = advertiesIds;
    }

    public String getExternalActions() {
        return externalActions;
    }

    public void setExternalActions(String externalActions) {
        this.externalActions = externalActions;
    }

    public String[] getExternal_actions() {
        return external_actions;
    }

    public void setExternal_actions(String[] external_actions) {
        this.external_actions = external_actions;
    }

    public String getHideIfExists() {
        return hideIfExists;
    }

    public void setHideIfExists(String hideIfExists) {
        this.hideIfExists = hideIfExists;
    }

    public String getActionScene() {
        return actionScene;
    }

    public void setActionScene(String actionScene) {
        this.actionScene = actionScene;
    }

    public String[] getAction_scene() {
        return action_scene;
    }

    public void setAction_scene(String[] action_scene) {
        this.action_scene = action_scene;
    }

    public String getActionDays() {
        return actionDays;
    }

    public void setActionDays(String actionDays) {
        this.actionDays = actionDays;
    }

    public String getActionCategories() {
        return actionCategories;
    }

    public void setActionCategories(String actionCategories) {
        this.actionCategories = actionCategories;
    }

    public String[] getAction_categories() {
        return action_categories;
    }

    public void setAction_categories(String[] action_categories) {
        this.action_categories = action_categories;
    }

    public String getActionWords() {
        return actionWords;
    }

    public void setActionWords(String actionWords) {
        this.actionWords = actionWords;
    }

    public String[] getAction_words() {
        return action_words;
    }

    public void setAction_words(String[] action_words) {
        this.action_words = action_words;
    }

    public String getInterestCategories() {
        return interestCategories;
    }

    public void setInterestCategories(String interestCategories) {
        this.interestCategories = interestCategories;
    }

    public String[] getInterest_categories() {
        return interest_categories;
    }

    public void setInterest_categories(String[] interest_categories) {
        this.interest_categories = interest_categories;
    }

    public String getInterestWords() {
        return interestWords;
    }

    public void setInterestWords(String interestWords) {
        this.interestWords = interestWords;
    }

    public String[] getInterest_words() {
        return interest_words;
    }

    public void setInterest_words(String[] interest_words) {
        this.interest_words = interest_words;
    }

    public String getGeolocations() {
        return geolocations;
    }

    public void setGeolocations(String geolocations) {
        this.geolocations = geolocations;
    }

    public JSONArray getGeolocation() {
        return geolocation;
    }

    public void setGeolocation(JSONArray geolocation) {
        this.geolocation = geolocation;
    }

    public String getAwemeFansNumbers() {
        return awemeFansNumbers;
    }

    public void setAwemeFansNumbers(String awemeFansNumbers) {
        this.awemeFansNumbers = awemeFansNumbers;
    }

    public String[] getAweme_fans_numbers() {
        return aweme_fans_numbers;
    }

    public void setAweme_fans_numbers(String[] aweme_fans_numbers) {
        this.aweme_fans_numbers = aweme_fans_numbers;
    }

    public String getFilterAwemeAbnormalActive() {
        return filterAwemeAbnormalActive;
    }

    public void setFilterAwemeAbnormalActive(String filterAwemeAbnormalActive) {
        this.filterAwemeAbnormalActive = filterAwemeAbnormalActive;
    }

    public String getFilterAwemeFansCount() {
        return filterAwemeFansCount;
    }

    public void setFilterAwemeFansCount(String filterAwemeFansCount) {
        this.filterAwemeFansCount = filterAwemeFansCount;
    }

    public String getFilterOwnAwemeNumber() {
        return filterOwnAwemeNumber;
    }

    public void setFilterOwnAwemeNumber(String filterOwnAwemeNumber) {
        this.filterOwnAwemeNumber = filterOwnAwemeNumber;
    }

    public String getProductPlatformId() {
        return productPlatformId;
    }

    public void setProductPlatformId(String productPlatformId) {
        this.productPlatformId = productPlatformId;
    }

    public String getRetargetingType() {
        return retargetingType;
    }

    public void setRetargetingType(String retargetingType) {
        this.retargetingType = retargetingType;
    }

    public String getAdvertiserStoreIds() {
        return advertiserStoreIds;
    }

    public void setAdvertiserStoreIds(String advertiserStoreIds) {
        this.advertiserStoreIds = advertiserStoreIds;
    }

    public String[] getAdvertiser_store_ids() {
        return advertiser_store_ids;
    }

    public void setAdvertiser_store_ids(String[] advertiser_store_ids) {
        this.advertiser_store_ids = advertiser_store_ids;
    }

    public String getAndroidOsv() {
        return androidOsv;
    }

    public void setAndroidOsv(String androidOsv) {
        this.androidOsv = androidOsv;
    }

    public String getIosOsv() {
        return iosOsv;
    }

    public void setIosOsv(String iosOsv) {
        this.iosOsv = iosOsv;
    }

    public String getDeviceBrand() {
        return deviceBrand;
    }

    public void setDeviceBrand(String deviceBrand) {
        this.deviceBrand = deviceBrand;
    }

    public String[] getDevice_brand() {
        return device_brand;
    }

    public void setDevice_brand(String[] device_brand) {
        this.device_brand = device_brand;
    }

    public String getActivateType() {
        return activateType;
    }

    public void setActivateType(String activateType) {
        this.activateType = activateType;
    }

    public String[] getActivate_type() {
        return activate_type;
    }

    public void setActivate_type(String[] activate_type) {
        this.activate_type = activate_type;
    }

    public String getDpaAdtype() {
        return dpaAdtype;
    }

    public void setDpaAdtype(String dpaAdtype) {
        this.dpaAdtype = dpaAdtype;
    }

    public String[] getDpa_adtype() {
        return dpa_adtype;
    }

    public void setDpa_adtype(String[] dpa_adtype) {
        this.dpa_adtype = dpa_adtype;
    }

    public String getDpaExternalUrls() {
        return dpaExternalUrls;
    }

    public void setDpaExternalUrls(String dpaExternalUrls) {
        this.dpaExternalUrls = dpaExternalUrls;
    }

    public String[] getDpa_external_urls() {
        return dpa_external_urls;
    }

    public void setDpa_external_urls(String[] dpa_external_urls) {
        this.dpa_external_urls = dpa_external_urls;
    }

    public String getDpaOpenUrls() {
        return dpaOpenUrls;
    }

    public void setDpaOpenUrls(String dpaOpenUrls) {
        this.dpaOpenUrls = dpaOpenUrls;
    }

    public String[] getDpa_open_urls() {
        return dpa_open_urls;
    }

    public void setDpa_open_urls(String[] dpa_open_urls) {
        this.dpa_open_urls = dpa_open_urls;
    }

    public String getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(String categoryType) {
        this.categoryType = categoryType;
    }

    public String[] getCategory_type() {
        return category_type;
    }

    public void setCategory_type(String[] category_type) {
        this.category_type = category_type;
    }

    public String getDpaCategories() {
        return dpaCategories;
    }

    public void setDpaCategories(String dpaCategories) {
        this.dpaCategories = dpaCategories;
    }

    public String[] getDpa_categories() {
        return dpa_categories;
    }

    public void setDpa_categories(String[] dpa_categories) {
        this.dpa_categories = dpa_categories;
    }

    public String getDpaProducts() {
        return dpaProducts;
    }

    public void setDpaProducts(String dpaProducts) {
        this.dpaProducts = dpaProducts;
    }

    public String[] getDpa_products() {
        return dpa_products;
    }

    public void setDpa_products(String[] dpa_products) {
        this.dpa_products = dpa_products;
    }

    public String getExternalUrlParams() {
        return externalUrlParams;
    }

    public void setExternalUrlParams(String externalUrlParams) {
        this.externalUrlParams = externalUrlParams;
    }

    public String getOpenUrlParams() {
        return openUrlParams;
    }

    public void setOpenUrlParams(String openUrlParams) {
        this.openUrlParams = openUrlParams;
    }

    public String getDpaLocalAudience() {
        return dpaLocalAudience;
    }

    public void setDpaLocalAudience(String dpaLocalAudience) {
        this.dpaLocalAudience = dpaLocalAudience;
    }

    public String getIncludeCustomActions() {
        return includeCustomActions;
    }

    public void setIncludeCustomActions(String includeCustomActions) {
        this.includeCustomActions = includeCustomActions;
    }

    public String[] getInclude_custom_actions() {
        return include_custom_actions;
    }

    public void setInclude_custom_actions(String[] include_custom_actions) {
        this.include_custom_actions = include_custom_actions;
    }

    public String getExcludeCustomActions() {
        return excludeCustomActions;
    }

    public void setExcludeCustomActions(String excludeCustomActions) {
        this.excludeCustomActions = excludeCustomActions;
    }

    public String[] getExclude_custom_actions() {
        return exclude_custom_actions;
    }

    public void setExclude_custom_actions(String[] exclude_custom_actions) {
        this.exclude_custom_actions = exclude_custom_actions;
    }

    public String getUnionVideoType() {
        return unionVideoType;
    }

    public void setUnionVideoType(String unionVideoType) {
        this.unionVideoType = unionVideoType;
    }

    public String getSuperiorPopularityType() {
        return superiorPopularityType;
    }

    public void setSuperiorPopularityType(String superiorPopularityType) {
        this.superiorPopularityType = superiorPopularityType;
    }

    public String getFlowPackage() {
        return flowPackage;
    }

    public void setFlowPackage(String flowPackage) {
        this.flowPackage = flowPackage;
    }

    public String[] getFlow_package() {
        return flow_package;
    }

    public void setFlow_package(String[] flow_package) {
        this.flow_package = flow_package;
    }

    public String getExcludeFlowPackage() {
        return excludeFlowPackage;
    }

    public void setExcludeFlowPackage(String excludeFlowPackage) {
        this.excludeFlowPackage = excludeFlowPackage;
    }

    public String[] getExclude_flow_package() {
        return exclude_flow_package;
    }

    public void setExclude_flow_package(String[] exclude_flow_package) {
        this.exclude_flow_package = exclude_flow_package;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String[] getDevice_type() {
        return device_type;
    }

    public void setDevice_type(String[] device_type) {
        this.device_type = device_type;
    }

    public String getAutoExtendTargets() {
        return autoExtendTargets;
    }

    public void setAutoExtendTargets(String autoExtendTargets) {
        this.autoExtendTargets = autoExtendTargets;
    }

    public String[] getAuto_extend_targets() {
        return auto_extend_targets;
    }

    public void setAuto_extend_targets(String[] auto_extend_targets) {
        this.auto_extend_targets = auto_extend_targets;
    }

    public String getInventoryType() {
        return inventoryType;
    }

    public void setInventoryType(String inventoryType) {
        this.inventoryType = inventoryType;
    }

    public String[] getInventory_type() {
        return inventory_type;
    }

    public void setInventory_type(String[] inventory_type) {
        this.inventory_type = inventory_type;
    }

    public String getAutoExtendEnabled() {
        return autoExtendEnabled;
    }

    public void setAutoExtendEnabled(String autoExtendEnabled) {
        this.autoExtendEnabled = autoExtendEnabled;
    }

    public String getDeepBidType() {
        return deepBidType;
    }

    public void setDeepBidType(String deepBidType) {
        this.deepBidType = deepBidType;
    }

    public String getDeepCpabid() {
        return deepCpabid;
    }

    public void setDeepCpabid(String deepCpabid) {
        this.deepCpabid = deepCpabid;
    }

    public String getRoiGoal() {
        return roiGoal;
    }

    public void setRoiGoal(String roiGoal) {
        this.roiGoal = roiGoal;
    }

    public String getLocationType() {
        return locationType;
    }

    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }

    public String[] getBusiness_ids() {
        return business_ids;
    }

    public void setBusiness_ids(String[] business_ids) {
        this.business_ids = business_ids;
    }

    public String getBusinessIds() {
        return businessIds;
    }

    public void setBusinessIds(String businessIds) {
        this.businessIds = businessIds;
    }

    public String getOperation() {
        return operation;
    }



    public void setOperation(String operation) {
        this.operation = operation;
    }

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

    public String getAudiencePackageId() {
        return audiencePackageId;
    }

    public void setAudiencePackageId(String audiencePackageId) {
        this.audiencePackageId = audiencePackageId;
    }

    public String getLaunchPrice() {
        return launchPrice;
    }

    public void setLaunchPrice(String launchPrice) {
        this.launchPrice = launchPrice;
    }

    public String[] getLaunch_price() {
        return launch_price;
    }

    public void setLaunch_price(String[] launch_price) {
        this.launch_price = launch_price;
    }

    public String getInterestActionMode() {
        return interestActionMode;
    }

    public void setInterestActionMode(String interestActionMode) {
        this.interestActionMode = interestActionMode;
    }

    public String getMatterId() {
        return matterId;
    }

    public void setMatterId(String matterId) {
        this.matterId = matterId;
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
