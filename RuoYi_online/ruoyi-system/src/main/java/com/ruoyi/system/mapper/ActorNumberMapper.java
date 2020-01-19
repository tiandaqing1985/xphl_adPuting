package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.ActorNumber;
import java.util.List;

/**
 * app名称id生成Mapper接口
 * 
 * @author ruoyi
 * @date 2020-01-08
 */
public interface ActorNumberMapper 
{
    /**
     * 查询app名称id生成
     * 
     * @param id app名称id生成ID
     * @return app名称id生成
     */
    public ActorNumber selectActorNumberById(Long id);

    /**
     * 查询app名称id生成列表
     * 
     * @param actorNumber app名称id生成
     * @return app名称id生成集合
     */
    public List<ActorNumber> selectActorNumberList(ActorNumber actorNumber);

    /**
     * 新增app名称id生成
     * 
     * @param actorNumber app名称id生成
     * @return 结果
     */
    public int insertActorNumber(ActorNumber actorNumber);

    /**
     * 修改app名称id生成
     * 
     * @param actorNumber app名称id生成
     * @return 结果
     */
    public int updateActorNumber(ActorNumber actorNumber);

    /**
     * 删除app名称id生成
     * 
     * @param id app名称id生成ID
     * @return 结果
     */
    public int deleteActorNumberById(Long id);

    /**
     * 批量删除app名称id生成
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteActorNumberByIds(String[] ids);


    public ActorNumber selectId();
}
