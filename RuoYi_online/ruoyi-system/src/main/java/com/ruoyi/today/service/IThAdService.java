package com.ruoyi.today.service;

import com.ruoyi.today.domain.ThAd;
import com.ruoyi.today.domain.ThAdvertiser;

import java.util.List;

/**
 * 广告计划Service接口
 * 
 * @author ruoyi
 * @date 2019-08-15
 */
public interface IThAdService 
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
     * 批量删除广告计划
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteThAdByIds(String ids);

    /**
     * 删除广告计划信息
     * 
     * @param id 广告计划ID
     * @return 结果
     */
    public int deleteThAdById(Long id);

    /**
     * 创建广告计划
     * @param ads
     * @param b
     * @param operName
     * @return
     */
    public String importThAd(List<ThAd> ads, boolean b, String operName,String fileName);

    /**
     * 启用广告计划
     * @param ids
     */
    public int startPlanById(String ids) throws Exception;

    public int synchronizedPlan(ThAdvertiser advertiser) throws Exception;

    public int updatePlanStatus(String id, String status)  throws Exception;
    /**
     * 停用广告计划
     * @param id
     */
    public int stopPlanById(String id) throws Exception;

    /**
     * 调用广告计划修改接口 修改广告计划
     * @param id
     * @return
     */
    public int updateTouTiaoPlanById(String id) throws Exception;
}
