package com.mshindelar.collection.repository;

import com.mshindelar.collection.model.card.Card;
import com.mshindelar.collection.model.deck.Deck;
import com.mshindelar.collection.model.deck.DeckCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;
import java.util.UUID;

public interface DeckCardRepository extends JpaRepository<DeckCard, UUID>, JpaSpecificationExecutor<DeckCard> {
    Optional<DeckCard> findByDeckAndCard(Deck deck, Card card);
}
