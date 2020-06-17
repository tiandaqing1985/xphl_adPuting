package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.ActorDetails;
import com.ruoyi.system.mapper.ActorDetailsMapper;
import com.ruoyi.system.service.IActorDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 视频拍摄详情Service业务层处理
 *
 * @author ruoyi
 * @date 2020-05-18
 */
@Service
public class ActorDetailsServiceImpl implements IActorDetailsService {
    @Autowired
    private ActorDetailsMapper actorDetailsMapper;

    /**
     * 查询视频拍摄详情
     *
     * @param id 视频拍摄详情ID
     * @return 视频拍摄详情
     */
    @Override
    public ActorDetails selectActorDetailsById(Long id) {
        return actorDetailsMapper.selectActorDetailsById(id);
    }

    /**
     * 查询视频拍摄详情列表
     *
     * @param actorDetails 视频拍摄详情
     * @return 视频拍摄详情
     */
    @Override
    public List<ActorDetails> selectActorDetailsList(ActorDetails actorDetails) {
        return actorDetailsMapper.selectActorDetailsList(actorDetails);
    }

    /**
     * 新增视频拍摄详情
     *
     * @param actorDetails 视频拍摄详情
     * @return 结果
     */
    @Override
    public int insertActorDetails(ActorDetails actorDetails) {
        return actorDetailsMapper.insertActorDetails(actorDetails);
    }

    /**
     * 修改视频拍摄详情
     *
     * @param actorDetails 视频拍摄详情
     * @return 结果
     */
    @Override
    public int updateActorDetails(ActorDetails actorDetails) {
        return actorDetailsMapper.updateActorDetails(actorDetails);
    }

    /**
     * 删除视频拍摄详情对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteActorDetailsByIds(String ids) {
        return actorDetailsMapper.deleteActorDetailsByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除视频拍摄详情信息
     *
     * @param id 视频拍摄详情ID
     * @return 结果
     */
    public int deleteActorDetailsById(Long id) {
        return actorDetailsMapper.deleteActorDetailsById(id);
    }


    /**
     * 查询视频拍摄详情列表
     *
     * @param actorDetails 视频拍摄详情
     * @return 视频拍摄详情
     */
    @Override
    public List<ActorDetails> selectDetailsList(Long applyId) {
        ActorDetails actorDetails = new ActorDetails();
        actorDetails.setApplyId(applyId);
        return actorDetailsMapper.selectActorDetailsList(actorDetails);
    }

}
