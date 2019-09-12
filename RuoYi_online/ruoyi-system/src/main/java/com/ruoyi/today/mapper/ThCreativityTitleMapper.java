package com.ruoyi.today.mapper;

import com.ruoyi.today.domain.ThCreativityTitle;

import java.util.List;

/**
 * 程序化创意标题Mapper接口
 * 
 * @author ruoyi
 * @date 2019-09-09
 */
public interface ThCreativityTitleMapper 
{
    /**
     * 查询程序化创意标题
     * 
     * @param id 程序化创意标题ID
     * @return 程序化创意标题
     */
    public ThCreativityTitle selectThCreativityTitleById(Long id);

    /**
     * 查询程序化创意标题列表
     * 
     * @param thCreativityTitle 程序化创意标题
     * @return 程序化创意标题集合
     */
    public List<ThCreativityTitle> selectThCreativityTitleList(ThCreativityTitle thCreativityTitle);

    /**
     * 新增程序化创意标题
     * 
     * @param thCreativityTitle 程序化创意标题
     * @return 结果
     */
    public int insertThCreativityTitle(ThCreativityTitle thCreativityTitle);

    /**
     * 修改程序化创意标题
     * 
     * @param thCreativityTitle 程序化创意标题
     * @return 结果
     */
    public int updateThCreativityTitle(ThCreativityTitle thCreativityTitle);

    /**
     * 删除程序化创意标题
     * 
     * @param id 程序化创意标题ID
     * @return 结果
     */
    public int deleteThCreativityTitleById(Long id);

    /**
     * 批量删除程序化创意标题
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteThCreativityTitleByIds(String[] ids);
}
