package com.boa.embeddedInvestment.controller;

import com.boa.embeddedInvestment.dto.UserResponseDto;
import com.boa.embeddedInvestment.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/user")
@RestController
public class UserController {

    @GetMapping("/profile")
    public ResponseEntity<UserResponseDto> authenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        User currentUser = (User) authentication.getPrincipal();

        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setId(currentUser.getId());
        userResponseDto.setName(currentUser.getName());
        userResponseDto.setEmail(currentUser.getEmail());
        userResponseDto.setMobileNumber(currentUser.getMobileNumber());
        userResponseDto.setTotalWalletAmount(currentUser.getWallet().getTotalAmount());
        return ResponseEntity.ok(userResponseDto);

    }


}