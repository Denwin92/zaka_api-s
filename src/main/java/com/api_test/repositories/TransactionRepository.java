package com.api_test.repositories;

import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;

import com.api_test.models.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer>{

   List<Transaction> findBySenderAccountNumber(String accountNumber);

}
