package com.open.auth.service.client;


import com.open.common.entity.vo.ResponseWrapper;
import com.open.user.api.UserUrl;
import com.open.user.api.entity.vo.RoleVO;
import com.open.user.api.entity.vo.UserVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@FeignClient(name = UserUrl.SERVICE_NAME)
public interface UserClient {
    /**
     * 通过用户名查询用户、角色信息
     *
     * @param username 用户名
     * @return UserVo
     */
    @RequestMapping(value= UserUrl.USER_FIND_USER_BY_USERNAME,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseWrapper<UserVo> findUserByUsername(@PathVariable("username") String username);
    @RequestMapping(value= UserUrl.USER_QUERY_USER_ROLES_BY_USERID,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseWrapper<Set<RoleVO>> queryUserRolesByUserId(@PathVariable("userId") String userId);

}
