package com.ruoyi.today.mapper;

import com.ruoyi.today.domain.MatterUseRecord;

import java.util.List;

public interface ThMatterUseRecordMapper {

    public List<MatterUseRecord> selectList(MatterUseRecord matterUseRecord);

    public int insertMatterUseRecord(MatterUseRecord matterUseRecord);

    public int deleteMatterUseRecord(MatterUseRecord matterUseRecord);

}
