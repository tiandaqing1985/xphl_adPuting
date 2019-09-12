package com.ruoyi.web.task;

import com.alibaba.fastjson.JSONArray;
import com.ruoyi.today.domain.ThAdIndustry;
import com.ruoyi.today.domain.response.ResponseVO;
import com.ruoyi.today.service.AdCenterService;
import com.ruoyi.today.service.IThAdIndustryService;
import com.ruoyi.today.service.impl.TouTiaoAdCenterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("todayIndustryTask")
public class TodayIndustryTask {

    @Autowired
    private IThAdIndustryService thAdIndustryService;
    @Autowired
    private AdCenterService touTiaoAdCenterService;

    public void syncIndustry() {
        TouTiaoAdCenterServiceImpl service = (TouTiaoAdCenterServiceImpl) touTiaoAdCenterService;
        ResponseVO responseVO = (ResponseVO) service.getIndustry();
        JSONArray jsonArray = responseVO.getData().getJSONArray("list");
        List<ThAdIndustry> thAdIndustries = jsonArray.toJavaList(ThAdIndustry.class);
        for (ThAdIndustry thAdIndustry : thAdIndustries) {
            thAdIndustryService.insertThAdIndustry(thAdIndustry);
        }

    }

}
