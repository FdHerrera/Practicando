package com.herrera.practicando.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.herrera.practicando.dto.RoleDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class UserResponse {
    private String username;
    private String firstName;
    private String lastName;
    private Set<RoleDto> roles;
}
