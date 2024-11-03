package com.mshindelar.collection.dto.collection;

import com.mshindelar.collection.dto.card.CardDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CollectionCardDto {
    private CardDto card;
    private List<CollectionPrintDto> prints;
}
