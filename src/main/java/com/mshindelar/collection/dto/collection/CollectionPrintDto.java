package com.mshindelar.collection.dto.collection;

import com.mshindelar.collection.dto.card.PrintDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CollectionPrintDto {
    private PrintDto print;
    private List<CollectionPrintOccurrenceDto> occurrences;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CollectionPrintDto that = (CollectionPrintDto) o;
        return print.equals(that.print) && occurrences.equals(that.occurrences);
    }

    @Override
    public int hashCode() {
        return Objects.hash(print, occurrences);
    }
}
