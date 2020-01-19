package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ActorAppnameMapper;
import com.ruoyi.system.domain.ActorAppname;
import com.ruoyi.system.service.IActorAppnameService;
import com.ruoyi.common.core.text.Convert;

/**
 * 拍摄app数量统计Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-01-07
 */
@Service
public class ActorAppnameServiceImpl implements IActorAppnameService 
{
    @Autowired
    private ActorAppnameMapper actorAppnameMapper;

    /**
     * 查询拍摄app数量统计
     * 
     * @param id 拍摄app数量统计ID
     * @return 拍摄app数量统计
     */
    @Override
    public ActorAppname selectActorAppnameById(Long id)
    {
        return actorAppnameMapper.selectActorAppnameById(id);
    }

    /**
     * 查询拍摄app数量统计列表
     * 
     * @param actorAppname 拍摄app数量统计
     * @return 拍摄app数量统计
     */
    @Override
    public List<ActorAppname> selectActorAppnameList(ActorAppname actorAppname)
    {
        return actorAppnameMapper.selectActorAppnameList(actorAppname);
    }

    /**
     * 新增拍摄app数量统计
     * 
     * @param actorAppname 拍摄app数量统计
     * @return 结果
     */
    @Override
    public int insertActorAppname(ActorAppname actorAppname)
    {
        return actorAppnameMapper.insertActorAppname(actorAppname);
    }

    /**
     * 修改拍摄app数量统计
     * 
     * @param actorAppname 拍摄app数量统计
     * @return 结果
     */
    @Override
    public int updateActorAppname(ActorAppname actorAppname)
    {
        return actorAppnameMapper.updateActorAppname(actorAppname);
    }

    /**
     * 删除拍摄app数量统计对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteActorAppnameByIds(String ids)
    {
        return actorAppnameMapper.deleteActorAppnameByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除拍摄app数量统计信息
     * 
     * @param id 拍摄app数量统计ID
     * @return 结果
     */
    public int deleteActorAppnameById(Long id)
    {
        return actorAppnameMapper.deleteActorAppnameById(id);
    }

    public  List<ActorAppname> selectAppname(Long id){
        return actorAppnameMapper.selectAppname(id);
    }

}
