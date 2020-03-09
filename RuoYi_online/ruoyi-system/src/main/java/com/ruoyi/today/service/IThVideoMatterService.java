package com.ruoyi.today.service;

import com.ruoyi.today.domain.ThVideoMatter;

import java.util.List;

/**
 * 订单交付素材关联Service接口
 * 
 * @author ruoyi
 * @date 2020-03-09
 */
public interface IThVideoMatterService 
{
    /**
     * 查询订单交付素材关联
     * 
     * @param id 订单交付素材关联ID
     * @return 订单交付素材关联
     */
    public ThVideoMatter selectThVideoMatterById(Long id);

    /**
     * 查询订单交付素材关联列表
     * 
     * @param thVideoMatter 订单交付素材关联
     * @return 订单交付素材关联集合
     */
    public List<ThVideoMatter> selectThVideoMatterList(ThVideoMatter thVideoMatter);

    /**
     * 新增订单交付素材关联
     * 
     * @param thVideoMatter 订单交付素材关联
     * @return 结果
     */
    public int insertThVideoMatter(ThVideoMatter thVideoMatter);

    /**
     * 修改订单交付素材关联
     * 
     * @param thVideoMatter 订单交付素材关联
     * @return 结果
     */
    public int updateThVideoMatter(ThVideoMatter thVideoMatter);

    /**
     * 批量删除订单交付素材关联
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteThVideoMatterByIds(String ids);

    /**
     * 删除订单交付素材关联信息
     * 
     * @param id 订单交付素材关联ID
     * @return 结果
     */
    public int deleteThVideoMatterById(Long id);
}
