package com.bankapp.service;

import com.bankapp.model.*;

import java.util.Optional;

public interface UserService {

    Long createUser(User user, UserAddress userAddress, EmploymentProfile employmentProfile);

    Optional<User> getUserById(Long userId);
    Optional<User> getUserByUsername(String username);
    Optional<User> getUserByEmail(String email);
    User getUserByIdentifier(String identifier);

    boolean updateUser(User user);
    boolean updateUserUsername(Long userId, String newUsername);
    boolean updateUserPassword(Long userId, String newHashedPassword);

    boolean deleteUser(Long userId);

    boolean userExistsByUsername(String username);
    boolean userExistsByEmail(String email);

}
