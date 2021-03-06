package com.example.testcase.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests().antMatchers(HttpMethod.GET, "/admin/**")
                .authenticated()
                .and()
                .authorizeRequests().antMatchers(HttpMethod.GET, "/**")
                .permitAll()
                .and()
                .authorizeRequests().antMatchers(HttpMethod.POST, "/**")
                .permitAll()
                .and()
                .httpBasic();
    }
}
