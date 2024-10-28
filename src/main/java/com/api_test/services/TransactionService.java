package com.api_test.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api_test.models.Transaction;
import com.api_test.repositories.TransactionRepository;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;
    
    public Transaction saveTransaction(Transaction transaction){
        return transactionRepository.save(transaction);
    }

}
