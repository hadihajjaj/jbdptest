package com.objectia.JBD_HandsOnLearning.Controllers;

import com.objectia.JBD_HandsOnLearning.DTO.TransactionRequestDTO;
import com.objectia.JBD_HandsOnLearning.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("transaction-controller")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/create-transaction")
    public void createTransaction(@RequestBody TransactionRequestDTO transactionRequestDTO) throws Exception {
        transactionService.createTransaction(transactionRequestDTO);
    }

    @GetMapping("/find-transaction-card/{cardId}")
    public ResponseEntity<Integer> findTransactionsByCard(@PathVariable UUID cardId) throws Exception {
        return new ResponseEntity<>(transactionService.findTransactionByCard(cardId), HttpStatus.ACCEPTED);
    }


}
