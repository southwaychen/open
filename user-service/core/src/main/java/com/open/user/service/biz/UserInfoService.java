package com.open.user.service.biz;

import com.open.api.entity.vo.ResponseCode;
import com.open.common.exception.ServiceException;
import com.open.common.util.UuidUtils;
import com.open.user.dal.mapper.UserInfoMapper;
import com.open.user.dal.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Tony on 6/10/2018.
 */
@Service
public class UserInfoService{

    @Autowired
    private UserInfoMapper userInfoMapper;

    public void addUserInfo(UserInfo userInfo){
        if (userInfo != null && userInfo.getUserId() == null) {
            userInfo.setUserId(UuidUtils.uuid());
        }
        userInfoMapper.insertSelective(userInfo);
    }

    public void updateUserInfo(UserInfo userInfo) {
        userInfoMapper.updateByPrimaryKeySelective(userInfo);
    }

    public UserInfo getUserInfo(UserInfo userInfo){
        if(userInfo == null){
           throw new ServiceException(ResponseCode.RET_PARAM_NOT_FOUND.getCode(),ResponseCode.RET_PARAM_NOT_FOUND.getMsg());
        }
        return userInfoMapper.selectOne(userInfo);
    }
}
