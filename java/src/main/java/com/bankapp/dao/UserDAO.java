package com.bankapp.dao;

import com.bankapp.model.User;

import java.sql.Connection;
import java.util.Optional;

public interface UserDAO {

    Long createUser(User user);
    Long createUser(User user, Connection connection);

    Optional<User> getUserById(Long id);
    Optional<User> getUserByUsername(String username);
    Optional<User> getUserByEmail(String email);
    Optional<User> getUserForAuthentication(String identifier);
    Optional<User> getUserByIdentifier(String identifier);

    boolean updateUser(User user);
    boolean updateUserUsername(Long userId, String newUsername);
    boolean updateUserPassword(Long userId, String newHashedPassword);

    boolean deleteUser(Long userId);

    boolean userExistsByUsername(String username);
    boolean userExistsByEmail(String email);
    boolean userExistsByUserId(Long userId);

}
