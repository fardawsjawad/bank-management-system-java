package com.bankapp.service;

import com.bankapp.model.UserRole;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public interface UserRoleService {

    Long createUserRole(UserRole userRole);

    Optional<UserRole> getRoleById(Long id);
    Optional<UserRole> getRoleByUserId(Long userId);
    List<UserRole> getAllUserRoles();

    boolean updateRole(UserRole userRole);

    boolean deleteRole(Long roleId);

}
