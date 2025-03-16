package com.objectia.JBD_HandsOnLearning.models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "account",schema = "cms")
@Getter
@Setter
@Audited
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "account_id")
    private UUID id;
    @Column
    private BigDecimal balance;
    @Column
    private String status;
    @ManyToOne
    @JoinColumn(name = "account_holder_id")
    private AccountHolder accountHolder;
    @ManyToMany
    private List<Card> cards ;
}
