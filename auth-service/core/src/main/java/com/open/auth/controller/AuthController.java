package com.open.auth.controller;

import com.crt.open.api.AuthUrl;
import com.open.auth.service.client.UserClient;
import com.open.common.controller.ResponseWrapper;
import com.open.user.api.UserUrl;
import com.open.user.api.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value =AuthUrl.SERVICE_PREFIX)
public class AuthController {

    @Autowired
    private UserClient userServiceClient;

    @RequestMapping(value = AuthUrl.FIND_USER_BY_USERNAME)
    public ResponseWrapper findUserByUsername(@PathVariable("username") String username){
        ResponseWrapper responseWrapper = userServiceClient.findUserByUsername(username);
        return responseWrapper;
    }
}
