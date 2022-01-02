package com.herrera.practicando.exceptionhandler.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class UsernameNotAvailableException extends RuntimeException{

    private String username;

    public UsernameNotAvailableException(String message, String username){
        super(message);
        this.username = username;
    }

}
