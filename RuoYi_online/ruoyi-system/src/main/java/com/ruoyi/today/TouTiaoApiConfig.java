package com.ruoyi.today;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component

@ConfigurationProperties(prefix = "toutiao")
public class TouTiaoApiConfig {

    //广告计划相关
    private Map<String, String> adPlanAPIUrls = new HashMap<>();
    //广告主相关
    private Map<String, String> advertiserAPIUrls = new HashMap<>();
    //广告组相关
    private Map<String, String> adGroupAPIUrls = new HashMap<>();
    //广告创意相关
    private Map<String, String> adCreativityAPIUrls = new HashMap<>();
    //头条字段值相关
    private Map<String, String> tools = new HashMap<>();

    public Map<String, String> getAdCreativityAPIUrls() {
        return adCreativityAPIUrls;
    }

    public void setAdCreativityAPIUrls(Map<String, String> adCreativityAPIUrls) {
        this.adCreativityAPIUrls = adCreativityAPIUrls;
    }

    public Map<String, String> getAdPlanAPIUrls() {
        return adPlanAPIUrls;
    }

    public void setAdPlanAPIUrls(Map<String, String> adPlanAPIUrls) {
        this.adPlanAPIUrls = adPlanAPIUrls;
    }

    public Map<String, String> getAdvertiserAPIUrls() {
        return advertiserAPIUrls;
    }

    public void setAdvertiserAPIUrls(Map<String, String> advertiserAPIUrls) {
        this.advertiserAPIUrls = advertiserAPIUrls;
    }

    public Map<String, String> getAdGroupAPIUrls() {
        return adGroupAPIUrls;
    }

    public void setAdGroupAPIUrls(Map<String, String> adGroupAPIUrls) {
        this.adGroupAPIUrls = adGroupAPIUrls;
    }

    public Map<String, String> getTools() {
        return tools;
    }

    public void setTools(Map<String, String> tools) {
        this.tools = tools;
    }
}
