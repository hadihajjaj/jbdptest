package com.objectia.JBD_HandsOnLearning.models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "account_holder",schema = "cms")
@Getter
@Setter
@Audited
public class AccountHolder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "account_holder_id")
    private UUID id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "phone_number")
    private Integer phoneNumber;
    @Column(name = "email")
    private String email;
    @Column(name = "date_of_birth")
    private LocalDate dob;
    @Column(name = "mother_name")
    private String motherName;
    @OneToMany(mappedBy = "accountHolder")
    private List<Account> accounts = new ArrayList<>();

    @PrePersist
    public void generateUUID() {
        if (id == null) {
            id = UUID.randomUUID();  // Generate UUID programmatically
        }
    }
}
