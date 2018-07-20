package com.open.auth.config;

import com.open.auth.security.CustomAccessDeniedHandler;
import com.open.auth.security.CustomAuthenticationFailureHandler;
import com.open.auth.security.CustomAuthenticationSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String LOGIN = "/login";
    private static final String LOGOUT_SUCCESS = "/login?logout";
    private static final String PROFILE = "/profile";

    @Autowired
    @Qualifier("userDetailService")
    private UserDetailsService userDetailsService;

    @Autowired
    private CustomAuthenticationFailureHandler customAuthenticationFailureHandler;

    @Autowired
    private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;

    @Autowired
    private CustomAccessDeniedHandler customAccessDeniedHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // @formatter:off
        http
                // enable cors
                .cors().and().requestMatchers().antMatchers("/oauth/**", "/*").and()
                // These from the above are secured by the following way
                .authorizeRequests().antMatchers("/", LOGIN).permitAll()
                // These from the rest are secured by the following way
                .anyRequest().authenticated().and()
                // Set login page
                .formLogin().loginPage(LOGIN).permitAll().defaultSuccessUrl(PROFILE)
                .failureHandler(customAuthenticationFailureHandler)
                .successHandler(customAuthenticationSuccessHandler)
                // Set logout handling
                .and().logout().logoutSuccessUrl(LOGOUT_SUCCESS)
                .and().exceptionHandling().accessDeniedHandler(customAccessDeniedHandler);
        // @formatter:on
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**","/js/**","/lib/**","/img/**","/skin/**","/actuator/health");
    }


    @Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
       /*authenticationManagerBuilder.inMemoryAuthentication()
               .withUser("root")
               .password("123456")
               .roles("USER");*/
        authenticationManagerBuilder
               .userDetailsService(userDetailsService)
               .passwordEncoder(passwordEncoder());
    }

    // 将 AuthenticationManager 注册为 bean , 方便配置 oauth server 的时候使用
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    /*@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }*/

    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }

}