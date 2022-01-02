package com.herrera.practicando.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.herrera.practicando.model.AppUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.time.Instant;
import java.util.Date;

import static com.herrera.practicando.constants.JwtConstants.*;

public class TokenHandler {

    public static String generateToken(Authentication auth){
        String[] rolesArray = auth.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .toArray(String[]::new);
        AppUser user = (AppUser) auth.getPrincipal();
        return JWT.create()
                .withSubject(user.getUsername())
                .withExpiresAt(Date.from(Instant.now().plusMillis(EXPIRATION_TIME)))
                .withArrayClaim("Roles", rolesArray)
                .sign(ALGORITHM);
    }

    public static DecodedJWT decodeToken(String token){
        return JWT.require(ALGORITHM).build().verify(token);
    }

}
