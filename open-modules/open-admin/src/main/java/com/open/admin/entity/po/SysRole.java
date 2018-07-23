/*
 *    Copyright (c) 2018-2025, lengleng All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 * Neither the name of the pig4cloud.com developer nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 * Author: lengleng (wangiegie@gmail.com)
 */

package com.open.admin.entity.po;

import com.open.common.entity.po.BasePo;


import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * <p>
 * </p>
 *
 * @author lengleng
 * @since 2017-10-29
 */

public class SysRole extends BasePo {

    private static final long serialVersionUID = 1L;


    private Integer roleId;

    private String roleName;

    private String roleCode;

    private String roleDesc;

    private Date createdTime;

    private Date updatedTime;
    /**
     * 删除标识（0-正常,1-删除）
     */
    private String delFlag;



    @Override
    public String toString() {
        return "SysRole{" +
                ", roleId=" + roleId +
                ", roleName=" + roleName +
                ", roleCode=" + roleCode +
                ", roleDesc=" + roleDesc +
                ", createdTime=" + super.getCreatedTime() +
                ", updatedTime=" + super.getUpdatedTime() +
                ", delFlag=" + delFlag +
                "}";
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    @Override
    public Date getCreatedTime() {
        return createdTime;
    }

    @Override
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    @Override
    public Date getUpdatedTime() {
        return updatedTime;
    }

    @Override
    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }
}
