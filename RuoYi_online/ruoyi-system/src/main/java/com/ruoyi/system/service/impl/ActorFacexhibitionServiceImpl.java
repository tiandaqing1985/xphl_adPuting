package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ActorFacexhibitionMapper;
import com.ruoyi.system.domain.ActorFacexhibition;
import com.ruoyi.system.service.IActorFacexhibitionService;
import com.ruoyi.common.core.text.Convert;

/**
 * 财务查看Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-01-13
 */
@Service
public class ActorFacexhibitionServiceImpl implements IActorFacexhibitionService 
{
    @Autowired
    private ActorFacexhibitionMapper actorFacexhibitionMapper;

    /**
     * 查询财务查看
     * 
     * @param id 财务查看ID
     * @return 财务查看
     */
    @Override
    public ActorFacexhibition selectActorFacexhibitionById(Long id)
    {
        return actorFacexhibitionMapper.selectActorFacexhibitionById(id);
    }

    /**
     * 查询财务查看列表
     * 
     * @param actorFacexhibition 财务查看
     * @return 财务查看
     */
    @Override
    public List<ActorFacexhibition> selectActorFacexhibitionList(ActorFacexhibition actorFacexhibition)
    {
        return actorFacexhibitionMapper.selectActorFacexhibitionList(actorFacexhibition);
    }

    /**
     * 新增财务查看
     * 
     * @param actorFacexhibition 财务查看
     * @return 结果
     */
    @Override
    public int insertActorFacexhibition(ActorFacexhibition actorFacexhibition)
    {
        return actorFacexhibitionMapper.insertActorFacexhibition(actorFacexhibition);
    }

    /**
     * 修改财务查看
     * 
     * @param actorFacexhibition 财务查看
     * @return 结果
     */
    @Override
    public int updateActorFacexhibition(ActorFacexhibition actorFacexhibition)
    {
        return actorFacexhibitionMapper.updateActorFacexhibition(actorFacexhibition);
    }

    /**
     * 删除财务查看对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteActorFacexhibitionByIds(String ids)
    {
        return actorFacexhibitionMapper.deleteActorFacexhibitionByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除财务查看信息
     * 
     * @param id 财务查看ID
     * @return 结果
     */
    public int deleteActorFacexhibitionById(Long id)
    {
        return actorFacexhibitionMapper.deleteActorFacexhibitionById(id);
    }


    @Override
    public List<ActorFacexhibition>  selectApprovalByIds(String ids) {
        return actorFacexhibitionMapper
                .selectApprovalByIds(Convert.toStrArray(ids));
    }

    /**
     * 查询财务查看列表
     *
     * @param actorFacexhibition 财务查看
     * @return 财务查看
     */
    @Override
    public List<ActorFacexhibition> selectList(ActorFacexhibition actorFacexhibition)
    {
        return actorFacexhibitionMapper.selectActorFacexhibitionList(actorFacexhibition);
    }


}
