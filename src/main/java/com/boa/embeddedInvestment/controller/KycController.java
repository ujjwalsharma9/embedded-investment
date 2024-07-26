package com.boa.embeddedInvestment.controller;

import com.boa.embeddedInvestment.dto.KycDto;
import com.boa.embeddedInvestment.entity.User;
import com.boa.embeddedInvestment.entity.UserKYCDetails;
import com.boa.embeddedInvestment.mapper.UserKycMapper;
import com.boa.embeddedInvestment.service.UserKYCService;
import com.boa.embeddedInvestment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/user/kyc")
public class KycController {

    @Autowired
    private UserKycMapper userKycMapper;

    @Autowired
    private UserKYCService userKYCService;

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<String> saveKycDetails(@RequestBody KycDto kycDto){
        UserKYCDetails userKYCDetails = userKycMapper.userKycEntity(kycDto);
        Optional<User> optionalUser = userService.findById(kycDto.getUserId());


        if(optionalUser.isEmpty()){
            return new ResponseEntity<>("User Not found", HttpStatus.BAD_REQUEST);
        }

        userKYCDetails.setUser(optionalUser.get());

        userKYCService.save(userKYCDetails);

        return new ResponseEntity<>("User Kyc Successful", HttpStatus.OK);
    }
}
