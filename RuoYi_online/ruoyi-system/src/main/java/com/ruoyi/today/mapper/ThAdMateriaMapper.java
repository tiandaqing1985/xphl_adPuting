package com.ruoyi.today.mapper;

import com.ruoyi.today.domain.ThAdMateria;

import java.util.List;

/**
 * 素材Mapper接口
 * 
 * @author ruoyi
 * @date 2019-09-11
 */
public interface ThAdMateriaMapper 
{
    /**
     * 查询素材
     * 
     * @param id 素材ID
     * @return 素材
     */
    public ThAdMateria selectThAdMateriaById(Long id);

    /**
     * 查询素材列表
     * 
     * @param thAdMateria 素材
     * @return 素材集合
     */
    public List<ThAdMateria> selectThAdMateriaList(ThAdMateria thAdMateria);

    /**
     * 新增素材
     * 
     * @param thAdMateria 素材
     * @return 结果
     */
    public int insertThAdMateria(ThAdMateria thAdMateria);

    /**
     * 修改素材
     * 
     * @param thAdMateria 素材
     * @return 结果
     */
    public int updateThAdMateria(ThAdMateria thAdMateria);

    /**
     * 删除素材
     * 
     * @param id 素材ID
     * @return 结果
     */
    public int deleteThAdMateriaById(Long id);

    /**
     * 批量删除素材
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteThAdMateriaByIds(String[] ids);

    public ThAdMateria selectThAdMateriaByFileName(String fileName);

    ThAdMateria selectThAdMateriaByMediaMateria(String imageId);
}
