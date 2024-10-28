package com.api_test.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

import com.api_test.models.Transaction;
import com.api_test.repositories.TransactionRepository;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    public List<Transaction> getAllTransactions(){
        return transactionRepository.findAll();
    }

    public Transaction saveTransaction(Transaction transaction){
        return transactionRepository.save(transaction);
    }

    public List<Transaction> getSenderTransactions(String senderAccountNumber){
        return transactionRepository.findBySenderAccountNumber(senderAccountNumber);
    }

}
