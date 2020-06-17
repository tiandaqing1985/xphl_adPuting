package com.ruoyi.system.service.impl;

import com.ruoyi.common.config.Global;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.common.utils.file.FileUtils;
import com.ruoyi.common.utils.security.PermissionUtils;
import com.ruoyi.system.domain.ActorFile;
import com.ruoyi.system.mapper.ActorFileMapper;
import com.ruoyi.system.service.IActorFileService;
import com.ruoyi.today.service.impl.ThAdMateriaServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

/**
 * 演员文件储存路径Service业务层处理
 *
 * @author ruoyi
 * @date 2020-05-11
 */
@Service
public class ActorFileServiceImpl implements IActorFileService {
    private static Logger logger = LoggerFactory.getLogger(ThAdMateriaServiceImpl.class);
    @Autowired
    private ActorFileMapper actorFileMapper;

    /**
     * 查询演员文件储存路径
     *
     * @param id 演员文件储存路径ID
     * @return 演员文件储存路径
     */
    @Override
    public ActorFile selectActorFileById(Long id) {
        return actorFileMapper.selectActorFileById(id);
    }

    /**
     * 查询演员文件储存路径列表
     *
     * @param actorFile 演员文件储存路径
     * @return 演员文件储存路径
     */
    @Override
    public List<ActorFile> selectActorFileList(ActorFile actorFile) {
        return actorFileMapper.selectActorFileList(actorFile);
    }

    /**
     * 新增演员文件储存路径
     *
     * @param actorFile 演员文件储存路径
     * @return 结果
     */
    @Override
    public int insertActorFile(ActorFile actorFile) {
        actorFile.setCreateTime(DateUtils.getNowDate());
        return actorFileMapper.insertActorFile(actorFile);
    }

    /**
     * 修改演员文件储存路径
     *
     * @param actorFile 演员文件储存路径
     * @return 结果
     */
    @Override
    public int updateActorFile(ActorFile actorFile) {
        actorFile.setUpdateTime(DateUtils.getNowDate());
        return actorFileMapper.updateActorFile(actorFile);
    }

    /**
     * 删除演员文件储存路径对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteActorFileByIds(String ids) {
        return actorFileMapper.deleteActorFileByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除演员文件储存路径信息
     *
     * @param id 演员文件储存路径ID
     * @return 结果
     */
    public int deleteActorFileById(Long id) {
        return actorFileMapper.deleteActorFileById(id);
    }

    @Override
    public Long facuploadMateria(MultipartFile file_data, String fileId, Long loadid) throws Exception {
        Long id = null;
        FileInputStream fileInputStream = null;
        try {
            String localPath = FileUploadUtils.upload(file_data);
            localPath = localPath.replace("/profile/", FileUploadUtils.getDefaultBaseDir());
            ActorFile materia = new ActorFile();
            materia.setFileName(fileId.substring(fileId.indexOf("_") + 1));
            fileInputStream = new FileInputStream(new File(localPath));
            materia.setFilePath(localPath);
            materia.setCreateBy((String) PermissionUtils.getPrincipalProperty("loginName"));
            materia.setCreateTime(DateUtils.getNowDate());
            materia.setFilePath(localPath);
            materia.setLoadid(loadid);
            actorFileMapper.insertActorFile(materia);
            id = materia.getId();
        } catch (Exception e) {
            logger.error("上传文件" + fileId + "出现异常：", e);
            throw e;
        } finally {
            if (fileInputStream != null) {
                fileInputStream.close();
            }
        }

        return id;
    }

    @Override
    public boolean ifPicUpload(Long userId, String idnumber) {
        List<ActorFile> fList = actorFileMapper.selectPicList(userId);
        if (fList.size() == 0 || fList == null) {
            return false;
        } else {
            for (ActorFile f : fList) {
                ActorFile actor = new ActorFile();
                actor.setId(f.getId());
                actor.setNum(idnumber);
                actorFileMapper.updateActorFile(actor);
            }
        }
        return true;
    }

    @Override
    public void xaizaiIdnumber(String idnumber) {
        ActorFile actorFile = new ActorFile();
        actorFile.setNum(idnumber);
        List<ActorFile> list = actorFileMapper.selectActorFileList(actorFile);
        if (list != null && !list.isEmpty()) {
            for (ActorFile a : list) {

                String filePath = Global.getUploadPath();
                File file = new File( filePath + File.separator +  idnumber);
                System.out.println("11111111111111"+filePath);
                file.mkdirs();
                ActorFileServiceImpl aaa = new ActorFileServiceImpl();
                try {
                    aaa.transferFile(a.getFilePath(), filePath + File.separator + idnumber + File.separator + a.getFileName());
                  //  aaa.transferFile(a.getFilePath(), "/opt/toutiao/webapps/upload/" + idnumber + File.separator + a.getFileName());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                //源文件路径    压缩后文件存储路径    压缩文件名
            FileUtils.compressToZip(filePath + File.separator +  idnumber, "/opt/toutiao/webapps/upload/" + idnumber+"s", idnumber+".zip");

        }
        }
    }

    private void transferFile(String oldPath, String newPath) throws Exception {

        int byteread = 0;
        File oldFile = new File(oldPath);
        FileInputStream fin = null;
        FileOutputStream fout = null;
        System.out.println("oldPath:"+oldPath);
        System.out.println("newPath:"+newPath);
        try {
            if (oldFile.exists()) {
                fin = new FileInputStream(oldFile);
                fout = new FileOutputStream(newPath);
                byte[] buffer = new byte[1444];
                while ((byteread = fin.read(buffer)) != -1) {
                    fout.write(buffer, 0, byteread);
                }
                if (fin != null) {
                    fin.close();//如果流不关闭,则删除不了旧文件
                }
            } else {
                throw new Exception("需要转移的文件不存在!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (fin != null) {
                fin.close();
            }
        }
    }
}
