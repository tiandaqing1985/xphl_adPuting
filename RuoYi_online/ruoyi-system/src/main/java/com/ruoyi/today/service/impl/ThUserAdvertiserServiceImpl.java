package com.ruoyi.today.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.today.mapper.ThUserAdvertiserMapper;
import com.ruoyi.today.domain.ThUserAdvertiser;
import com.ruoyi.today.service.IThUserAdvertiserService;
import com.ruoyi.common.core.text.Convert;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-11-07
 */
@Service
public class ThUserAdvertiserServiceImpl implements IThUserAdvertiserService 
{
    @Autowired
    private ThUserAdvertiserMapper thUserAdvertiserMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public ThUserAdvertiser selectThUserAdvertiserById(Long id)
    {
        return thUserAdvertiserMapper.selectThUserAdvertiserById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param thUserAdvertiser 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<ThUserAdvertiser> selectThUserAdvertiserList(ThUserAdvertiser thUserAdvertiser)
    {
        return thUserAdvertiserMapper.selectThUserAdvertiserList(thUserAdvertiser);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param thUserAdvertiser 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertThUserAdvertiser(ThUserAdvertiser thUserAdvertiser)
    {
        return thUserAdvertiserMapper.insertThUserAdvertiser(thUserAdvertiser);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param thUserAdvertiser 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateThUserAdvertiser(ThUserAdvertiser thUserAdvertiser)
    {
        return thUserAdvertiserMapper.updateThUserAdvertiser(thUserAdvertiser);
    }

    /**
     * 删除【请填写功能名称】对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteThUserAdvertiserByIds(String ids)
    {
        return thUserAdvertiserMapper.deleteThUserAdvertiserByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteThUserAdvertiserById(Long id)
    {
        return thUserAdvertiserMapper.deleteThUserAdvertiserById(id);
    }
}
