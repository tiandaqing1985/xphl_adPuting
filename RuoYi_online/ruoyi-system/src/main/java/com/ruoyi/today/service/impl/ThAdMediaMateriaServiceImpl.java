package com.ruoyi.today.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.today.domain.ThAdMediaMateria;
import com.ruoyi.today.mapper.ThAdMediaMateriaMapper;
import com.ruoyi.today.service.IThAdMediaMateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.text.Convert;

/**
 * 媒体素材Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-09-11
 */
@Service
public class ThAdMediaMateriaServiceImpl implements IThAdMediaMateriaService
{
    @Autowired
    private ThAdMediaMateriaMapper thAdMediaMateriaMapper;

    /**
     * 查询媒体素材
     * 
     * @param id 媒体素材ID
     * @return 媒体素材
     */
    @Override
    public ThAdMediaMateria selectThAdMediaMateriaById(Long id)
    {
        return thAdMediaMateriaMapper.selectThAdMediaMateriaById(id);
    }

    /**
     * 查询媒体素材列表
     * 
     * @param thAdMediaMateria 媒体素材
     * @return 媒体素材
     */
    @Override
    public List<ThAdMediaMateria> selectThAdMediaMateriaList(ThAdMediaMateria thAdMediaMateria)
    {
        return thAdMediaMateriaMapper.selectThAdMediaMateriaList(thAdMediaMateria);
    }

    /**
     * 新增媒体素材
     * 
     * @param thAdMediaMateria 媒体素材
     * @return 结果
     */
    @Override
    public int insertThAdMediaMateria(ThAdMediaMateria thAdMediaMateria)
    {
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
    public int updateThAdMediaMateria(ThAdMediaMateria thAdMediaMateria)
    {
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
    public int deleteThAdMediaMateriaByIds(String ids)
    {
        return thAdMediaMateriaMapper.deleteThAdMediaMateriaByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除媒体素材信息
     * 
     * @param id 媒体素材ID
     * @return 结果
     */
    public int deleteThAdMediaMateriaById(Long id)
    {
        return thAdMediaMateriaMapper.deleteThAdMediaMateriaById(id);
    }
}
