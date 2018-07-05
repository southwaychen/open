package com.open.user.controller;


import com.open.api.entity.vo.ResponseCode;
import com.open.common.entity.vo.ResponseWrapper;
import com.open.common.exception.ServiceException;
import com.open.user.api.UserUrl;
import com.open.user.api.entity.vo.UserVo;
import com.open.user.dal.entity.Role;
import com.open.user.dal.entity.UserInfo;
import com.open.user.service.biz.RoleService;
import com.open.user.service.biz.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * Created by Tony on 6/10/2018.
 */
@RestController
@RequestMapping(value =UserUrl.SERVICE_PREFIX )
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @RequestMapping(value = UserUrl.FIND_USER_BY_USERNAME)
    public ResponseWrapper findUserByUsername(@PathVariable("username") String username){
        if(StringUtils.isEmpty(username)){
            throw new ServiceException(ResponseCode.RET_PARAM_NOT_FOUND.getCode(),ResponseCode.RET_PARAM_NOT_FOUND.getMsg());
        }
        UserInfo userInfoParam = new UserInfo();
        userInfoParam.setUsername(username);
        UserInfo userInfoResult = userService.getUserInfo(userInfoParam);
        if(userInfoResult == null){
            throw new ServiceException(ResponseCode.RET_USER_DATA_NOT_EXISTS.getCode(),ResponseCode.RET_USER_DATA_NOT_EXISTS.getMsg());
        }
        ResponseWrapper<UserVo> responseWrapper = new ResponseWrapper<UserVo>();
        UserVo userVO = new UserVo();
        BeanUtils.copyProperties(userInfoResult,userVO);
        responseWrapper.setData(userVO);
        return responseWrapper;
    }
    @RequestMapping(value = UserUrl.QUERY_USER_ROLES_BY_USERID)
    public ResponseWrapper queryUserRolesByUserId(@PathVariable("userId") String userId){
        if(StringUtils.isEmpty(userId)){
            throw new ServiceException(ResponseCode.RET_PARAM_NOT_FOUND.getCode(),ResponseCode.RET_PARAM_NOT_FOUND.getMsg());
        }
        Set<Role> roles = roleService.queryUserRolesByUserId(userId);
        ResponseWrapper responseWrapper = new ResponseWrapper();
        responseWrapper.setData(roles);
        return responseWrapper;
    }
}
