package com.ruoyi.today.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.today.domain.ThCreativityImage;
import com.ruoyi.today.mapper.ThCreativityImageMapper;
import com.ruoyi.today.service.IThCreativityImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 程序化创意素材Service业务层处理
 *
 * @author ruoyi
 * @date 2019-09-09
 */
@Service
public class ThCreativityImageServiceImpl implements IThCreativityImageService {
    @Autowired
    private ThCreativityImageMapper thCreativityImageMapper;

    /**
     * 查询程序化创意素材
     *
     * @param id 程序化创意素材ID
     * @return 程序化创意素材
     */
    @Override
    public ThCreativityImage selectThCreativityImageById(Long id) {
        return thCreativityImageMapper.selectThCreativityImageById(id);
    }

    /**
     * 查询程序化创意素材列表
     *
     * @param thCreativityImage 程序化创意素材
     * @return 程序化创意素材
     */
    @Override
    public List<ThCreativityImage> selectThCreativityImageList(ThCreativityImage thCreativityImage) {
        List<ThCreativityImage> thCreativityImages = thCreativityImageMapper.selectThCreativityImageList(thCreativityImage);

        for (ThCreativityImage image : thCreativityImages) {
            if (image.getImageIds() != null) {
                image.setImage_ids(Convert.toStrArray(image.getImageIds()));
            }
            if (image.getDpaTemplate() != null) {
                image.setDpa_template(Convert.toStrArray(image.getDpaTemplate()));
            }
        }

        return thCreativityImages;
    }

    /**
     * 新增程序化创意素材
     *
     * @param thCreativityImage 程序化创意素材
     * @return 结果
     */
    @Override
    public int insertThCreativityImage(ThCreativityImage thCreativityImage) {
        thCreativityImage.setCreateTime(DateUtils.getNowDate());
        return thCreativityImageMapper.insertThCreativityImage(thCreativityImage);
    }

    /**
     * 修改程序化创意素材
     *
     * @param thCreativityImage 程序化创意素材
     * @return 结果
     */
    @Override
    public int updateThCreativityImage(ThCreativityImage thCreativityImage) {
        thCreativityImage.setUpdateTime(DateUtils.getNowDate());
        return thCreativityImageMapper.updateThCreativityImage(thCreativityImage);
    }

    /**
     * 删除程序化创意素材对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteThCreativityImageByIds(String ids) {
        return thCreativityImageMapper.deleteThCreativityImageByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除程序化创意素材信息
     *
     * @param id 程序化创意素材ID
     * @return 结果
     */
    public int deleteThCreativityImageById(Long id) {
        return thCreativityImageMapper.deleteThCreativityImageById(id);
    }
}
