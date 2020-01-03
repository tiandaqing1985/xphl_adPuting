package com.ruoyi.today.service;

import com.ruoyi.today.domain.ThUserAdvertiser;
import java.util.List;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2019-11-07
 */
public interface IThUserAdvertiserService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public ThUserAdvertiser selectThUserAdvertiserById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param thUserAdvertiser 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<ThUserAdvertiser> selectThUserAdvertiserList(ThUserAdvertiser thUserAdvertiser);

    /**
     * 新增【请填写功能名称】
     * 
     * @param thUserAdvertiser 【请填写功能名称】
     * @return 结果
     */
    public int insertThUserAdvertiser(ThUserAdvertiser thUserAdvertiser);

    /**
     * 修改【请填写功能名称】
     * 
     * @param thUserAdvertiser 【请填写功能名称】
     * @return 结果
     */
    public int updateThUserAdvertiser(ThUserAdvertiser thUserAdvertiser);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteThUserAdvertiserByIds(String ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteThUserAdvertiserById(Long id);
}
