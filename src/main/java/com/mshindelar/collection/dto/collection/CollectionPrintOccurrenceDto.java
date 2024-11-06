package com.mshindelar.collection.dto.collection;

import com.mshindelar.collection.model.card.Condition;
import com.mshindelar.collection.model.card.Edition;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CollectionPrintOccurrenceDto {
    private Condition condition;
    private Edition edition;
    private int quantity;
    private int grade;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CollectionPrintOccurrenceDto that = (CollectionPrintOccurrenceDto) o;
        return quantity == that.quantity && grade == that.grade && condition == that.condition && edition == that.edition;
    }

    @Override
    public int hashCode() {
        return Objects.hash(condition, edition, quantity, grade);
    }
}
