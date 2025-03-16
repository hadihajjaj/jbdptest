package com.objectia.JBD_HandsOnLearning.services;

import com.objectia.JBD_HandsOnLearning.models.Account;
import com.objectia.JBD_HandsOnLearning.models.AccountCard;
import com.objectia.JBD_HandsOnLearning.models.Card;
import com.objectia.JBD_HandsOnLearning.repositories.AccountCardRepository;
import com.objectia.JBD_HandsOnLearning.repositories.AccountRepository;
import com.objectia.JBD_HandsOnLearning.repositories.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AccountCardService {
    @Autowired
    AccountCardRepository accountCardRepository;
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    CardRepository cardRepository;


    public UUID linkAccountCard (UUID accountId, UUID cardId) throws Exception {
        Optional<Account> account = accountRepository.findById(accountId);
        Optional<Card> card = cardRepository.findById(cardId);
        if(!account.isPresent() || !card.isPresent()){
            throw new Exception();
        }
        AccountCard accountCard  = new AccountCard();
        accountCard.setAccount(account.get());
        accountCard.setCard(card.get());
        AccountCard savedAccountCard = accountCardRepository.save(accountCard);
        return savedAccountCard.getId();
    }
}
