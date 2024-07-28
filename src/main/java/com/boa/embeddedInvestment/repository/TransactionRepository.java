package com.boa.embeddedInvestment.repository;

import com.boa.embeddedInvestment.entity.Transaction;
import com.boa.embeddedInvestment.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findByUser(User user);
}
