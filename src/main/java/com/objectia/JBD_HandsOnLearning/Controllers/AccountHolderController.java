package com.objectia.JBD_HandsOnLearning.Controllers;


import com.objectia.JBD_HandsOnLearning.models.AccountHolder;
import com.objectia.JBD_HandsOnLearning.services.AccountHolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/account-holder")
public class AccountHolderController {
    @Autowired
    AccountHolderService accountHolderService;
    @PostMapping("create-account-holder")
    public ResponseEntity<AccountHolder> createAccountHolder (@RequestBody AccountHolder accountHolder){
        AccountHolder createdAccountHolder = accountHolderService.createAccountHolder(accountHolder);
        return  new ResponseEntity<>(createdAccountHolder, HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<AccountHolder> getAccountHolderById(@PathVariable UUID id){
       Optional<AccountHolder> accountHolder = accountHolderService.getById(id);
       return new ResponseEntity<>(accountHolder.get(),HttpStatus.FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccountHolder(@PathVariable UUID id){
        accountHolderService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }















}
