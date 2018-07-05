package com.open.auth.controller;

import com.open.auth.api.AuthUrl;
import com.open.auth.api.entity.vo.JwtVo;
import com.open.api.entity.vo.ResponseWrapper;
import com.open.api.entity.vo.TrueOrFalseVo;
import com.open.auth.service.biz.AuthService;
import com.open.user.api.client.UserClient;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.InvalidSignatureException;
import org.springframework.security.jwt.crypto.sign.MacSigner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Controller
@RequestMapping(value =AuthUrl.SERVICE_PREFIX)
public class AuthController {

    private static Logger logger = LoggerFactory.getLogger(AuthController.class);
    /**
     * Authorization认证开头是"bearer "
     */
    private static final int BEARER_BEGIN_INDEX = 7;

    @Value("${spring.security.oauth2.jwt.signingKey}")
    private String signingKey;
    @Autowired
    private AuthService authService;

    @Autowired
    private UserClient userClient;
    /**
     * jwt验签
     */
    private MacSigner verifier;
    /**
     * 认证页面
     * @return ModelAndView
     */
    @GetMapping("/require")
    public String require() {
        return "login";
    }

    @RequestMapping(value = AuthUrl.GET_JWT)
    @ResponseBody
    public ResponseWrapper getJwt(@PathVariable("authentication") String authentication){
        ResponseWrapper responseWrapper = new ResponseWrapper();
        Jwt jwt = JwtHelper.decode(StringUtils.substring(authentication, BEARER_BEGIN_INDEX));
        JwtVo jwtVo = new JwtVo();
        BeanUtils.copyProperties(jwt,jwtVo);
        responseWrapper.setData(jwtVo);
        return responseWrapper;
    }

    @RequestMapping(value = AuthUrl.CHECK_PERMISSION)
    @ResponseBody
    public ResponseWrapper checkPermission(HttpServletRequest request, String authentication, String url, String method){
        //token是否有效
        ResponseWrapper responseWrapper = new ResponseWrapper();
        if (invalidJwtAccessToken(authentication)) {
            responseWrapper.setData(new TrueOrFalseVo());
            return responseWrapper;
        }
        //从认证服务获取是否有权限
        Boolean result = authService.decide(new HttpServletRequestAuthWrapper(request, url, method));
        TrueOrFalseVo trueOrFalseVo = new TrueOrFalseVo();
        trueOrFalseVo.setResult(result);
        responseWrapper.setData(trueOrFalseVo);
        return responseWrapper;
    }

    @RequestMapping(value = AuthUrl.FIND_USER_BY_USERNAME)
    @ResponseBody
    public ResponseWrapper findUserByUsername(@PathVariable("username") String username){
        ResponseWrapper responseWrapper = userClient.findUserByUsername(username);
        return responseWrapper;
    }

    private boolean invalidJwtAccessToken(String authentication) {
        verifier = Optional.ofNullable(verifier).orElse(new MacSigner(signingKey));
        //是否无效true表示无效
        boolean invalid = Boolean.TRUE;
        try {
            Jwt jwt = JwtHelper.decode(StringUtils.substring(authentication, BEARER_BEGIN_INDEX));
            jwt.verifySignature(verifier);
            invalid = Boolean.FALSE;
        } catch (InvalidSignatureException | IllegalArgumentException ex) {
            logger.warn("user token has expired or signature error ");
        }
        return invalid;
    }
}
