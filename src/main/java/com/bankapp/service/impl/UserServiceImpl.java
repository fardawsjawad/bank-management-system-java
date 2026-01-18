package com.bankapp.service.impl;

import com.bankapp.config.DBConnectionPoolUtil;
import com.bankapp.dao.EmploymentProfileDAO;
import com.bankapp.dao.UserAddressDAO;
import com.bankapp.dao.UserDAO;
import com.bankapp.dao.UserRoleDAO;
import com.bankapp.exception.service_exceptions.user_service.*;
import com.bankapp.model.*;
import com.bankapp.security.PasswordHasher;
import com.bankapp.service.UserService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;
    private final UserAddressDAO  userAddressDAO;
    private final EmploymentProfileDAO employmentProfileDAO;
    private final UserRoleDAO  userRoleDAO;

    public UserServiceImpl(UserDAO userDAO, UserAddressDAO userAddressDAO,
                           EmploymentProfileDAO employmentProfileDAO,
                           UserRoleDAO userRoleDAO) {

        this.userDAO = userDAO;
        this.userAddressDAO = userAddressDAO;
        this.employmentProfileDAO = employmentProfileDAO;
        this.userRoleDAO = userRoleDAO;
    }

    @Override
    public Long createUser(User user, UserAddress userAddress, EmploymentProfile employmentProfile) {
        if (user == null) {
            throw new InvalidUserDataException("User cannot be null");
        }

        if (userDAO.userExistsByEmail(user.getEmail())) {
            throw new UserAlreadyExistsException("Email already exists: " + user.getEmail());
        }

        try (Connection connection = DBConnectionPoolUtil.getConnection()) {

            connection.setAutoCommit(false);

            user.setPasswordHash(PasswordHasher.hashPassword(user.getPasswordHash()));
            Long userId = userDAO.createUser(user, connection);
            if (userId == null) {
                connection.rollback();
                throw new UserCreationException("Failed to create user");
            }

            if (userAddress != null) {
                userAddress.setUserId(userId);
                Long addressId = userAddressDAO.createUserAddress(userAddress, connection);

                if (addressId == null) {
                    connection.rollback();
                    throw new UserCreationException("Failed to create user address");
                }
            }

            if  (employmentProfile != null) {
                employmentProfile.setUserId(userId);
                Long employmentProfileId = employmentProfileDAO.createEmploymentProfile(employmentProfile, connection);

                if (employmentProfileId == null) {
                    connection.rollback();
                    throw new UserCreationException("Failed to create employment profile");
                }
            }

            UserRole userRole = new UserRole(
                    userId, Role.USER
            );
            Long roleId = userRoleDAO.createUserRole(userRole, connection);

            if (roleId == null) {
                connection.rollback();
                throw new UserCreationException("Failed to create user role");
            }

            connection.commit();
            return userId;

        } catch (SQLException e) {
            throw new UserCreationException("Database error: " +  e.getMessage(), e);
        }
    }

    @Override
    public Optional<User> getUserById(Long userId) {
        if (userId == null) {
            throw new InvalidUserDataException("UserId cannot be null");
        }

        Optional<User> optionalUser = userDAO.getUserById(userId);
        if (!optionalUser.isPresent()) {
            return Optional.empty();
        }

        User user =  optionalUser.get();

        List<UserAddress> addresses = userAddressDAO.getAddressesByUserId(user.getUserId());
        user.setUserAddresses(addresses);

        Optional<UserRole> role = userRoleDAO.getRoleByUserId(user.getUserId());
        role.ifPresent(userRole -> user.setRole(userRole.getUserRole()));

        Optional<EmploymentProfile> employmentProfileOptional = employmentProfileDAO.getEmploymentProfileByUserId(user.getUserId());
        if (employmentProfileOptional.isPresent()) {
            user.setEmploymentProfile(employmentProfileOptional.get());
        }

        return Optional.of(user);
    }

    @Override
    public Optional<User> getUserByUsername(String username) {
        if (username == null || username.isEmpty()) {
            throw new InvalidUserDataException("Username cannot be empty/null");
        }

        Optional<User> userOptional = userDAO.getUserByUsername(username);
        if (!userOptional.isPresent()) {
            return Optional.empty();
        }

        User user =  userOptional.get();

        List<UserAddress> addresses = userAddressDAO.getAddressesByUserId(user.getUserId());
        user.setUserAddresses(addresses);

        Optional<UserRole> userRole = userRoleDAO.getRoleByUserId(user.getUserId());
        userRole.ifPresent(role -> user.setRole(role.getUserRole()));

        Optional<EmploymentProfile> employmentProfileOptional = employmentProfileDAO.getEmploymentProfileByUserId(user.getUserId());
        if (employmentProfileOptional.isPresent()) {
            user.setEmploymentProfile(employmentProfileOptional.get());
        }

        return Optional.of(user);
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        if (email == null || email.isEmpty()) {
            throw new InvalidUserDataException("Email cannot be empty/null");
        }

        Optional<User> userOptional = userDAO.getUserByEmail(email);
        if (!userOptional.isPresent()) {
            return Optional.empty();
        }

        User user =  userOptional.get();

        List<UserAddress> addresses = userAddressDAO.getAddressesByUserId(user.getUserId());
        user.setUserAddresses(addresses);

        Optional<UserRole> userRole = userRoleDAO.getRoleByUserId(user.getUserId());
        userRole.ifPresent(role -> user.setRole(role.getUserRole()));

        Optional<EmploymentProfile> employmentProfileOptional = employmentProfileDAO.getEmploymentProfileByUserId(user.getUserId());
        if (employmentProfileOptional.isPresent()) {
            user.setEmploymentProfile(employmentProfileOptional.get());
        }

        return Optional.of(user);
    }

    @Override
    public User getUserByIdentifier(String identifier) {
        if (identifier == null || identifier.isEmpty()) {
            throw new InvalidUserDataException("Identifier cannot be empty/null");
        }

        User user =  userDAO.getUserByIdentifier(identifier)
                .orElseThrow(() ->
                            new EmailAddressNotFoundException("Identifier: " + identifier + " not found")
                        );

        return user;
    }

    @Override
    public boolean updateUser(User user) {
        if (user == null) {
            throw new InvalidUserDataException("User cannot be null");
        }

        if (user.getUserId() == null) {
            throw new  InvalidUserDataException("UserId cannot be null");
        }

        User user1 = userDAO.getUserById(user.getUserId())
                .orElseThrow(() ->
                            new UserNotFoundException("User not found")
                        );

        boolean success = userDAO.updateUser(user);
        if (!success) {
            throw new UserException("Failed to update user");
        }

        return true;
    }

    @Override
    public boolean updateUserUsername(Long userId, String newUsername) {
        if (userId == null || newUsername == null || newUsername.isEmpty()) {
            throw new InvalidUserDataException("userId and username cannot be empty/null");
        }

        User user = userDAO.getUserById(userId)
                .orElseThrow(() ->
                        new UserNotFoundException("User not found.")
                );

        return userDAO.updateUserUsername(userId, newUsername);
    }

    @Override
    public boolean updateUserPassword(Long userId, String newHashedPassword) {
        if (userId == null || newHashedPassword.isEmpty()) {
            throw new InvalidUserDataException("userId and password cannot be empty/null");
        }

        return userDAO.updateUserPassword(userId, newHashedPassword);
    }

    @Override
    public boolean deleteUser(Long userId) {
        if (userId == null) {
            throw new InvalidUserDataException("UserId cannot be null");
        }

        User user = userDAO.getUserById(userId)
                .orElseThrow(() ->
                        new UserNotFoundException("User not found")
                );

        return userDAO.deleteUser(userId);
    }

    @Override
    public boolean userExistsByUsername(String username) {
        if (username == null || username.isEmpty()) {
            throw new InvalidUserDataException("Username cannot be empty/null");
        }

        return userDAO.userExistsByUsername(username);
    }

    @Override
    public boolean userExistsByEmail(String email) {
        if (email == null || email.isEmpty()) {
            throw new InvalidUserDataException("Email cannot be empty/null");
        }

        return userDAO.userExistsByEmail(email);
    }
}
