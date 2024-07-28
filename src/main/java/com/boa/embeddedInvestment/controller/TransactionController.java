package com.boa.embeddedInvestment.controller;

import com.boa.embeddedInvestment.dto.TransactionDto;
import com.boa.embeddedInvestment.dto.TransactionResponseDto;
import com.boa.embeddedInvestment.entity.Transaction;
import com.boa.embeddedInvestment.entity.User;
import com.boa.embeddedInvestment.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/api/transaction")
@RestController
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/discountToWallet")
    public ResponseEntity<TransactionResponseDto> addDiscountToWallet(@RequestBody TransactionDto transactionDto){
        Long userId = transactionDto.getAccountId();
        Transaction transaction = new Transaction();

        transaction.setReferenceId(transactionDto.getReferenceId());
        transaction.setDescription(transactionDto.getDescription());
        transaction.setAmount(transactionDto.getAmount());

        return ResponseEntity.ok(transactionToDto(transactionService.walletTransaction(userId, transaction)));
    }

    @GetMapping("/account")
    public ResponseEntity<List<TransactionResponseDto>> getTransactions(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        User currentUser = (User) authentication.getPrincipal();

        return ResponseEntity.ok(transactionService.getTransactions(currentUser).stream()
                .map(this::transactionToDto).collect(Collectors.toList()));
    }


    private TransactionResponseDto transactionToDto(Transaction transaction){
        TransactionResponseDto responseDto = new TransactionResponseDto();
        responseDto.setAccountId(transaction.getUser().getId());
        responseDto.setReferenceId(transaction.getReferenceId());
        responseDto.setDescription(transaction.getDescription());
        responseDto.setAmount(transaction.getAmount());
        responseDto.setCreatedAt(transaction.getCreatedAt());

        return responseDto;
    }
}
