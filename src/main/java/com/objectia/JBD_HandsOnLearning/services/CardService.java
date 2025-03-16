package com.objectia.JBD_HandsOnLearning.services;

import com.objectia.JBD_HandsOnLearning.models.Card;
import com.objectia.JBD_HandsOnLearning.repositories.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service

public class CardService {
    @Autowired
    CardRepository cardRepository;

    public Card createCard(){
      Card card = new Card();
        Date currentDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.YEAR, 3);
        Date futureDate = calendar.getTime();
      card.setExpiryDate(futureDate);
      card.setCvv(String.valueOf(new Random().nextInt(999)+100));
      card.setCardNumber(generateCardNumber());
      cardRepository.save(card);
      return card;
    }
    public String generateCardNumber(){
        String bin = "12345678";
        Random random = new Random();
        StringBuilder randomDigits = new StringBuilder();
        for(int i = 0 ;i<7; i++){
            randomDigits.append(random.nextInt(10));
        }
          String cardNumber = bin + randomDigits;
//        String cardNumber = bin.concat(randomDigits.toString());
        return cardNumber;
    }


    public Card findCardByCvv(String cvv){
        Card card = cardRepository.findByCvv(cvv);
        return card;
    }


}
