package com.herrera.practicando.service.impl;

import com.herrera.practicando.dto.request.UserRequest;
import com.herrera.practicando.dto.response.UserResponse;
import com.herrera.practicando.exceptionhandler.exceptions.NotFoundException;
import com.herrera.practicando.exceptionhandler.exceptions.NotAvailableException;
import com.herrera.practicando.model.AppUser;
import com.herrera.practicando.model.Role;
import com.herrera.practicando.model.User;
import com.herrera.practicando.repository.RoleRepo;
import com.herrera.practicando.repository.UserRepo;
import com.herrera.practicando.service.IUserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

import static com.herrera.practicando.utils.Thrower.throwException;

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
                        new NotAvailableException("This username is not available", user.getUsername())
                ));
        String encodedPass = encoder.encode(request.getPassword());
        User newUser = User.builder()
                .username(request.getUsername())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .password(encodedPass)
                .roles(loadDefaultRoles()).build();
        userRepo.save(newUser);
        return mapper.map(newUser, UserResponse.class);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username)
                .orElseThrow(() -> new NotFoundException("User not found", username));
        return new AppUser(
                user,
                user.getRoles().stream()
                        .map(role -> new SimpleGrantedAuthority(role.getRoleName()))
                        .collect(Collectors.toSet())
        );
    }

    private Set<Role> loadDefaultRoles(){
        String userRole = "ROLE_USER";
        return Set.of(
                roleRepo.findByRoleName(userRole)
                        .orElseThrow( () -> new NotFoundException("Role not found",  userRole))
        );
    }


}
