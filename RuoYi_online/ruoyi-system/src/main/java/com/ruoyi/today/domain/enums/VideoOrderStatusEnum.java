package com.ruoyi.today.domain.enums;

public enum VideoOrderStatusEnum {

    ORDER("order"),//下单
    RECEIVE("receive"),//接单
    DELIVERY("delivery"),//交付
    SIGNIN("signIn"),//签收
    PUTIN("putIn");//投放
    private String value;

    VideoOrderStatusEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
