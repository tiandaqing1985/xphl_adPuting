package com.ruoyi.today.domain.response;

import com.alibaba.fastjson.JSONArray;

//同步广告计划时 今日头条返回的
public class AudienceVO {

    private String[] ac;
    private String[] user_type;
    private String[] exclude_custom_actions;
    private String[] app_ids;
    private String[] device_type;
    private String[] interest_tags;
    private String android_osv;
    private String[] city;
    private String district;
    private String[] exclude_flow_package;
    private String[] business_ids;
    private String[] include_custom_actions;
    private String[] platform;
    private String[] activate_type;
    private String ios_osv;
    private String[] ad_tag;
    private String[] app_category;
    private String auto_extend_enabled;
    private String[] retargeting_tags_exclude;
    private String[] article_category;
    private String[] device_brand;
    private String[] retargeting_tags;
    private String location_type;
    private String superior_popularity_type;
    private String app_behavior_target;
    private String gender;
    private String[] age;
    private String retargeting_type;
    private String[] auto_extend_targets;
    private String[] carrier;
    private String dpa_local_audience;
    private String[] retargeting_tags_include;
    private String[] flow_package;

    private String[] geolocation;
    private String[] advertiser_store_ids;
    private String product_platform_id;
    private String[] dpa_adtype;
    private String[] dpa_external_urls;
    private String[] dpa_open_urls;
    private String[] category_type;
    private String[] dpa_categories;
    private String[] dpa_products;
    private String external_url_params;
    private String open_url_params;
    private String union_video_type;
    private String deep_bid_type;
    private String deep_cpabid;
    private String roi_goal;
    private String smart_bid_type;
    private String adjust_cpa;
    private String[] inventory_type;
    private String[] external_actions;
    private String[] launch_price;

    public String[] getLaunch_price() {
        return launch_price;
    }

    public void setLaunch_price(String[] launch_price) {
        this.launch_price = launch_price;
    }

    public String[] getExternal_actions() {
        return external_actions;
    }

    public void setExternal_actions(String[] external_actions) {
        this.external_actions = external_actions;
    }

    public String[] getGeolocation() {
        return geolocation;
    }

    public void setGeolocation(String[] geolocation) {
        this.geolocation = geolocation;
    }

    public String[] getAdvertiser_store_ids() {
        return advertiser_store_ids;
    }

    public void setAdvertiser_store_ids(String[] advertiser_store_ids) {
        this.advertiser_store_ids = advertiser_store_ids;
    }

    public String getProduct_platform_id() {
        return product_platform_id;
    }

    public void setProduct_platform_id(String product_platform_id) {
        this.product_platform_id = product_platform_id;
    }

    public String[] getDpa_adtype() {
        return dpa_adtype;
    }

    public void setDpa_adtype(String[] dpa_adtype) {
        this.dpa_adtype = dpa_adtype;
    }

    public String[] getDpa_external_urls() {
        return dpa_external_urls;
    }

    public void setDpa_external_urls(String[] dpa_external_urls) {
        this.dpa_external_urls = dpa_external_urls;
    }

    public String[] getDpa_open_urls() {
        return dpa_open_urls;
    }

    public void setDpa_open_urls(String[] dpa_open_urls) {
        this.dpa_open_urls = dpa_open_urls;
    }

    public String[] getCategory_type() {
        return category_type;
    }

    public void setCategory_type(String[] category_type) {
        this.category_type = category_type;
    }

    public String[] getDpa_categories() {
        return dpa_categories;
    }

    public void setDpa_categories(String[] dpa_categories) {
        this.dpa_categories = dpa_categories;
    }

    public String[] getDpa_products() {
        return dpa_products;
    }

    public void setDpa_products(String[] dpa_products) {
        this.dpa_products = dpa_products;
    }

    public String getExternal_url_params() {
        return external_url_params;
    }

    public void setExternal_url_params(String external_url_params) {
        this.external_url_params = external_url_params;
    }

    public String getOpen_url_params() {
        return open_url_params;
    }

    public void setOpen_url_params(String open_url_params) {
        this.open_url_params = open_url_params;
    }

    public String getUnion_video_type() {
        return union_video_type;
    }

    public void setUnion_video_type(String union_video_type) {
        this.union_video_type = union_video_type;
    }

    public String getDeep_bid_type() {
        return deep_bid_type;
    }

    public void setDeep_bid_type(String deep_bid_type) {
        this.deep_bid_type = deep_bid_type;
    }

    public String getDeep_cpabid() {
        return deep_cpabid;
    }

    public void setDeep_cpabid(String deep_cpabid) {
        this.deep_cpabid = deep_cpabid;
    }

    public String getRoi_goal() {
        return roi_goal;
    }

    public void setRoi_goal(String roi_goal) {
        this.roi_goal = roi_goal;
    }

    public String getSmart_bid_type() {
        return smart_bid_type;
    }

    public void setSmart_bid_type(String smart_bid_type) {
        this.smart_bid_type = smart_bid_type;
    }

    public String getAdjust_cpa() {
        return adjust_cpa;
    }

    public void setAdjust_cpa(String adjust_cpa) {
        this.adjust_cpa = adjust_cpa;
    }

    public String[] getInventory_type() {
        return inventory_type;
    }

    public void setInventory_type(String[] inventory_type) {
        this.inventory_type = inventory_type;
    }

