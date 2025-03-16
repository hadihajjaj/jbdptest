package com.objectia.JBD_HandsOnLearning.models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name = "cards",schema = "cms")
@Getter
@Setter
@Audited
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "card_id")
    private UUID id;
    @Column(name = "cvv" ,length = 3)
    private String cvv;
    @Column(name = "card_number")
    private String cardNumber;
    @Column(name = "expiry_date")
    private Date expiryDate;
    @ManyToMany
    private List<Account> accounts ;
    @OneToMany(mappedBy = "card")
    private List<Transaction> transactions;
}
