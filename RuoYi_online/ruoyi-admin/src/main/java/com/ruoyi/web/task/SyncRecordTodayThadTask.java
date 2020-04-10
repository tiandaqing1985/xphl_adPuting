package com.ruoyi.web.task;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.today.domain.MatterUseRecord;
import com.ruoyi.today.domain.ThAdvertiser;
import com.ruoyi.today.domain.request.PlanSyncRequest;
import com.ruoyi.today.domain.response.PlanSyncResponse;
import com.ruoyi.today.domain.response.PlanSyncThAdVO;
import com.ruoyi.today.mapper.ThMatterUseRecordMapper;
import com.ruoyi.today.service.AdCenterService;
import com.ruoyi.today.service.IThAdService;
import com.ruoyi.today.service.IThAdvertiserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@Component
public class SyncRecordTodayThadTask {

    private static Logger logger = LoggerFactory.getLogger(SyncRecordTodayThadTask.class);

    @Autowired
    private ThMatterUseRecordMapper thMatterUseRecordMapper;
    @Autowired
    private IThAdvertiserService thAdvertiserService;
    @Autowired
    private AdCenterService touTiaoAdCenterService;

    private StringBuffer errorMsg;

    @Transactional(rollbackFor = Exception.class)
    public void syncAdByAdvertiserId(Long id) throws Exception {

        int pageSize = 1000;
        int page = 0;
        int totalPage = -1;
        int totalNumber = 0;
        while (page != totalPage) {
            page++;
            PlanSyncRequest planSyncRequest = new PlanSyncRequest();
            planSyncRequest.setAdvertiser_id(id.toString());
            planSyncRequest.setAd_name("xphlsc");
            planSyncRequest.setPage(page);
            planSyncRequest.setPage_size(pageSize);
            planSyncRequest.setStatus("AD_STATUS_DELIVERY_OK");
            PlanSyncResponse response = (PlanSyncResponse) touTiaoAdCenterService.selectPlan(planSyncRequest);

            if (response.getCode().equals("0")) {

                page = response.getData().getJSONObject("page_info").getIntValue("page");
                totalPage = response.getData().getJSONObject("page_info").getIntValue("total_page");
                totalNumber = response.getData().getJSONObject("page_info").getIntValue("total_number");
                if (totalNumber == 0) {
                    break;
                }

                List<PlanSyncThAdVO> adVOS = response.getData().getJSONArray("list").toJavaList(PlanSyncThAdVO.class);
                MatterUseRecord matterUseRecord = new MatterUseRecord();
                matterUseRecord.setTime(new Date(new java.util.Date().getTime()));
                for (PlanSyncThAdVO adVO : adVOS) {
                    try {
                        String adName = adVO.getName();
                        adName = adName.replace("_", "-");
                        adName = adName.replace(" ", "");
                        String[] splitArrays = adName.split("-");
                        String name = null;
                        for (String str : splitArrays) {
                            if (str.contains("xphlsc")) {
                                name = str;
                                break;
                            }
                        }
                        matterUseRecord.setMatterId(Long.valueOf(name.trim().substring(14)));
                        List<MatterUseRecord> matterUseRecords = thMatterUseRecordMapper.selectList(matterUseRecord);
                        if (matterUseRecords.size() == 0) {
                            thMatterUseRecordMapper.insertMatterUseRecord(matterUseRecord);
                        }
                    } catch (Exception e) {
                        logger.error("同步更新广告计划出现错误：", e);
                        errorMsg.append("广告主" + adVO.getAdvertiserId() + ":" + e.getMessage() + "\n");
                    }
                }

            } else {
                errorMsg.append("广告主" + id + ":" + "广告计划同步失败，平台错误码：" + response.getCode() + "，错误信息：" + response.getMessage() + "\n");
                throw new Exception("广告计划同步失败，平台错误码：" + response.getCode() + "，错误信息：" + response.getMessage());
            }

        }


    }

    public void syncAd() {

        errorMsg = new StringBuffer();
        List<ThAdvertiser> thAdvertisers = thAdvertiserService.selectThAdvertiserList(new ThAdvertiser());
        for (ThAdvertiser advertiser : thAdvertisers) {
            try {
                syncAdByAdvertiserId(advertiser.getId());
            } catch (Exception e) {
                logger.error("出现错误", e);
                errorMsg.append("广告主" + advertiser.getId() + ":" + e.getMessage() + "\n");
            }
        }

    }

}
