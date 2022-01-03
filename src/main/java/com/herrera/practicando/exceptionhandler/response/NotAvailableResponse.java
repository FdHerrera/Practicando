package com.herrera.practicando.exceptionhandler.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NotAvailableResponse {
    private String message;
    private String unavailable;
}
