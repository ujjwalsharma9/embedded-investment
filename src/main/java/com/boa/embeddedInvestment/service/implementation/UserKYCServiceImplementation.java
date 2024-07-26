package com.boa.embeddedInvestment.service.implementation;

import com.boa.embeddedInvestment.entity.UserKYCDetails;
import com.boa.embeddedInvestment.repository.UserKYCDetailsRepository;
import com.boa.embeddedInvestment.service.UserKYCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserKYCServiceImplementation implements UserKYCService {
    @Autowired
    private UserKYCDetailsRepository userKYCDetailsRepository;
    @Override
    public void save(UserKYCDetails details) {
        userKYCDetailsRepository.save(details);
    }
}
