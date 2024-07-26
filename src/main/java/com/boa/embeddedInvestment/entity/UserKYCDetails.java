package com.boa.embeddedInvestment.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "user_kyc_detail")
public class UserKYCDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
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

    @OneToOne
    private User user;
}
