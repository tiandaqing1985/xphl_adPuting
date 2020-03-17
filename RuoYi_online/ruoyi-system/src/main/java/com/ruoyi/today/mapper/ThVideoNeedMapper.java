package com.ruoyi.today.mapper;

import com.ruoyi.today.domain.ThVideoNeed;

import java.util.List;

/**
 * 视频需求Mapper接口
 * 
 * @author ruoyi
 * @date 2020-03-02
 */
public interface ThVideoNeedMapper 
{
    /**
     * 查询视频需求
     * 
     * @param id 视频需求ID
     * @return 视频需求
     */
    public ThVideoNeed selectThVideoNeedById(Long id);

    /**
     * 查询视频需求列表
     * 
     * @param thVideoNeed 视频需求
     * @return 视频需求集合
     */
    public List<ThVideoNeed> selectThVideoNeedList(ThVideoNeed thVideoNeed);

    /**
     * 新增视频需求
     * 
     * @param thVideoNeed 视频需求
     * @return 结果
     */
    public int insertThVideoNeed(ThVideoNeed thVideoNeed);

    /**
     * 修改视频需求
     * 
     * @param thVideoNeed 视频需求
     * @return 结果
     */
    public int updateThVideoNeed(ThVideoNeed thVideoNeed);

    /**
     * 删除视频需求
     * 
     * @param id 视频需求ID
     * @return 结果
     */
    public int deleteThVideoNeedById(Long id);

    /**
     * 批量删除视频需求
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteThVideoNeedByIds(String[] ids);

    int deleteThVideoNeedByOrderId(Long id);
}
