package com.ruoyi.today.mapper;

import com.ruoyi.today.domain.ThCreativity;

import java.util.List;

/**
 * 创意公共属性Mapper接口
 * 
 * @author ruoyi
 * @date 2019-09-09
 */
public interface ThCreativityMapper 
{
    /**
     * 查询创意公共属性
     * 
     * @param id 创意公共属性ID
     * @return 创意公共属性
     */
    public ThCreativity selectThCreativityById(Long id);

    /**
     * 查询创意公共属性列表
     * 
     * @param thCreativity 创意公共属性
     * @return 创意公共属性集合
     */
    public List<ThCreativity> selectThCreativityList(ThCreativity thCreativity);

    /**
     * 新增创意公共属性
     * 
     * @param thCreativity 创意公共属性
     * @return 结果
     */
    public int insertThCreativity(ThCreativity thCreativity);

    /**
     * 修改创意公共属性
     * 
     * @param thCreativity 创意公共属性
     * @return 结果
     */
    public int updateThCreativity(ThCreativity thCreativity);

    /**
     * 删除创意公共属性
     * 
     * @param id 创意公共属性ID
     * @return 结果
     */
    public int deleteThCreativityById(Long id);

    /**
     * 批量删除创意公共属性
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteThCreativityByIds(String[] ids);

    public ThCreativity  selectThCreativityByThAdId(String id);

    public void updateThCreativityByThAdId(ThCreativity creativity);
}
