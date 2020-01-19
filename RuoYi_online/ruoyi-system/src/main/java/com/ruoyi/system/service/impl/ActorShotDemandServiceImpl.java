package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ActorShotDemandMapper;
import com.ruoyi.system.domain.ActorShotDemand;
import com.ruoyi.system.service.IActorShotDemandService;
import com.ruoyi.common.core.text.Convert;

/**
 * 拍摄需求单Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-01-06
 */
@Service
public class ActorShotDemandServiceImpl implements IActorShotDemandService 
{
    @Autowired
    private ActorShotDemandMapper actorShotDemandMapper;

    /**
     * 查询拍摄需求单
     * 
     * @param id 拍摄需求单ID
     * @return 拍摄需求单
     */
    @Override
    public ActorShotDemand selectActorShotDemandById(Long id)
    {
        return actorShotDemandMapper.selectActorShotDemandById(id);
    }

    /**
     * 查询拍摄需求单列表
     * 
     * @param actorShotDemand 拍摄需求单
     * @return 拍摄需求单
     */
    @Override
    public List<ActorShotDemand> selectActorShotDemandList(ActorShotDemand actorShotDemand)
    {
        return actorShotDemandMapper.selectActorShotDemandList(actorShotDemand);
    }

    /**
     * 新增拍摄需求单
     * 
     * @param actorShotDemand 拍摄需求单
     * @return 结果
     */
    @Override
    public int insertActorShotDemand(ActorShotDemand actorShotDemand)
    {
        return actorShotDemandMapper.insertActorShotDemand(actorShotDemand);
    }

    /**
     * 修改拍摄需求单
     * 
     * @param actorShotDemand 拍摄需求单
     * @return 结果
     */
    @Override
    public int updateActorShotDemand(ActorShotDemand actorShotDemand)
    {
        return actorShotDemandMapper.updateActorShotDemand(actorShotDemand);
    }

    /**
     * 删除拍摄需求单对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteActorShotDemandByIds(String ids)
    {
        return actorShotDemandMapper.deleteActorShotDemandByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除拍摄需求单信息
     * 
     * @param id 拍摄需求单ID
     * @return 结果
     */
    public int deleteActorShotDemandById(Long id)
    {
        return actorShotDemandMapper.deleteActorShotDemandById(id);
    }
}
