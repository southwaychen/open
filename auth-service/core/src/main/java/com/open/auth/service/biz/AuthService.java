package com.open.auth.service.biz;

import com.open.auth.dal.entity.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AuthService {

    private static Logger logger = LoggerFactory.getLogger(AuthService.class);

    /**
     * 未在资源库中的URL默认标识
     */
    public static final String NONEXISTENT_URL = "NONEXISTENT_URL";

    @Autowired
    private ResourceService resourceService;

    /**
     * 系统中所有权限集合
     */
    Map<RequestMatcher, ConfigAttribute> resourceConfigAttributes= new HashMap() {
        {
            MvcRequestMatcher mvcRequestMatcher1 = new MvcRequestMatcher(new HandlerMappingIntrospector(), "/users");
            mvcRequestMatcher1.setMethod(HttpMethod.resolve("POST"));
            MvcRequestMatcher mvcRequestMatcher2 = new MvcRequestMatcher(new HandlerMappingIntrospector(), "/users/{id}");
            mvcRequestMatcher2.setMethod(HttpMethod.resolve("PUT"));
            MvcRequestMatcher mvcRequestMatcher3 = new MvcRequestMatcher(new HandlerMappingIntrospector(), "/users/{id}");
            mvcRequestMatcher3.setMethod(HttpMethod.resolve("DELETE"));
            MvcRequestMatcher mvcRequestMatcher4 = new MvcRequestMatcher(new HandlerMappingIntrospector(), "/users/{id}");
            mvcRequestMatcher4.setMethod(HttpMethod.resolve("GET"));
            MvcRequestMatcher mvcRequestMatcher5 = new MvcRequestMatcher(new HandlerMappingIntrospector(), "/users/{id}/order");
            mvcRequestMatcher5.setMethod(HttpMethod.resolve("GET"));
            put(mvcRequestMatcher1, new SecurityConfig("user_manager:btn_add"));
            put(mvcRequestMatcher2, new SecurityConfig("user_manager:btn_edit"));
            put(mvcRequestMatcher3, new SecurityConfig("user_manager:btn_del"));
            put(mvcRequestMatcher4, new SecurityConfig("user_manager:view"));
            put(mvcRequestMatcher5, new SecurityConfig("user_order:view"));
        }
    };


    /**
     * @param authRequest 访问的url,method
     * @return 有权限true, 无权限或全局资源中未找到请求url返回否
     */
    public boolean decide(HttpServletRequest authRequest) {
        logger.debug("正在访问的url是:{}，method:{}", authRequest.getServletPath(), authRequest.getMethod());
        //获取用户认证信息
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        //获取此url，method访问对应的权限资源信息
        ConfigAttribute urlConfigAttribute = findConfigAttributesByUrl(authRequest);
        if (NONEXISTENT_URL.equals(urlConfigAttribute.getAttribute()))
            logger.debug("url未在资源池中找到，拒绝访问");
        //获取此访问用户所有角色拥有的权限资源
        Set<Resource> userResources = findResourcesByAuthorityRoles(authentication.getAuthorities());
        //用户拥有权限资源 与 url要求的资源进行对比
        return isMatch(urlConfigAttribute, userResources);
    }

    /**
     * url对应资源与用户拥有资源进行匹配
     *
     * @param urlConfigAttribute
     * @param userResources
     * @return
     */
    public boolean isMatch(ConfigAttribute urlConfigAttribute, Set<Resource> userResources) {
        return userResources.stream().anyMatch(resource -> resource.getCode().equals(urlConfigAttribute.getAttribute()));
    }

    /**
     * 根据url和method查询到对应的权限信息
     *
     * @param authRequest
     * @return
     */
    public ConfigAttribute findConfigAttributesByUrl(HttpServletRequest authRequest) {
        return this.resourceConfigAttributes.keySet().stream()
                .filter(requestMatcher -> requestMatcher.matches(authRequest))
                .map(requestMatcher -> this.resourceConfigAttributes.get(requestMatcher))
                .peek(urlConfigAttribute -> logger.debug("url在资源池中配置：{}", urlConfigAttribute.getAttribute()))
                .findFirst()
                .orElse(new SecurityConfig(NONEXISTENT_URL));
    }

    /**
     * 根据用户所被授予的角色，查询到用户所拥有的资源
     *
     * @param authorityRoles
     * @return
     */
    private Set<Resource> findResourcesByAuthorityRoles(Collection<? extends GrantedAuthority> authorityRoles) {
        //用户被授予的角色
        logger.debug("用户的授权角色集合信息为:{}", authorityRoles);
        String[] authorityRoleCodes = authorityRoles.stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList())
                .toArray(new String[authorityRoles.size()]);
        Set<Resource> resources = resourceService.queryByRoleCodes(authorityRoleCodes);
        if (logger.isDebugEnabled()) {
            logger.debug("用户被授予角色的资源数量是:{}, 资源集合信息为:{}", resources.size(), resources);
        }
        return resources;
    }

}
