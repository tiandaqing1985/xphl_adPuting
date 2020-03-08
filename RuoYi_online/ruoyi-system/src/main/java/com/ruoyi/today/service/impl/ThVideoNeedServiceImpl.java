package com.ruoyi.today.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.today.domain.ThVideoNeed;
import com.ruoyi.today.mapper.ThVideoNeedMapper;
import com.ruoyi.today.service.IThVideoNeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.text.Convert;

/**
 * 视频需求Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-03-02
 */
@Service
public class ThVideoNeedServiceImpl implements IThVideoNeedService
{
    @Autowired
    private ThVideoNeedMapper thVideoNeedMapper;

    /**
     * 查询视频需求
     * 
     * @param id 视频需求ID
     * @return 视频需求
     */
    @Override
    public ThVideoNeed selectThVideoNeedById(Long id)
    {
        return thVideoNeedMapper.selectThVideoNeedById(id);
    }

    /**
     * 查询视频需求列表
     * 
     * @param thVideoNeed 视频需求
     * @return 视频需求
     */
    @Override
    public List<ThVideoNeed> selectThVideoNeedList(ThVideoNeed thVideoNeed)
    {
        return thVideoNeedMapper.selectThVideoNeedList(thVideoNeed);
    }

    /**
     * 新增视频需求
     * 
     * @param thVideoNeed 视频需求
     * @return 结果
     */
    @Override
    public int insertThVideoNeed(ThVideoNeed thVideoNeed)
    {
        thVideoNeed.setCreateTime(DateUtils.getNowDate());
        return thVideoNeedMapper.insertThVideoNeed(thVideoNeed);
    }

    /**
     * 修改视频需求
     * 
     * @param thVideoNeed 视频需求
     * @return 结果
     */
    @Override
    public int updateThVideoNeed(ThVideoNeed thVideoNeed)
    {
        thVideoNeed.setUpdateTime(DateUtils.getNowDate());
        return thVideoNeedMapper.updateThVideoNeed(thVideoNeed);
    }

    /**
     * 删除视频需求对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteThVideoNeedByIds(String ids)
    {
        return thVideoNeedMapper.deleteThVideoNeedByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除视频需求信息
     * 
     * @param id 视频需求ID
     * @return 结果
     */
    public int deleteThVideoNeedById(Long id)
    {
        return thVideoNeedMapper.deleteThVideoNeedById(id);
    }

    @Override
    public int deleteThVideoNeedByOrderId(Long id) {
        return thVideoNeedMapper.deleteThVideoNeedByOrderId(id);
    }
}

