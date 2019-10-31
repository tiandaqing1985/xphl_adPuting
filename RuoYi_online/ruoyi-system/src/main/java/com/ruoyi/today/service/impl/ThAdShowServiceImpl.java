package com.ruoyi.today.service.impl;

import java.util.List;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.today.domain.ThAdShow;
import com.ruoyi.today.mapper.ThAdShowMapper;
import com.ruoyi.today.service.IThAdShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.text.Convert;

/**
 * 广告计划显示字段方案Service业务层处理
 *
 * @author ruoyi
 * @date 2019-09-04
 */
@Service
public class ThAdShowServiceImpl implements IThAdShowService {
    @Autowired
    private ThAdShowMapper thAdShowMapper;

    /**
     * 查询广告计划显示字段方案
     *
     * @param id 广告计划显示字段方案ID
     * @return 广告计划显示字段方案
     */
    @Override
    public ThAdShow selectThAdShowById(Long id) {
        return thAdShowMapper.selectThAdShowById(id);
    }

    /**
     * 查询广告计划显示字段方案列表
     *
     * @param thAdShow 广告计划显示字段方案
     * @return 广告计划显示字段方案
     */
    @Override
    public List<ThAdShow> selectThAdShowList(ThAdShow thAdShow) {
        return thAdShowMapper.selectThAdShowList(thAdShow);
    }

    /**
     * 新增广告计划显示字段方案
     *
     * @param thAdShow 广告计划显示字段方案
     * @return 结果
     */
    @Override
    public int insertThAdShow(ThAdShow thAdShow) {
        thAdShow.setCreateTime(DateUtils.getNowDate());
        return thAdShowMapper.insertThAdShow(thAdShow);
    }

    /**
     * 修改广告计划显示字段方案
     *
     * @param thAdShow 广告计划显示字段方案
     * @return 结果
     */
    @Override
    public int updateThAdShow(ThAdShow thAdShow) {
        thAdShow.setUpdateTime(DateUtils.getNowDate());
        return thAdShowMapper.updateThAdShow(thAdShow);
    }

    /**
     * 删除广告计划显示字段方案对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteThAdShowByIds(String ids) {
        return thAdShowMapper.deleteThAdShowByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除广告计划显示字段方案信息
     *
     * @param id 广告计划显示字段方案ID
     * @return 结果
     */
    public int deleteThAdShowById(Long id) {
        return thAdShowMapper.deleteThAdShowById(id);
    }

    /**
     * 根据创建人查询出满足记录的记录条数
     */
    @Override
    public String selectCountByCreateBy(String createBy,String type) {

        return thAdShowMapper.selectCountByCreateBy(createBy,type);

    }
}
