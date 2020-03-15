package com.ruoyi.today.service.impl;

import java.util.List;

import com.ruoyi.today.domain.AdMatterVO;
import com.ruoyi.today.domain.MatterReportVO;
import com.ruoyi.today.domain.ThVideoMatterReport;
import com.ruoyi.today.mapper.ThVideoMatterReportMapper;
import com.ruoyi.today.service.IThVideoMatterReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.text.Convert;

/**
 * 素材报Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-03-11
 */
@Service
public class ThVideoMatterReportServiceImpl implements IThVideoMatterReportService
{
    @Autowired
    private ThVideoMatterReportMapper thVideoMatterReportMapper;

    /**
     * 查询素材报
     * 
     * @param id 素材报ID
     * @return 素材报
     */
    @Override
    public ThVideoMatterReport selectThVideoMatterReportById(Long id)
    {
        return thVideoMatterReportMapper.selectThVideoMatterReportById(id);
    }

    /**
     * 查询素材报列表
     * 
     * @param thVideoMatterReport 素材报
     * @return 素材报
     */
    @Override
    public List<ThVideoMatterReport> selectThVideoMatterReportList(ThVideoMatterReport thVideoMatterReport)
    {
        return thVideoMatterReportMapper.selectThVideoMatterReportList(thVideoMatterReport);
    }

    /**
     * 新增素材报
     * 
     * @param thVideoMatterReport 素材报
     * @return 结果
     */
    @Override
    public int insertThVideoMatterReport(ThVideoMatterReport thVideoMatterReport)
    {
        return thVideoMatterReportMapper.insertThVideoMatterReport(thVideoMatterReport);
    }

    /**
     * 修改素材报
     * 
     * @param thVideoMatterReport 素材报
     * @return 结果
     */
    @Override
    public int updateThVideoMatterReport(ThVideoMatterReport thVideoMatterReport)
    {
        return thVideoMatterReportMapper.updateThVideoMatterReport(thVideoMatterReport);
    }

    /**
     * 删除素材报对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteThVideoMatterReportByIds(String ids)
    {
        return thVideoMatterReportMapper.deleteThVideoMatterReportByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除素材报信息
     * 
     * @param id 素材报ID
     * @return 结果
     */
    public int deleteThVideoMatterReportById(Long id)
    {
        return thVideoMatterReportMapper.deleteThVideoMatterReportById(id);
    }

    @Override
    public List<AdMatterVO> selectAdMatterList() {
        return thVideoMatterReportMapper.selectAdMatterList();
    }

    @Override
    public List<MatterReportVO> selectGroupByTimeList(MatterReportVO matterReportVO) {
        return thVideoMatterReportMapper.selectGroupByTimeList(matterReportVO);
    }
}
