package com.open.common.domain;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by Tony on 6/10/2018.
 */
public class BaseModel implements Serializable{

    private Timestamp createTime;
    private Timestamp updateTime;

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }
}
