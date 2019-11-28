package com.ruoyi.today.service.impl;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.today.domain.ThAd;
import com.ruoyi.today.domain.ThAdvertiser;
import com.ruoyi.today.domain.ThCreativity;
import com.ruoyi.today.domain.request.AdCreativitySelectRequest;
import com.ruoyi.today.domain.request.AdGroupCreateRequest;
import com.ruoyi.today.domain.request.AdGroupSelectRequest;
import com.ruoyi.today.domain.response.AdGroupCreateResponse;
import com.ruoyi.today.domain.response.AdGroupSelectResponse;
import com.ruoyi.today.domain.response.ResponseVO;
import com.ruoyi.today.service.AdCenterService;
import com.ruoyi.today.service.IThAdService;
import com.ruoyi.today.service.IThCreativityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.today.mapper.ThCampaignMapper;
import com.ruoyi.today.domain.ThCampaign;
import com.ruoyi.today.service.IThCampaignService;
import com.ruoyi.common.core.text.Convert;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 广告组Service业务层处理
 *
 * @author ruoyi
 * @date 2019-08-14
 */
@Service
public class ThCampaignServiceImpl implements IThCampaignService {

    private static Logger logger = LoggerFactory.getLogger(ThCampaignServiceImpl.class);

    @Autowired
    private ThCampaignMapper thCampaignMapper;

    @Autowired
    private AdCenterService touTiaoAdCenterService;

    @Autowired
    private IThAdService thAdService;

    @Autowired
    private IThCreativityService creativityService;

    /**
     * 查询广告组
     *
     * @param campaignId 广告组ID
     * @return 广告组
     */
    @Override
    public ThCampaign selectThCampaignById(Long campaignId) {
        return thCampaignMapper.selectThCampaignById(campaignId);
    }

    /**
     * 查询广告组列表
     *
     * @param thCampaign 广告组
     * @return 广告组
     */
    @Override
    public List<ThCampaign> selectThCampaignList(ThCampaign thCampaign) {
        return thCampaignMapper.selectThCampaignList(thCampaign);
    }

    /**
     * 新增广告组
     *
     * @param thCampaign 广告组
     * @return 结果
     */
    @Override
    public int insertThCampaign(ThCampaign thCampaign) {
        thCampaign.setCreateTime(DateUtils.getNowDate());
        return thCampaignMapper.insertThCampaign(thCampaign);
    }

    /**
     * 修改广告组
     *
     * @param thCampaign 广告组
     * @return 结果
     */
    @Override
    public int updateThCampaign(ThCampaign thCampaign) {
        thCampaign.setUpdateTime(DateUtils.getNowDate());
        return thCampaignMapper.updateThCampaign(thCampaign);
    }

    /**
     * 删除广告组对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteThCampaignByIds(String ids) {
        return thCampaignMapper.deleteThCampaignByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除广告组信息
     *
     * @param campaignId 广告组ID
     * @return 结果
     */
    public int deleteThCampaignById(Long campaignId) {
        return thCampaignMapper.deleteThCampaignById(campaignId);
    }

    /**
     * 从头条查询广告组信息
     *
     * @param thCampaign 广告组VO
     * @return 结果
     */
    public List<ThCampaign> selectThCampaignFromTouTiao(ThCampaign thCampaign) throws Exception {

        AdGroupSelectRequest request = new AdGroupSelectRequest();
        request.setAdvertiser_id(thCampaign.getAdvertiserId().toString());
        request.setCampaign_name(thCampaign.getCampaignName());
        if (thCampaign.getCampaignId() != null) {
            request.setIds(new String[]{thCampaign.getCampaignId().toString()});
        }
        request.setLanding_type(thCampaign.getLandingType());
        request.setPage("1");
        request.setPage_size("1000");
        AdGroupSelectResponse response = (AdGroupSelectResponse) touTiaoAdCenterService.selectGroup(request);
        if (response.getCode().equals("0")) {
            JSONObject data = response.getData();
            JSONArray listObject = (JSONArray) data.get("list");
            List<ThCampaign> thCampaigns = listObject.toJavaList(ThCampaign.class);
            return thCampaigns;
        } else {
            throw new Exception("查询广告计划出现错误：" + response.getCode() + "," + response.getMessage());
        }

    }

