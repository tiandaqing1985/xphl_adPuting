package com.ruoyi.today.domain.response;

import com.alibaba.fastjson.JSONObject;

public class ResponseVO {

    private String code;
    private String message;
    private JSONObject data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public JSONObject getData() {
        return data;
    }

    public void setData(JSONObject data) {
        this.data = data;
    }
}
