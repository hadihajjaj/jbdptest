package com.objectia.JBD_HandsOnLearning.DTO;

import com.objectia.JBD_HandsOnLearning.models.AccountHolder;
import com.objectia.JBD_HandsOnLearning.models.Card;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
public class AccountResponseDTO {

    private UUID id;

    private Float balance;

    private String status;

    private UUID accountHolderId;

}
