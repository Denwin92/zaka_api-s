package com.api_test.models;

import java.math.BigDecimal;

import jakarta.persistence.*;

@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "beneficiary_account_number", nullable = false)
    private String beneficiaryAccountNumber;

    @Column(name = "sender_account_number", nullable = false)
    private String senderAccountNumber;

    @Column(name = "account_name", nullable = false)
    private String accountName;

    @Column(name = "beneficiary_reference", nullable = false)
    private String beneficiaryReference;

    @Column(name = "sender_reference", nullable = false)
    private String senderReference;

    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

    public Transaction() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBeneficiaryAccountNumber() {
        return beneficiaryAccountNumber;
    }

    public void setBeneficiaryAccountNumber(String beneficiaryAccountNumber) {
        this.beneficiaryAccountNumber = beneficiaryAccountNumber;
    }

    public String getSenderAccountNumber() {
        return senderAccountNumber;
    }

    public void setSenderAccountNumber(String senderAccountNumber) {
        this.senderAccountNumber = senderAccountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getBeneficiaryReference() {
        return beneficiaryReference;
    }

    public void setBeneficiaryReference(String beneficiaryReference) {
        this.beneficiaryReference = beneficiaryReference;
    }

    public String getSenderReference() {
        return senderReference;
    }

    public void setSenderReference(String senderReference) {
        this.senderReference = senderReference;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

}

