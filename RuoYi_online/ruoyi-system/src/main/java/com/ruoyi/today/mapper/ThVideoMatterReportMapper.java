package com.ruoyi.today.mapper;

import com.ruoyi.today.domain.AdMatterVO;
import com.ruoyi.today.domain.MatterReportVO;
import com.ruoyi.today.domain.ThVideoMatterReport;

import java.util.List;

/**
 * 素材报Mapper接口
 * 
 * @author ruoyi
 * @date 2020-03-11
 */
public interface ThVideoMatterReportMapper 
{
    /**
     * 查询素材报
     * 
     * @param id 素材报ID
     * @return 素材报
     */
    public ThVideoMatterReport selectThVideoMatterReportById(Long id);

    /**
     * 查询素材报列表
     * 
     * @param thVideoMatterReport 素材报
     * @return 素材报集合
     */
    public List<ThVideoMatterReport> selectThVideoMatterReportList(ThVideoMatterReport thVideoMatterReport);

    public List<ThVideoMatterReport> selectGroupByOrderList(ThVideoMatterReport thVideoMatterReport);


    /**
     * 新增素材报
     * 
     * @param thVideoMatterReport 素材报
     * @return 结果
     */
    public int insertThVideoMatterReport(ThVideoMatterReport thVideoMatterReport);

    /**
     * 修改素材报
     * 
     * @param thVideoMatterReport 素材报
     * @return 结果
     */
    public int updateThVideoMatterReport(ThVideoMatterReport thVideoMatterReport);

    /**
     * 删除素材报
     * 
     * @param id 素材报ID
     * @return 结果
     */
    public int deleteThVideoMatterReportById(Long id);

    /**
     * 批量删除素材报
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteThVideoMatterReportByIds(String[] ids);

    List<AdMatterVO> selectAdMatterList();

    List<MatterReportVO> selectGroupByTimeList(MatterReportVO matterReportVO);

    List<ThVideoMatterReport> selectMatterReportList(ThVideoMatterReport report);
}
