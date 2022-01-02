package com.herrera.practicando.controller;

import com.herrera.practicando.dto.request.UserRequest;
import com.herrera.practicando.dto.response.UserResponse;
import com.herrera.practicando.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/users")
@AllArgsConstructor
public class AuthController {

    private final IUserService userService;

    @PostMapping(path = "sign-up")
    public ResponseEntity<UserResponse> signUpUser (@RequestBody UserRequest request){
        UserResponse response = userService.signUpUser(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
