package com.bankapp.service.impl;

import com.bankapp.dao.UserDAO;
import com.bankapp.dao.UserRoleDAO;
import com.bankapp.exception.service_exceptions.user_role.InvalidUserRoleDataException;
import com.bankapp.exception.service_exceptions.user_role.UserRoleCreationException;
import com.bankapp.exception.service_exceptions.user_role.UserRoleException;
import com.bankapp.exception.service_exceptions.user_role.UserRoleNotFoundException;
import com.bankapp.exception.service_exceptions.user_service.UserNotFoundException;
import com.bankapp.model.Role;
import com.bankapp.model.UserRole;
import com.bankapp.service.UserRoleService;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleDAO userRoleDAO;
    private final UserDAO  userDAO;

    public UserRoleServiceImpl(UserRoleDAO userRoleDAO, UserDAO userDAO) {
        this.userRoleDAO = userRoleDAO;
        this.userDAO = userDAO;
    }

    @Override
    public Long createUserRole(UserRole userRole) {
        if (userRole == null) {
            throw new InvalidUserRoleDataException("userRole must not be null");
        }

        if (userRole.getUserId() == null) {
            throw new InvalidUserRoleDataException("userId must not be null");
        }

        if (!userDAO.userExistsByUserId(userRole.getUserId())) {
            throw new UserNotFoundException("User with ID: " + userRole.getUserId() + " does not exist");
        }

        userRole.setUserRole(Role.USER);

        Long  userRoleId = userRoleDAO.createUserRole(userRole);
        if (userRoleId == null) {
            throw new UserRoleCreationException("Failed to create user role");
        }

        return userRoleId;
    }

    @Override
    public Optional<UserRole> getRoleById(Long id) {
        if (id == null) {
            throw new InvalidUserRoleDataException("id must not be null");
        }

        return userRoleDAO.getRoleById(id);
    }

    @Override
    public Optional<UserRole> getRoleByUserId(Long userId) {
        if (userId == null) {
            throw new  InvalidUserRoleDataException("userId must not be null");
        }

        return userRoleDAO.getRoleByUserId(userId);
    }

    @Override
    public List<UserRole> getAllUserRoles() {
        return userRoleDAO.getAllUserRoles();
    }

    @Override
    public boolean updateRole(UserRole userRole) {
        if (userRole == null) {
            throw new InvalidUserRoleDataException("userRole must not be null");
        }

        if (userRole.getRoleId() == null) {
            throw new InvalidUserRoleDataException("roleId must not be null");
        }

        if (userRole.getUserId() == null) {
            throw new InvalidUserRoleDataException("userId must not be null");
        }

        if (!userDAO.userExistsByUserId(userRole.getUserId())) {
            throw new UserNotFoundException("User with ID: " + userRole.getUserId() + " does not exist");
        }


        UserRole currentRole = userRoleDAO.getRoleById(userRole.getRoleId())
                .orElseThrow(() ->
                        new UserRoleNotFoundException(
                                "Role with ID: " + userRole.getRoleId() + " does not exist"
                        )
                );

        if (currentRole.getUserRole().equals(userRole.getUserRole())) {
            throw new UserRoleException(
                    "Current user role is already " + userRole.getUserRole()
            );
        }

        boolean success = userRoleDAO.updateRole(userRole);
        if (!success) {
            throw new UserRoleException("Failed to update user role");
        }

        return true;
    }

    @Override
    public boolean deleteRole(Long roleId) {
        if (roleId == null) {
            throw new InvalidUserRoleDataException("roleId must not be null");
        }

        UserRole currentRole = userRoleDAO.getRoleById(roleId)
                .orElseThrow(() ->
                        new UserRoleNotFoundException(
                                "Role with ID: " + roleId + " does not exist"
                        )
                );

        if (currentRole.getUserRole().equals(Role.ADMIN)) {
            throw new UserRoleException("Cannot delete admin role");
        }

        boolean success = userRoleDAO.deleteRole(roleId);
        if (!success) {
            throw new UserRoleException("Failed to delete user role");
        }

        return true;
    }
}
