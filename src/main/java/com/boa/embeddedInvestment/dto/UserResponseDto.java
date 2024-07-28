package com.boa.embeddedInvestment.dto;

import lombok.Data;

@Data
public class UserResponseDto {
    private Long id;
    private String name;
    private String email;
    private String mobileNumber;
    private Long totalWalletAmount;
}
