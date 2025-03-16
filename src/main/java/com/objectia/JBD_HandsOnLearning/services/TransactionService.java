package com.objectia.JBD_HandsOnLearning.services;

import com.objectia.JBD_HandsOnLearning.DTO.TransactionRequestDTO;
import com.objectia.JBD_HandsOnLearning.models.Account;
import com.objectia.JBD_HandsOnLearning.models.AccountCard;
import com.objectia.JBD_HandsOnLearning.models.Card;
import com.objectia.JBD_HandsOnLearning.models.Transaction;
import com.objectia.JBD_HandsOnLearning.repositories.AccountCardRepository;
import com.objectia.JBD_HandsOnLearning.repositories.AccountRepository;
import com.objectia.JBD_HandsOnLearning.repositories.CardRepository;
import com.objectia.JBD_HandsOnLearning.repositories.TransactionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    CardRepository cardRepository;

    @Autowired
    AccountCardRepository accountCardRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    AccountRepository accountRepository;


    public void createTransaction(TransactionRequestDTO transactionRequestDTO) throws Exception {
        AccountCard accountCard = accountCardRepository.findById(transactionRequestDTO.getAccountCard()).get();
        Card card = accountCard.getCard();
        if (!card.getExpiryDate().after(new Date())) {
            throw new Exception();
        }
        Account account = accountCard.getAccount();
        if (transactionRequestDTO.getTransactionType().equals("D")) {
            if (account.getBalance().subtract(transactionRequestDTO.getAmount()).intValue() < 0) {
                throw new Exception();
            }
        }
        if (transactionRequestDTO.getTransactionType().equals("D")) {
            account.setBalance(account.getBalance().subtract(transactionRequestDTO.getAmount()));
        } else {
            account.setBalance(account.getBalance().add(transactionRequestDTO.getAmount()));
        }
        UUID transactionId = UUID.randomUUID();
        Transaction transaction = new Transaction();
        transaction.setCard(card);
        transaction.setId(transactionId);
        transaction.setTransactionAmount(transactionRequestDTO.getAmount());
        transaction.setTransactionType(transactionRequestDTO.getTransactionType());
        transactionRepository.save(transaction);
        accountRepository.save(account);

    }

    public int findTransactionByCard(UUID cardId) {
        return transactionRepository.findByCardId(cardId).size();
    }

}
