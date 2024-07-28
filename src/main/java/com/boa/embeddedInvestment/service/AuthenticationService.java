package com.boa.embeddedInvestment.service;

import com.boa.embeddedInvestment.dto.LoginDto;
import com.boa.embeddedInvestment.dto.RegisterDto;
import com.boa.embeddedInvestment.entity.User;
import com.boa.embeddedInvestment.entity.Wallet;
import com.boa.embeddedInvestment.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    public AuthenticationService(
            UserRepository userRepository,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder
    ) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User signup(RegisterDto input) {
        User user = new User();
        user.setName(input.getName());
        user.setMobileNumber(input.getMobileNumber());
        user.setEmail(input.getEmail());
        user.setPassword(passwordEncoder.encode(input.getPassword()));
        user.setWallet(new Wallet());
        return userRepository.save(user);
    }

    public Boolean checkIfUserExists(long userId){
        return userRepository.findById(userId).isPresent();
    }

    public User authenticate(LoginDto input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPassword()
                )
        );

        return userRepository.findByEmail(input.getEmail())
                .orElseThrow();
    }
}
