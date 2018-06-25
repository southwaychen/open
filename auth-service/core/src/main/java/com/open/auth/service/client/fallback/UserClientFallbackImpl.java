package com.open.auth.service.client.fallback;

import com.open.auth.service.client.UserClient;
import com.open.common.controller.ResponseWrapper;
import com.open.user.api.vo.UserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by Tony on 6/23/2018.
 */
@Service
public class UserClientFallbackImpl implements UserClient{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public ResponseWrapper<UserVO> findUserByUsername(String username) {
        logger.error("调用{}异常:{}", "findUserByUsername", username);
        return null;
    }
}
