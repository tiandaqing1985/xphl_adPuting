package com.ruoyi.web.task;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.today.domain.ThAdvertiser;
import com.ruoyi.today.domain.request.PlanSyncRequest;
import com.ruoyi.today.domain.response.PlanSyncResponse;
import com.ruoyi.today.domain.response.PlanSyncThAdVO;
import com.ruoyi.today.service.AdCenterService;
import com.ruoyi.today.service.IThAdService;
import com.ruoyi.today.service.IThAdvertiserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Component("syncTodayAdPlan")
public class SyncTodayAdPlanTask {

    private static Logger logger = LoggerFactory.getLogger(SyncTodayAdPlanTask.class);

    @Autowired
    private IThAdService thAdService;
    @Autowired
    private IThAdvertiserService thAdvertiserService;
    @Autowired
    private AdCenterService touTiaoAdCenterService;

    @Transactional(rollbackFor = Exception.class)
    public void syncAdByAdvertiserId(Long id) throws Exception {

        thAdService.deleteThAdByAdvertiserId(id);
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
            PlanSyncResponse response = (PlanSyncResponse) touTiaoAdCenterService.selectPlan(planSyncRequest);

            if (response.getCode().equals("0")) {

                page = response.getData().getJSONObject("page_info").getIntValue("page");
                totalPage = response.getData().getJSONObject("page_info").getIntValue("total_page");
                totalNumber = response.getData().getJSONObject("page_info").getIntValue("total_number");
                if(totalNumber==0){
                    break;
                }

                List<PlanSyncThAdVO> adVOS = response.getData().getJSONArray("list").toJavaList(PlanSyncThAdVO.class);

                for (PlanSyncThAdVO adVO : adVOS) {
                    try {
                        adVO.setCreateBy("syncTask");
                        adVO.setCreateTime(DateUtils.getNowDate());
                        String adName = adVO.getName();
                        adName = adName.replace("_","-");
                        adName = adName.replace(" ","");
                        String[] splitArrays = adName.split("-");
                        String name = null;
                        for(String str : splitArrays){
                            if(str.contains("xphlsc")){
                                name = str;
                                break;
                            }
                        }
                        adVO.setMatterId(name.trim().substring(14));
                        thAdService.insertThAd(adVO);
                    } catch (Exception e) {
                        logger.error("同步更新广告计划出现错误：", e);
                    }
                }

            } else {
                throw new Exception("<br/><br/>广告计划同步失败，平台错误码：" + response.getCode() + "，错误信息：" + response.getMessage());
            }

        }


    }

    public void syncAd() {

        List<ThAdvertiser> thAdvertisers = thAdvertiserService.selectThAdvertiserList(new ThAdvertiser());
        for (ThAdvertiser advertiser : thAdvertisers) {
            try {
                syncAdByAdvertiserId(advertiser.getId());
            }catch (Exception e){
                logger.error("出现错误",e);
            }
        }

    }


}
