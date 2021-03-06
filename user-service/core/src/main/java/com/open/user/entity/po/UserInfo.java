package com.open.user.entity.po;



import com.open.common.entity.po.BasePo;

import javax.persistence.Id;

/**
 * Created by Tony on 6/10/2018.
 */
public class UserInfo extends BasePo {

    @Id
    private String userId;
    private String username;
    private String password;
    private String avatar;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
