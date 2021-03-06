package com.ruoyi.today.service;

import com.ruoyi.today.domain.ThCreativity;
import com.ruoyi.today.domain.request.GetImagesRequest;
import com.ruoyi.today.domain.request.PlanReportSyncRequest;
import com.ruoyi.today.domain.request.PlanSyncRequest;
import com.ruoyi.today.domain.response.PlanSyncResponse;
import com.ruoyi.today.domain.response.ResponseVO;

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

    //创建广告组
    public Object createGroup(Object group);

    //上传图片素材
    public Object uploadImageFile(Object image);

    //上传视频素材
    public Object uploadVideoFile(Object video);

    //创建创意
    public Object createCreativity(Object creativity);

    //查询创意
    public Object selectCreativity(Object creativity);

    public Object updateCreativity(Object thCreativity);

    //查询广告计划报表数据
    public Object reportPlan(Object object);

    //查询广告主的图片素材库
    Object getImages(Object request) throws Exception;

    //查询广告主的视频素材库
    Object getVideo(Object request) throws Exception;

    Object reportMatter(Object reportSyncRequest) throws Exception;
}
