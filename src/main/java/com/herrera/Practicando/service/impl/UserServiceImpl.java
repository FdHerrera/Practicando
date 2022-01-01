package com.herrera.Practicando.service.impl;

import com.herrera.Practicando.dto.request.UserRequest;
import com.herrera.Practicando.dto.response.UserResponse;
import com.herrera.Practicando.repository.UserRepo;
import com.herrera.Practicando.service.IUserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements IUserService {

    private final UserRepo userRepo;
    private final ModelMapper mapper;
    private final PasswordEncoder encoder;

    @Override
    public UserResponse signUpUser(UserRequest request) {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
