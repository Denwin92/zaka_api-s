package com.api_test.controllers;

import java.util.*;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.api_test.models.*;
import com.api_test.services.TransactionService;




@RestController
@RequestMapping("api/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

     @GetMapping
    public ResponseEntity<Map<String,Object>> getAllTransactions(){
        List<Transaction> transactions = transactionService.getAllTransactions();
        return ResponseEntity.ok(ApiRespone.getResponse(0, "Transactions", Map.of("transactions",transactions)));
    }

    @GetMapping("/{accountNumber}")
    public ResponseEntity<Map<String,Object>> getSenderTransactions(@PathVariable String accountNumber) {
        List<Transaction> transactions = transactionService.getSenderTransactions(accountNumber);
        return ResponseEntity.ok(ApiRespone.getResponse(0, "Transactions history", Map.of("transactions",transactions)));
    }


    @PostMapping("/transfer")
    public ResponseEntity<Map<String,Object>> addTransaction(@RequestBody Map<String,Object> body) {
        Transaction transaction = new Transaction();
        transaction.setAccountName(body.get("account_name").toString());
        transaction.setAmount(new BigDecimal(body.get("amount").toString()));
        transaction.setBeneficiaryAccountNumber(body.get("beneficiary_account_number").toString());
        transaction.setBeneficiaryReference(body.get("beneficiary_reference").toString());
        transaction.setSenderAccountNumber(body.get("sender_account_number").toString());
        transaction.setSenderReference(body.get("sender_reference").toString());

        transactionService.saveTransaction(transaction);

        return ResponseEntity.ok(ApiRespone.getResponse(0, "Transfer successful", Map.of("transaction",transaction)));
    }


}
