package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.ActorDetails;
import java.util.List;

/**
 * 视频拍摄详情Mapper接口
 * 
 * @author ruoyi
 * @date 2020-05-18
 */
public interface ActorDetailsMapper 
{
    /**
     * 查询视频拍摄详情
     * 
     * @param id 视频拍摄详情ID
     * @return 视频拍摄详情
     */
    public ActorDetails selectActorDetailsById(Long id);

    /**
     * 查询视频拍摄详情列表
     * 
     * @param actorDetails 视频拍摄详情
     * @return 视频拍摄详情集合
     */
    public List<ActorDetails> selectActorDetailsList(ActorDetails actorDetails);

    /**
     * 新增视频拍摄详情
     * 
     * @param actorDetails 视频拍摄详情
     * @return 结果
     */
    public int insertActorDetails(ActorDetails actorDetails);

    /**
     * 修改视频拍摄详情
     * 
     * @param actorDetails 视频拍摄详情
     * @return 结果
     */
    public int updateActorDetails(ActorDetails actorDetails);

    /**
     * 删除视频拍摄详情
     * 
     * @param id 视频拍摄详情ID
     * @return 结果
     */
    public int deleteActorDetailsById(Long id);

    /**
     * 批量删除视频拍摄详情
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteActorDetailsByIds(String[] ids);
}
