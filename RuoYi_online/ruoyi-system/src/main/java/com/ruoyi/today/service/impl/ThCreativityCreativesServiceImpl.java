package com.ruoyi.today.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.today.domain.ThCreativity;
import com.ruoyi.today.domain.ThCreativityCreatives;
import com.ruoyi.today.domain.ThCreativityImage;
import com.ruoyi.today.domain.ThCreativityTitle;
import com.ruoyi.today.domain.request.AdCreativitySelectRequest;
import com.ruoyi.today.domain.response.ResponseVO;
import com.ruoyi.today.mapper.ThCreativityCreativesMapper;
import com.ruoyi.today.service.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 创意Service业务层处理
 *
 * @author ruoyi
 * @date 2019-09-09
 */
@Service
public class ThCreativityCreativesServiceImpl implements IThCreativityCreativesService {
    @Autowired
    private ThCreativityCreativesMapper thCreativityCreativesMapper;
    @Autowired
    private IThCreativityService thCreativityService;
    @Autowired
    private AdCenterService touTiaoAdCenterService;
    @Autowired
    private IThCreativityTitleService thCreativityTitleService;
    @Autowired
    private IThCreativityImageService thCreativityImageService;

    /**
     * 查询创意
     *
     * @param id 创意ID
     * @return 创意
     */
    @Override
    public ThCreativityCreatives selectThCreativityCreativesById(Long id) {
        return thCreativityCreativesMapper.selectThCreativityCreativesById(id);
    }

    /**
     * 查询创意列表
     *
     * @param thCreativityCreatives 创意
     * @return 创意
     */
    @Override
    public List<ThCreativityCreatives> selectThCreativityCreativesList(ThCreativityCreatives thCreativityCreatives) {

//        List<ThCreativityCreatives> thCreativityCreativeList = thCreativityCreativesMapper.selectThCreativityCreativesList(thCreativityCreatives);
//
//        for (ThCreativityCreatives creatives : thCreativityCreativeList) {
//            if (creatives.getCreativeWordIds() != null) {
//                creatives.setCreative_word_ids(Convert.toStrArray(creatives.getCreativeWordIds()));
//            }
//            if (creatives.getImageIds() != null) {
//                creatives.setImage_ids(Convert.toStrArray(creatives.getImageIds()));
//            }
//        }

        return thCreativityCreativesMapper.selectThCreativityCreativesList(thCreativityCreatives);
    }

    /**
     * 新增创意
     *
     * @param thCreativityCreatives 创意
     * @return 结果
     */
    @Override
    public int insertThCreativityCreatives(ThCreativityCreatives thCreativityCreatives) {
        thCreativityCreatives.setCreateTime(DateUtils.getNowDate());
        return thCreativityCreativesMapper.insertThCreativityCreatives(thCreativityCreatives);
    }

    /**
     * 修改创意
     *
     * @param thCreativityCreatives 创意
     * @return 结果
     */
    @Override
    public int updateThCreativityCreatives(ThCreativityCreatives thCreativityCreatives) {
        thCreativityCreatives.setUpdateTime(DateUtils.getNowDate());
        return thCreativityCreativesMapper.updateThCreativityCreatives(thCreativityCreatives);
    }

    /**
     * 删除创意对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteThCreativityCreativesByIds(String ids) {
        return thCreativityCreativesMapper.deleteThCreativityCreativesByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除创意信息
     *
     * @param id 创意ID
     * @return 结果
     */
    public int deleteThCreativityCreativesById(Long id) {
        return thCreativityCreativesMapper.deleteThCreativityCreativesById(id);
    }

    //同步广告创意
    @Override
    public void syncCreativities(ThCreativityCreatives creatives) {
        try {

            //根据广告主id和计划id查询广告创意详情
            AdCreativitySelectRequest request = new AdCreativitySelectRequest();
            request.setAdvertiser_id(creatives.getAdvertiserId());
            request.setAd_id(creatives.getAdId());
            //查询创意详情
            ResponseVO responseVO = (ResponseVO) touTiaoAdCenterService.selectCreativity(request);
            if (responseVO.getCode().equals("0")) {

                ThCreativity thCreativity = JSONObject.parseObject(responseVO.getData().toJSONString(), ThCreativity.class);
                thCreativity.setInventoryType(StringUtils.join(thCreativity.getInventory_type(), ","));
                thCreativity.setAdKeywords(StringUtils.join(thCreativity.getAd_keywords(), ","));
                thCreativityService.insertThCreativity(thCreativity);

            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
