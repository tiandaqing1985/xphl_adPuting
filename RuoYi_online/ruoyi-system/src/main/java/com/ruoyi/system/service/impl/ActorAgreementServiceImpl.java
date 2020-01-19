package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ActorAgreementMapper;
import com.ruoyi.system.domain.ActorAgreement;
import com.ruoyi.system.service.IActorAgreementService;
import com.ruoyi.common.core.text.Convert;

/**
 * 演员协议帐Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-01-09
 */
@Service
public class ActorAgreementServiceImpl implements IActorAgreementService 
{
    @Autowired
    private ActorAgreementMapper actorAgreementMapper;

    /**
     * 查询演员协议帐
     * 
     * @param id 演员协议帐ID
     * @return 演员协议帐
     */
    @Override
    public ActorAgreement selectActorAgreementById(Long id)
    {
        return actorAgreementMapper.selectActorAgreementById(id);
    }

    /**
     * 查询演员协议帐列表
     * 
     * @param actorAgreement 演员协议帐
     * @return 演员协议帐
     */
    @Override
    public List<ActorAgreement> selectActorAgreementList(ActorAgreement actorAgreement)
    {
        return actorAgreementMapper.selectActorAgreementList(actorAgreement);
    }

    /**
     * 新增演员协议帐
     * 
     * @param actorAgreement 演员协议帐
     * @return 结果
     */
    @Override
    public int insertActorAgreement(ActorAgreement actorAgreement)
    {
        return actorAgreementMapper.insertActorAgreement(actorAgreement);
    }

    /**
     * 修改演员协议帐
     * 
     * @param actorAgreement 演员协议帐
     * @return 结果
     */
    @Override
    public int updateActorAgreement(ActorAgreement actorAgreement)
    {
        return actorAgreementMapper.updateActorAgreement(actorAgreement);
    }

    /**
     * 删除演员协议帐对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteActorAgreementByIds(String ids)
    {
        return actorAgreementMapper.deleteActorAgreementByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除演员协议帐信息
     * 
     * @param id 演员协议帐ID
     * @return 结果
     */
    public int deleteActorAgreementById(Long id)
    {
        return actorAgreementMapper.deleteActorAgreementById(id);
    }
}
