package com.ruoyi.today.service;

import com.ruoyi.today.domain.ThCreativity;

import java.util.List;

/**
 * 创意公共属性Service接口
 * 
 * @author ruoyi
 * @date 2019-09-09
 */
public interface IThCreativityService 
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
     * 批量删除创意公共属性
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteThCreativityByIds(String ids);

    /**
     * 删除创意公共属性信息
     * 
     * @param id 创意公共属性ID
     * @return 结果
     */
    public int deleteThCreativityById(Long id);

    //创建广告创意 id是广告计划的主键id
    public void createCreativity(String id) throws Exception;

    ThCreativity selectThCreativityByThAdId(String id);

    //创建广告创意 id是广告创意公共字段表的主键
    public int startCreativityById(String id) throws Exception;

    void updateThCreativityByThAdId(ThCreativity creativity);
}
