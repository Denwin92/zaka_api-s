package com.api_test.models;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "Account") 
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "account_number")
    private Integer accountNumber;

    @Column(name = "first_name", length = 50) // VARCHAR(50) maps to String
    private String firstName;

    @Column(name = "last_name", length = 50)
    private String lastName;

    @Column(name = "cell_number", length = 15)
    private String cellNumber;

    @Column(name = "email_address", length = 100)
    private String emailAddress;

    @Column(name = "province", length = 50)
    private String province;

    @Column(name = "suburb", length = 50)
    private String suburb;

    @Column(name = "city", length = 50)
    private String city;

    @Column(name = "street_number")
    private Integer streetNumber;

    @Column(name = "street_name", length = 100)
    private String streetName;

    @Column(name = "id_number", length = 50)
    private String idNumber;

    @Column(name = "date_of_birth")
    @Temporal(TemporalType.DATE) 
    private Date dateOfBirth;

    @JsonIgnore 
    @Column(name = "password", length = 32)
    private String password;

    @Column(name = "balance")
    private Integer balance;

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }


    public Integer getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCellNumber() {
        return cellNumber;
    }

    public void setCellNumber(String cellNumber) {
        this.cellNumber = cellNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(Integer streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
