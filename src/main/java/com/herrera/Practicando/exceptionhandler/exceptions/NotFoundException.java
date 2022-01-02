package com.herrera.Practicando.exceptionhandler.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class NotFoundException extends RuntimeException{

    private String notFound;

    public NotFoundException(String message, String notFound){
        super(message);
        this.notFound = notFound;
    }

}
