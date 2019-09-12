package com.ruoyi.today.service;

import com.ruoyi.today.domain.ThCreativityImage;

import java.util.List;

/**
 * 程序化创意素材Service接口
 * 
 * @author ruoyi
 * @date 2019-09-09
 */
public interface IThCreativityImageService 
{
    /**
     * 查询程序化创意素材
     * 
     * @param id 程序化创意素材ID
     * @return 程序化创意素材
     */
    public ThCreativityImage selectThCreativityImageById(Long id);

    /**
     * 查询程序化创意素材列表
     * 
     * @param thCreativityImage 程序化创意素材
     * @return 程序化创意素材集合
     */
    public List<ThCreativityImage> selectThCreativityImageList(ThCreativityImage thCreativityImage);

    /**
     * 新增程序化创意素材
     * 
     * @param thCreativityImage 程序化创意素材
     * @return 结果
     */
    public int insertThCreativityImage(ThCreativityImage thCreativityImage);

    /**
     * 修改程序化创意素材
     * 
     * @param thCreativityImage 程序化创意素材
     * @return 结果
     */
    public int updateThCreativityImage(ThCreativityImage thCreativityImage);

    /**
     * 批量删除程序化创意素材
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteThCreativityImageByIds(String ids);

    /**
     * 删除程序化创意素材信息
     * 
     * @param id 程序化创意素材ID
     * @return 结果
     */
    public int deleteThCreativityImageById(Long id);
}
