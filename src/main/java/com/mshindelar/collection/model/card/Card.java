package com.mshindelar.collection.model.card;

import com.mshindelar.collection.dto.card.CardDto;
import com.mshindelar.collection.dto.card.YGOCardDto;
import com.mshindelar.collection.model.DaoConverter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "card")
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING, name = "franchise")
public class Card implements Serializable, DaoConverter<CardDto> {
    @Id
    private String id;
    private String name;

    @Override
    public CardDto convertToDto(ModelMapper modelMapper) { return null; }
}
