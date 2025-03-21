package com.objectia.JBD_HandsOnLearning.repositories;

import com.objectia.JBD_HandsOnLearning.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AccountRepository extends JpaRepository<Account, UUID> {


}
