package com.ruoyi.today.service.impl;

import java.util.List;

import com.ruoyi.today.domain.ThVideoOperationHistory;
import com.ruoyi.today.mapper.ThVideoOperationHistoryMapper;
import com.ruoyi.today.service.IThVideoOperationHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.text.Convert;

/**
 * 操作历史Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-03-05
 */
@Service
public class ThVideoOperationHistoryServiceImpl implements IThVideoOperationHistoryService
{
    @Autowired
    private ThVideoOperationHistoryMapper thVideoOperationHistoryMapper;

    /**
     * 查询操作历史
     * 
     * @param id 操作历史ID
     * @return 操作历史
     */
    @Override
    public ThVideoOperationHistory selectThVideoOperationHistoryById(Long id)
    {
        return thVideoOperationHistoryMapper.selectThVideoOperationHistoryById(id);
    }

    /**
     * 查询操作历史列表
     * 
     * @param thVideoOperationHistory 操作历史
     * @return 操作历史
     */
    @Override
    public List<ThVideoOperationHistory> selectThVideoOperationHistoryList(ThVideoOperationHistory thVideoOperationHistory)
    {
        return thVideoOperationHistoryMapper.selectThVideoOperationHistoryList(thVideoOperationHistory);
    }

    /**
     * 新增操作历史
     * 
     * @param thVideoOperationHistory 操作历史
     * @return 结果
     */
    @Override
    public int insertThVideoOperationHistory(ThVideoOperationHistory thVideoOperationHistory)
    {
        return thVideoOperationHistoryMapper.insertThVideoOperationHistory(thVideoOperationHistory);
    }

    /**
     * 修改操作历史
     * 
     * @param thVideoOperationHistory 操作历史
     * @return 结果
     */
    @Override
    public int updateThVideoOperationHistory(ThVideoOperationHistory thVideoOperationHistory)
    {
        return thVideoOperationHistoryMapper.updateThVideoOperationHistory(thVideoOperationHistory);
    }

    /**
     * 删除操作历史对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteThVideoOperationHistoryByIds(String ids)
    {
        return thVideoOperationHistoryMapper.deleteThVideoOperationHistoryByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除操作历史信息
     * 
     * @param id 操作历史ID
     * @return 结果
     */
    public int deleteThVideoOperationHistoryById(Long id)
    {
        return thVideoOperationHistoryMapper.deleteThVideoOperationHistoryById(id);
    }
}
