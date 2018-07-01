package com.open.common.entity.po;

import lombok.Data;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Date;

public class BasePo implements Serializable {

    private Date createdTime = Date.from(ZonedDateTime.now().toInstant());
    private Date updatedTime = Date.from(ZonedDateTime.now().toInstant());



}
