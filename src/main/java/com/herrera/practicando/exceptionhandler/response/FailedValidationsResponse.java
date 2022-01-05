package com.herrera.practicando.exceptionhandler.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FailedValidationsResponse {
    private String field;
    private String message;
}
