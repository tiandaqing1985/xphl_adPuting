package com.ruoyi.system.service;

import com.ruoyi.system.domain.ActorFile;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 演员文件储存路径Service接口
 * 
 * @author ruoyi
 * @date 2020-05-11
 */
public interface IActorFileService 
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
     * 批量删除演员文件储存路径
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteActorFileByIds(String ids);

    /**
     * 删除演员文件储存路径信息
     * 
     * @param id 演员文件储存路径ID
     * @return 结果
     */
    public int deleteActorFileById(Long id);




    /**
     * 上传图片
     * @param file_data
     * @param fileId
     * @return
     * @throws Exception
     */
    public Long facuploadMateria(MultipartFile file_data, String fileId,Long loadid) throws Exception;

    /**
     * 验证图片是否已经上传
     * @param userId
     * @return
     */
    public boolean ifPicUpload(Long userId,String idnumber);

    void xaizaiIdnumber(String idnumber);
}
