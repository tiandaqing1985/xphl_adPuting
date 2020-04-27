package com.ruoyi.today.service;

import com.ruoyi.today.domain.ThMatterManage;

import java.util.List;

public interface IThVideoMatterManageService {
    List<ThMatterManage> selectMatter(ThMatterManage thMatterManage);

    int selectMatterCount(ThMatterManage thMatterManage);

    String selectMatterCostSum(ThMatterManage thMatterManage);

    List<ThMatterManage> selectImageMatter(ThMatterManage thMatterManage);

    String selectImageMatterCostSum(ThMatterManage thMatterManage);

    int selectImageMatterCount(ThMatterManage thMatterManage);
}
