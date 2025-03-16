package com.objectia.JBD_HandsOnLearning.DTO;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
public class TransactionResponseDTO {
    private UUID transactionId;
    private BigDecimal transactionAmount;
    private Timestamp transactionDate;
    private String transactionType;
}
