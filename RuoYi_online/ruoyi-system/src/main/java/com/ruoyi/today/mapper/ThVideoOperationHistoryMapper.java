package com.ruoyi.today.mapper;

import com.ruoyi.today.domain.ThVideoOperationHistory;

import java.util.List;

/**
 * 操作历史Mapper接口
 * 
 * @author ruoyi
 * @date 2020-03-05
 */
public interface ThVideoOperationHistoryMapper 
{
    /**
     * 查询操作历史
     * 
     * @param id 操作历史ID
     * @return 操作历史
     */
    public ThVideoOperationHistory selectThVideoOperationHistoryById(Long id);

    /**
     * 查询操作历史列表
     * 
     * @param thVideoOperationHistory 操作历史
     * @return 操作历史集合
     */
    public List<ThVideoOperationHistory> selectThVideoOperationHistoryList(ThVideoOperationHistory thVideoOperationHistory);

    /**
     * 新增操作历史
     * 
     * @param thVideoOperationHistory 操作历史
     * @return 结果
     */
    public int insertThVideoOperationHistory(ThVideoOperationHistory thVideoOperationHistory);

    /**
     * 修改操作历史
     * 
     * @param thVideoOperationHistory 操作历史
     * @return 结果
     */
    public int updateThVideoOperationHistory(ThVideoOperationHistory thVideoOperationHistory);

    /**
     * 删除操作历史
     * 
     * @param id 操作历史ID
     * @return 结果
     */
    public int deleteThVideoOperationHistoryById(Long id);

    /**
     * 批量删除操作历史
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteThVideoOperationHistoryByIds(String[] ids);
}
