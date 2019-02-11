package com.estheto.esms.repositories;

import com.estheto.esms.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

/**
 * User repository for CRUD operations.
 */
public interface UserRepository extends MongoRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
