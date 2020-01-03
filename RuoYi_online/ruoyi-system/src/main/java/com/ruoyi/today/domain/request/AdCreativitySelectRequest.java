package com.ruoyi.today.domain.request;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * 查询广告组请求类
 */
public class AdCreativitySelectRequest {
    private String advertiser_id;//广告主ID
    private String ad_id;//计划ID

    public String getAdvertiser_id() {
        return advertiser_id;
    }

    public void setAdvertiser_id(String advertiser_id) {
        this.advertiser_id = advertiser_id;
    }

    public String getAd_id() {
        return ad_id;
    }

    public void setAd_id(String ad_id) {
        this.ad_id = ad_id;
    }

    //当是get请求时 使用Map传参
    public Map<String, Object> requestMap() {
        Map<String, Object> request = new HashMap<>();
        if (getAdvertiser_id() != null) {
            request.put("advertiser_id", getAdvertiser_id());
        }
        if (getAd_id() != null) {
            request.put("ad_id", getAd_id());
        }
        return request;
    }

}
