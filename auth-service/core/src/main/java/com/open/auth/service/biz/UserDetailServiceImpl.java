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

package com.open.auth.service.biz;

import com.open.auth.service.client.UserClient;
import com.open.user.api.entity.vo.RoleVo;
import com.open.user.api.entity.vo.UserVo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author lengleng
 * @date 2017/10/26
 * <p>
 */
@Service("userDetailService")
public class UserDetailServiceImpl implements UserDetailsService {

    private static final Log logger = LogFactory.getLog(UserDetailServiceImpl.class);
    @Autowired
    private UserClient userClient;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserVo user = userClient.findUserByUsername(username).getData();
        if(user == null){
            return null;
        }
        Set<GrantedAuthority> grantedAuthorities=new HashSet<GrantedAuthority>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        return new User(user.getUsername(),user.getPassword(),grantedAuthorities);
    }

    /**
     * 获得登录者所有角色的权限集合.
     *
     * @param user
     * @return
     */
    /*private Set<GrantedAuthority> obtainGrantedAuthorities(UserVo user) {
        Set<RoleVo> roles = userClient.queryUserRolesByUserId(user.getUserId()).getData();
        //logger.info("user:{},roles:{}", user.getUsername(), roles);
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getRoleCode()))
                .collect(Collectors.toSet());
    }*/
}
