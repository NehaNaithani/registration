package com.countypower.registration.services;

import com.countypower.registration.model.User;
import com.countypower.registration.repositories.UserRegistrationRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * UserRegistrationService impl which interacts with the dao layer
 * @author Neha Naithani
 */
@Service
public class UserRegistrationServiceImpl implements UserRegistrationService{

    private UserRegistrationRepository userRegistrationRepository;

    public UserRegistrationServiceImpl(UserRegistrationRepository userRegistrationRepository) {
        this.userRegistrationRepository = userRegistrationRepository;
    }

    /**
     * Method calls the dao layer to return all the users in the database
     * @return List of all users
     */
    @Override
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        userRegistrationRepository.findAll().forEach(users::add);;
        return users;
    }

    /**
     * Method calls the dao layer to return the list of users with the given surname
     * @param surname
     * @return List of all users with the matched surname
     */
    @Override
    public List<User> getUserBySurname(String surname) {
        List<User> users = new ArrayList<>();
        userRegistrationRepository.findAll().forEach(users::add);
        List<User> matchedUsers = users.stream()
                .filter(user -> user.getSurname().equalsIgnoreCase(surname))
                .collect(Collectors.toList());
        return matchedUsers;
    }

    /**
     * Method calls the dao layer to return user with the given ID
     * @param id
     * @return User with the specified ID
     */
    @Override
    public User getUserById(Long id) {
        return userRegistrationRepository.findById(id).get();
    }

    /**
     * Method calls the dao layer to add the user in the database
     * @param user
     * @return Added user in the Database
     */
    @Override
    public User addUser(User user) {
        return userRegistrationRepository.save(user);
    }

    /**
     * Method calls the dao layer to update the given user with specified ID
     * @param id
     * @param user
     */
    @Override
    public void updateUser(Long id, User user) {
        User dbUser =  userRegistrationRepository.findById(id).get();
        dbUser.setEmailAddress(user.getEmailAddress());
        dbUser.setFirstName(user.getFirstName());
        dbUser.setSurname(user.getSurname());
        userRegistrationRepository.save(dbUser);

    }

    /**
     * Method calls the dao layer to delete the user
     * @param userId
     */
    @Override
    public void deleteUser(Long userId) {
        userRegistrationRepository.deleteById(userId);

    }
}
