package com.open.admin.service.biz;

import com.open.admin.entity.po.SysMenu;
import com.open.admin.entity.vo.MenuVo;
import com.open.admin.mapper.SysMenuMapper;
import com.open.common.constant.CommonConstant;
import com.open.core.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysMenuService extends BaseService<SysMenu>{

    @Autowired
    private SysMenuMapper sysMenuMapper;


    @Cacheable(value = "menu_details", key = "#role  + '_menu'")
    public List<MenuVo> findMenuByRoleName(String role) {
        return sysMenuMapper.findMenuByRoleName(role);
    }


    @CacheEvict(value = "menu_details", allEntries = true)
    public void deleteMenu(Integer id) {
        // 删除当前节点
        SysMenu condition1 = new SysMenu();
        condition1.setMenuId(id);
        condition1.setDelFlag(CommonConstant.STATUS_DEL);
        sysMenuMapper.updateByPrimaryKeySelective(condition1);

        // 删除父节点为当前节点的节点
        SysMenu conditon2 = new SysMenu();
        conditon2.setParentId(id);
        SysMenu sysMenu = new SysMenu();
        sysMenu.setDelFlag(CommonConstant.STATUS_DEL);
        sysMenuMapper.updateByPrimaryKeySelective(conditon2);
    }


    @CacheEvict(value = "menu_details", allEntries = true)
    public int updateMenuById(SysMenu sysMenu) {
        return sysMenuMapper.updateByPrimaryKeySelective(sysMenu);
    }
}
