package com.open.auth.api.entity.vo;

import com.open.api.entity.vo.BaseVo;

public class JwtVo extends BaseVo{

    private byte[] content;
    private byte[] crypto;
    private String claims;

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public byte[] getCrypto() {
        return crypto;
    }

    public void setCrypto(byte[] crypto) {
        this.crypto = crypto;
    }

    public String getClaims() {
        return claims;
    }

    public void setClaims(String claims) {
        this.claims = claims;
    }
}
