package com.mshindelar.collection.model.deck;

import com.mshindelar.collection.dto.deck.DeckCardDto;
import com.mshindelar.collection.model.DaoConverter;
import com.mshindelar.collection.model.card.Card;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.io.Serializable;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "deck_card")
public class DeckCard implements Serializable, DaoConverter<DeckCardDto> {
    @Id
    @GeneratedValue
    private UUID id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Deck deck;
    @ManyToOne(fetch = FetchType.LAZY)
    private Card card;
    private int quantity;

    @Override
    public DeckCardDto convertToDto(ModelMapper modelMapper) {
        DeckCardDto deckCardDto = new DeckCardDto();
        deckCardDto.setCard(this.card.convertToDto(modelMapper));
        deckCardDto.setQuantity(quantity);
        return deckCardDto;
    }
}
