package com.boa.embeddedInvestment.service;

import com.boa.embeddedInvestment.entity.Role;

import java.util.Optional;

public interface RoleService {
    Optional<Role> findByName(String name);
}
