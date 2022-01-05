package com.herrera.practicando.service;

import com.herrera.practicando.dto.request.UserRequest;
import com.herrera.practicando.dto.response.UserResponse;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService extends UserDetailsService {

    UserResponse signUpUser(UserRequest request);

}
