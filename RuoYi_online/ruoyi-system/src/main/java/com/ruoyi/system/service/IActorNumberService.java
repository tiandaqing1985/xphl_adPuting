package com.ruoyi.system.service;

import com.ruoyi.system.domain.ActorNumber;
import java.util.List;

/**
 * app名称id生成Service接口
 * 
 * @author ruoyi
 * @date 2020-01-08
 */
public interface IActorNumberService 
{
    /**
     * 查询app名称id生成
     * 
     * @param id app名称id生成ID
     * @return app名称id生成
     */
    public ActorNumber selectActorNumberById(Long id);



    public  ActorNumber selectId();

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
     * 批量删除app名称id生成
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteActorNumberByIds(String ids);

    /**
     * 删除app名称id生成信息
     * 
     * @param id app名称id生成ID
     * @return 结果
     */
    public int deleteActorNumberById(Long id);
}
