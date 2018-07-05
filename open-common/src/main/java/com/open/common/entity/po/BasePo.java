package com.open.common.entity.po;


import java.io.Serializable;
import java.util.Date;

public class BasePo implements Serializable {

    private Date createTime;
    private Date updateTime ;

    public Date getCreatedTime() {
        return createTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createTime = createdTime;
    }

    public Date getUpdatedTime() {
        return updateTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updateTime = updatedTime;
    }
}
