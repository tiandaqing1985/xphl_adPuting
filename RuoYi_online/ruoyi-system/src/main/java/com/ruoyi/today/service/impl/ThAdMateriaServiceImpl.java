package com.ruoyi.today.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.common.utils.security.PermissionUtils;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.today.domain.ThAdMateria;
import com.ruoyi.today.mapper.ThAdMateriaMapper;
import com.ruoyi.today.service.IThAdMateriaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.text.Convert;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import org.springframework.web.multipart.MultipartFile;

/**
 * 素材Service业务层处理
 *
 * @author ruoyi
 * @date 2019-09-11
 */
@Service
public class ThAdMateriaServiceImpl implements IThAdMateriaService {

    private static Logger logger = LoggerFactory.getLogger(ThAdMateriaServiceImpl.class);

    @Autowired
    private ThAdMateriaMapper thAdMateriaMapper;

    /**
     * 查询素材
     *
     * @param id 素材ID
     * @return 素材
     */
    @Override
    public ThAdMateria selectThAdMateriaById(Long id) {
        return thAdMateriaMapper.selectThAdMateriaById(id);
    }

    /**
     * 查询素材列表
     *
     * @param thAdMateria 素材
     * @return 素材
     */
    @Override
    public List<ThAdMateria> selectThAdMateriaList(ThAdMateria thAdMateria) {
        return thAdMateriaMapper.selectThAdMateriaList(thAdMateria);
    }

    /**
     * 新增素材
     *
     * @param thAdMateria 素材
     * @return 结果
     */
    @Override
    public int insertThAdMateria(ThAdMateria thAdMateria) {
        thAdMateria.setCreateTime(DateUtils.getNowDate());
        return thAdMateriaMapper.insertThAdMateria(thAdMateria);
    }

    /**
     * 修改素材
     *
     * @param thAdMateria 素材
     * @return 结果
     */
    @Override
    public int updateThAdMateria(ThAdMateria thAdMateria) {
        thAdMateria.setUpdateTime(DateUtils.getNowDate());
        return thAdMateriaMapper.updateThAdMateria(thAdMateria);
    }

    /**
     * 删除素材对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteThAdMateriaByIds(String ids) {
        return thAdMateriaMapper.deleteThAdMateriaByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除素材信息
     *
     * @param id 素材ID
     * @return 结果
     */
    public int deleteThAdMateriaById(Long id) {
        return thAdMateriaMapper.deleteThAdMateriaById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long uploadMateria(MultipartFile file_data, String fileId) throws Exception {
        FileInputStream fileInputStream = null;
        Long id = null;
        try {
            String localPath = FileUploadUtils.upload(file_data);
            localPath = localPath.replace("/profile/",FileUploadUtils.getDefaultBaseDir());
            ThAdMateria materia = new ThAdMateria();
            materia.setFileName(fileId.substring(fileId.indexOf("_")+1));
            materia.setLocalPath(localPath);
            fileInputStream = new FileInputStream(new File(localPath));
            materia.setMd5(DigestUtils.md5DigestAsHex(fileInputStream));
            materia.setCreateBy((String) PermissionUtils.getPrincipalProperty("loginName"));
            materia.setCreateTime(DateUtils.getNowDate());
            thAdMateriaMapper.insertThAdMateria(materia);
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
}
