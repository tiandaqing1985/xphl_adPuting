package com.ruoyi.today.service;

import com.ruoyi.today.domain.ThTodayMatter;

import java.util.List;

/**
 * 头条广告主对应素材的idService接口
 * 
 * @author ruoyi
 * @date 2020-04-02
 */
public interface IThTodayMatterService 
{
    /**
     * 查询头条广告主对应素材的id
     * 
     * @param id 头条广告主对应素材的idID
     * @return 头条广告主对应素材的id
     */
    public ThTodayMatter selectThTodayMatterById(Long id);

    /**
     * 查询头条广告主对应素材的id列表
     * 
     * @param thTodayMatter 头条广告主对应素材的id
     * @return 头条广告主对应素材的id集合
     */
    public List<ThTodayMatter> selectThTodayMatterList(ThTodayMatter thTodayMatter);

    /**
     * 新增头条广告主对应素材的id
     * 
     * @param thTodayMatter 头条广告主对应素材的id
     * @return 结果
     */
    public int insertThTodayMatter(ThTodayMatter thTodayMatter);

    /**
     * 修改头条广告主对应素材的id
     * 
     * @param thTodayMatter 头条广告主对应素材的id
     * @return 结果
     */
    public int updateThTodayMatter(ThTodayMatter thTodayMatter);

    /**
     * 批量删除头条广告主对应素材的id
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteThTodayMatterByIds(String ids);

    /**
     * 删除头条广告主对应素材的id信息
     * 
     * @param id 头条广告主对应素材的idID
     * @return 结果
     */
    public int deleteThTodayMatterById(Long id);

    void deleteAllThTodayMatter();

    List<ThTodayMatter> selectThTodayMatterByType(String s);

    int insertThTodayMatterList(List<ThTodayMatter> thTodayMatters);
}
