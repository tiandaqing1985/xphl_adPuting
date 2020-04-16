package com.ruoyi.web.task;

import com.alibaba.fastjson.JSONArray;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.today.domain.AdMatterVO;
import com.ruoyi.today.domain.MatterUseRecord;
import com.ruoyi.today.domain.ThTodayMatter;
import com.ruoyi.today.domain.ThVideoMatterReport;
import com.ruoyi.today.domain.request.PlanReportSyncRequest;
import com.ruoyi.today.domain.response.ResponseVO;
import com.ruoyi.today.mapper.ThMatterUseRecordMapper;
import com.ruoyi.today.service.AdCenterService;
import com.ruoyi.today.service.IThTodayMatterService;
import com.ruoyi.today.service.IThVideoMatterReportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Component("syncTodayAdPlanDataTask")
public class SyncTodayAdPlanDataTask {

    private static Logger logger = LoggerFactory.getLogger(SyncTodayAdPlanDataTask.class);

    @Autowired
    private IThVideoMatterReportService thVideoMatterReportService;
    @Autowired
    private IThTodayMatterService thTodayMatterServicel;

    @Autowired
    private AdCenterService touTiaoAdCenterService;
    @Autowired
    private ThMatterUseRecordMapper thMatterUseRecordMapper;

    @Transactional
    public void syncVideoReport(ThTodayMatter thTodayMatter, String timeStr, Date time) throws Exception {
        //查询并插入新的广告计划报表数据(视频的)
        PlanReportSyncRequest reportSyncRequest = new PlanReportSyncRequest();
        reportSyncRequest.setAdvertiser_id(thTodayMatter.getAdvertiserId());
        reportSyncRequest.setStart_date(timeStr);
        reportSyncRequest.setEnd_date(timeStr);
        reportSyncRequest.setGroup_by(new String[]{"STAT_GROUP_BY_MATERIAL_ID"});
        reportSyncRequest.setMaterial_id(new String[]{thTodayMatter.getTodayId()});
        ResponseVO responseVO = (ResponseVO) touTiaoAdCenterService.reportMatter(reportSyncRequest);
        ThVideoMatterReport report = null;
        if (responseVO.getCode().equals("0")) {
            JSONArray list = responseVO.getData().getJSONArray("list");
            if (list.size() != 0) {
                report = list.getJSONObject(0).getJSONObject("metrics").toJavaObject(ThVideoMatterReport.class);
                if (!report.isAllZero()) {
                    report.setTime(time);
                    report.setAdvertiserId(thTodayMatter.getAdvertiserId());
                    report.setMatterId(Long.valueOf(thTodayMatter.getMatterId()));
                    thVideoMatterReportService.insertThVideoMatterReport(report);
                }
            }
        } else {
            throw new Exception("广告主：" + thTodayMatter.getAdvertiserId() + ",素材：" + thTodayMatter.getTodayId() + responseVO.getCode() + "-" + responseVO.getMessage());
        }


//        PlanReportSyncRequest reportSyncRequest = new PlanReportSyncRequest();
//        reportSyncRequest.setAdvertiser_id(adMatterVO.getAdvertiserId());
//        reportSyncRequest.setStart_date(timeStr);
//        reportSyncRequest.setEnd_date(timeStr);
//        reportSyncRequest.setAd_ids(adMatterVO.getAdIds().split(","));
//        ResponseVO responseVO = (ResponseVO) touTiaoAdCenterService.reportPlan(reportSyncRequest);
//        ThVideoMatterReport report = null;
//        if (responseVO.getCode().equals("0")) {
//            List<ThVideoMatterReport> list = responseVO.getData().getJSONArray("list").toJavaList(ThVideoMatterReport.class);
//            report = list.get(0);
//            if (!report.isAllZero()) {
//                report.setTime(time);
//                report.setAdvertiserId(adMatterVO.getAdvertiserId());
//                report.setMatterId(adMatterVO.getMatterId());
//                thVideoMatterReportService.insertThVideoMatterReport(report);
//            }
//        } else {
//            throw new Exception("广告主：" + adMatterVO.getAdvertiserId() + ",计划id：" + adMatterVO.getAdIds() + ":" + responseVO.getCode() + "-" + responseVO.getMessage());
//        }
    }

    public void syncImageReport(ThTodayMatter thTodayMatter, String timeStr, Date time) throws Exception {
        //查询并插入新的素材报表数据(图片的)
        PlanReportSyncRequest reportSyncRequest = new PlanReportSyncRequest();
        reportSyncRequest.setAdvertiser_id(thTodayMatter.getAdvertiserId());
        reportSyncRequest.setStart_date(timeStr);
        reportSyncRequest.setEnd_date(timeStr);
        reportSyncRequest.setGroup_by(new String[]{"STAT_GROUP_BY_MATERIAL_ID"});
        reportSyncRequest.setMaterial_id(new String[]{thTodayMatter.getTodayId()});
        ResponseVO responseVO = (ResponseVO) touTiaoAdCenterService.reportMatter(reportSyncRequest);
        ThVideoMatterReport report = null;
        if (responseVO.getCode().equals("0")) {
            JSONArray list = responseVO.getData().getJSONArray("list");
            if (list.size() != 0) {
                report = list.getJSONObject(0).getJSONObject("metrics").toJavaObject(ThVideoMatterReport.class);
                if (!report.isAllZero()) {
                    report.setTime(time);
                    report.setAdvertiserId(thTodayMatter.getAdvertiserId());
                    report.setMatterId(Long.valueOf(thTodayMatter.getMatterId()));
                    thVideoMatterReportService.insertThVideoMatterReport(report);
                }
            }
        } else {
            throw new Exception("广告主：" + thTodayMatter.getAdvertiserId() + ",素材：" + thTodayMatter.getTodayId() + responseVO.getCode() + "-" + responseVO.getMessage());
        }
    }

    public void syncMatterReport() throws Exception {

        //查询素材 广告主 广告计划对应关系（视频的）
        List<ThTodayMatter> thTodayMatters = thTodayMatterServicel.selectThTodayMatterByType("video");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        Date time = calendar.getTime();
        String timeStr = DateUtils.parseDateToStr("yyyy-MM-dd", calendar.getTime());
        StringBuffer stringBuffer = new StringBuffer();
        for (ThTodayMatter adMatterVO : thTodayMatters) {
            try {
                syncVideoReport(adMatterVO, timeStr, time);
            } catch (Exception e) {
                logger.error("出现错误：", e);
                stringBuffer.append(e.getMessage() + "\n");
            }
        }



//        //图片的
//        List<ThTodayMatter> thTodayMatters = thTodayMatterServicel.selectThTodayMatterByType("image");
//        for (ThTodayMatter thTodayMatter : thTodayMatters) {
//            try {
//                syncImageReport(thTodayMatter, timeStr, time);
//            } catch (Exception e) {
//                logger.error("出现错误：", e);
//                stringBuffer.append(e.getMessage() + "\n");
//            }
//        }


        if (stringBuffer.length() != 0) {
            throw new Exception(stringBuffer.toString());
        }

    }

}