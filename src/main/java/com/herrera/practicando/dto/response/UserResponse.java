package com.herrera.practicando.dto.response;

import com.herrera.practicando.dto.RoleDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
public class UserResponse {
    private String username;
    private Set<RoleDto> roles;
}
