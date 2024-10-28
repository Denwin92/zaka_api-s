package com.api_test.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.api_test.models.Account;

public interface AccountRepository extends JpaRepository<Account,Integer> {

    Optional<Account> findByEmailAddressAndPassword(String email, String password);

    Optional<Account> findByCellNumberAndPassword(String cell, String password);

    @Query("SELECT COUNT(a) > 0 FROM Account a WHERE a.emailAddress = :email OR a.cellNumber = :cellNumber")
    boolean existsByEmailAddressOrCellNumber(String email, String cellNumber);

}
