package com.ruoyi.system.service;

import com.ruoyi.system.domain.ActorSysuserapproval;
import java.util.List;

/**
 * 演员审批Service接口
 * 
 * @author ruoyi
 * @date 2020-01-09
 */
public interface IActorSysuserapprovalService 
{
    /**
     * 查询演员审批
     * 
     * @param id 演员审批ID
     * @return 演员审批
     */
    public ActorSysuserapproval selectActorSysuserapprovalById(Long id);

    /**
     * 查询演员审批列表
     * 
     * @param actorSysuserapproval 演员审批
     * @return 演员审批集合
     */
    public List<ActorSysuserapproval> selectActorSysuserapprovalList(ActorSysuserapproval actorSysuserapproval);

    /**
     * 新增演员审批
     * 
     * @param actorSysuserapproval 演员审批
     * @return 结果
     */
    public int insertActorSysuserapproval(ActorSysuserapproval actorSysuserapproval);

    /**
     * 修改演员审批
     * 
     * @param actorSysuserapproval 演员审批
     * @return 结果
     */
    public int updateActorSysuserapproval(ActorSysuserapproval actorSysuserapproval);

    /**
     * 批量删除演员审批
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteActorSysuserapprovalByIds(String ids);

    /**
     * 删除演员审批信息
     * 
     * @param id 演员审批ID
     * @return 结果
     */
    public int deleteActorSysuserapprovalById(Long id);


    public ActorSysuserapproval selectApplyById(Long id);

    /**
     * 查询演员审批列表
     *
     * @param actorSysuserapproval 演员审批
     * @return 演员审批集合
     */
    public List<ActorSysuserapproval> selectList(ActorSysuserapproval actorSysuserapproval);


    /**
     * 查询演员审批列表
     *
     * @param actorSysuserapproval 演员审批
     * @return 演员审批集合
     */
    public List<ActorSysuserapproval> selectListPliang(String ids);



}
