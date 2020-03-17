package com.ruoyi.today.domain.request;
//投放视频时前端传到后端的请求实体类
public class CreativitiesVideoRequest {
    public Long advertiserId;//广告主id

    public Long adId;//广告计划id

    public String matterIds;//素材主键

    public Long id;//创意主键

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

    public String getMatterIds() {
        return matterIds;
    }

    public void setMatterIds(String matterIds) {
        this.matterIds = matterIds;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
