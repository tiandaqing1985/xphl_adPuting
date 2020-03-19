package com.ruoyi.system.service;

import com.ruoyi.system.domain.ActorInformation;
import java.util.List;

/**
 * 演员信息Service接口
 * 
 * @author ruoyi
 * @date 2020-01-03
 */
public interface IActorInformationService 
{
    /**
     * 查询演员信息
     * 
     * @param id 演员信息ID
     * @return 演员信息
     */
    public ActorInformation selectActorInformationById(Long id);

    /**
     * 查询演员信息列表
     * 
     * @param actorInformation 演员信息
     * @return 演员信息集合
     */
    public List<ActorInformation> selectActorInformationList(ActorInformation actorInformation);

    /**
     * 新增演员信息
     * 
     * @param actorInformation 演员信息
     * @return 结果
     */
    public int insertActorInformation(ActorInformation actorInformation);

    /**
     * 修改演员信息
     * 
     * @param actorInformation 演员信息
     * @return 结果
     */
    public int updateActorInformation(ActorInformation actorInformation);

    /**
     * 批量删除演员信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteActorInformationByIds(String ids);

    /**
     * 删除演员信息信息
     * 
     * @param id 演员信息ID
     * @return 结果
     */
    public int deleteActorInformationById(Long id);

    /**
     * 查询演员信息
     *
     * @param name 演员
     * @return 演员信息
     */
    public ActorInformation selectActorname(String name);


    public List<ActorInformation> selectAllUserModel();
}
