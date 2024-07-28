package com.boa.embeddedInvestment.dto;

import lombok.Data;

import java.util.Date;

@Data
public class TransactionResponseDto {
    private String referenceId;

    private Long accountId;

    private String description;

    private Long amount;
    private Date createdAt;
}
