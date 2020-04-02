package com.ruoyi.web.task;

import com.alibaba.fastjson.JSONArray;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.today.domain.ThAdvertiser;
import com.ruoyi.today.domain.ThTodayMatter;
import com.ruoyi.today.domain.request.GetImagesRequest;
import com.ruoyi.today.domain.response.ResponseVO;
import com.ruoyi.today.service.AdCenterService;
import com.ruoyi.today.service.IThAdvertiserService;
import com.ruoyi.today.service.IThTodayMatterService;
import com.ruoyi.today.tools.MultiThreadExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

@Component("syncTodayMatterTask")
public class SyncTodayMatterTask extends MultiThreadExecutor<ThTodayMatter> {

    private static Logger logger = LoggerFactory.getLogger(SyncTodayMatterTask.class);

    @Autowired
    private IThAdvertiserService thAdvertiserService;
    @Autowired
    private AdCenterService touTiaoAdCenterService;
    @Autowired
    private IThTodayMatterService thTodayMatterService;

    @Override
    protected void product(LinkedBlockingQueue storage) {

    }

    @Override
    protected void consume(LinkedBlockingQueue storage) {
 
        storage.poll();

    }

    @Transactional(rollbackFor = Exception.class)
    public void syncAdvertieserMatter(ThAdvertiser thAdvertiser) throws Exception {
        int page = 1;
        int pageSize = 100;
        int totalPage = -1;
        GetImagesRequest request = new GetImagesRequest();
        request.setAdvertiser_id(thAdvertiser.getId().toString());
        request.setPage_size(pageSize);
        ThTodayMatter thTodayMatter = new ThTodayMatter();
        thTodayMatter.setAdvertiserId(thAdvertiser.getId().toString());
        thTodayMatter.setType("image");
        while (totalPage < 0 || page <= totalPage) {
            request.setPage(page);
            ResponseVO resp = (ResponseVO) touTiaoAdCenterService.getImages(request);
            if (resp.getCode().equals("0")) {
                totalPage = resp.getData().getJSONObject("page_info").getIntValue("total_page");
                page++;
                JSONArray list = resp.getData().getJSONArray("list");
                for (int i = 0; i < list.size(); i++) {
                    thTodayMatter.setId(null);
                    thTodayMatter.setSignature(list.getJSONObject(i).getString("signature"));
                    thTodayMatter.setTodayId(list.getJSONObject(i).getString("id"));
                    thTodayMatter.setCreateTime(DateUtils.getNowDate());
                    thTodayMatterService.insertThTodayMatter(thTodayMatter);
                }
            } else {
                throw new Exception(resp.getCode() + resp.getMessage());
            }
        }

    }

    public void syncMatter() throws Exception {

        logger.info("开始同步广告主图片素材" + DateUtils.getDate());
        thTodayMatterService.deleteAllThTodayMatter();
        StringBuffer stringBuffer = new StringBuffer();

        List<ThAdvertiser> thAdvertisers = thAdvertiserService.selectThAdvertiserList(new ThAdvertiser());
        for (ThAdvertiser thAdvertiser : thAdvertisers) {
            try {
                syncAdvertieserMatter(thAdvertiser);
            } catch (Exception e) {
                logger.error("出现错误", e);
                stringBuffer.append(e.getMessage() + "\n");
            }
        }
        if(stringBuffer.length()!=0){
            throw new Exception(stringBuffer.toString());
        }


        logger.info("同步广告主图片素材结束" + DateUtils.getDate());

    }

}
