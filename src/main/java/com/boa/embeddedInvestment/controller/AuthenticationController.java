package com.boa.embeddedInvestment.controller;

import com.boa.embeddedInvestment.dto.LoginDto;
import com.boa.embeddedInvestment.dto.LoginResponseDto;
import com.boa.embeddedInvestment.dto.RegisterDto;
import com.boa.embeddedInvestment.dto.UserResponseDto;
import com.boa.embeddedInvestment.entity.User;
import com.boa.embeddedInvestment.service.AuthenticationService;
import com.boa.embeddedInvestment.service.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {
    private final JwtService jwtService;

    private final AuthenticationService authenticationService;

    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup")
    public ResponseEntity<UserResponseDto> register(@RequestBody RegisterDto registerDto) {
        User registeredUser = authenticationService.signup(registerDto);
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setId(registeredUser.getId());
        userResponseDto.setName(registeredUser.getName());
        userResponseDto.setEmail(registeredUser.getEmail());
        userResponseDto.setMobileNumber(registeredUser.getMobileNumber());
        return ResponseEntity.ok(userResponseDto);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> authenticate(@RequestBody LoginDto loginDto) {
        User authenticatedUser = authenticationService.authenticate(loginDto);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginResponseDto loginResponse = new LoginResponseDto();
        loginResponse.setToken(jwtToken);
        loginResponse.setExpiresIn(jwtService.getExpirationTime());

        return ResponseEntity.ok(loginResponse);
    }
}