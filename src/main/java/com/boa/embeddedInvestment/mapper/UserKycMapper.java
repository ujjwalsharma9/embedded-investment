package com.boa.embeddedInvestment.mapper;

import com.boa.embeddedInvestment.dto.KycDto;
import com.boa.embeddedInvestment.entity.UserKYCDetails;
import com.boa.embeddedInvestment.repository.UserRepository;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(
        componentModel = "spring"
)
public interface UserKycMapper {

    UserKYCDetails userKycEntity(KycDto kycDto);
}
