package com.countypower.registration.bootstrap;

import com.countypower.registration.model.User;
import com.countypower.registration.repositories.UserRegistrationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * UserLoader is used to load default users in the system.
 * @author Neha Naithani
 *
 */
@Component
public class UserLoader implements CommandLineRunner {
    private final UserRegistrationRepository userRegistrationRepository;

    public UserLoader(UserRegistrationRepository userRegistrationRepository) {
        this.userRegistrationRepository = userRegistrationRepository;
    }
    @Override
    public void run(String... args) {
        loadUsers();
    }

    /**
     * Method to load users in the memory database
     */
    private void loadUsers() {
        if (userRegistrationRepository.count() == 0) {
            userRegistrationRepository.save(
                    User.builder()
                            .surname("Scott")
                            .emailAddress("bob@gmail.com")
                            .firstName("Bob")
                            .build()
            );
            userRegistrationRepository.save(
                    User.builder()
                            .surname("Scott")
                            .emailAddress("todd@gmail.com")
                            .firstName("Todd")
                            .build()
            );
            userRegistrationRepository.save(
                    User.builder()
                            .surname("Hopkins")
                            .emailAddress("mat@gmail.com")
                            .firstName("Mathew")
                            .build()
            );
            System.out.println("User Loaded");
        }
    }
}
