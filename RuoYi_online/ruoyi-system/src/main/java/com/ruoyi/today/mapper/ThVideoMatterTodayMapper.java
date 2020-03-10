package com.ruoyi.today.mapper;

import com.ruoyi.today.domain.ThVideoMatterToday;

import java.util.List;

/**
 * 素材在每个广告主的素材idMapper接口
 * 
 * @author ruoyi
 * @date 2020-03-10
 */
public interface ThVideoMatterTodayMapper 
{
    /**
     * 查询素材在每个广告主的素材id
     * 
     * @param id 素材在每个广告主的素材idID
     * @return 素材在每个广告主的素材id
     */
    public ThVideoMatterToday selectThVideoMatterTodayById(Long id);

    /**
     * 查询素材在每个广告主的素材id列表
     * 
     * @param thVideoMatterToday 素材在每个广告主的素材id
     * @return 素材在每个广告主的素材id集合
     */
    public List<ThVideoMatterToday> selectThVideoMatterTodayList(ThVideoMatterToday thVideoMatterToday);

    /**
     * 新增素材在每个广告主的素材id
     * 
     * @param thVideoMatterToday 素材在每个广告主的素材id
     * @return 结果
     */
    public int insertThVideoMatterToday(ThVideoMatterToday thVideoMatterToday);

    /**
     * 修改素材在每个广告主的素材id
     * 
     * @param thVideoMatterToday 素材在每个广告主的素材id
     * @return 结果
     */
    public int updateThVideoMatterToday(ThVideoMatterToday thVideoMatterToday);

    /**
     * 删除素材在每个广告主的素材id
     * 
     * @param id 素材在每个广告主的素材idID
     * @return 结果
     */
    public int deleteThVideoMatterTodayById(Long id);

    /**
     * 批量删除素材在每个广告主的素材id
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteThVideoMatterTodayByIds(String[] ids);
}
