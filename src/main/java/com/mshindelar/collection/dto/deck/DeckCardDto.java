package com.mshindelar.collection.dto.deck;

import com.mshindelar.collection.dto.card.CardDto;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeckCardDto {
    private CardDto card;
    private int quantity;
}
