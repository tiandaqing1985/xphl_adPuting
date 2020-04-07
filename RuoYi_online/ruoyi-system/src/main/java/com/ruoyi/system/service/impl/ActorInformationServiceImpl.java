package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.ActorInformation;
import com.ruoyi.system.mapper.ActorInformationMapper;
import com.ruoyi.system.service.IActorInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 演员信息Service业务层处理
 *
 * @author ruoyi
 * @date 2020-01-03
 */
@Service
public class ActorInformationServiceImpl implements IActorInformationService {
    @Autowired
    private ActorInformationMapper actorInformationMapper;

    /**
     * 查询演员信息
     *
     * @param id 演员信息ID
     * @return 演员信息
     */
    @Override
    public ActorInformation selectActorInformationById(Long id) {
        return actorInformationMapper.selectActorInformationById(id);
    }

    /**
     * 查询演员信息列表
     *
     * @param actorInformation 演员信息
     * @return 演员信息
     */
    @Override
    public List<ActorInformation> selectActorInformationList(ActorInformation actorInformation) {
        return actorInformationMapper.selectActorInformationList(actorInformation);
    }

    /**
     * 新增演员信息
     *
     * @param actorInformation 演员信息
     * @return 结果
     */
    @Override
    public int insertActorInformation(ActorInformation actorInformation) {
        long a;
        if (actorInformationMapper.selectActorId() != null) {
            a = actorInformationMapper.selectActorId() + 1;
        } else {
            a = 1L;
        }
        actorInformation.setNum("P00" + a);
        return actorInformationMapper.insertActorInformation(actorInformation);
    }

    /**
     * 修改演员信息
     *
     * @param actorInformation 演员信息
     * @return 结果
     */
    @Override
    public int updateActorInformation(ActorInformation actorInformation) {
        return actorInformationMapper.updateActorInformation(actorInformation);
    }

    /**
     * 删除演员信息对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteActorInformationByIds(String ids) {
        return actorInformationMapper.deleteActorInformationByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除演员信息信息
     *
     * @param id 演员信息ID
     * @return 结果
     */
    public int deleteActorInformationById(Long id) {
        return actorInformationMapper.deleteActorInformationById(id);
    }


    public ActorInformation selectActorname(String name) {
        return actorInformationMapper.selectActorname(name);
    }

    public List<ActorInformation> selectAllUserModel() {
        return actorInformationMapper.selectAllUserModel();
    }
}
