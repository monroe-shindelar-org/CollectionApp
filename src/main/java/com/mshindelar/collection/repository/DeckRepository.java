package com.mshindelar.collection.repository;

import com.mshindelar.collection.model.deck.Deck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DeckRepository extends JpaRepository<Deck, UUID>, JpaSpecificationExecutor<Deck> { }
