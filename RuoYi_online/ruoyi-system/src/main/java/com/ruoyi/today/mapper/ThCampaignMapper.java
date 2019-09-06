package com.ruoyi.today.mapper;

import com.ruoyi.today.domain.ThCampaign;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import java.util.List;


/**
 * 广告组Mapper接口
 *
 * @author ruoyi
 * @date 2019-08-14
 */
public interface ThCampaignMapper
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
     * 删除广告组
     *
     * @param campaignId 广告组ID
     * @return 结果
     */
    public int deleteThCampaignById(Long campaignId);

    /**
     * 批量删除广告组
     *
     * @param campaignIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteThCampaignByIds(String[] campaignIds);
}
