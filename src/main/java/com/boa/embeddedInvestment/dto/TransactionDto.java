package com.boa.embeddedInvestment.dto;

import lombok.Data;

@Data
public class TransactionDto {
    private String referenceId;

    private Long accountId;

    private String description;

    private Long amount;
}
