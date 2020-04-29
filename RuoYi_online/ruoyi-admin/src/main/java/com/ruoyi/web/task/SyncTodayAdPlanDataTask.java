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
import com.ruoyi.today.tools.MultiThreadExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;

@Component("syncTodayAdPlanDataTask")
public class SyncTodayAdPlanDataTask extends MultiThreadExecutor<ThVideoMatterReport> {

    private static Logger logger = LoggerFactory.getLogger(SyncTodayAdPlanDataTask.class);

    @Autowired
    private IThVideoMatterReportService thVideoMatterReportService;
    @Autowired
    private IThTodayMatterService thTodayMatterServicel;

    @Autowired
    private AdCenterService touTiaoAdCenterService;
    @Autowired
    private ThMatterUseRecordMapper thMatterUseRecordMapper;

    private LinkedBlockingQueue<ThTodayMatter> thTodayMatterQueue = new LinkedBlockingQueue<>(100);

    private Date time;
    private String timeStr;
    private StringBuffer errorBuffer;

    public ThVideoMatterReport syncVideoReport(ThTodayMatter thTodayMatter, String timeStr, Date time) throws Exception {
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
                    return report;
//                    thVideoMatterReportService.insertThVideoMatterReport(report);
                }
            }
        } else {
            throw new Exception("广告主：" + thTodayMatter.getAdvertiserId() + ",素材：" + thTodayMatter.getTodayId() + responseVO.getCode() + "-" + responseVO.getMessage());
        }
        return null;
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
        errorBuffer = new StringBuffer();
        List<ThTodayMatter> thTodayMatters = thTodayMatterServicel.selectThTodayMatterByType("video");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        time = calendar.getTime();
        timeStr = DateUtils.parseDateToStr("yyyy-MM-dd", calendar.getTime());
        start(5, 1, 10);
        for (ThTodayMatter adMatterVO : thTodayMatters) {
            try {
                thTodayMatterQueue.put(adMatterVO);
            } catch (Exception e) {
                logger.error("出现错误：", e);
                errorBuffer.append(adMatterVO.getAdvertiserId() + ":" + adMatterVO.getMatterId() + ":" + adMatterVO.getTodayId() + e.getMessage() + "\n");
            }
        }
        thTodayMatterQueue.put(new ThTodayMatter());
        await();
        if (errorBuffer.length() != 0) {
            throw new Exception(errorBuffer.toString());
        }

    }

    @Override
    protected void product(LinkedBlockingQueue<ThVideoMatterReport> storage) {
        logger.info("生产者线程" + Thread.currentThread().getName() + "开始");
        ThTodayMatter thTodayMatter = null;
        ThVideoMatterReport thVideoMatterReport = null;
        try {
            thTodayMatter = thTodayMatterQueue.take();
            while (thTodayMatter.getAdvertiserId() != null) {
                try {

                    thVideoMatterReport = syncVideoReport(thTodayMatter, timeStr, time);
                    if (thVideoMatterReport != null) {
                        storage.put(thVideoMatterReport);
                    }
                    thTodayMatter = thTodayMatterQueue.take();
                    thVideoMatterReport = null;
                } catch (Exception e) {
                    logger.error("出现错误：", e);
                    errorBuffer.append(thTodayMatter.getAdvertiserId() + ":" + thTodayMatter.getTodayId() + ":" + thTodayMatter.getMatterId() + e.getMessage() + "\n");
                }
            }
            thTodayMatterQueue.put(thTodayMatter);
        } catch (Exception e) {
            logger.error("出现错误：", e);
            errorBuffer.append(thTodayMatter.getAdvertiserId() + ":" + thTodayMatter.getTodayId() + ":" + thTodayMatter.getMatterId() + e.getMessage() + "\n");
        }
    }

    @Override
    protected void productEnd(LinkedBlockingQueue<ThVideoMatterReport> storage, CountDownLatch countDownLatch) {
        if (countDownLatch.getCount() == 1) {
            try {
                storage.put(new ThVideoMatterReport());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        logger.info("生产者线程" + Thread.currentThread().getName() + "结束");
    }

    @Override
    protected void consume(LinkedBlockingQueue<ThVideoMatterReport> storage) {
        logger.info("消费者线程" + Thread.currentThread().getName() + "开始");
        ThVideoMatterReport videoMatterReport = null;
        try {
            videoMatterReport = storage.take();
            while (videoMatterReport.getAdvertiserId() != null) {
                try {
                    thVideoMatterReportService.insertThVideoMatterReport(videoMatterReport);
                    videoMatterReport = storage.take();
                } catch (Exception e) {
                    logger.error("出现错误：", e);
                    errorBuffer.append(videoMatterReport.getAdvertiserId() + ":" + videoMatterReport.getMatterId() + e.getMessage() + "\n");
                }
            }
            storage.put(videoMatterReport);
        } catch (InterruptedException e) {
            logger.error("出现错误：", e);
            errorBuffer.append(videoMatterReport.getAdvertiserId() + ":" + videoMatterReport.getMatterId() + e.getMessage() + "\n");
        } finally {
            logger.info("消费者线程" + Thread.currentThread().getName() + "结束");
        }


    }
}