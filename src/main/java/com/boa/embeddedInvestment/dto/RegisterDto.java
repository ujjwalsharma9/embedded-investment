package com.boa.embeddedInvestment.dto;

import lombok.Data;

@Data
public class RegisterDto {
    private String name;
    private String mobileNumber;
    private String email;
    private String password;
}
