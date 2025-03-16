package com.objectia.JBD_HandsOnLearning.DTO;

import com.objectia.JBD_HandsOnLearning.models.Account;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
public class CardResponseDTO {
    private UUID id;

    private String cvv;

    private String cardNumber;

    private LocalDate expiryDate;
}
