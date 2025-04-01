package com.elecxa.repository;

import com.elecxa.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    // Find a role by its name
    Optional<Role> findByRoleName(String roleName);

    // Find a role by its ID (inherited from JpaRepository)
    Optional<Role> findById(Long roleId);
}
