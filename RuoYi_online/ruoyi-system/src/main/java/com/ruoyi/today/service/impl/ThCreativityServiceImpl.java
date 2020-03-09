package com.ruoyi.today.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.today.domain.*;
import com.ruoyi.today.domain.response.ResponseVO;
import com.ruoyi.today.mapper.ThCreativityCreativesMapper;
import com.ruoyi.today.mapper.ThCreativityImageMapper;
import com.ruoyi.today.mapper.ThCreativityMapper;
import com.ruoyi.today.mapper.ThCreativityTitleMapper;
import com.ruoyi.today.service.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 创意公共属性Service业务层处理
 *
 * @author ruoyi
 * @date 2019-09-09
 */
@Service
public class ThCreativityServiceImpl implements IThCreativityService {
    @Autowired
    private ThCreativityMapper thCreativityMapper;
    @Autowired
    private ThCreativityCreativesMapper thCreativityCreativesMapper;
    @Autowired
    private ThCreativityImageMapper thCreativityImageMapper;
    @Autowired
    private ThCreativityTitleMapper thCreativityTitleMapper;
    @Autowired
    private AdCenterService adCenterService;
    @Autowired
    private IThCreativityCreativesService creativityCreativesService;
    @Autowired
    private IThCreativityImageService creativityImageService;
    @Autowired
    private IThCreativityTitleService creativityTitleService;
    @Autowired
    private IThAdService adService;

    /**
     * 查询创意公共属性
     *
     * @param id 创意公共属性ID
     * @return 创意公共属性
     */
    @Override
    public ThCreativity selectThCreativityById(Long id) {
        return thCreativityMapper.selectThCreativityById(id);
    }

    /**
     * 查询创意公共属性列表
     *
     * @param thCreativity 创意公共属性
     * @return 创意公共属性
     */
    @Override
    public List<ThCreativity> selectThCreativityList(ThCreativity thCreativity) {
        return thCreativityMapper.selectThCreativityList(thCreativity);
    }

    /**
     * 新增创意公共属性
     *
     * @param thCreativity 创意公共属性
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertThCreativity(ThCreativity thCreativity) {
        thCreativity.setCreateTime(DateUtils.getNowDate());
        int i = thCreativityMapper.insertThCreativity(thCreativity);
        if (thCreativity.getImage_list() != null) {
            for (ThCreativityImage image : thCreativity.getImage_list()) {
                image.setCreativityId(thCreativity.getId());
                image.setImageIds(StringUtils.join(image.getImage_ids(), ","));
                thCreativityImageMapper.insertThCreativityImage(image);
            }
        }
        if (thCreativity.getTitle_list() != null) {
            for (ThCreativityTitle title : thCreativity.getTitle_list()) {
                title.setCreativityId(thCreativity.getId());
                title.setCreativeWordIds(StringUtils.join(title.getCreative_word_ids(), ","));
                thCreativityTitleMapper.insertThCreativityTitle(title);
            }
        }
        if (thCreativity.getCreatives() != null) {
            for (ThCreativityCreatives creatives : thCreativity.getCreatives()) {
                creatives.setCreativeWordIds(StringUtils.join(creatives.getCreative_word_ids(), ","));
                creatives.setImageIds(StringUtils.join(creatives.getImage_ids(), ","));
                creatives.setCreativityId(thCreativity.getId());
                thCreativityCreativesMapper.insertThCreativityCreatives(creatives);
            }
        }
        return i;
    }

    /**
     * 修改创意公共属性
     *
     * @param thCreativity 创意公共属性
     * @return 结果
     */
    @Override
    public int updateThCreativity(ThCreativity thCreativity) {
        thCreativity.setUpdateTime(DateUtils.getNowDate());
        return thCreativityMapper.updateThCreativity(thCreativity);
    }

    /**
     * 删除创意公共属性对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteThCreativityByIds(String ids) {
        String[] strings = Convert.toStrArray(ids);
        for (String id : strings) {
            thCreativityMapper.deleteThCreativityById(Long.valueOf(id));
            thCreativityCreativesMapper.deleteThCreativityCreativesByCreativityId(id);
            thCreativityTitleMapper.deleteThCreativityTitleByCreativityId(id);
            thCreativityImageMapper.deleteThCreativityImageByCreativityId(id);
        }
        return strings.length;
    }

    /**
     * 删除创意公共属性信息
     *
     * @param id 创意公共属性ID
     * @return 结果
     */
    public int deleteThCreativityById(Long id) {
        return thCreativityMapper.deleteThCreativityById(id);
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createCreativity(String id) throws Exception {

        //查询创意公共部分
        ThCreativity creativity = thCreativityMapper.selectThCreativityByThAdId(id);

        createCreativity(creativity);

    }

    @Override
    public ThCreativity selectThCreativityByThAdId(String id) {
        return thCreativityMapper.selectThCreativityByThAdId(id);
    }

    @Transactional
    @Override
    public void createCreativity(ThCreativity creativity) throws Exception {
        //字符串转换为数组
        if (creativity.getInventoryType() != null) {
            creativity.setInventory_type(Convert.toStrArray(creativity.getInventoryType()));
        }
        if (creativity.getAdKeywords() != null) {
            creativity.setAd_keywords(Convert.toStrArray(creativity.getAdKeywords()));
        }

        if (creativity.getStatus() == null || "".equals(creativity.getStatus())) {
            //查询创意素材等部分
            //程序化创意
            if ("STATIC_ASSEMBLE".equals(creativity.getCreativeMaterialMode())) {
                ThCreativityTitle creativityTitle = new ThCreativityTitle();
                creativityTitle.setCreativityId(creativity.getId());
                ThCreativityImage creativityImage = new ThCreativityImage();
                creativityImage.setCreativityId(creativity.getId());
                List<ThCreativityImage> thCreativityImages = creativityImageService.selectThCreativityImageList(creativityImage);
                List<ThCreativityTitle> thCreativityTitles = creativityTitleService.selectThCreativityTitleList(creativityTitle);
                creativity.setTitle_list(thCreativityTitles);
                creativity.setImage_list(thCreativityImages);
            }
            //自定义创意
            else {
                ThCreativityCreatives creativityCreatives = new ThCreativityCreatives();
                creativityCreatives.setCreativeId(creativity.getId().toString());
                List<ThCreativityCreatives> thCreativityCreatives = creativityCreativesService.selectThCreativityCreativesList(creativityCreatives);
                creativity.setCreatives(thCreativityCreatives);
            }
            creativity.setStatus("2");
            ThAd thAd = adService.selectThAdById(Long.valueOf(creativity.getThAdId()));
            if (thAd == null || thAd.getAdId() == null) {
                throw new Exception("请先启用广告计划");
            }
            creativity.setAdId(thAd.getAdId().toString());
            thCreativityMapper.updateThCreativity(creativity);
            //发送头条创建广告创意
            ResponseVO responseVO = (ResponseVO) adCenterService.createCreativity(creativity);
            if (!"0".equals(responseVO.getCode())) {
                throw new Exception("广告创意创建失败，响应码：" + responseVO.getCode() + "，响应信息：" + responseVO.getMessage());
            }
        } else {

        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int startCreativityById(String id) throws Exception {

        //查询创意公共部分
        ThCreativity creativity = thCreativityMapper.selectThCreativityById(Long.valueOf(id));

        createCreativity(creativity);

        return 0;
    }

    @Override
    public void updateThCreativityByThAdId(ThCreativity creativity) {
        thCreativityMapper.updateThCreativityByThAdId(creativity);
    }
}
