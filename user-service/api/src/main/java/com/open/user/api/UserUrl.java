package com.open.user.api;

/**
 * Created by liubin on 2016/3/30.
 */
public interface UserUrl {

    public final static String SERVICE_NAME = "user-service";

    public final static String SERVICE_PREFIX = "/user";

    public final static String FIND_USER_BY_USERNAME = "/findUserByUsername/{username}";

    public final static String USER_FIND_USER_BY_USERNAME = SERVICE_PREFIX + FIND_USER_BY_USERNAME;
}
