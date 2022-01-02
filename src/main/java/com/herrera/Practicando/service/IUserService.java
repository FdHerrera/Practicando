package com.herrera.Practicando.service;

import com.herrera.Practicando.dto.request.UserRequest;
import com.herrera.Practicando.dto.response.UserResponse;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService extends UserDetailsService {

    UserResponse signUpUser(UserRequest request);

}
