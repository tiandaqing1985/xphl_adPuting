package com.ruoyi.today.service;

import com.ruoyi.today.domain.ThMatterManage;

import java.util.List;

public interface IThVideoMatterManageService {
    List<ThMatterManage> selectMatter(ThMatterManage thMatterManage);

    int selectMatterCount(ThMatterManage thMatterManage);
}
