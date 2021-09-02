package com.countypower.registration.controllers;

import com.countypower.registration.model.User;
import com.countypower.registration.services.UserRegistrationService;
import io.swagger.annotations.Api;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * UserLoader is used to load default users in the system.
 * @author Neha Naithani
 *
 */
@RestController
@RequestMapping("/api/v1/user")
@Api(value="userRegistration")
public class UserController {

    private UserRegistrationService userRegistrationService;

    public UserController(UserRegistrationService userRegistrationService) {
        this.userRegistrationService = userRegistrationService;
    }

    /**
     * The function receives a GET request, processes it and gives back a list of User as a response.
     * @return List of all users
     */
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userRegistrationService.getUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    /**
     * The function receives a GET request with id in the url path, processes it and returns a User with the specified Id
     * @param userId
     * @return User
     */
    @GetMapping({"/id/{userId}"})
    public ResponseEntity<User> getUserById(@PathVariable Long userId) {
        return new ResponseEntity<>(userRegistrationService.getUserById(userId), HttpStatus.OK);
    }

    /**
     * The function receives a GET request with surname in the url path, processes it and returns all users with the specified surname
     * @param surname
     * @return List of users
     */
    @GetMapping({"/surname/{surname}"})
    public ResponseEntity<List<User>> getUserBySurname(@PathVariable String surname) {
        return new ResponseEntity<>(userRegistrationService.getUserBySurname(surname), HttpStatus.OK);
    }

    /**
     * The function receives a POST request,creates a new User and saves it to the database, and returns a resource link to the created User.
     * @param User
     * @return saved user
     */
    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User User) {
        User saveUser = userRegistrationService.addUser(User);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.add("user", "/api/v1/User/" + saveUser.getId().toString());
        return new ResponseEntity<>(saveUser, httpHeaders, HttpStatus.CREATED);
    }

    /**
     * /The function receives a PUT request, updates the User with the specified ID and returns the updated User
     * @param userId
     * @param User to be updated
     * @return Updated user
     */
    @PutMapping({"/{userId}"})
    public ResponseEntity<User> updateUser(@PathVariable("userId") Long userId, @RequestBody User User) {
        userRegistrationService.updateUser(userId, User);
        return new ResponseEntity<>(userRegistrationService.getUserById(userId), HttpStatus.OK);
    }

    /**
     * The function receives a DELETE request, deletes the User with the specified ID.
     * @param userId
     * @return String
     */
    @DeleteMapping({"/{userId}"})
    public ResponseEntity deleteUser(@PathVariable("userId") Long userId) {
        userRegistrationService.deleteUser(userId);
        return new ResponseEntity("Product deleted successfully", HttpStatus.NO_CONTENT);
    }
}
