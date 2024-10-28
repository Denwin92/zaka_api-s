package com.api_test.controllers;

import java.util.*;
import java.util.regex.Pattern;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.api_test.models.*;
import com.api_test.services.AccountService;


@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/login")
public ResponseEntity<Map<String, Object>> login(@RequestBody Map<String, String> body) {
    String username = body.get("username");
    String password = body.get("password");

    Optional<Account> account;
    if (isEmail(username)) {
        account = accountService.getAccountByEmailPassword(username, hashPasswordMD5(password));
    } else if (isPhoneNumber(username)) {
        account = accountService.getAccountByCellNumberPassword(username, hashPasswordMD5(password));
    } else {
        return ResponseEntity.badRequest().body(ApiRespone.getResponse(1, "Invalid username format.", null));
    }

    if (account.isPresent()) {
        return ResponseEntity.ok(ApiRespone.getResponse(0, "Account found", Map.of("account", account)));
    } else {
        return ResponseEntity.status(404).body(ApiRespone.getResponse(1, "Account not found.", null));
    }
}

private boolean isEmail(String input) {
    String emailPattern = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    return Pattern.matches(emailPattern, input);
}

private boolean isPhoneNumber(String input) {
    String phonePattern = "^\\d{10}$"; 
    return Pattern.matches(phonePattern, input);
}

    @PostMapping("/create-account")
    public ResponseEntity<Map<String, Object>> createAccount(@RequestBody Map<String, String> body) {
        String email = body.get("email").toString();
        String cellPhone = body.get("cell_number").toString();

        if(accountService.checkAccountExists(cellPhone, email)){
            return ResponseEntity.status(400).body(ApiRespone.getResponse(1, "Account already exists.", null));
        }

        Account account = new Account();
        account.setCellNumber(cellPhone);
        account.setCity(body.get("city").toString());
        try {
            account.setDateOfBirth(
                    new java.sql.Date(new SimpleDateFormat("dd-MM-yyyy").parse(body.get("dob").toString()).getTime()));
        } catch (ParseException e) {
    
            e.printStackTrace();
        }
        account.setEmailAddress(email);
        account.setFirstName(body.get("first_name").toString());
        account.setLastName(body.get("last_name").toString());
        account.setIdNumber(body.get("id_number").toString());
        account.setProvince(body.get("province").toString());
        account.setStreetName(body.get("street_name").toString());
        account.setSuburb(body.get("suburb").toString());
        account.setPassword(hashPasswordMD5(body.get("password")));
        account.setStreetNumber(Integer.parseInt(body.get("street_number").toString()));

        Account savedAccount = accountService.saveAccount(account);

        return ResponseEntity
                .ok(ApiRespone.getResponse(0, "Account saved successfully.", Map.of("account", savedAccount)));
    }


private String hashPasswordMD5(String password) {
    try {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] hashInBytes = md.digest(password.getBytes());

        // Convert the byte array into a hexadecimal string
        StringBuilder sb = new StringBuilder();
        for (byte b : hashInBytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    } catch (NoSuchAlgorithmException e) {
        throw new RuntimeException("Error hashing password", e);
    }
}

}
