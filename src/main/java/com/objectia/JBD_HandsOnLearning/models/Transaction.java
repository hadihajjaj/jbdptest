package com.objectia.JBD_HandsOnLearning.models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "transaction",schema = "cms")
@Getter
@Setter
@Audited
public class Transaction {

    @Id
    @Column(name = "transaction_id")
    private UUID id;

    @ManyToOne
    @NotNull(message = "Card is mandatory")
    @JoinColumn(name = "card_id")
    private Card card;

    @NotNull(message = "Transaction amount is mandatory")
    private BigDecimal transactionAmount;


    @NotNull(message = "Transaction Date is mandatory")
    private Timestamp transactionDate = new Timestamp(System.currentTimeMillis());


    @NotNull(message = "Transaction type is mandatory")
    private String transactionType;
}
