package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.ActorShotApply;
import java.util.List;

/**
 * 演员拍摄汇总Mapper接口
 * 
 * @author ruoyi
 * @date 2020-01-06
 */
public interface ActorShotApplyMapper 
{
    /**
     * 查询演员拍摄汇总
     * 
     * @param id 演员拍摄汇总ID
     * @return 演员拍摄汇总
     */
    public ActorShotApply selectActorShotApplyById(Long id);

    /**
     * 查询演员拍摄汇总列表
     * 
     * @param actorShotApply 演员拍摄汇总
     * @return 演员拍摄汇总集合
     */
    public List<ActorShotApply> selectActorShotApplyList(ActorShotApply actorShotApply);

    /**
     * 新增演员拍摄汇总
     * 
     * @param actorShotApply 演员拍摄汇总
     * @return 结果
     */
    public int insertActorShotApply(ActorShotApply actorShotApply);

    /**
     * 修改演员拍摄汇总
     * 
     * @param actorShotApply 演员拍摄汇总
     * @return 结果
     */
    public int updateActorShotApply(ActorShotApply actorShotApply);

    /**
     * 删除演员拍摄汇总
     * 
     * @param id 演员拍摄汇总ID
     * @return 结果
     */
    public int deleteActorShotApplyById(Long id);

    /**
     * 批量删除演员拍摄汇总
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteActorShotApplyByIds(String[] ids);
}
