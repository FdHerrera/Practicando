package com.herrera.Practicando.repository;

import com.herrera.Practicando.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepo extends JpaRepository<Role, Long> {
    Optional<Role> findByRoleName(String roleName);
}
