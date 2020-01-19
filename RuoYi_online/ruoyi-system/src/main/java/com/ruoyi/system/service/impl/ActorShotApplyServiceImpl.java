package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ActorShotApplyMapper;
import com.ruoyi.system.domain.ActorShotApply;
import com.ruoyi.system.service.IActorShotApplyService;
import com.ruoyi.common.core.text.Convert;

/**
 * 演员拍摄汇总Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-01-06
 */
@Service
public class ActorShotApplyServiceImpl implements IActorShotApplyService 
{
    @Autowired
    private ActorShotApplyMapper actorShotApplyMapper;

    /**
     * 查询演员拍摄汇总
     * 
     * @param id 演员拍摄汇总ID
     * @return 演员拍摄汇总
     */
    @Override
    public ActorShotApply selectActorShotApplyById(Long id)
    {
        return actorShotApplyMapper.selectActorShotApplyById(id);
    }

    /**
     * 查询演员拍摄汇总列表
     * 
     * @param actorShotApply 演员拍摄汇总
     * @return 演员拍摄汇总
     */
    @Override
    public List<ActorShotApply> selectActorShotApplyList(ActorShotApply actorShotApply)
    {
        return actorShotApplyMapper.selectActorShotApplyList(actorShotApply);
    }

    /**
     * 新增演员拍摄汇总
     * 
     * @param actorShotApply 演员拍摄汇总
     * @return 结果
     */
    @Override
    public int insertActorShotApply(ActorShotApply actorShotApply)
    {
        return actorShotApplyMapper.insertActorShotApply(actorShotApply);
    }

    /**
     * 修改演员拍摄汇总
     * 
     * @param actorShotApply 演员拍摄汇总
     * @return 结果
     */
    @Override
    public int updateActorShotApply(ActorShotApply actorShotApply)
    {
        return actorShotApplyMapper.updateActorShotApply(actorShotApply);
    }

    /**
     * 删除演员拍摄汇总对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteActorShotApplyByIds(String ids)
    {
        return actorShotApplyMapper.deleteActorShotApplyByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除演员拍摄汇总信息
     * 
     * @param id 演员拍摄汇总ID
     * @return 结果
     */
    public int deleteActorShotApplyById(Long id)
    {
        return actorShotApplyMapper.deleteActorShotApplyById(id);
    }
}