    /**
     * 新增广告组
     *
     * @param thCampaign 广告组
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public int createThCampaign(ThCampaign thCampaign) throws Exception {
        int row = 0;
        //发送头条创建广告组
        AdGroupCreateRequest request = new AdGroupCreateRequest();
        request.setAdvertiser_id(thCampaign.getAdvertiserId().toString());
        request.setLanding_type(thCampaign.getLandingType());
        request.setCampaign_name(thCampaign.getCampaignName());
        if (thCampaign.getBudget() != null) {
            request.setBudget(thCampaign.getBudget().toString());
        }
        request.setBudget_mode(thCampaign.getBudgetMode());
        request.setOperation(thCampaign.getOperation());
        AdGroupCreateResponse response = (AdGroupCreateResponse) touTiaoAdCenterService.createGroup(request);
        if (response.getCode().equals("0")) {
            //插入数据库
            Long id = (Long) response.getData().get("campaign_id");
            thCampaign.setCreateTime(DateUtils.getNowDate());
            thCampaign.setCampaignId(id);
            row = thCampaignMapper.insertThCampaign(thCampaign);
        } else {
            throw new Exception("广告组名称：" + thCampaign.getCampaignName() + "，发送头条创建失败：" + response.getMessage());
        }

        return row;
    }

    /**
     * 同步广告组
     *
     * @param advertiser
     */
    public void syncCampaign(ThAdvertiser advertiser) throws Exception {
        ThCampaign thCampaign = new ThCampaign();
        thCampaign.setAdvertiserId(advertiser.getId());
        List<ThCampaign> thCampaigns = selectThCampaignFromTouTiao(thCampaign);
        ThCampaign selectCampaign = null;
        thCampaignMapper.deleteThCampaignByAdvertiserId(advertiser.getId());
        for (ThCampaign campaign : thCampaigns) {
            try {
//                selectCampaign = thCampaignMapper.selectThCampaignById(campaign.getCampaignId());
//                if (selectCampaign == null) {
                    thCampaignMapper.insertThCampaign(campaign);
//                } else {
//                    thCampaignMapper.updateThCampaign(selectCampaign);
//                }
            } catch (Exception e) {
                logger.error("同步广告主" + advertiser.getName() + "的广告组" + campaign.getCampaignName() + "失败", e);
            }
        }
    }

    /**
     * 复制广告组和计划和创意
     *
     * @param copyCampaign
     * @param copyThAds
     */
    @Override
    public void copy(ThCampaign copyCampaign, List<ThAd> copyThAds) throws Exception {

        AdCreativitySelectRequest request = null;
        if (copyCampaign != null) {
            //复制广告计划
            createThCampaign(copyCampaign);
        }
        if (copyThAds != null && copyThAds.size() != 0) {
            for (ThAd thAd : copyThAds) {
                request = new AdCreativitySelectRequest();
                request.setAd_id(thAd.getAdId().toString());
                request.setAdvertiser_id(thAd.getAdvertiserId().toString());
                thAd.setId(null);
                if(copyCampaign!=null){
                    thAd.setCampaignId(copyCampaign.getCampaignId());
                }
                thAd.setOperation("disable");
                thAdService.createPlan(thAd);
                //查询创意详情
                ResponseVO responseVO = (ResponseVO) touTiaoAdCenterService.selectCreativity(request);
                if(responseVO.getCode().equals("0")){
                    ThCreativity thCreativity = JSONObject.parseObject(responseVO.getData().toJSONString(), ThCreativity.class);
                    if(thCreativity.getCreativeMaterialMode()!=null&&thCreativity.getCreativeMaterialMode().equals("STATIC_ASSEMBLE")){
                        thCreativity.setCreatives(null);
                    }else {
                        thCreativity.setImage_list(null);
                        thCreativity.setTitle_list(null);
                    }
                    //复制创意
                    thCreativity.setThAdId(thAd.getId().toString());
                    creativityService.createCreativity(thCreativity);
                }
            }
        }

    }


}
