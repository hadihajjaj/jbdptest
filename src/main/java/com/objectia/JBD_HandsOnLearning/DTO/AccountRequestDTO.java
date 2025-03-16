package com.objectia.JBD_HandsOnLearning.DTO;

import com.objectia.JBD_HandsOnLearning.models.AccountHolder;
import com.objectia.JBD_HandsOnLearning.models.Card;
import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;


@Data
public class AccountRequestDTO {
    @NotNull(message = "Balance cannot be null")
    @Positive(message = "Balance must be positive")
    private Float balance;
    @NotBlank(message = "status cannot be blank")
    private String status;
    private AccountHolder accountHolder;
}
