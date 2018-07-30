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

package com.open.user.entity.po;

import com.open.common.entity.po.BasePo;

import javax.persistence.Id;


/**
 * <p>
 * 菜单权限表
 * </p>
 *
 * @author lengleng
 * @since 2017-11-08
 */


public class SysMenu extends BasePo {

    private static final long serialVersionUID = 1L;

    /**
     * 菜单ID
     */

    @Id
	private String menuId;
    /**
     * 菜单名称
     */
	private String menuName;
    /**
     * 菜单权限标识
     */
	private String permission;
    /**
     * 请求链接
     */
	private String url;
    /**
     * 请求方法
     */
	private String method;
    /**
     * 父菜单ID
     */
	private Integer parentId;
    /**
     * 图标
     */
	private String icon;
    /**
     * 排序值
     */
	private Integer sort;
    /**
     * 菜单类型 （0菜单 1按钮）
     */
	private Integer type;
	/**
	 * 前端URL
	 */
	private String path;



	public String toString() {
		return "SysMenu{" +
			", menuId=" + menuId +
			", menuName=" + menuName +
			", permission=" + permission +
			", url=" + url +
			", method=" + method +
			", parentId=" + parentId +
			", icon=" + icon +
			", sort=" + sort +
			", type=" + type +
			", createdTime=" + super.getCreatedTime() +
			", updatedTime=" + super.getUpdatedTime() +
			", status=" + super.getStatus() +
			"}";
	}

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
