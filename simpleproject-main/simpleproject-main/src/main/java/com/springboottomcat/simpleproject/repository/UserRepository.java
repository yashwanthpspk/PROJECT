package com.springboottomcat.simpleproject.repository;

import com.springboottomcat.simpleproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // Custom query to check if email already exists
    boolean existsByEmail(String email);
}
