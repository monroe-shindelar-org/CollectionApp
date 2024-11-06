package com.mshindelar.collection.dto.card;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PrintDto {
    private String id;
    private String setRarityCode;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrintDto printDto = (PrintDto) o;
        return id.equals(printDto.id) && setRarityCode.equals(printDto.setRarityCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, setRarityCode);
    }
}
