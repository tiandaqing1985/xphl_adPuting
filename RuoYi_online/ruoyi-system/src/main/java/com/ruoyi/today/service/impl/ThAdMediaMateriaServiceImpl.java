package com.ruoyi.today.service.impl;

import java.util.List;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.security.PermissionUtils;
import com.ruoyi.today.domain.*;
import com.ruoyi.today.domain.response.ResponseVO;
import com.ruoyi.today.mapper.ThAdMediaMateriaMapper;
import com.ruoyi.today.service.AdCenterService;
import com.ruoyi.today.service.IThAdMateriaService;
import com.ruoyi.today.service.IThAdMediaMateriaService;
import com.ruoyi.today.service.IThAdvertiserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.text.Convert;
import org.springframework.transaction.annotation.Transactional;

/**
 * 媒体素材Service业务层处理
 *
 * @author ruoyi
 * @date 2019-09-11
 */
@Service
public class ThAdMediaMateriaServiceImpl implements IThAdMediaMateriaService {
    @Autowired
    private ThAdMediaMateriaMapper thAdMediaMateriaMapper;
    @Autowired
    private AdCenterService centerService;
    @Autowired
    private IThAdMateriaService materiaService;
    @Autowired
    private IThAdvertiserService advertiserService;

    /**
     * 查询媒体素材
     *
     * @param id 媒体素材ID
     * @return 媒体素材
     */
    @Override
    public ThAdMediaMateria selectThAdMediaMateriaById(Long id) {
        return thAdMediaMateriaMapper.selectThAdMediaMateriaById(id);
    }

    /**
     * 查询媒体素材列表
     *
     * @param thAdMediaMateria 媒体素材
     * @return 媒体素材
     */
    @Override
    public List<ThAdMediaMateria> selectThAdMediaMateriaList(ThAdMediaMateria thAdMediaMateria) {
        return thAdMediaMateriaMapper.selectThAdMediaMateriaList(thAdMediaMateria);
    }

    /**
     * 新增媒体素材
     *
     * @param thAdMediaMateria 媒体素材
     * @return 结果
     */
    @Override
    public int insertThAdMediaMateria(ThAdMediaMateria thAdMediaMateria) {
        thAdMediaMateria.setCreateTime(DateUtils.getNowDate());
        return thAdMediaMateriaMapper.insertThAdMediaMateria(thAdMediaMateria);
    }

    /**
     * 修改媒体素材
     *
     * @param thAdMediaMateria 媒体素材
     * @return 结果
     */
    @Override
    public int updateThAdMediaMateria(ThAdMediaMateria thAdMediaMateria) {
        thAdMediaMateria.setUpdateTime(DateUtils.getNowDate());
        return thAdMediaMateriaMapper.updateThAdMediaMateria(thAdMediaMateria);
    }

    /**
     * 删除媒体素材对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteThAdMediaMateriaByIds(String ids) {
        return thAdMediaMateriaMapper.deleteThAdMediaMateriaByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除媒体素材信息
     *
     * @param id 媒体素材ID
     * @return 结果
     */
    public int deleteThAdMediaMateriaById(Long id) {
        return thAdMediaMateriaMapper.deleteThAdMediaMateriaById(id);
    }


    @Override
    public String selectMediaMateriaIdByFileName(ThAdCreativityImport imoprt, String fileName) throws Exception {

        if (fileName != null) {

            //查询素材上传到本地的记录
            ThAdMateria materia = materiaService.selectThAdMateriaByFileName(fileName);
            if (materia == null) {
                throw new Exception("请先将素材上传");
            } else {
                //查询媒体素材id
                ThAdMediaMateria mediaMateria = thAdMediaMateriaMapper.selectThAdMediaMateriaIdByAdvertiserNameAndMateriaId(imoprt.getAdvertiserName(), materia.getId().toString());
                if (mediaMateria != null) {
                    return mediaMateria.getMediaMateriaId();
                } else {
                    ThAdvertiser advertiser = new ThAdvertiser();
                    advertiser.setName(imoprt.getAdvertiserName());
                    ThAdvertiser advertiser1 = advertiserService.selectThAdvertiserByName(advertiser);
                    materia.setAdvertiserId(advertiser1.getId().toString());
                    String videoId = null;
                    //jpg, jpeg, png, bmp, gif
                    fileName = fileName.toLowerCase();
                    if (fileName.endsWith("jpg") || fileName.endsWith("jpeg") || fileName.endsWith("png") || fileName.endsWith("bmp") || fileName.endsWith("gif")) {
                        videoId = uploadImageFileToMedia(materia);
                    }
                    //mp4、mpeg、3gp、avi
                    else if (fileName.endsWith("mp4") || fileName.endsWith("mpeg") || fileName.endsWith("3gp") || fileName.endsWith("avi")) {
                        videoId = uploadVideoFileToMedia(materia);
                    } else {
                        throw new Exception("文件格式不支持！！");
                    }
                    return videoId;
                }
            }

        } else {
            throw new Exception("文件名错误！！");
        }

    }
    //上传文件到媒体(图片)
    @Override
    public String uploadImageFileToMedia(ThAdMateria materia) throws Exception {

        ResponseVO responseVO = (ResponseVO) centerService.uploadImageFile(materia);
        if ("0".equals(responseVO.getCode())) {
            ThAdMediaMateria mediaMateria = new ThAdMediaMateria();
            mediaMateria.setAdvertiserId(Long.valueOf(materia.getAdvertiserId()));
            mediaMateria.setMateriaId(materia.getId().toString());
            mediaMateria.setMediaMateriaId(responseVO.getData().getString("id"));
            mediaMateria.setCreateBy((String) PermissionUtils.getPrincipalProperty("loginName"));
            mediaMateria.setCreateTime(DateUtils.getNowDate());
            thAdMediaMateriaMapper.insertThAdMediaMateria(mediaMateria);
            return mediaMateria.getMediaMateriaId();
        } else {
            throw new Exception("上传文件出现错误，错误码：" + responseVO.getCode() + ",错误信息：" + responseVO.getMessage());
        }

    }

    //上传文件到媒体
    @Override
    public String uploadVideoFileToMedia(ThAdMateria materia) throws Exception {

        ResponseVO responseVO = (ResponseVO) centerService.uploadVideoFile(materia);
        if ("0".equals(responseVO.getCode())) {
            ThAdMediaMateria mediaMateria = new ThAdMediaMateria();
            mediaMateria.setAdvertiserId(Long.valueOf(materia.getAdvertiserId()));
            mediaMateria.setMateriaId(materia.getId().toString());
            mediaMateria.setMediaMateriaId(responseVO.getData().getString("video_id"));
            mediaMateria.setCreateBy((String) PermissionUtils.getPrincipalProperty("loginName"));
            mediaMateria.setCreateTime(DateUtils.getNowDate());
            thAdMediaMateriaMapper.insertThAdMediaMateria(mediaMateria);
            return mediaMateria.getMediaMateriaId();
        } else {
            throw new Exception("上传文件出现错误，错误码：" + responseVO.getCode() + ",错误信息：" + responseVO.getMessage());
        }

    }

    @Override
    public ThAdMediaMateria selectThAdMediaMateriaByMediaMateriaId(String imageId) {
        return thAdMediaMateriaMapper.selectThAdMediaMateriaByMediaMateriaId(imageId);
    }
}
