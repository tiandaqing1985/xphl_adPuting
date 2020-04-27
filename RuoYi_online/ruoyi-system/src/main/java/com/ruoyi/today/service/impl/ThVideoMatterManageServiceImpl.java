package com.ruoyi.today.service.impl;

import com.ruoyi.today.domain.ThMatterManage;
import com.ruoyi.today.mapper.ThVideoMatterManageMapper;
import com.ruoyi.today.service.IThVideoMatterManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThVideoMatterManageServiceImpl implements IThVideoMatterManageService {

    @Autowired
    private ThVideoMatterManageMapper thVideoMatterManageMapper;

    @Override
    public List<ThMatterManage> selectMatter(ThMatterManage thMatterManage) {

        return thVideoMatterManageMapper.selectMatter(thMatterManage);
    }

    @Override
    public int selectMatterCount(ThMatterManage thMatterManage) {
        return thVideoMatterManageMapper.selectMatterCount(thMatterManage);
    }

    @Override
    public String selectMatterCostSum(ThMatterManage thMatterManage) {
        return thVideoMatterManageMapper.selectMatterCostSum(thMatterManage);
    }

    @Override
    public List<ThMatterManage> selectImageMatter(ThMatterManage thMatterManage) {
        return thVideoMatterManageMapper.selectImageMatter(thMatterManage);
    }


    @Override
    public String selectImageMatterCostSum(ThMatterManage thMatterManage) {
        return thVideoMatterManageMapper.selectImageMatterCostSum(thMatterManage);
    }

    @Override
    public int selectImageMatterCount(ThMatterManage thMatterManage) {
        return thVideoMatterManageMapper.selectImageMatterCount(thMatterManage);
    }
}
