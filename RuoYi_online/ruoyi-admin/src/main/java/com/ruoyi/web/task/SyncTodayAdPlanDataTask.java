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
import java.util.ArrayList;
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

    private String startStr;
    private String endStr;

    private StringBuffer errorBuffer;

    private static String endFlg = "endFlg";

    //返回更新某段时间的数据(区间超过100天需要自动翻页，这里没有实现)
    public List<ThVideoMatterReport> syncVideoReport(ThTodayMatter thTodayMatter, String startStr, String endStr) throws Exception {
        //查询并插入新的广告计划报表数据(视频的)
        PlanReportSyncRequest reportSyncRequest = new PlanReportSyncRequest();
        reportSyncRequest.setAdvertiser_id(thTodayMatter.getAdvertiserId());
        reportSyncRequest.setStart_date(startStr);
        reportSyncRequest.setEnd_date(endStr);
        reportSyncRequest.setGroup_by(new String[]{"STAT_GROUP_BY_MATERIAL_ID", "STAT_GROUP_BY_TIME_DAY"});
        reportSyncRequest.setMaterial_id(new String[]{thTodayMatter.getTodayId()});
        reportSyncRequest.setPage_size(100);
        ResponseVO responseVO = (ResponseVO) touTiaoAdCenterService.reportMatter(reportSyncRequest);
        ThVideoMatterReport report = null;
        List<ThVideoMatterReport> result = new ArrayList<>();
        if (responseVO.getCode().equals("0")) {
            JSONArray list = responseVO.getData().getJSONArray("list");
            if (list.size() != 0) {
                for (int i = 0; i < list.size(); i++) {
                    report = list.getJSONObject(i).getJSONObject("metrics").toJavaObject(ThVideoMatterReport.class);
                    if (!report.isAllZero()) {
                        report.setTime(list.getJSONObject(i).getJSONObject("dimensions").getDate("stat_datetime"));
                        report.setAdvertiserId(thTodayMatter.getAdvertiserId());
                        report.setMatterId(Long.valueOf(thTodayMatter.getMatterId()));
                        result.add(report);
                    }
                }
            }
        } else {
            throw new Exception("广告主：" + thTodayMatter.getAdvertiserId() + ",素材：" + thTodayMatter.getTodayId() + ":" + responseVO.getCode() + "-" + responseVO.getMessage());
        }
        return result;
    }


    //获取某段时间的数据 参数为日期
    public void syncMatterReport(Integer offset, String startTime, String endTime) throws Exception {

        //查询素材 广告主 广告计划对应关系（视频的）
        errorBuffer = new StringBuffer();
        startStr = null;
        endStr = null;
        thTodayMatterQueue = new LinkedBlockingQueue<>(100);
        List<ThTodayMatter> thTodayMattersVideo = thTodayMatterServicel.selectThTodayMatterByType("video");
        List<ThTodayMatter> thTodayMattersImage = thTodayMatterServicel.selectThTodayMatterByType("image");
        if (startTime == null || startTime.equals("") || endTime == null || endTime.equals("")) {
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DATE, offset);
            startStr = DateUtils.parseDateToStr("yyyy-MM-dd", calendar.getTime());
            endStr = startStr;
        } else {
            startStr = startTime;
            endStr = endTime;
        }
        start(5, 1, 10);
        for (ThTodayMatter adMatterVO : thTodayMattersVideo) {
            try {
                thTodayMatterQueue.put(adMatterVO);
            } catch (Exception e) {
                logger.error("出现错误：", e);
                errorBuffer.append(adMatterVO.getAdvertiserId() + ":" + adMatterVO.getMatterId() + ":" + adMatterVO.getTodayId() + e.getMessage() + "\n");
            }
        }
        for (ThTodayMatter adMatterVO : thTodayMattersImage) {
            try {
                thTodayMatterQueue.put(adMatterVO);
            } catch (Exception e) {
                logger.error("出现错误：", e);
                errorBuffer.append(adMatterVO.getAdvertiserId() + ":" + adMatterVO.getMatterId() + ":" + adMatterVO.getTodayId() + e.getMessage() + "\n");
            }
        }
        ThTodayMatter flg = new ThTodayMatter();
        flg.setTodayId(endFlg);
        while (true){
            if(thTodayMatterQueue.size()==0){
                thTodayMatterQueue.put(flg);
                break;
            }else {
                Thread.sleep(3000);
            }
        }
        await();
        if (errorBuffer.length() != 0) {
            throw new Exception(errorBuffer.toString());
        }

    }

    @Override
    protected void product(LinkedBlockingQueue<ThVideoMatterReport> storage) {
        logger.info("生产者线程" + Thread.currentThread().getName() + "开始");
        ThTodayMatter thTodayMatter = null;
        List<ThVideoMatterReport> thVideoMatterReports = null;
        try {
            thTodayMatter = thTodayMatterQueue.take();
            while (!thTodayMatter.getTodayId().equals(endFlg)) {
                try {

                    thVideoMatterReports = syncVideoReport(thTodayMatter, startStr, endStr);
                    if (thVideoMatterReports != null) {
                        for (int i = 0; i < thVideoMatterReports.size(); i++) {
                            storage.put(thVideoMatterReports.get(i));
                        }
                    }
                } catch (Exception e) {
                    logger.error("出现错误：", e);
                    errorBuffer.append(thTodayMatter.getAdvertiserId() + ":" + thTodayMatter.getTodayId() + ":" + thTodayMatter.getMatterId() + e.getMessage() + "\n");
                }
                thTodayMatter = thTodayMatterQueue.take();
                thVideoMatterReports = null;
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
        List<ThVideoMatterReport> thVideoMatterReports = new ArrayList<>();
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