package com.countypower.registration.repositories;

import com.countypower.registration.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * UserRegistrationRepository which executes the database operations
 * @author Neha Naithani
 */
@Repository
public interface UserRegistrationRepository extends CrudRepository<User, Long> {
}
