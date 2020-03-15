package com.ruoyi.today.service.impl;

import java.util.List;

import com.ruoyi.today.domain.ThVideoMatter;
import com.ruoyi.today.mapper.ThVideoMatterMapper;
import com.ruoyi.today.service.IThVideoMatterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.text.Convert;

/**
 * 订单交付素材关联Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-03-09
 */
@Service
public class ThVideoMatterServiceImpl implements IThVideoMatterService
{
    @Autowired
    private ThVideoMatterMapper thVideoMatterMapper;

    /**
     * 查询订单交付素材关联
     * 
     * @param id 订单交付素材关联ID
     * @return 订单交付素材关联
     */
    @Override
    public ThVideoMatter selectThVideoMatterById(Long id)
    {
        return thVideoMatterMapper.selectThVideoMatterById(id);
    }

    /**
     * 查询订单交付素材关联列表
     * 
     * @param thVideoMatter 订单交付素材关联
     * @return 订单交付素材关联
     */
    @Override
    public List<ThVideoMatter> selectThVideoMatterList(ThVideoMatter thVideoMatter)
    {
        return thVideoMatterMapper.selectThVideoMatterList(thVideoMatter);
    }

    /**
     * 新增订单交付素材关联
     * 
     * @param thVideoMatter 订单交付素材关联
     * @return 结果
     */
    @Override
    public int insertThVideoMatter(ThVideoMatter thVideoMatter)
    {
        return thVideoMatterMapper.insertThVideoMatter(thVideoMatter);
    }

    /**
     * 修改订单交付素材关联
     * 
     * @param thVideoMatter 订单交付素材关联
     * @return 结果
     */
    @Override
    public int updateThVideoMatter(ThVideoMatter thVideoMatter)
    {
        return thVideoMatterMapper.updateThVideoMatter(thVideoMatter);
    }

    /**
     * 删除订单交付素材关联对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteThVideoMatterByIds(String ids)
    {
        return thVideoMatterMapper.deleteThVideoMatterByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除订单交付素材关联信息
     * 
     * @param id 订单交付素材关联ID
     * @return 结果
     */
    public int deleteThVideoMatterById(Long id)
    {
        return thVideoMatterMapper.deleteThVideoMatterById(id);
    }

    @Override
    public int updateNoSignInThVideoMatterByOrderId(ThVideoMatter thVideoMatter) {
        return thVideoMatterMapper.updateNoSignInThVideoMatterByOrderId(thVideoMatter);
    }

    @Override
    public void deleteThVideoMatterByOrderId(Long id) {
        thVideoMatterMapper.deleteThVideoMatterByOrderId(id);
    }

    @Override
    public void deleteThVideoMatter(ThVideoMatter thVideoMatter) {
        thVideoMatterMapper.deleteThVideoMatter(thVideoMatter);
    }
}
