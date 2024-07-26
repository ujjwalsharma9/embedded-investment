package com.boa.embeddedInvestment.repository;

import com.boa.embeddedInvestment.entity.UserKYCDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserKYCDetailsRepository extends JpaRepository<UserKYCDetails, Long> {
}
