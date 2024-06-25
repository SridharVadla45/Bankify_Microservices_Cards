package com.Bankify.Cards.Repository;

import com.Bankify.Cards.Entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CardsRepository extends JpaRepository<Card, Long> {

    Optional<Card> findByMobileNumber(String MobileNumber);
}
