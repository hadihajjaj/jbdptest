package com.objectia.JBD_HandsOnLearning.services;

import com.objectia.JBD_HandsOnLearning.models.Account;
import com.objectia.JBD_HandsOnLearning.models.AccountHolder;
import com.objectia.JBD_HandsOnLearning.repositories.AccountHolderRepository;
import com.objectia.JBD_HandsOnLearning.repositories.AccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class AccountService {
    @Autowired
    AccountRepository accountRepository;

    @Autowired
    AccountHolderRepository accountHolderRepository;
    public Account  createAccount(Account account) throws Exception {
        log.trace("creating account {}",account);
        log.debug("getting account holder by id {}",account.getAccountHolder().getId());
       Optional<AccountHolder>  accountHolder = accountHolderRepository.findById(account.getAccountHolder().getId());
       if(accountHolder.isPresent()){
           log.info("account holder is retrieved of id {}",accountHolder.get().getId());
           log.error("this is error level");
           account.setAccountHolder(accountHolder.get());
           Account savedAccount = accountRepository.save(account);
           return savedAccount;
       }
       else{
           log.error("account holder is not present");
           throw new Exception();
       }
    }

    public Account getById(UUID accountId) throws Exception {
        Optional<Account> account  = accountRepository.findById(accountId);
        if(account.isPresent()){
            return account.get();
        }
        else{
            throw  new Exception();
        }

    }
    public Account updateAccount(Account account, UUID id) throws Exception {
        Optional<Account> dbAcccount = accountRepository.findById(id);
        if(dbAcccount.isPresent()){
            account.setId(id);
            return accountRepository.save(account);
        }
        else{
            throw new Exception();
        }
    }

    public void deleteById(UUID accountId) {
        accountRepository.deleteById(accountId);
    }


    public BigDecimal modifyBalance(BigDecimal balance, UUID accountId) throws Exception {
        Optional<Account> dbAccount = accountRepository.findById(accountId);
        if(dbAccount.isPresent()){
            dbAccount.get().setBalance(balance);
            accountRepository.save(dbAccount.get());
            return  dbAccount.get().getBalance();
        }
        else{
            throw new Exception();
        }
    }
}
