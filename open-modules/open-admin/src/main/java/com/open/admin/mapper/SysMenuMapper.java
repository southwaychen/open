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

package com.open.admin.mapper;

import com.open.admin.entity.po.SysMenu;


import com.open.admin.entity.vo.MenuVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * <p>
 * 菜单权限表 Mapper 接口
 * </p>
 *
 * @author lengleng
 * @since 2017-10-29
 */
public interface SysMenuMapper extends Mapper<SysMenu> {

    @Select(" <script>" +
            "SELECT "
            +" sys_menu.* "
            +" FROM sys_role "
            +" LEFT JOIN sys_role_menu ON sys_role_menu.role_id = sys_role.role_id "
            +" LEFT JOIN sys_menu ON sys_menu.menu_id = sys_role_menu.menu_id "
            +" WHERE 1=1"
            +" sys_role.del_flag = 0 "
            +" AND sys_menu.del_flag = 0 "
            + "<when test='role!=null'> "
            +" AND sys_role.role_code = #{role} "
            + "</when>"
            +" ORDER BY sys_menu.sort DESC "
            + "</script>")
    @Results({
            @Result(id = true, property = "menuId", column = "red_packet_id"),
            @Result(property = "name", column = "name"),
            @Result(property = "permission", column = "permission"),
            @Result(property = "url", column = "url"),
            @Result(property = "method", column = "method"),
            @Result(property = "parent_id", column = "parent_id"),
            @Result(property = "icon", column = "icon"),
            @Result(property = "path", column = "path"),
            @Result(property = "component", column = "component"),
            @Result(property = "sort", column = "sort"),
            @Result(property = "type", column = "type"),
            @Result(property = "createdTime", column = "created_time"),
            @Result(property = "updatedTime", column = "updated_time"),
            @Result(property = "delFlag", column = "del_flag"),

    })
    List<MenuVo> findMenuByRoleName(@Param("role") String role);
}