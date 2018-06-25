package com.crt.open.api;

/**
 * Created by liubin on 2016/3/30.
 */
public interface OpenUrl {

    public final static String SERVICE_NAME = "OPEN-SERVICE";

    public final static String SECURE = "/secure";

    public final static String LOGIN = "/login";

    public final static String DOLOGIN ="/dologin";

    public final static String LOGOUT ="/logout";

    /*
    *   for user
    * */
    public final static String USER = "/user";

    public final static String USER_MGR = "/mgr/user";

    public final static String USER_REGISTER = "/userRegister";

    public final static String USER_QUERY ="/userQuery";

    public final static String USER_QUERY_BY_USERNAME = "userQueryByUsername";

    public final static String USER_PAGE = "/userPage";

    public final static String USER_PWD_CHECK = "/userPwdCheck";

    public final static String USER_PWD_RESET ="/userPwdReset";

    public final static String USER_UPDATE = "/userUpdate";

    public final static String USER_PWD_MODIFY = "/userPwdModify";

    public final static String USER_ADD = "/userAdd";

    public final static String USER_REMOVE ="/userRemove";

    /*
    *   for topic
    * */
    public final static String TOPIC ="/topic";

    public final static String TOPIC_MGR ="/mgr/topic";

    public final static String TOPIC_LIST = "/topicList";

    public final static String TOPIC_PAGE = "/topicPage";

    public final static String TOPIC_ADD = "/topicAdd";

    public final static String TOPIC_REMOVE = "/topicRemove";

    public final static String TOPIC_UPDATE = "/topicUpdate";

    public final static String TOPIC_MIN_LIST = "/topicMinList";

    public final static String TOPIC_MAX_LIST ="/topicMaxList";

    /*
    *   for doc
    * */
    public final static String DOC ="/doc";

    public final static String DOC_MGR ="/mgr/doc";

    public final static String DOC_QUERY = "/docQuery";

    public final static String DOC_LIST = "/docList";

    public final static String DOC_PAGE = "/docPage";

    public final static String DOC_ADD = "/docAdd";

    public final static String DOC_REMOVE = "/docRemove";

    public final static String DOC_UPDATE = "/docUpdate";


    /*
    *   for catalog
    * */
    public final static String CATALOG ="/catalog";

    public final static String CATALOG_MGR ="/mgr/catalog";

    public final static String CATALOG_LIST = "/catalogList";

    public final static String CATALOG_PAGE = "/catalogPage";

    public final static String CATALOG_ADD = "/catalogAdd";

    public final static String CATALOG_REMOVE = "/catalogRemove";

    public final static String CATALOG_UPDATE = "/catalogUpdate";


    /*
    *   for api
    * */
    public final static String API ="/api";

    public final static String API_MGR ="/mgr/api";

    public final static String API_LIST = "/apiList";

    public final static String API_PAGE = "/apiPage";

    public final static String API_QUERY = "/apiQuery";

    public final static String API_INVOKE ="/apiInvoke";

    public final static String API_ADD = "/apiAdd";

    public final static String API_REMOVE = "/apiRemove";

    public final static String API_UPDATE = "/apiUpdate";
    /**
     * for help
     */
    public final static String HELP ="/help";

    public final static String HELP_MGR ="/mgr/help";

    public final static String HELP_LIST ="/helpList";

    public final static String HELP_ADD ="/helpAdd";

    public final static String HELP_UPDATE ="/helpUpdate";

    public final static String HELP_REMOVE ="/helpRemove";

    public final static String PROFILE ="/profile";

    public final static String ORG_LIST = "/orgList";

    public final static String SYS_LIST = "/sysList";

    public final static String APP_LIST = "/appList";

    public final static String LOG_LIST = "/logList";

    public final static String SUB_LIST = "/subList";

    public final static String ORG_REFRESH = "/orgRefresh";

    public final static String SYS_REFRESH = "/sysRefresh";

    public final static String APP_REFRESH = "/appRefresh";

    public final static String SUB_REFRESH = "/subRefresh";

    public final static String ES_SEARCH ="/search";

}
