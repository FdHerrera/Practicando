package com.herrera.practicando.exceptionhandler.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NotFoundResponse {
    private String message;
    private String notFound;
}
