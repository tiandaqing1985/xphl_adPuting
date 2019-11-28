package com.ruoyi.yiche.service;

import com.ruoyi.yiche.domain.Yiche;

import java.util.List;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2019-11-21
 */
public interface IYicheService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public Yiche selectYicheById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param yiche 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Yiche> selectYicheList(Yiche yiche);

    /**
     * 新增【请填写功能名称】
     * 
     * @param yiche 【请填写功能名称】
     * @return 结果
     */
    public int insertYiche(Yiche yiche);

    /**
     * 修改【请填写功能名称】
     * 
     * @param yiche 【请填写功能名称】
     * @return 结果
     */
    public int updateYiche(Yiche yiche);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteYicheByIds(String ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteYicheById(Long id);
}
