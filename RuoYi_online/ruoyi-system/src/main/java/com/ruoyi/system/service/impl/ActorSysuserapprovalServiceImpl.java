package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.ActorSysuserapproval;
import com.ruoyi.system.mapper.ActorSysuserapprovalMapper;
import com.ruoyi.system.service.IActorSysuserapprovalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 演员审批Service业务层处理
 *
 * @author ruoyi
 * @date 2020-01-09
 */
@Service
public class ActorSysuserapprovalServiceImpl implements IActorSysuserapprovalService {
    @Autowired
    private ActorSysuserapprovalMapper actorSysuserapprovalMapper;

    /**
     * 查询演员审批
     *
     * @param id 演员审批ID
     * @return 演员审批
     */
    @Override
    public ActorSysuserapproval selectActorSysuserapprovalById(Long id) {
        return actorSysuserapprovalMapper.selectActorSysuserapprovalById(id);
    }

    /**
     * 查询演员审批列表
     *
     * @param actorSysuserapproval 演员审批
     * @return 演员审批
     */
    @Override
    public List<ActorSysuserapproval> selectActorSysuserapprovalList(ActorSysuserapproval actorSysuserapproval) {
        return actorSysuserapprovalMapper.selectActorSysuserapprovalList(actorSysuserapproval);
    }

    /**
     * 新增演员审批
     *
     * @param actorSysuserapproval 演员审批
     * @return 结果
     */
    @Override
    public int insertActorSysuserapproval(ActorSysuserapproval actorSysuserapproval) {
        actorSysuserapproval.setCreateTime(DateUtils.getNowDate());
        return actorSysuserapprovalMapper.insertActorSysuserapproval(actorSysuserapproval);
    }

    /**
     * 修改演员审批
     *
     * @param actorSysuserapproval 演员审批
     * @return 结果
     */

    @Override
    public int updateActorSysuserapproval(ActorSysuserapproval actorSysuserapproval) {
        actorSysuserapproval.setUpdateTime(DateUtils.getNowDate());
        actorSysuserapproval.setApprovalTime(new Date());

        ActorSysuserapproval actor = actorSysuserapprovalMapper.selectActorSysuserapprovalById(actorSysuserapproval.getId());
        ActorSysuserapproval actors = new ActorSysuserapproval();
        if (actorSysuserapproval.getApprovalState().equals("3")) {
            if (actor.getApprovalLevel() == 1L) {
                actors.setApplyId(actor.getApplyId());
                actors.setApprovalLevel(2);
                ActorSysuserapproval actorx = actorSysuserapprovalMapper.selectActorApply(actors);
                actorx.setApprovalSight("1");
                actorSysuserapprovalMapper.updateActorSysuserapproval(actorx);
            } else if (actor.getApprovalLevel() == 2L) {
                actors.setApplyId(actor.getApplyId());
                actors.setApprovalLevel(3);
                ActorSysuserapproval actorx = actorSysuserapprovalMapper.selectActorApply(actors);
                actorx.setApprovalSight("1");
                actorSysuserapprovalMapper.updateActorSysuserapproval(actorx);
            } else if (actor.getApprovalLevel() == 3L) {
            }
        }

        return actorSysuserapprovalMapper.updateActorSysuserapproval(actorSysuserapproval);
    }

    /**
     * 删除演员审批对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteActorSysuserapprovalByIds(String ids) {
        return actorSysuserapprovalMapper.deleteActorSysuserapprovalByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除演员审批信息
     *
     * @param id 演员审批ID
     * @return 结果
     */
    public int deleteActorSysuserapprovalById(Long id) {
        return actorSysuserapprovalMapper.deleteActorSysuserapprovalById(id);
    }

    public ActorSysuserapproval selectApplyById(Long id) {

        if (actorSysuserapprovalMapper.selectApplyId(id) == null) {
            return null;
        }
        return actorSysuserapprovalMapper.selectApplyById(id);
    }

    public List<ActorSysuserapproval> selectList(ActorSysuserapproval actorSysuserapproval) {
        return actorSysuserapprovalMapper.selectList(actorSysuserapproval);
    }


    public List<ActorSysuserapproval> selectListPliang(String ids){
        return actorSysuserapprovalMapper.selectListPliang(Convert.toStrArray(ids));
    }
}
