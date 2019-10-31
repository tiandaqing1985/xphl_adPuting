package com.ruoyi.today.service.impl;

import java.util.List;

import com.ruoyi.today.domain.ThAdIndustry;
import com.ruoyi.today.mapper.ThAdIndustryMapper;
import com.ruoyi.today.service.IThAdIndustryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.text.Convert;

/**
 * 行业列Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-09-11
 */
@Service
public class ThAdIndustryServiceImpl implements IThAdIndustryService
{
    @Autowired
    private ThAdIndustryMapper thAdIndustryMapper;

    /**
     * 查询行业列
     * 
     * @param id 行业列ID
     * @return 行业列
     */
    @Override
    public ThAdIndustry selectThAdIndustryById(Long id)
    {
        return thAdIndustryMapper.selectThAdIndustryById(id);
    }

    /**
     * 查询行业列列表
     * 
     * @param thAdIndustry 行业列
     * @return 行业列
     */
    @Override
    public List<ThAdIndustry> selectThAdIndustryList(ThAdIndustry thAdIndustry)
    {
        return thAdIndustryMapper.selectThAdIndustryList(thAdIndustry);
    }

    /**
     * 新增行业列
     * 
     * @param thAdIndustry 行业列
     * @return 结果
     */
    @Override
    public int insertThAdIndustry(ThAdIndustry thAdIndustry)
    {
        return thAdIndustryMapper.insertThAdIndustry(thAdIndustry);
    }

    /**
     * 修改行业列
     * 
     * @param thAdIndustry 行业列
     * @return 结果
     */
    @Override
    public int updateThAdIndustry(ThAdIndustry thAdIndustry)
    {
        return thAdIndustryMapper.updateThAdIndustry(thAdIndustry);
    }

    /**
     * 删除行业列对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteThAdIndustryByIds(String ids)
    {
        return thAdIndustryMapper.deleteThAdIndustryByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除行业列信息
     * 
     * @param id 行业列ID
     * @return 结果
     */
    public int deleteThAdIndustryById(Long id)
    {
        return thAdIndustryMapper.deleteThAdIndustryById(id);
    }

    @Override
    public ThAdIndustry selectThAdIndustryByIndustryNameAndLevel(String industryName, String s) {
        return thAdIndustryMapper.selectThAdIndustryByIndustryNameAndLevel(industryName,s);
    }
}
