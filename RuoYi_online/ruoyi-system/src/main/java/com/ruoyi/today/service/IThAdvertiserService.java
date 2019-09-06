package com.ruoyi.today.service;

import com.ruoyi.today.domain.ThAdvertiser;
import java.util.List;

/**
 * 广告主Service接口
 * 
 * @author ruoyi
 * @date 2019-08-12
 */
public interface IThAdvertiserService 
{
    /**
     * 查询广告主
     * 
     * @param id 广告主ID
     * @return 广告主
     */
    public ThAdvertiser selectThAdvertiserById(Long id);

    /**
     * 查询广告主列表
     * 
     * @param thAdvertiser 广告主
     * @return 广告主集合
     */
    public List<ThAdvertiser> selectThAdvertiserList(ThAdvertiser thAdvertiser);

    /**
     * 新增广告主
     * 
     * @param thAdvertiser 广告主
     * @return 结果
     */
    public int insertThAdvertiser(ThAdvertiser thAdvertiser);

    /**
     * 修改广告主
     * 
     * @param thAdvertiser 广告主
     * @return 结果
     */
    public int updateThAdvertiser(ThAdvertiser thAdvertiser);

    /**
     * 批量删除广告主
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteThAdvertiserByIds(String ids);

    /**
     * 删除广告主信息
     * 
     * @param id 广告主ID
     * @return 结果
     */
    public int deleteThAdvertiserById(Long id);
    
    /**
     * 从头条同步广告主数据
     * @return
     */
    public int adMutual(String createBy);

    /**
     * 根据广告主名称查询广告主
     * @param advertiser
     * @return
     */
    public ThAdvertiser selectThAdvertiserByName(ThAdvertiser advertiser);
}
