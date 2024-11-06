package com.mshindelar.collection.dto.collection;

import com.mshindelar.collection.dto.card.CardDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CollectionCardDto {
    private CardDto card;
    private List<CollectionPrintDto> prints;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CollectionCardDto that = (CollectionCardDto) o;
        return card.equals(that.card) && prints.equals(that.prints);
    }

    @Override
    public int hashCode() {
        return Objects.hash(card, prints);
    }
}
