package com.objectia.JBD_HandsOnLearning.repositories;

import com.objectia.JBD_HandsOnLearning.models.Account;
import com.objectia.JBD_HandsOnLearning.models.AccountCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AccountCardRepository extends JpaRepository<AccountCard, UUID> {
    AccountCard findByCardId(UUID accountId);
}
