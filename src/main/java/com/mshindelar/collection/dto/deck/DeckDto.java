package com.mshindelar.collection.dto.deck;

import lombok.*;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeckDto {
    private UUID id;
    private UUID ownerId;

    private String name;
    private List<DeckCardDto> main;
    private List<DeckCardDto> side;
    private List<DeckCardDto> extra;
}
