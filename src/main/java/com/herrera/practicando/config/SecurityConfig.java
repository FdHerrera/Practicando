package com.herrera.practicando.config;

import com.herrera.practicando.config.jwt.JwtAuthenticationFilter;
import com.herrera.practicando.config.jwt.JwtAuthorizationFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        JwtAuthenticationFilter jwtAuthFilter = new JwtAuthenticationFilter(authenticationManager());
        http
                .addFilterBefore(jwtAuthFilter, JwtAuthenticationFilter.class);
        http
                .cors().and()
                .csrf().disable().authorizeRequests()
                .antMatchers("/test").access("hasAnyRole('ROLE_ADMIN')")
                .antMatchers("/users/sign-up").permitAll()
                .anyRequest().authenticated()
                .and().addFilter(new JwtAuthorizationFilter(authenticationManager()))
                .formLogin()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        //TODO check why need to put antMatchers here for sign up
        web.ignoring()
                .antMatchers("/h2-console/**")
                .antMatchers("/users/sign-up");
    }
}
