package com.ruoyi.today.service;

import com.ruoyi.today.domain.request.PlanSyncRequest;
import com.ruoyi.today.domain.response.PlanSyncResponse;

import java.util.List;

/**
 * 平台service，广告组等的增删改查
 */
public interface AdCenterService {

    /**
     * 创建广告计划
     * @param plans
     * @return
     */
    public Object createAdPlan(Object plans);

    /**
     * 更新广告计划状态
     * @param plan
     * @return
     */
    public Object updateAdPlanStatus(Object plan);

    public Object updateAdPlan(Object plan);

    /**
     * 查询广告计划
     * @param request
     * @return
     */
    public Object selectPlan(Object request);

    /**
     * 查询广告组
     * @param request
     * @return
     */
    public Object selectGroup(Object request);

    public Object createGroup(Object group);
}
