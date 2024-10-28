package com.api_test.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.api_test.models.Account;

import jakarta.transaction.Transactional;

public interface AccountRepository extends JpaRepository<Account,Integer> {

    Optional<Account> findByEmailAddress(String email);

    Optional<Account> findByEmailAddressAndPassword(String email, String password);

    Optional<Account> findByCellNumberAndPassword(String cell, String password);

    @Modifying
    @Transactional
    @Query("UPDATE Account a SET a.balance = :amount WHERE a.accountNumber = :accountNumber")
    int updateAccountBalance(Integer accountNumber,Integer amount);

}
