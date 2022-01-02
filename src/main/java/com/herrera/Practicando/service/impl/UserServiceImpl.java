package com.herrera.Practicando.service.impl;

import com.herrera.Practicando.dto.request.UserRequest;
import com.herrera.Practicando.dto.response.UserResponse;
import com.herrera.Practicando.exceptionhandler.exceptions.NotFoundException;
import com.herrera.Practicando.exceptionhandler.exceptions.UsernameNotAvailableException;
import com.herrera.Practicando.model.AppUser;
import com.herrera.Practicando.model.Role;
import com.herrera.Practicando.model.User;
import com.herrera.Practicando.repository.RoleRepo;
import com.herrera.Practicando.repository.UserRepo;
import com.herrera.Practicando.service.IUserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.function.Consumer;

@Service
@AllArgsConstructor
public class UserServiceImpl implements IUserService {

    private final UserRepo userRepo;
    private final ModelMapper mapper;
    private final PasswordEncoder encoder;
    private final RoleRepo roleRepo;

    @Override
    public UserResponse signUpUser(UserRequest request) {
        userRepo.findByUsername(request.getUsername())
                .ifPresent( user -> throwException(
                        new UsernameNotAvailableException("This username is not available", user.getUsername())
                ));
        String encodedPass = encoder.encode(request.getPassword());
        User newUser = User.builder()
                .username(request.getUsername())
                .password(encodedPass)
                .roles(loadDefaultRoles()).build();
        userRepo.save(newUser);
        return mapper.map(newUser, UserResponse.class);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new AppUser(
                userRepo.findByUsername(username)
                        .orElseThrow(() -> new NotFoundException("User not found", username))
        );
    }

    private Set<Role> loadDefaultRoles(){
        String userRole = "ROLE_USER";
        return Set.of(
                roleRepo.findByRoleName(userRole)
                        .orElseThrow( () -> new NotFoundException("Role not found",  userRole))
        );
    }

    private void throwException(RuntimeException toThrow){
        throw toThrow;
    }

}
