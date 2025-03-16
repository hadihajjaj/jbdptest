package com.objectia.JBD_HandsOnLearning.repositories;


import com.objectia.JBD_HandsOnLearning.models.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CardRepository extends JpaRepository<Card, UUID> {
    Card findByCvv(String cvv);


}
