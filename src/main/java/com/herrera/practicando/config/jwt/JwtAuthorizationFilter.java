package com.herrera.practicando.config.jwt;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.herrera.practicando.utils.TokenHandler;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

    public JwtAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String authToken = Optional.ofNullable(request.getHeader("Authorization")).orElseThrow();
        if(authToken.startsWith("Bearer ")){
            UsernamePasswordAuthenticationToken auth = authenticateToken(authToken);
            SecurityContextHolder.getContext().setAuthentication(auth);
        }
        chain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken authenticateToken(String token){
        token = token.replace("Bearer ", "");
        DecodedJWT decodedToken = TokenHandler.decodeToken(token);
        Set<GrantedAuthority> authoritiesFromToken = decodedToken.getClaim("Roles")
                .asList(String.class).stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toSet());
        return new UsernamePasswordAuthenticationToken(
                decodedToken.getSubject(), null, authoritiesFromToken
        );
    }

}