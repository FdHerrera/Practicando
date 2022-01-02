package com.herrera.Practicando.dto.response;

import com.herrera.Practicando.dto.RoleDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
public class UserResponse {
    private String username;
    private Set<RoleDto> roles;
}
