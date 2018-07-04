package com.open.user.service.biz;

import com.open.user.dal.entity.Role;
import com.open.user.dal.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class RoleService{

    @Autowired
    private RoleMapper roleMapper;

    public Set<Role> queryUserRolesByUserId(String userId) {
        return roleMapper.queryByUserId(userId);
    }

}
