package com.open.auth.api.entity.vo;

import com.open.api.entity.vo.BaseVo;

public class AuthVo extends BaseVo {

    private String authentication;
    private String url;
    private String method;

    public String getAuthentication() {
        return authentication;
    }

    public void setAuthentication(String authentication) {
        this.authentication = authentication;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
