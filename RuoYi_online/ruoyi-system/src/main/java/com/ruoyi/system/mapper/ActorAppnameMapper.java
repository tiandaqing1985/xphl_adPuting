package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.ActorAppname;
import java.util.List;

/**
 * 拍摄app数量统计Mapper接口
 * 
 * @author ruoyi
 * @date 2020-01-07
 */
public interface ActorAppnameMapper 
{
    /**
     * 查询拍摄app数量统计
     * 
     * @param id 拍摄app数量统计ID
     * @return 拍摄app数量统计
     */
    public ActorAppname selectActorAppnameById(Long id);

    /**
     * 查询拍摄app数量统计列表
     * 
     * @param actorAppname 拍摄app数量统计
     * @return 拍摄app数量统计集合
     */
    public List<ActorAppname> selectActorAppnameList(ActorAppname actorAppname);

    /**
     * 新增拍摄app数量统计
     * 
     * @param actorAppname 拍摄app数量统计
     * @return 结果
     */
    public int insertActorAppname(ActorAppname actorAppname);

    /**
     * 修改拍摄app数量统计
     * 
     * @param actorAppname 拍摄app数量统计
     * @return 结果
     */
    public int updateActorAppname(ActorAppname actorAppname);

    /**
     * 删除拍摄app数量统计
     * 
     * @param id 拍摄app数量统计ID
     * @return 结果
     */
    public int deleteActorAppnameById(Long id);

    /**
     * 批量删除拍摄app数量统计
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteActorAppnameByIds(String[] ids);

    public List<ActorAppname>  selectAppname(Long id);

    public List<ActorAppname>  selectquChong(Long id);
}
