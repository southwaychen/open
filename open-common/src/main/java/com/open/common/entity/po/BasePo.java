package com.open.common.entity.po;


import java.io.Serializable;
import java.util.Date;

public class BasePo implements Serializable {

    private Date createdTime;
    private Date updatedTime ;

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }
}
