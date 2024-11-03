package com.mshindelar.collection.dto.collection;

import com.mshindelar.collection.dto.card.PrintDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CollectionPrintDto {
    private PrintDto print;
    private List<CollectionPrintOccurrenceDto> occurrences;
}
