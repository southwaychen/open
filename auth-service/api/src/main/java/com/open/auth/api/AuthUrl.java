package com.open.auth.api;

/**
 * Created by liubin on 2016/3/30.
 */
public interface AuthUrl {

    public final static String SERVICE_NAME = "auth-service";

    public final static String SERVICE_PREFIX = "/auth";

    public final static String FIND_USER_BY_USERNAME = "/findUserByUsername/{username}";

    public final static String GET_JWT = "/getJwt/{authentication}";

    public final static String AUTH_GET_JWT = SERVICE_PREFIX + "/getJwt/{authentication}";

    public final static String CHECK_PERMISSION = "/checkPermission/{authentication}/{url}/{method}";

    public final static String AUTH_CHECK_PERMISSION = SERVICE_PREFIX + "/checkPermission/{authentication}/{url}/{method}";

}
