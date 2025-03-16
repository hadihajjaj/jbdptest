package com.objectia.JBD_HandsOnLearning.services;

import com.objectia.JBD_HandsOnLearning.models.AccountHolder;
import com.objectia.JBD_HandsOnLearning.repositories.AccountHolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AccountHolderService {
    @Autowired
    AccountHolderRepository accountHolderRepository;

    public AccountHolder createAccountHolder(AccountHolder accountHolder){
        return accountHolderRepository.save(accountHolder);
    }
    public Optional<AccountHolder> getById(UUID id){
        return accountHolderRepository.findById(id);
    }

    public AccountHolder updateAccountHolder(AccountHolder accountHolder){
        return accountHolderRepository.save(accountHolder);
    }

    public void deleteById(UUID id){
        accountHolderRepository.deleteById(id);
    }
}
