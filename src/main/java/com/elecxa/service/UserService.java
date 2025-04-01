package com.elecxa.service;

import com.elecxa.model.User;
import com.elecxa.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Create a new user
    public User createUser(User user) {
        // In a real-world scenario, you may want to perform additional checks (e.g., if the email/phone exists)
        return userRepository.save(user);
    }

    // Get a user by their ID
    public Optional<User> getUserById(Long userId) {
        return userRepository.findById(userId);
    }

    // Get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Update user details
    public Optional<User> updateUser(Long userId, User userDetails) {
        return userRepository.findById(userId)
                .map(existingUser -> {
                    existingUser.setFirstName(userDetails.getFirstName());
                    existingUser.setLastName(userDetails.getLastName());
                    existingUser.setEmail(userDetails.getEmail());
                    existingUser.setPhoneNumber(userDetails.getPhoneNumber());
                    existingUser.setPassword(userDetails.getPassword());
                    existingUser.setRole(userDetails.getRole());
                    // You can also update other fields if needed
                    return userRepository.save(existingUser);
                });
    }

    // Delete a user
    public boolean deleteUser(Long userId) {
        return userRepository.findById(userId)
                .map(user -> {
                    userRepository.delete(user);
                    return true;
                }).orElse(false);
    }
}
