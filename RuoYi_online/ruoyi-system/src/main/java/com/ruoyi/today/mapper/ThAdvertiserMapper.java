package com.ruoyi.today.mapper;

import com.ruoyi.today.domain.ThAdvertiser;
import java.util.List;

/**
 * 广告主Mapper接口
 * 
 * @author ruoyi
 * @date 2019-08-12
 */
public interface ThAdvertiserMapper 
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
     * 删除广告主
     * 
     * @param id 广告主ID
     * @return 结果
     */
    public int deleteThAdvertiserById(Long id);

    /**
     * 批量删除广告主
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteThAdvertiserByIds(String[] ids);

    public ThAdvertiser selectThAdvertiserByName(ThAdvertiser advertiser);

    void insertThAdvertiserList(List<ThAdvertiser> thAdvertisers);
}
