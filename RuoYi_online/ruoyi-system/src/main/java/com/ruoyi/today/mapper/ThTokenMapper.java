package com.ruoyi.today.mapper;

import com.ruoyi.today.domain.ThToken;
import java.util.List;

/**
 * tokenMapper接口
 * 
 * @author ruoyi
 * @date 2019-08-20
 */
public interface ThTokenMapper 
{
    /**
     * 查询token
     * 
     * @param id tokenID
     * @return token
     */
    public ThToken selectThTokenById(Long id);

    /**
     * 查询token列表
     * 
     * @param thToken token
     * @return token集合
     */
    public List<ThToken> selectThTokenList(ThToken thToken);

    /**
     * 新增token
     * 
     * @param thToken token
     * @return 结果
     */
    public int insertThToken(ThToken thToken);

    /**
     * 修改token
     * 
     * @param thToken token
     * @return 结果
     */
    public int updateThToken(ThToken thToken);

    /**
     * 删除token
     * 
     * @param id tokenID
     * @return 结果
     */
    public int deleteThTokenById(Long id);

    /**
     * 批量删除token
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteThTokenByIds(String[] ids);
}
