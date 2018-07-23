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

package com.open.admin.controller;

import com.open.admin.entity.po.SysMenu;
import com.open.admin.entity.vo.MenuTree;
import com.open.admin.entity.vo.MenuVo;
import com.open.admin.service.biz.SysMenuService;
import com.open.admin.util.TreeUtil;
import com.open.common.constant.CommonConstant;
import com.open.common.entity.vo.ResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @author lengleng
 * @date 2017/10/31
 */
@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private SysMenuService sysMenuService;

    /**
     * 通过角色名称查询用户菜单
     *
     * @param role 角色名称
     * @return 菜单列表
     */
    @GetMapping("/findMenuByRole/{role}")
    public List<MenuVo> findMenuByRole(@PathVariable String role) {
        return sysMenuService.findMenuByRoleName(role);
    }

   /* *//**
     * 返回当前用户的树形菜单集合
     *
     * @return 当前用户的树形菜单
     *//*
    @GetMapping(value = "/userMenu")
    public List<MenuTree> userMenu() {
        // 获取符合条件得菜单
        Set<MenuVo> all = new HashSet<MenuVo>();
        getRole().forEach(roleName -> all.addAll(sysMenuService.findMenuByRoleName(roleName)));
        List<MenuTree> menuTreeList = new ArrayList<>();
        all.forEach(menuVo -> {
            if (CommonConstant.MENU.equals(menuVo.getType())) {
                menuTreeList.add(new MenuTree(menuVo));
            }
        });
        CollUtil.sort(menuTreeList, Comparator.comparingInt(MenuTree::getSort));
        return TreeUtil.bulid(menuTreeList, -1);
    }*/

    /**
     * 返回树形菜单集合
     *
     * @return 树形菜单
     */
    @GetMapping(value = "/allTree")
    public ResponseWrapper<List<MenuTree>> getTree() {
        ResponseWrapper<List<MenuTree>> responseWrapper = new ResponseWrapper<List<MenuTree>>();
        SysMenu condition = new SysMenu();
        condition.setDelFlag(CommonConstant.STATUS_NORMAL);
        responseWrapper.setData(TreeUtil.bulidTree(sysMenuService.select(condition),-1));
        return responseWrapper;
    }
    
    /**
     * 返回角色的菜单集合
     *
     * @param roleName 角色名称
     * @return 属性集合
     */
    @GetMapping("/roleTree/{roleName}")
    public ResponseWrapper<List<Integer>> roleTree(@PathVariable String roleName) {
        ResponseWrapper<List<Integer>> responseWrapper = new ResponseWrapper<List<Integer>>();
        List<MenuVo> menus = sysMenuService.findMenuByRoleName(roleName);
        List<Integer> menuList = new ArrayList<>();
        for (MenuVo menuVo : menus) {
            menuList.add(menuVo.getMenuId());
        }
        responseWrapper.setData(menuList);
        return responseWrapper;
    }

    /**
     * 通过ID查询菜单的详细信息
     *
     * @param id 菜单ID
     * @return 菜单详细信息
     *//*
    @GetMapping("/{id}")
    public SysMenu menu(@PathVariable Integer id) {
        return sysMenuService.selectById(id);
    }

    *//**
     * 新增菜单
     *
     * @param sysMenu 菜单信息
     * @return success/false
     *//*
    @PostMapping
    public R<Boolean> menu(@RequestBody SysMenu sysMenu) {
        return new R<>(sysMenuService.insert(sysMenu));
    }

    *//**
     * 删除菜单
     *
     * @param id 菜单ID
     * @return success/false
     * TODO  级联删除下级节点
     *//*
    @DeleteMapping("/{id}")
    public R<Boolean> menuDel(@PathVariable Integer id) {
        return new R<>(sysMenuService.deleteMenu(id));
    }

    @PutMapping
    public R<Boolean> menuUpdate(@RequestBody SysMenu sysMenu) {
        return new R<>(sysMenuService.updateMenuById(sysMenu));
    }*/

}
