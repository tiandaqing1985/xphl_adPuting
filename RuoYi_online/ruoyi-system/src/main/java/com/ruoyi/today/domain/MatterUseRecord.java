package com.ruoyi.today.domain;

import java.sql.Date;

public class MatterUseRecord {

    private Long matterId;

    private Date time;

    public Long getMatterId() {
        return matterId;
    }

    public void setMatterId(Long matterId) {
        this.matterId = matterId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
