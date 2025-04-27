package com.mshindelar.collection.service;

import com.mshindelar.collection.db.filter.*;
import com.mshindelar.collection.db.filter.deck.DeckCardSpecification;
import com.mshindelar.collection.model.card.Card;
import com.mshindelar.collection.model.card.ygo.YGOCard;
import com.mshindelar.collection.model.deck.Deck;
import com.mshindelar.collection.model.deck.DeckCard;
import com.mshindelar.collection.repository.DeckCardRepository;
import com.mshindelar.collection.repository.DeckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DeckService {
    @Autowired
    private DeckRepository deckRepository;

    @Autowired
    private DeckCardRepository deckCardRepository;

    @Autowired
    private AccountService accountService;

    @Autowired
    private CardService cardService;

    public Deck getDeck(UUID id) {
        return deckRepository.findById(id).orElseThrow();
    }

    public Deck addCardsToDeck(UUID deckId, List<String> cardIds) {
        Deck deck = this.getDeck(deckId);
        this.deckCardRepository.saveAll(this.getDeckCards(deck, cardIds));
        return deck;
    }

    public DeckCard getOrCreateDeckCard(Deck deck, Card card) {
        return this.deckCardRepository.findByDeckAndCard(deck, card)
                .orElse(new DeckCard(null, deck, card, 0));
    }

    public Deck getFilteredDeck(UUID deckId, AbstractFilter filter) {
        Deck deck = getDeck(deckId);

        SimpleFilter f = new SimpleFilter(new Filter(
                "deck",
                FilterOperator.EQUAL_TO,
                deck,
                null,
                null,
                DeckCard.class));

        List<DeckCard> filteredCards = this.deckCardRepository.findAll(new DeckCardSpecification(
                new AndFilter(List.of(f, filter))));
        deck.setCards(filteredCards);
        return deck;
    }

    private List<DeckCard> getDeckCards(Deck deck, List<String> cardIds) {
        return new java.util.ArrayList<>(cardIds.stream().map(c -> {
            String id = String.valueOf(Integer.parseInt(c));
            YGOCard card = (YGOCard) this.cardService.getCard(id);

            DeckCard deckCard = this.getOrCreateDeckCard(deck, card);
            deckCard.setQuantity(deckCard.getQuantity() + 1);
            return deckCard;
        }).toList());
    }
}
