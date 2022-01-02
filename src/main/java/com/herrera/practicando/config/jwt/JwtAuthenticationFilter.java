package com.herrera.practicando.config.jwt;

import com.herrera.practicando.utils.JwtGenerator;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

@AllArgsConstructor
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        Optional<String> username = Optional.ofNullable(obtainUsername(request));
        Optional<String> password = Optional.ofNullable(obtainPassword(request));
        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
                username.orElseThrow(),
                password.orElseThrow(),
                new ArrayList<>()
        );
        this.setDetails(request, auth);
        return authenticationManager.authenticate(auth);

    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        String token  = JwtGenerator.generateToken(authResult);
        response.addHeader("Token", token);
        response.getWriter().flush();
        chain.doFilter(request, response);
    }
}