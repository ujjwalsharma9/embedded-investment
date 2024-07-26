package com.boa.embeddedInvestment.service;

import com.boa.embeddedInvestment.entity.User;

import java.util.Optional;

public interface UserService {
    Optional<User> findByEmail(String email);
    Optional<User> findByUsernameOrEmail(String username, String email);
    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
    void save(User user);
    Optional<User> findById(Long Id);
}
