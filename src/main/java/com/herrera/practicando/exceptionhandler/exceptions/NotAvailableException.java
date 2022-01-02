package com.herrera.practicando.exceptionhandler.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class NotAvailableException extends RuntimeException{

    private String notAvailable;

    public NotAvailableException(String message, String notAvailable){
        super(message);
        this.notAvailable = notAvailable;
    }

}
