package com.ruoyi.today.service;

import com.ruoyi.today.domain.ThAdShow;

import java.util.List;

/**
 * 广告计划显示字段方案Service接口
 * 
 * @author ruoyi
 * @date 2019-09-04
 */
public interface IThAdShowService 
{
    /**
     * 查询广告计划显示字段方案
     * 
     * @param id 广告计划显示字段方案ID
     * @return 广告计划显示字段方案
     */
    public ThAdShow selectThAdShowById(Long id);

    /**
     * 查询广告计划显示字段方案列表
     * 
     * @param thAdShow 广告计划显示字段方案
     * @return 广告计划显示字段方案集合
     */
    public List<ThAdShow> selectThAdShowList(ThAdShow thAdShow);

    /**
     * 新增广告计划显示字段方案
     * 
     * @param thAdShow 广告计划显示字段方案
     * @return 结果
     */
    public int insertThAdShow(ThAdShow thAdShow);

    /**
     * 修改广告计划显示字段方案
     * 
     * @param thAdShow 广告计划显示字段方案
     * @return 结果
     */
    public int updateThAdShow(ThAdShow thAdShow);

    /**
     * 批量删除广告计划显示字段方案
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteThAdShowByIds(String ids);

    /**
     * 删除广告计划显示字段方案信息
     * 
     * @param id 广告计划显示字段方案ID
     * @return 结果
     */
    public int deleteThAdShowById(Long id);

    /**
     * 根据创建人查询出满足记录的记录条数
     */
    public String selectCountByCreateBy(String createBy);
}
