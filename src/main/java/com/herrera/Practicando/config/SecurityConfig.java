package com.herrera.Practicando.config;

import com.herrera.Practicando.config.jwt.JwtAuthenticationFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        JwtAuthenticationFilter jwtAuthFilter = new JwtAuthenticationFilter(authenticationManager());
        jwtAuthFilter.setFilterProcessesUrl("/login");

        http
                .csrf().disable()
                .formLogin().and()
                .authorizeRequests().antMatchers("/users/sign-up")
                .permitAll()
                .anyRequest()
                .permitAll().and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http
                .addFilter(jwtAuthFilter);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        //TODO check why need to put antMatchers here for sign up
        web.ignoring()
                .antMatchers("/h2-console/**")
                .antMatchers("/users/sign-up");
    }
}
