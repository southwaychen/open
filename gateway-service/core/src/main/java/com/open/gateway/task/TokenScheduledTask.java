package com.open.gateway.task;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * 定时刷新token
 *
 * @author yinjihuan
 * @create 2017-11-09 15:39
 **/
//@Component
public class TokenScheduledTask {
    private static Logger logger = LoggerFactory.getLogger(TokenScheduledTask.class);

    public final static long ONE_Minute = 60 * 1000 * 60 * 20;

    //@Autowired
    //private AuthRemoteClient authRemoteClient;

    /**
     * 刷新Token
     */
    @Scheduled(fixedDelay = ONE_Minute)
    public void reloadApiToken() {
        String token = this.getToken();
        while (StringUtils.isBlank(token)) {
            try {
                Thread.sleep(1000);
                token = this.getToken();
            } catch (InterruptedException e) {
                logger.error("", e);
            }
        }
        System.setProperty("fangjia.auth.token", token);
    }

    public String getToken() {
        //AuthQuery query = new AuthQuery();
       // query.setAccessKey("1");
        //query.setSecretKey("1");
       // ResponseData response = authRemoteClient.auth(query);
       // return response.getData() == null ? "" : response.getData().toString();
        return null;
    }
}
