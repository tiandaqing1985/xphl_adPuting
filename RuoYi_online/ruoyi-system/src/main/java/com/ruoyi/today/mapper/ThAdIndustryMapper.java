package com.ruoyi.today.mapper;

import com.ruoyi.today.domain.ThAdIndustry;

import java.util.List;

/**
 * 行业列Mapper接口
 * 
 * @author ruoyi
 * @date 2019-09-11
 */
public interface ThAdIndustryMapper 
{
    /**
     * 查询行业列
     * 
     * @param id 行业列ID
     * @return 行业列
     */
    public ThAdIndustry selectThAdIndustryById(Long id);

    /**
     * 查询行业列列表
     * 
     * @param thAdIndustry 行业列
     * @return 行业列集合
     */
    public List<ThAdIndustry> selectThAdIndustryList(ThAdIndustry thAdIndustry);

    /**
     * 新增行业列
     * 
     * @param thAdIndustry 行业列
     * @return 结果
     */
    public int insertThAdIndustry(ThAdIndustry thAdIndustry);

    /**
     * 修改行业列
     * 
     * @param thAdIndustry 行业列
     * @return 结果
     */
    public int updateThAdIndustry(ThAdIndustry thAdIndustry);

    /**
     * 删除行业列
     * 
     * @param id 行业列ID
     * @return 结果
     */
    public int deleteThAdIndustryById(Long id);

    /**
     * 批量删除行业列
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteThAdIndustryByIds(String[] ids);
}
