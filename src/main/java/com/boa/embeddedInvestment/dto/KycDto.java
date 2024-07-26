package com.boa.embeddedInvestment.dto;

import lombok.Data;

@Data
public class KycDto {
    private Long userId;
    private String fullName;
    private String dateOfBirth;
    private String nationality;
    private String gender;
    private String maritalStatus;
    private String occupation;
    private String govtIssuedIdNumber;
    private String residentialAddress;
    private String mailingAddress;
    private String phoneNumber;
    private String emailAddress;
    private String typeOfIdProvided;
    private double annualIncome;

}
