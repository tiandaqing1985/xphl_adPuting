package com.ruoyi.yiche.service.impl;

import java.util.List;

import com.ruoyi.yiche.domain.Yiche;
import com.ruoyi.yiche.mapper.YicheMapper;
import com.ruoyi.yiche.service.IYicheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.text.Convert;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-11-21
 */
@Service
public class YicheServiceImpl implements IYicheService
{
    @Autowired
    private YicheMapper yicheMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public Yiche selectYicheById(Long id)
    {
        return yicheMapper.selectYicheById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param yiche 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<Yiche> selectYicheList(Yiche yiche)
    {
        return yicheMapper.selectYicheList(yiche);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param yiche 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertYiche(Yiche yiche)
    {
        return yicheMapper.insertYiche(yiche);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param yiche 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateYiche(Yiche yiche)
    {
        return yicheMapper.updateYiche(yiche);
    }

    /**
     * 删除【请填写功能名称】对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteYicheByIds(String ids)
    {
        return yicheMapper.deleteYicheByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteYicheById(Long id)
    {
        return yicheMapper.deleteYicheById(id);
    }
}
