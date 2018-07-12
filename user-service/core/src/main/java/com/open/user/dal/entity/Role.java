package com.open.user.dal.entity;


import com.open.common.entity.po.BasePo;

import javax.persistence.Id;


public class Role extends BasePo {

    @Id
    private String roleId;
    private String roleName;
    private String roleCode;
    private String roleDesc;
    private String delFlag;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}
