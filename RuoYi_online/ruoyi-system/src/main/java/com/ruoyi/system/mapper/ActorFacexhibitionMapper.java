package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.ActorFacexhibition;
import java.util.List;

/**
 * 财务查看Mapper接口
 * 
 * @author ruoyi
 * @date 2020-01-13
 */
public interface ActorFacexhibitionMapper 
{
    /**
     * 查询财务查看
     * 
     * @param id 财务查看ID
     * @return 财务查看
     */
    public ActorFacexhibition selectActorFacexhibitionById(Long id);

    /**
     * 查询财务查看列表
     * 
     * @param actorFacexhibition 财务查看
     * @return 财务查看集合
     */
    public List<ActorFacexhibition> selectActorFacexhibitionList(ActorFacexhibition actorFacexhibition);

    /**
     * 新增财务查看
     * 
     * @param actorFacexhibition 财务查看
     * @return 结果
     */
    public int insertActorFacexhibition(ActorFacexhibition actorFacexhibition);

    /**
     * 修改财务查看
     * 
     * @param actorFacexhibition 财务查看
     * @return 结果
     */
    public int updateActorFacexhibition(ActorFacexhibition actorFacexhibition);

    /**
     * 删除财务查看
     * 
     * @param id 财务查看ID
     * @return 结果
     */
    public int deleteActorFacexhibitionById(Long id);

    /**
     * 批量删除财务查看
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteActorFacexhibitionByIds(String[] ids);


    /**
     * 批量查询
     *
     * @param id 需要查询的数据ID
     * @return 结果
     */
    public List<ActorFacexhibition>  selectApprovalByIds(String[] id);




}
