package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ActorNumberMapper;
import com.ruoyi.system.domain.ActorNumber;
import com.ruoyi.system.service.IActorNumberService;
import com.ruoyi.common.core.text.Convert;

/**
 * app名称id生成Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-01-08
 */
@Service
public class ActorNumberServiceImpl implements IActorNumberService 
{
    @Autowired
    private ActorNumberMapper actorNumberMapper;

    /**
     * 查询app名称id生成
     * 
     * @param id app名称id生成ID
     * @return app名称id生成
     */
    @Override
    public ActorNumber selectActorNumberById(Long id)
    {
        return actorNumberMapper.selectActorNumberById(id);
    }

    /**
     * 查询app名称id生成列表
     * 
     * @param actorNumber app名称id生成
     * @return app名称id生成
     */
    @Override
    public List<ActorNumber> selectActorNumberList(ActorNumber actorNumber)
    {
        return actorNumberMapper.selectActorNumberList(actorNumber);
    }

    /**
     * 新增app名称id生成
     * 
     * @param actorNumber app名称id生成
     * @return 结果
     */
    @Override
    public int insertActorNumber(ActorNumber actorNumber)
    {
        return actorNumberMapper.insertActorNumber(actorNumber);
    }

    /**
     * 修改app名称id生成
     * 
     * @param actorNumber app名称id生成
     * @return 结果
     */
    @Override
    public int updateActorNumber(ActorNumber actorNumber)
    {
        return actorNumberMapper.updateActorNumber(actorNumber);
    }

    /**
     * 删除app名称id生成对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteActorNumberByIds(String ids)
    {
        return actorNumberMapper.deleteActorNumberByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除app名称id生成信息
     * 
     * @param id app名称id生成ID
     * @return 结果
     */
    public int deleteActorNumberById(Long id)
    {
        return actorNumberMapper.deleteActorNumberById(id);
    }
    @Override
    public  ActorNumber selectId(){

        return actorNumberMapper.selectId();
    }
}
