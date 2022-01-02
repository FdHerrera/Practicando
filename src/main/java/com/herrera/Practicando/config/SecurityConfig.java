package com.herrera.Practicando.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests().antMatchers("/users/sign-up")
                .permitAll()
                .anyRequest()
                .permitAll();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        //TODO check why need to put antMatchers here for sign up
        web.ignoring().antMatchers("/h2-console/**").antMatchers("/users/sign-up");
    }
}
