package com.ruoyi.today.mapper;

import com.ruoyi.today.domain.ThAd;
import com.ruoyi.today.domain.response.PlanSyncThAdVO;

import java.util.List;

/**
 * 广告计划Mapper接口
 * 
 * @author ruoyi
 * @date 2019-08-15
 */
public interface ThAdMapper 
{
    /**
     * 查询广告计划
     * 
     * @param id 广告计划ID
     * @return 广告计划
     */
    public ThAd selectThAdById(Long id);

    /**
     * 查询广告计划列表
     * 
     * @param thAd 广告计划
     * @return 广告计划集合
     */
    public List<ThAd> selectThAdList(ThAd thAd);

    /**
     * 新增广告计划
     * 
     * @param thAd 广告计划
     * @return 结果
     */
    public int insertThAd(ThAd thAd);

    /**
     * 修改广告计划
     * 
     * @param thAd 广告计划
     * @return 结果
     */
    public int updateThAd(ThAd thAd);

    /**
     * 删除广告计划
     * 
     * @param id 广告计划ID
     * @return 结果
     */
    public int deleteThAdById(Long id);

    /**
     * 批量删除广告计划
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteThAdByIds(String[] ids);

    /**
     * 根据广告计划头条的id查询
     * @param adVO
     * @return
     */
    public ThAd selectThAdByAdId(ThAd adVO);
    //查询已经同步到头条的广告计划
    public List<ThAd> selectSyncThAdList(ThAd thAd);

    public List<ThAd> selectThAdListByAdvertiesIds(List<String> advertiserIds);

    void deleteThAdByAdvertiserId(Long id);
}
