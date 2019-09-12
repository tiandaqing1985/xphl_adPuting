package com.ruoyi.today.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.today.domain.ThCreativityTitle;
import com.ruoyi.today.mapper.ThCreativityTitleMapper;
import com.ruoyi.today.service.IThCreativityTitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 程序化创意标题Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-09-09
 */
@Service
public class ThCreativityTitleServiceImpl implements IThCreativityTitleService
{
    @Autowired
    private ThCreativityTitleMapper thCreativityTitleMapper;

    /**
     * 查询程序化创意标题
     * 
     * @param id 程序化创意标题ID
     * @return 程序化创意标题
     */
    @Override
    public ThCreativityTitle selectThCreativityTitleById(Long id)
    {
        return thCreativityTitleMapper.selectThCreativityTitleById(id);
    }

    /**
     * 查询程序化创意标题列表
     * 
     * @param thCreativityTitle 程序化创意标题
     * @return 程序化创意标题
     */
    @Override
    public List<ThCreativityTitle> selectThCreativityTitleList(ThCreativityTitle thCreativityTitle)
    {
        return thCreativityTitleMapper.selectThCreativityTitleList(thCreativityTitle);
    }

    /**
     * 新增程序化创意标题
     * 
     * @param thCreativityTitle 程序化创意标题
     * @return 结果
     */
    @Override
    public int insertThCreativityTitle(ThCreativityTitle thCreativityTitle)
    {
        thCreativityTitle.setCreateTime(DateUtils.getNowDate());
        return thCreativityTitleMapper.insertThCreativityTitle(thCreativityTitle);
    }

    /**
     * 修改程序化创意标题
     * 
     * @param thCreativityTitle 程序化创意标题
     * @return 结果
     */
    @Override
    public int updateThCreativityTitle(ThCreativityTitle thCreativityTitle)
    {
        thCreativityTitle.setUpdateTime(DateUtils.getNowDate());
        return thCreativityTitleMapper.updateThCreativityTitle(thCreativityTitle);
    }

    /**
     * 删除程序化创意标题对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteThCreativityTitleByIds(String ids)
    {
        return thCreativityTitleMapper.deleteThCreativityTitleByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除程序化创意标题信息
     * 
     * @param id 程序化创意标题ID
     * @return 结果
     */
    public int deleteThCreativityTitleById(Long id)
    {
        return thCreativityTitleMapper.deleteThCreativityTitleById(id);
    }
}
