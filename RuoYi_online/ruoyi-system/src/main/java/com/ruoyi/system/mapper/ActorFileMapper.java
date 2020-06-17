package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.ActorFile;
import java.util.List;

/**
 * 演员文件储存路径Mapper接口
 * 
 * @author ruoyi
 * @date 2020-05-11
 */
public interface ActorFileMapper 
{
    /**
     * 查询演员文件储存路径
     * 
     * @param id 演员文件储存路径ID
     * @return 演员文件储存路径
     */
    public ActorFile selectActorFileById(Long id);

    /**
     * 查询演员文件储存路径列表
     * 
     * @param actorFile 演员文件储存路径
     * @return 演员文件储存路径集合
     */
    public List<ActorFile> selectActorFileList(ActorFile actorFile);

    /**
     * 新增演员文件储存路径
     * 
     * @param actorFile 演员文件储存路径
     * @return 结果
     */
    public int insertActorFile(ActorFile actorFile);

    /**
     * 修改演员文件储存路径
     * 
     * @param actorFile 演员文件储存路径
     * @return 结果
     */
    public int updateActorFile(ActorFile actorFile);

    /**
     * 删除演员文件储存路径
     * 
     * @param id 演员文件储存路径ID
     * @return 结果
     */
    public int deleteActorFileById(Long id);

    /**
     * 批量删除演员文件储存路径
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteActorFileByIds(String[] ids);

    /**
     * 查询图片是否上传
     * @param loadid
     * @return
     */
    public List<ActorFile> selectPicList(Long loadid);


}
