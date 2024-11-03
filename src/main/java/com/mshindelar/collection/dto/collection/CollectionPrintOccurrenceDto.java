package com.mshindelar.collection.dto.collection;

import com.mshindelar.collection.model.card.Condition;
import com.mshindelar.collection.model.card.Edition;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CollectionPrintOccurrenceDto {
    private Condition condition;
    private Edition edition;
    private int quantity;
    private int grade;
}
