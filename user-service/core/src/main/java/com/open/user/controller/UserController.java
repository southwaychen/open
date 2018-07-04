package com.open.user.controller;


import com.open.api.entity.vo.ResponseCode;
import com.open.api.entity.vo.ResponseWrapper;
import com.open.common.exception.ServiceException;
import com.open.user.api.UserUrl;
import com.open.user.api.entity.vo.UserVO;
import com.open.user.dal.model.UserInfo;
import com.open.user.service.biz.UserInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Tony on 6/10/2018.
 */
@RestController
@RequestMapping(value =UserUrl.SERVICE_PREFIX )
public class UserController {

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping(value = "/get")
    public ResponseWrapper getUser(@RequestBody UserVO userVO){
        ResponseWrapper responseWrapper = new ResponseWrapper();
        UserInfo userInfo = new UserInfo();
        BeanUtils.copyProperties(userVO,userInfo);
        //responseWrapper.setData("hello","world");
        responseWrapper.setData(userInfoService.getUserInfo(userInfo));
        return responseWrapper;
    }

    @RequestMapping(value = UserUrl.FIND_USER_BY_USERNAME)
    public ResponseWrapper findUserByUsername(@PathVariable("username") String username){
        if(StringUtils.isEmpty(username)){
            throw new ServiceException(ResponseCode.RET_PARAM_NOT_FOUND.getCode(),ResponseCode.RET_PARAM_NOT_FOUND.getMsg());
        }
        UserInfo userInfoParam = new UserInfo();
        userInfoParam.setUsername(username);
        UserInfo userInfoResult = userInfoService.getUserInfo(userInfoParam);
        if(userInfoResult == null){
            throw new ServiceException(ResponseCode.RET_USER_DATA_NOT_EXISTS.getCode(),ResponseCode.RET_USER_DATA_NOT_EXISTS.getMsg());
        }
        ResponseWrapper<UserVO> responseWrapper = new ResponseWrapper<UserVO>();
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(userInfoResult,userVO);
        responseWrapper.setData(userVO);
        return responseWrapper;
    }
}
