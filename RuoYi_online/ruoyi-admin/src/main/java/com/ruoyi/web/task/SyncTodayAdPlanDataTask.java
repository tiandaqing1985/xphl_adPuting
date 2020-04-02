package com.ruoyi.web.task;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.today.domain.AdMatterVO;
import com.ruoyi.today.domain.ThVideoMatterReport;
import com.ruoyi.today.domain.request.PlanReportSyncRequest;
import com.ruoyi.today.domain.response.ResponseVO;
import com.ruoyi.today.service.AdCenterService;
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
    private AdCenterService touTiaoAdCenterService;

    @Transactional(rollbackFor = Exception.class)
    public void syncReport(AdMatterVO adMatterVO, String timeStr, Date time) throws Exception {
        //查询并插入新的广告计划报表数据
        PlanReportSyncRequest reportSyncRequest = new PlanReportSyncRequest();
        reportSyncRequest.setAdvertiser_id(adMatterVO.getAdvertiserId());
        reportSyncRequest.setStart_date(timeStr);
        reportSyncRequest.setEnd_date(timeStr);
        reportSyncRequest.setAd_ids(adMatterVO.getAdIds().split(","));
        ResponseVO responseVO = (ResponseVO) touTiaoAdCenterService.reportPlan(reportSyncRequest);
        ThVideoMatterReport report = null;
        if (responseVO.getCode().equals("0")) {
            List<ThVideoMatterReport> list = responseVO.getData().getJSONArray("list").toJavaList(ThVideoMatterReport.class);
            report = list.get(0);
            if (!report.isAllZero()) {
                report.setTime(time);
                report.setAdvertiserId(adMatterVO.getAdvertiserId());
                report.setMatterId(adMatterVO.getMatterId());
                thVideoMatterReportService.insertThVideoMatterReport(report);
            }
        } else {
            throw new Exception(responseVO.getCode() + "-" + responseVO.getMessage());
        }
    }

    public void syncMatterReport() {

        //查询素材 广告主 广告计划对应关系
        List<AdMatterVO> list = thVideoMatterReportService.selectAdMatterList();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        Date time = calendar.getTime();
        String timeStr = DateUtils.parseDateToStr("yyyy-MM-dd", calendar.getTime());
        for (AdMatterVO adMatterVO : list) {
            try {
                syncReport(adMatterVO, timeStr, time);
            } catch (Exception e) {
                logger.error("出现错误：", e);
            }
        }


    }

}
image