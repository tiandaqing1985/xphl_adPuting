package com.ruoyi.today.domain.request;

import java.util.HashMap;
import java.util.Map;

public class GetImagesRequest {

    private String advertiser_id;
    private Integer page;
    private Integer page_size;

    //当是get请求时 使用Map传参
    public Map<String, Object> requestMap() {

        Map<String, Object> requestMap = new HashMap<>();

        if (advertiser_id != null) {
            requestMap.put("advertiser_id", advertiser_id);
        }
        if (page != null) {
            requestMap.put("page", page);
        }
        if (page_size != null) {
            requestMap.put("page_size", page_size);
        }

        return requestMap;

    }

    public String getAdvertiser_id() {
        return advertiser_id;
    }

    public void setAdvertiser_id(String advertiser_id) {
        this.advertiser_id = advertiser_id;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPage_size() {
        return page_size;
    }

    public void setPage_size(Integer page_size) {
        this.page_size = page_size;
    }
}
