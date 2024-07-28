package com.boa.embeddedInvestment.service;

import com.boa.embeddedInvestment.entity.Transaction;
import com.boa.embeddedInvestment.entity.User;
import com.boa.embeddedInvestment.entity.Wallet;
import com.boa.embeddedInvestment.repository.TransactionRepository;
import com.boa.embeddedInvestment.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TransactionRepository transactionRepository;


    @Transactional
    public Transaction walletTransaction(Long userId, Transaction transaction){
        //verify transaction.referenceId;

        User user = userRepository.findById(userId).orElseThrow();

        transaction.setUser(user);
        Transaction savedTransaction = transactionRepository.save(transaction);

        Wallet wallet = user.getWallet();

        wallet.setTotalAmount(wallet.getTotalAmount() + transaction.getAmount());

        return savedTransaction;
    }

    public List<Transaction> getTransactions(User user){
        return transactionRepository.findByUser(user);
    }
}
