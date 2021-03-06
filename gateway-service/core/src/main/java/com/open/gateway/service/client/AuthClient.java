package com.open.gateway.service.client;

import com.open.api.entity.vo.TrueOrFalseVo;
import com.open.auth.api.AuthUrl;
import com.open.auth.api.entity.vo.AuthVo;
import com.open.auth.api.entity.vo.JwtVo;
import com.open.common.entity.vo.ResponseWrapper;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = AuthUrl.SERVICE_NAME)
public interface AuthClient {

    @RequestMapping(value= AuthUrl.AUTH_GET_JWT,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseWrapper<JwtVo> getJwt(@PathVariable("authentication") String authentication);
    @RequestMapping(value= AuthUrl.AUTH_CHECK_PERMISSION,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseWrapper<TrueOrFalseVo> checkPermission(@RequestBody AuthVo authVo);
}
