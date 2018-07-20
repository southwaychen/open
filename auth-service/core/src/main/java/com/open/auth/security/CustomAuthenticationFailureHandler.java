package com.open.auth.security;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.open.common.entity.vo.ResponseCode;
import com.open.common.entity.vo.ResponseWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Component
public class CustomAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {
    private Logger log = LoggerFactory.getLogger(this.getClass());
    private String failureUrl = "/login";


    @Override
    public void onAuthenticationFailure(HttpServletRequest request,
                                        HttpServletResponse response, AuthenticationException exception)
            throws IOException, ServletException {
        String username = request.getParameter("username");
        logger.debug(username + " try to login");

        boolean isAjax = "XMLHttpRequest".equals(request
                .getHeader("X-Requested-With")) || "apiLogin".equals(request
                .getHeader("api-login"));
        if (isAjax) {
            response.setHeader("Content-Type", "application/json;charset=UTF-8");
            try {
                ResponseWrapper responseWrapper = new ResponseWrapper();
                responseWrapper.setCode(ResponseCode.RET_PARAM_USERNAME_PWD_INVALID.getCode());
                responseWrapper.setMsg(ResponseCode.RET_PARAM_USERNAME_PWD_INVALID.getMsg());
                ObjectMapper objectMapper = new ObjectMapper();
                JsonGenerator jsonGenerator = objectMapper.getFactory().createGenerator(response.getOutputStream(),
                        JsonEncoding.UTF8);
                objectMapper.writeValue(jsonGenerator, responseWrapper);
            } catch (Exception ex) {
                if (logger.isErrorEnabled()) {
                    logger.error("Could not write JSON:", ex);
                }
                throw new HttpMessageNotWritableException("Could not write JSON: " + ex.getMessage(), ex);
            }
        } else {
            String encodedId = "";
            try {
                encodedId = URLEncoder.encode("用户名和密码不匹配", "UTF-8");
            } catch (UnsupportedEncodingException e) {
                if (logger.isErrorEnabled()) {
                    logger.error("encodedId", e);
                }
            }
            response.sendRedirect(failureUrl + "?authentication_error=true&loginMessage=" + encodedId);
        /*super.onAuthenticationFailure(request, response, exception);*/
        }
    }
}
