package com.api_test.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api_test.models.Account;
import com.api_test.repositories.AccountRepository;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account saveAccount(Account account){
        return accountRepository.save(account);
    }

    public Optional<Account> getAccountByEmailPassword(String email, String password){
        return accountRepository.findByEmailAddressAndPassword(email, password);
    }

    public Optional<Account> getAccountByCellNumberPassword(String cell, String password){
        return accountRepository.findByCellNumberAndPassword(cell, password);
    }

    public boolean checkAccountExists(String cell, String email){
        boolean x = accountRepository.existsByEmailAddressOrCellNumber(cell,email);
        return x;
    }

    

}