    public String[] getAc() {
        return ac;
    }

    public void setAc(String[] ac) {
        this.ac = ac;
    }

    public String[] getUser_type() {
        return user_type;
    }

    public void setUser_type(String[] user_type) {
        this.user_type = user_type;
    }

    public String[] getExclude_custom_actions() {
        return exclude_custom_actions;
    }

    public void setExclude_custom_actions(String[] exclude_custom_actions) {
        this.exclude_custom_actions = exclude_custom_actions;
    }

    public String[] getApp_ids() {
        return app_ids;
    }

    public void setApp_ids(String[] app_ids) {
        this.app_ids = app_ids;
    }

    public String[] getDevice_type() {
        return device_type;
    }

    public void setDevice_type(String[] device_type) {
        this.device_type = device_type;
    }

    public String[] getInterest_tags() {
        return interest_tags;
    }

    public void setInterest_tags(String[] interest_tags) {
        this.interest_tags = interest_tags;
    }

    public String getAndroid_osv() {
        return android_osv;
    }

    public void setAndroid_osv(String android_osv) {
        this.android_osv = android_osv;
    }

    public String[] getCity() {
        return city;
    }

    public void setCity(String[] city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String[] getExclude_flow_package() {
        return exclude_flow_package;
    }

    public void setExclude_flow_package(String[] exclude_flow_package) {
        this.exclude_flow_package = exclude_flow_package;
    }

    public String[] getBusiness_ids() {
        return business_ids;
    }

    public void setBusiness_ids(String[] business_ids) {
        this.business_ids = business_ids;
    }

    public String[] getInclude_custom_actions() {
        return include_custom_actions;
    }

    public void setInclude_custom_actions(String[] include_custom_actions) {
        this.include_custom_actions = include_custom_actions;
    }

    public String[] getPlatform() {
        return platform;
    }

    public void setPlatform(String[] platform) {
        this.platform = platform;
    }

    public String[] getActivate_type() {
        return activate_type;
    }

    public void setActivate_type(String[] activate_type) {
        this.activate_type = activate_type;
    }

    public String getIos_osv() {
        return ios_osv;
    }

    public void setIos_osv(String ios_osv) {
        this.ios_osv = ios_osv;
    }

    public String[] getAd_tag() {
        return ad_tag;
    }

    public void setAd_tag(String[] ad_tag) {
        this.ad_tag = ad_tag;
    }

    public String[] getApp_category() {
        return app_category;
    }

    public void setApp_category(String[] app_category) {
        this.app_category = app_category;
    }

    public String getAuto_extend_enabled() {
        return auto_extend_enabled;
    }

    public void setAuto_extend_enabled(String auto_extend_enabled) {
        this.auto_extend_enabled = auto_extend_enabled;
    }

    public String[] getRetargeting_tags_exclude() {
        return retargeting_tags_exclude;
    }

    public void setRetargeting_tags_exclude(String[] retargeting_tags_exclude) {
        this.retargeting_tags_exclude = retargeting_tags_exclude;
    }

    public String[] getArticle_category() {
        return article_category;
    }

    public void setArticle_category(String[] article_category) {
        this.article_category = article_category;
    }

    public String[] getDevice_brand() {
        return device_brand;
    }

    public void setDevice_brand(String[] device_brand) {
        this.device_brand = device_brand;
    }

    public String[] getRetargeting_tags() {
        return retargeting_tags;
    }

    public void setRetargeting_tags(String[] retargeting_tags) {
        this.retargeting_tags = retargeting_tags;
    }

    public String getLocation_type() {
        return location_type;
    }

    public void setLocation_type(String location_type) {
        this.location_type = location_type;
    }

    public String getSuperior_popularity_type() {
        return superior_popularity_type;
    }

    public void setSuperior_popularity_type(String superior_popularity_type) {
        this.superior_popularity_type = superior_popularity_type;
    }

    public String getApp_behavior_target() {
        return app_behavior_target;
    }

    public void setApp_behavior_target(String app_behavior_target) {
        this.app_behavior_target = app_behavior_target;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String[] getAge() {
        return age;
    }

    public void setAge(String[] age) {
        this.age = age;
    }

    public String getRetargeting_type() {
        return retargeting_type;
    }

    public void setRetargeting_type(String retargeting_type) {
        this.retargeting_type = retargeting_type;
    }

    public String[] getAuto_extend_targets() {
        return auto_extend_targets;
    }

    public void setAuto_extend_targets(String[] auto_extend_targets) {
        this.auto_extend_targets = auto_extend_targets;
    }

    public String[] getCarrier() {
        return carrier;
    }

    public void setCarrier(String[] carrier) {
        this.carrier = carrier;
    }

    public String getDpa_local_audience() {
        return dpa_local_audience;
    }

    public void setDpa_local_audience(String dpa_local_audience) {
        this.dpa_local_audience = dpa_local_audience;
    }

    public String[] getRetargeting_tags_include() {
        return retargeting_tags_include;
    }

    public void setRetargeting_tags_include(String[] retargeting_tags_include) {
        this.retargeting_tags_include = retargeting_tags_include;
    }

    public String[] getFlow_package() {
        return flow_package;
    }

    public void setFlow_package(String[] flow_package) {
        this.flow_package = flow_package;
    }
}
