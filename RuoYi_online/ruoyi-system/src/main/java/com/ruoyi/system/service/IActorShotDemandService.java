package com.ruoyi.system.service;

import com.ruoyi.system.domain.ActorShotDemand;
import java.util.List;

/**
 * 拍摄需求单Service接口
 * 
 * @author ruoyi
 * @date 2020-01-06
 */
public interface IActorShotDemandService 
{
    /**
     * 查询拍摄需求单
     * 
     * @param id 拍摄需求单ID
     * @return 拍摄需求单
     */
    public ActorShotDemand selectActorShotDemandById(Long id);

    /**
     * 查询拍摄需求单列表
     * 
     * @param actorShotDemand 拍摄需求单
     * @return 拍摄需求单集合
     */
    public List<ActorShotDemand> selectActorShotDemandList(ActorShotDemand actorShotDemand);

    /**
     * 新增拍摄需求单
     * 
     * @param actorShotDemand 拍摄需求单
     * @return 结果
     */
    public int insertActorShotDemand(ActorShotDemand actorShotDemand);

    /**
     * 修改拍摄需求单
     * 
     * @param actorShotDemand 拍摄需求单
     * @return 结果
     */
    public int updateActorShotDemand(ActorShotDemand actorShotDemand);

    /**
     * 批量删除拍摄需求单
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteActorShotDemandByIds(String ids);

    /**
     * 删除拍摄需求单信息
     * 
     * @param id 拍摄需求单ID
     * @return 结果
     */
    public int deleteActorShotDemandById(Long id);
}
