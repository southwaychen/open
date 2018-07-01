package com.open.user.api.client;


import com.open.api.entity.vo.ResponseWrapper;
import com.open.user.api.UserUrl;
import com.open.user.api.entity.vo.UserVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = UserUrl.SERVICE_NAME)
public interface UserClient {
    /**
     * 通过用户名查询用户、角色信息
     *
     * @param username 用户名
     * @return UserVo
     */
    @RequestMapping(value= UserUrl.USER_FIND_USER_BY_USERNAME,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseWrapper<UserVO> findUserByUsername(@PathVariable("username") String username);

}
