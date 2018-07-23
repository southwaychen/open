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


/**
 * <p>
 * 角色菜单表
 * </p>
 *
 * @author lengleng
 * @since 2017-10-29
 */

public class SysRoleMenu extends BasePo {

    private static final long serialVersionUID = 1L;

    /**
     * 角色ID
     */

	private Integer roleId;
    /**
     * 菜单ID
     */

	private Integer menuId;



	@Override
	public String toString() {
		return "SysRoleMenu{" +
			", roleId=" + roleId +
			", menuId=" + menuId +
			"}";
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}
}
