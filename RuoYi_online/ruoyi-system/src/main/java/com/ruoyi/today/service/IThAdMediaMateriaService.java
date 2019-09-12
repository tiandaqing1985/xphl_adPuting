package com.ruoyi.today.service;

import com.ruoyi.today.domain.ThAdMediaMateria;

import java.util.List;

/**
 * 媒体素材Service接口
 * 
 * @author ruoyi
 * @date 2019-09-11
 */
public interface IThAdMediaMateriaService 
{
    /**
     * 查询媒体素材
     * 
     * @param id 媒体素材ID
     * @return 媒体素材
     */
    public ThAdMediaMateria selectThAdMediaMateriaById(Long id);

    /**
     * 查询媒体素材列表
     * 
     * @param thAdMediaMateria 媒体素材
     * @return 媒体素材集合
     */
    public List<ThAdMediaMateria> selectThAdMediaMateriaList(ThAdMediaMateria thAdMediaMateria);

    /**
     * 新增媒体素材
     * 
     * @param thAdMediaMateria 媒体素材
     * @return 结果
     */
    public int insertThAdMediaMateria(ThAdMediaMateria thAdMediaMateria);

    /**
     * 修改媒体素材
     * 
     * @param thAdMediaMateria 媒体素材
     * @return 结果
     */
    public int updateThAdMediaMateria(ThAdMediaMateria thAdMediaMateria);

    /**
     * 批量删除媒体素材
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteThAdMediaMateriaByIds(String ids);

    /**
     * 删除媒体素材信息
     * 
     * @param id 媒体素材ID
     * @return 结果
     */
    public int deleteThAdMediaMateriaById(Long id);
}
