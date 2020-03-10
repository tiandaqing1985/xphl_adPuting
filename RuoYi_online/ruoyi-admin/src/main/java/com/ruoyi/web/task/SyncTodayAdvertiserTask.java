package com.ruoyi.web.task;

import com.ruoyi.today.service.IThAdvertiserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("syncTodayAdvertiserTask")
public class SyncTodayAdvertiserTask {

    @Autowired
    private IThAdvertiserService thAdvertiserService;

    public void syncAdvertiser() {
        thAdvertiserService.adMutual("task");
    }

}
