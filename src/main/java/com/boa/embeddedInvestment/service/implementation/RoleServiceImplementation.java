package com.boa.embeddedInvestment.service.implementation;

import com.boa.embeddedInvestment.entity.Role;
import com.boa.embeddedInvestment.repository.RoleRepository;
import com.boa.embeddedInvestment.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceImplementation implements RoleService {

    @Autowired
    private RoleRepository roleRepository;
    @Override
    public Optional<Role> findByName(String name) {
        return roleRepository.findByName(name);
    }
}
