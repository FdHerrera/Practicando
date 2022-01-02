package com.herrera.practicando.exceptionhandler.controller;

import com.herrera.practicando.exceptionhandler.response.FailedValidationsResponse;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice(annotations = RestController.class)
public class ExceptionsController {

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<FailedValidationsResponse> validationsFailedHandler(MethodArgumentNotValidException exception) {
        return exception.getBindingResult().getAllErrors()
                .stream().map(this::mapResponse)
                .collect(Collectors.toList());
    }

    private FailedValidationsResponse mapResponse(ObjectError objectError) {
        if (objectError instanceof FieldError) {
            return new FailedValidationsResponse(((FieldError) objectError).getField(),
                    objectError.getDefaultMessage());
        }
        return new FailedValidationsResponse(objectError.getObjectName(), objectError.getDefaultMessage());
    }
}