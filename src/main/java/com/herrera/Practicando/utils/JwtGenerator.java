package com.herrera.Practicando.utils;

import com.auth0.jwt.JWT;
import com.herrera.Practicando.constants.JwtConstants;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.Instant;
import java.util.Date;

import static com.herrera.Practicando.constants.JwtConstants.*;

public class JwtGenerator {

    public static String generateToken(Authentication auth){
        String[] rolesArray = auth.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .toArray(String[]::new);
        return JWT.create()
                .withSubject(auth.getPrincipal().toString())
                .withExpiresAt(Date.from(Instant.now().plusMillis(EXPIRATION_TIME)))
                .withArrayClaim("Roles", rolesArray)
                .sign(ALGORITHM);
    }

}
