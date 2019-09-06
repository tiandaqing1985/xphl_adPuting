package com.ruoyi.today.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.today.mapper.ThTokenMapper;
import com.ruoyi.today.domain.ThToken;
import com.ruoyi.today.service.IThTokenService;
import com.ruoyi.common.core.text.Convert;

/**
 * tokenService业务层处理
 * 
 * @author ruoyi
 * @date 2019-08-20
 */
@Service
public class ThTokenServiceImpl implements IThTokenService 
{
    @Autowired
    private ThTokenMapper thTokenMapper;


    /**
     * 查询token
     * 
     * @param id tokenID
     * @return token
     */
    @Override
    public ThToken selectThTokenById(Long id)
    {
        return thTokenMapper.selectThTokenById(id);
    }

    /**
     * 查询token列表
     * 
     * @param thToken token
     * @return token
     */
    @Override
    public List<ThToken> selectThTokenList(ThToken thToken)
    {
        return thTokenMapper.selectThTokenList(thToken);
    }

    /**
     * 新增token
     * 
     * @param thToken token
     * @return 结果
     */
    @Override
    public int insertThToken(ThToken thToken)
    {
        return thTokenMapper.insertThToken(thToken);
    }

    /**
     * 修改token
     * 
     * @param thToken token
     * @return 结果
     */
    @Override
    public int updateThToken(ThToken thToken)
    {
        return thTokenMapper.updateThToken(thToken);
    }

    /**
     * 删除token对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteThTokenByIds(String ids)
    {
        return thTokenMapper.deleteThTokenByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除token信息
     * 
     * @param id tokenID
     * @return 结果
     */
    public int deleteThTokenById(Long id)
    {
        return thTokenMapper.deleteThTokenById(id);
    }
}
