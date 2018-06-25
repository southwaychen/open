package com.open.auth.controller;

import com.crt.open.api.AuthUrl;
import com.open.auth.service.client.UserClient;
import com.open.common.constant.SecurityConstants;
import com.open.common.controller.ResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(value =AuthUrl.SERVICE_PREFIX)
public class AuthController {

    @Autowired
    private UserClient userServiceClient;
    @Autowired
    @Qualifier("consumerTokenServices")
    private ConsumerTokenServices consumerTokenServices;


    /**
     * 认证页面
     * @return ModelAndView
     */
    @GetMapping("/require")
    public ModelAndView require() {
        return new ModelAndView("ftl/login");
    }

    /**
     * 用户信息校验
     * @param authentication 信息
     * @return 用户信息
     */
    @RequestMapping("/user")
    public Object user(Authentication authentication) {
        return authentication.getPrincipal();
    }

    /**
     * 清除Redis中 accesstoken refreshtoken
     *
     * @param accesstoken  accesstoken
     * @return true/false
     */
    @PostMapping("/removeToken")
    @CacheEvict(value = SecurityConstants.TOKEN_USER_DETAIL, key = "#accesstoken")
    public ResponseWrapper removeToken(String accesstoken) {
        ResponseWrapper responseWrapper = new ResponseWrapper();
        consumerTokenServices.revokeToken(accesstoken);
        return responseWrapper;
    }

    @RequestMapping(value = AuthUrl.FIND_USER_BY_USERNAME)
    public ResponseWrapper findUserByUsername(@PathVariable("username") String username){
        ResponseWrapper responseWrapper = userServiceClient.findUserByUsername(username);
        return responseWrapper;
    }
}
