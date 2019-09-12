package com.ruoyi.today.domain;

import com.alibaba.fastjson.annotation.JSONField;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

/**
 * 创意公共属性对象 th_creativity
 * 
 * @author ruoyi
 * @date 2019-09-09
 */
public class ThCreativity extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long id;

    /** 搜索值 */
    private String searchValue;

    /** 广告主ID */
    @JSONField(name = "advertiser_id")
    private String advertiserId;

    private String thAdId;

    /** 计划ID */
    @JSONField(name = "ad_id")
    private String adId;

    /** 展示监测链接 */
    @Excel(name = "展示监测链接")
    @JSONField(name = "track_url")
    private String trackUrl;

    /** 点击监测链接 */
    @Excel(name = "点击监测链接")
    @JSONField(name = "action_track_url")
    private String actionTrackUrl;

    /** 视频有效播放监测链接 */
    @Excel(name = "视频有效播放监测链接")
    @JSONField(name = "video_play_effective_track_url")
    private String videoPlayEffectiveTrackUrl;

    /** 视频播放完毕监测链接 */
    @Excel(name = "视频播放完毕监测链接")
    @JSONField(name = "video_play_effective_track_url ")
    private String videoPlayDoneTrackUrl;

    /** 视频播放监测链接 */
    @Excel(name = "视频播放监测链接")
    @JSONField(name = "video_play_track_url")
    private String videoPlayTrackUrl;

    /** 是否关闭评论 */
    @Excel(name = "是否关闭评论")
    @JSONField(name = "is_comment_disable")
    private String isCommentDisable;

    /** 是否关闭视频详情页落地页 */
    @Excel(name = "是否关闭视频详情页落地页")
    @JSONField(name = "close_video_detail")
    private String closeVideoDetail;

    /** 创意展现方式 */
    @Excel(name = "创意展现方式")
    @JSONField(name = "creative_display_mode")
    private String creativeDisplayMode;

    /** 是否使用优选广告位 */
    @Excel(name = "是否使用优选广告位")
    @JSONField(name = "smart_inventory")
    private String smartInventory;

    /** 场景广告位 */
    @Excel(name = "场景广告位")
    @JSONField(name = "scene_inventory")
    private String sceneInventory;

    /** 是否开启衍生计划 */
    @Excel(name = "是否开启衍生计划")
    @JSONField(name = "generate_derived_ad")
    private String generateDerivedAd;

    /** 创意投放位置 */
    @Excel(name = "创意投放位置")
    @JSONField(serialize = false)
    private String inventoryType;

    //创意投放位置 数组
    private String[] inventory_type;

    /** 文章来源 */
    @Excel(name = "文章来源")
    private String source;

    /** 应用名 */
    @Excel(name = "应用名")
    @JSONField(name = "app_name")
    private String appName;

    /** Android应用下载详情页 */
    @Excel(name = "Android应用下载详情页")
    @JSONField(name = "web_url")
    private String webUrl;

    /** 创意标签 */
    @Excel(name = "创意标签")
    @JSONField(serialize = false)
    private String adKeywords;

    //创意标签 数组
    private String[] ad_keywords;

    /** 创意分类 */
    @Excel(name = "创意分类")
    @JSONField(name = "third_industry_id")
    private String thirdIndustryId;

    /** 附加创意类型 */
    @Excel(name = "附加创意类型")
    @JSONField(name = "advanced_creative_type")
    private String advancedCreativeType;

    /** 副标题 */
    @Excel(name = "副标题")
    @JSONField(name = "advanced_creative_title")
    private String advancedCreativeTitle;

    /** 电话号码 */
    @Excel(name = "电话号码")
    @JSONField(name = "phone_number")
    private String phoneNumber;

    /** 按钮文本 */
    @Excel(name = "按钮文本")
    @JSONField(name = "button_text")
    private String buttonText;

    /** 表单提交链接 */
    @Excel(name = "表单提交链接")
    @JSONField(name = "form_url")
    private String formUrl;

    /** 创意类型 */
    @Excel(name = "创意类型")
    @JSONField(name = "creative_material_mode")
    private String creativeMaterialMode;

    /** 是否隐藏抖音主页 */
    @Excel(name = "是否隐藏抖音主页")
    @JSONField(name = "is_feed_and_fav_see")
    private String isFeedAndFavSee;

    /** 试玩素材url */
    @Excel(name = "试玩素材url")
    @JSONField(name = "playable_url")
    private String playableUrl;

    //标题信息
    @Excel(name = "程序化标题信息",type = Excel.Type.IMPORT)
    @JSONField(name = "程序化标题信息")
    private String titleStr;

    //素材信息
    @Excel(name = "程序化素材信息",type = Excel.Type.IMPORT)
    @JSONField(name = "程序化素材信息")
    private String imageStr;

    //自定义创意
    @Excel(name = "自定义创意",type = Excel.Type.IMPORT)
    @JSONField(name = "自定义创意")
    private String creativesStr;

    //标题信息
    private List<ThCreativityTitle> title_list;

    //素材信息
    private List<ThCreativityImage> image_list;

    //素材信息, 投放位置和创意类型决定素材规格
    private List<ThCreativityCreatives> creatives;

    public String getTitleStr() {
        return titleStr;
    }

    public void setTitleStr(String titleStr) {
        this.titleStr = titleStr;
    }

    public String getThAdId() {
        return thAdId;
    }

    public void setThAdId(String thAdId) {
        this.thAdId = thAdId;
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

    public String[] getInventory_type() {
        return inventory_type;
    }

    public void setInventory_type(String[] inventory_type) {
        this.inventory_type = inventory_type;
    }

    public String[] getAd_keywords() {
        return ad_keywords;
    }

    public void setAd_keywords(String[] ad_keywords) {
        this.ad_keywords = ad_keywords;
    }

    public List<ThCreativityTitle> getTitle_list() {
        return title_list;
    }

    public void setTitle_list(List<ThCreativityTitle> title_list) {
        this.title_list = title_list;
    }

    public List<ThCreativityImage> getImage_list() {
        return image_list;
    }

    public void setImage_list(List<ThCreativityImage> image_list) {
        this.image_list = image_list;
    }

    public List<ThCreativityCreatives> getCreatives() {
        return creatives;
    }

    public void setCreatives(List<ThCreativityCreatives> creatives) {
        this.creatives = creatives;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setSearchValue(String searchValue)
    {
        this.searchValue = searchValue;
    }

    public String getSearchValue()
    {
        return searchValue;
    }
    public void setAdvertiserId(String advertiserId)
    {
        this.advertiserId = advertiserId;
    }

    public String getAdvertiserId()
    {
        return advertiserId;
    }
    public void setAdId(String adId)
    {
        this.adId = adId;
    }

    public String getAdId()
    {
        return adId;
    }
    public void setTrackUrl(String trackUrl)
    {
        this.trackUrl = trackUrl;
    }

    public String getTrackUrl()
    {
        return trackUrl;
    }
    public void setActionTrackUrl(String actionTrackUrl)
    {
        this.actionTrackUrl = actionTrackUrl;
    }

    public String getActionTrackUrl()
    {
        return actionTrackUrl;
    }
    public void setVideoPlayEffectiveTrackUrl(String videoPlayEffectiveTrackUrl)
    {
        this.videoPlayEffectiveTrackUrl = videoPlayEffectiveTrackUrl;
    }

    public String getVideoPlayEffectiveTrackUrl()
    {
        return videoPlayEffectiveTrackUrl;
    }
    public void setVideoPlayDoneTrackUrl(String videoPlayDoneTrackUrl)
    {
        this.videoPlayDoneTrackUrl = videoPlayDoneTrackUrl;
    }

    public String getVideoPlayDoneTrackUrl()
    {
        return videoPlayDoneTrackUrl;
    }
    public void setVideoPlayTrackUrl(String videoPlayTrackUrl)
    {
        this.videoPlayTrackUrl = videoPlayTrackUrl;
    }

    public String getVideoPlayTrackUrl()
    {
        return videoPlayTrackUrl;
    }
    public void setIsCommentDisable(String isCommentDisable)
    {
        this.isCommentDisable = isCommentDisable;
    }

    public String getIsCommentDisable()
    {
        return isCommentDisable;
    }
    public void setCloseVideoDetail(String closeVideoDetail)
    {
        this.closeVideoDetail = closeVideoDetail;
    }

    public String getCloseVideoDetail()
    {
        return closeVideoDetail;
    }
    public void setCreativeDisplayMode(String creativeDisplayMode)
    {
        this.creativeDisplayMode = creativeDisplayMode;
    }

    public String getCreativeDisplayMode()
    {
        return creativeDisplayMode;
    }
    public void setSmartInventory(String smartInventory)
    {
        this.smartInventory = smartInventory;
    }

    public String getSmartInventory()
    {
        return smartInventory;
    }
    public void setSceneInventory(String sceneInventory)
    {
        this.sceneInventory = sceneInventory;
    }

    public String getSceneInventory()
    {
        return sceneInventory;
    }
    public void setGenerateDerivedAd(String generateDerivedAd)
    {
        this.generateDerivedAd = generateDerivedAd;
    }

    public String getGenerateDerivedAd()
    {
        return generateDerivedAd;
    }
    public void setInventoryType(String inventoryType)
    {
        this.inventoryType = inventoryType;
    }

    public String getInventoryType()
    {
        return inventoryType;
    }
    public void setSource(String source)
    {
        this.source = source;
    }

    public String getSource()
    {
        return source;
    }
    public void setAppName(String appName)
    {
        this.appName = appName;
    }

    public String getAppName()
    {
        return appName;
    }
    public void setWebUrl(String webUrl)
    {
        this.webUrl = webUrl;
    }

    public String getWebUrl()
    {
        return webUrl;
    }
    public void setAdKeywords(String adKeywords)
    {
        this.adKeywords = adKeywords;
    }

    public String getAdKeywords()
    {
        return adKeywords;
    }
    public void setThirdIndustryId(String thirdIndustryId)
    {
        this.thirdIndustryId = thirdIndustryId;
    }

    public String getThirdIndustryId()
    {
        return thirdIndustryId;
    }
    public void setAdvancedCreativeType(String advancedCreativeType)
    {
        this.advancedCreativeType = advancedCreativeType;
    }

    public String getAdvancedCreativeType()
    {
        return advancedCreativeType;
    }
    public void setAdvancedCreativeTitle(String advancedCreativeTitle)
    {
        this.advancedCreativeTitle = advancedCreativeTitle;
    }

    public String getAdvancedCreativeTitle()
    {
        return advancedCreativeTitle;
    }
    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }
    public void setButtonText(String buttonText)
    {
        this.buttonText = buttonText;
    }

    public String getButtonText()
    {
        return buttonText;
    }
    public void setFormUrl(String formUrl)
    {
        this.formUrl = formUrl;
    }

    public String getFormUrl()
    {
        return formUrl;
    }
    public void setCreativeMaterialMode(String creativeMaterialMode)
    {
        this.creativeMaterialMode = creativeMaterialMode;
    }

    public String getCreativeMaterialMode()
    {
        return creativeMaterialMode;
    }
    public void setIsFeedAndFavSee(String isFeedAndFavSee)
    {
        this.isFeedAndFavSee = isFeedAndFavSee;
    }

    public String getIsFeedAndFavSee()
    {
        return isFeedAndFavSee;
    }
    public void setPlayableUrl(String playableUrl)
    {
        this.playableUrl = playableUrl;
    }

    public String getPlayableUrl()
    {
        return playableUrl;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("searchValue", getSearchValue())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("advertiserId", getAdvertiserId())
            .append("adId", getAdId())
            .append("trackUrl", getTrackUrl())
            .append("actionTrackUrl", getActionTrackUrl())
            .append("videoPlayEffectiveTrackUrl", getVideoPlayEffectiveTrackUrl())
            .append("videoPlayDoneTrackUrl", getVideoPlayDoneTrackUrl())
            .append("videoPlayTrackUrl", getVideoPlayTrackUrl())
            .append("isCommentDisable", getIsCommentDisable())
            .append("closeVideoDetail", getCloseVideoDetail())
            .append("creativeDisplayMode", getCreativeDisplayMode())
            .append("smartInventory", getSmartInventory())
            .append("sceneInventory", getSceneInventory())
            .append("generateDerivedAd", getGenerateDerivedAd())
            .append("inventoryType", getInventoryType())
            .append("source", getSource())
            .append("appName", getAppName())
            .append("webUrl", getWebUrl())
            .append("adKeywords", getAdKeywords())
            .append("thirdIndustryId", getThirdIndustryId())
            .append("advancedCreativeType", getAdvancedCreativeType())
            .append("advancedCreativeTitle", getAdvancedCreativeTitle())
            .append("phoneNumber", getPhoneNumber())
            .append("buttonText", getButtonText())
            .append("formUrl", getFormUrl())
            .append("creativeMaterialMode", getCreativeMaterialMode())
            .append("isFeedAndFavSee", getIsFeedAndFavSee())
            .append("playableUrl", getPlayableUrl())
            .toString();
    }
}
