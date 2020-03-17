package com.ruoyi.today.service;

import com.ruoyi.today.domain.ThCreativityCreatives;

import java.util.List;

/**
 * 创意Service接口
 * 
 * @author ruoyi
 * @date 2019-09-09
 */
public interface IThCreativityCreativesService 
{
    /**
     * 查询创意
     * 
     * @param id 创意ID
     * @return 创意
     */
    public ThCreativityCreatives selectThCreativityCreativesById(Long id);

    /**
     * 查询创意列表
     * 
     * @param thCreativityCreatives 创意
     * @return 创意集合
     */
    public List<ThCreativityCreatives> selectThCreativityCreativesList(ThCreativityCreatives thCreativityCreatives);

    /**
     * 新增创意
     * 
     * @param thCreativityCreatives 创意
     * @return 结果
     */
    public int insertThCreativityCreatives(ThCreativityCreatives thCreativityCreatives);

    /**
     * 修改创意
     * 
     * @param thCreativityCreatives 创意
     * @return 结果
     */
    public int updateThCreativityCreatives(ThCreativityCreatives thCreativityCreatives);

    /**
     * 批量删除创意
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteThCreativityCreativesByIds(String ids);

    /**
     * 删除创意信息
     * 
     * @param id 创意ID
     * @return 结果
     */
    public int deleteThCreativityCreativesById(Long id);

    void syncCreativities(ThCreativityCreatives creatives);
}
