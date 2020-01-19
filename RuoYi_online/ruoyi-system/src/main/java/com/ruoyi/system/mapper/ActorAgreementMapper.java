package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.ActorAgreement;
import java.util.List;

/**
 * 演员协议帐Mapper接口
 * 
 * @author ruoyi
 * @date 2020-01-09
 */
public interface ActorAgreementMapper 
{
    /**
     * 查询演员协议帐
     * 
     * @param id 演员协议帐ID
     * @return 演员协议帐
     */
    public ActorAgreement selectActorAgreementById(Long id);

    /**
     * 查询演员协议帐列表
     * 
     * @param actorAgreement 演员协议帐
     * @return 演员协议帐集合
     */
    public List<ActorAgreement> selectActorAgreementList(ActorAgreement actorAgreement);

    /**
     * 新增演员协议帐
     * 
     * @param actorAgreement 演员协议帐
     * @return 结果
     */
    public int insertActorAgreement(ActorAgreement actorAgreement);

    /**
     * 修改演员协议帐
     * 
     * @param actorAgreement 演员协议帐
     * @return 结果
     */
    public int updateActorAgreement(ActorAgreement actorAgreement);

    /**
     * 删除演员协议帐
     * 
     * @param id 演员协议帐ID
     * @return 结果
     */
    public int deleteActorAgreementById(Long id);

    /**
     * 批量删除演员协议帐
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteActorAgreementByIds(String[] ids);
}
