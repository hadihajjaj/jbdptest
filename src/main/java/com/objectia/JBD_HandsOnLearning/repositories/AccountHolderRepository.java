package com.objectia.JBD_HandsOnLearning.repositories;

import com.objectia.JBD_HandsOnLearning.models.AccountHolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AccountHolderRepository extends JpaRepository<AccountHolder, UUID>{





}
