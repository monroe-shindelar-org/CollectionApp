package com.mshindelar.collection.controller;

import com.mshindelar.collection.dto.deck.DeckDto;
import com.mshindelar.collection.model.collection.request.CardFilterChain;
import com.mshindelar.collection.service.DeckService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import java.util.UUID;

@RestController
@RequestMapping("/decks")
public class DeckController {
    private Logger LOGGER = LoggerFactory.getLogger(DeckController.class);

    @Autowired
    private DeckService deckService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("{id}")
    public DeckDto getDeck(@PathVariable UUID id) {
        return this.deckService.getDeck(id).convertToDto(modelMapper);
    }

    @PostMapping("{id}")
    public DeckDto modifyDeckCards(@PathVariable UUID id, @RequestBody List<DeckCardModificationRequestItem> cards) {
        List<String> cardIds = cards.stream().map(DeckCardModificationRequestItem::getCardId).toList();
        return this.deckService.addCardsToDeck(id, cardIds).convertToDto(modelMapper);
    }

    @PostMapping("{id}/filters")
    public DeckDto getFilteredDeckCards(@PathVariable UUID id, @RequestBody CardFilterChain filterChain) {
        return this.deckService.getFilteredDeck(id, filterChain.toFilter()).convertToDto(modelMapper);
    }
}
