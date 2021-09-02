package com.countypower.registration.services;

import com.countypower.registration.model.User;

import java.util.List;

/**
 * UserRegistrationService interface
 * @author Neha Naithani
 *
 */
public interface UserRegistrationService {
    List<User> getUsers();

    List<User> getUserBySurname(String surname);

    User getUserById(Long id);

    User addUser(User user);

    void updateUser(Long id, User user);

    void deleteUser(Long userId);
}
