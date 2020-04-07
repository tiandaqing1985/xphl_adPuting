package com.ruoyi.today.service.impl;

import java.util.List;

import com.ruoyi.today.domain.ThTodayMatter;
import com.ruoyi.today.mapper.ThTodayMatterMapper;
import com.ruoyi.today.service.IThTodayMatterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.text.Convert;

/**
 * 头条广告主对应素材的idService业务层处理
 * 
 * @author ruoyi
 * @date 2020-04-02
 */
@Service
public class ThTodayMatterServiceImpl implements IThTodayMatterService
{
    @Autowired
    private ThTodayMatterMapper thTodayMatterMapper;

    /**
     * 查询头条广告主对应素材的id
     * 
     * @param id 头条广告主对应素材的idID
     * @return 头条广告主对应素材的id
     */
    @Override
    public ThTodayMatter selectThTodayMatterById(Long id)
    {
        return thTodayMatterMapper.selectThTodayMatterById(id);
    }

    /**
     * 查询头条广告主对应素材的id列表
     * 
     * @param thTodayMatter 头条广告主对应素材的id
     * @return 头条广告主对应素材的id
     */
    @Override
    public List<ThTodayMatter> selectThTodayMatterList(ThTodayMatter thTodayMatter)
    {
        return thTodayMatterMapper.selectThTodayMatterList(thTodayMatter);
    }

    /**
     * 新增头条广告主对应素材的id
     * 
     * @param thTodayMatter 头条广告主对应素材的id
     * @return 结果
     */
    @Override
    public int insertThTodayMatter(ThTodayMatter thTodayMatter)
    {
        return thTodayMatterMapper.insertThTodayMatter(thTodayMatter);
    }

    /**
     * 修改头条广告主对应素材的id
     * 
     * @param thTodayMatter 头条广告主对应素材的id
     * @return 结果
     */
    @Override
    public int updateThTodayMatter(ThTodayMatter thTodayMatter)
    {
        return thTodayMatterMapper.updateThTodayMatter(thTodayMatter);
    }

    /**
     * 删除头条广告主对应素材的id对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteThTodayMatterByIds(String ids)
    {
        return thTodayMatterMapper.deleteThTodayMatterByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除头条广告主对应素材的id信息
     * 
     * @param id 头条广告主对应素材的idID
     * @return 结果
     */
    public int deleteThTodayMatterById(Long id)
    {
        return thTodayMatterMapper.deleteThTodayMatterById(id);
    }

    @Override
    public void deleteAllThTodayMatter() {
        thTodayMatterMapper.deleteAllThTodayMatter();
    }
}
