package com.ruoyi.today.mapper;

import com.ruoyi.today.domain.ThMatterManage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface ThVideoMatterManageMapper {
    List<ThMatterManage> selectMatter(ThMatterManage thMatterManage);

    int selectMatterCount(ThMatterManage thMatterManage);

    String selectMatterCostSum(ThMatterManage thMatterManage);
}
