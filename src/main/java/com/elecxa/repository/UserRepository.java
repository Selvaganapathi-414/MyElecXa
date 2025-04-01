package com.elecxa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elecxa.model.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Optional method to find a user by email, as it's unique
    Optional<User> findByEmail(String email);

    // Optional method to find a user by phone number, as it's unique
    Optional<User> findByPhoneNumber(String phoneNumber);
}
