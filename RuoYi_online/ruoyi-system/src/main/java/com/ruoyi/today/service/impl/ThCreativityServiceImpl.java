package com.ruoyi.today.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.today.domain.ThCreativity;
import com.ruoyi.today.domain.ThCreativityCreatives;
import com.ruoyi.today.domain.ThCreativityImage;
import com.ruoyi.today.domain.ThCreativityTitle;
import com.ruoyi.today.mapper.ThCreativityCreativesMapper;
import com.ruoyi.today.mapper.ThCreativityImageMapper;
import com.ruoyi.today.mapper.ThCreativityMapper;
import com.ruoyi.today.mapper.ThCreativityTitleMapper;
import com.ruoyi.today.service.IThCreativityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public int insertThCreativity(ThCreativity thCreativity) {
        thCreativity.setCreateTime(DateUtils.getNowDate());
        int i = thCreativityMapper.insertThCreativity(thCreativity);
        if (thCreativity.getImage_list() != null) {
            for (ThCreativityImage image : thCreativity.getImage_list()) {
                image.setCreativityId(thCreativity.getId());
                thCreativityImageMapper.insertThCreativityImage(image);
            }
        }
        if (thCreativity.getTitle_list() != null) {
            for (ThCreativityTitle title : thCreativity.getTitle_list()) {
                title.setCreativityId(thCreativity.getId());
                thCreativityTitleMapper.insertThCreativityTitle(title);
            }
        }
        if (thCreativity.getCreatives() != null) {
            for (ThCreativityCreatives creatives : thCreativity.getCreatives()) {
                creatives.setCreativeId(thCreativity.getId().toString());
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
    public int deleteThCreativityByIds(String ids) {
        return thCreativityMapper.deleteThCreativityByIds(Convert.toStrArray(ids));
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
}
