package com.ruoyi.today.service;

import com.ruoyi.today.domain.ThAdvertiser;
import com.ruoyi.today.domain.ThCampaign;
import java.util.List;

/**
 * 广告组Service接口
 * 
 * @author ruoyi
 * @date 2019-08-14
 */
public interface IThCampaignService 
{
    /**
     * 查询广告组
     * 
     * @param campaignId 广告组ID
     * @return 广告组
     */
    public ThCampaign selectThCampaignById(Long campaignId);

    /**
     * 查询广告组列表
     * 
     * @param thCampaign 广告组
     * @return 广告组集合
     */
    public List<ThCampaign> selectThCampaignList(ThCampaign thCampaign);

    /**
     * 新增广告组
     * 
     * @param thCampaign 广告组
     * @return 结果
     */
    public int insertThCampaign(ThCampaign thCampaign);

    /**
     * 修改广告组
     * 
     * @param thCampaign 广告组
     * @return 结果
     */
    public int updateThCampaign(ThCampaign thCampaign);

    /**
     * 批量删除广告组
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteThCampaignByIds(String ids);

    /**
     * 删除广告组信息
     * 
     * @param campaignId 广告组ID
     * @return 结果
     */
    public int deleteThCampaignById(Long campaignId);

    /**
     * 从头条查询广告组信息
     *
     * @param thCampaign 广告组VO
     * @return 结果
     */
    public List<ThCampaign> selectThCampaignFromTouTiao(ThCampaign thCampaign) throws Exception;

    public int createThCampaign(ThCampaign thCampaign) throws Exception;

    /**
     * 同步广告组
     * @param advertiser
     */
    public void syncCampaign(ThAdvertiser advertiser) throws Exception;
}
