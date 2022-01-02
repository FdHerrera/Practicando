package com.herrera.practicando.constants;

import com.auth0.jwt.algorithms.Algorithm;

public class JwtConstants {
    public static final Long EXPIRATION_TIME = 1000000L;
    public static final Algorithm ALGORITHM = Algorithm.HMAC512("Ultra_Secreto".getBytes());
}
