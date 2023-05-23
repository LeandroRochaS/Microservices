package com.leandro.hroauth.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity

public class AppConfig extends WebSecurityConfigurerAdapter {





@Override

public void configure(HttpSecurity http) throws Exception {

    // @formatter:off

    http

        .csrf()

        .disable()

        .exceptionHandling()

           

    .and()

        .authorizeRequests()

        .antMatchers("/hr-oauth/**").permitAll();



    // @formatter:on

}

}
