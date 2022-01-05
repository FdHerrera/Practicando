package com.herrera.practicando.utils;

import org.springframework.security.core.context.SecurityContextHolder;

public class UserGetter {

    public static String getUserFromContext(){
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
    }

}
