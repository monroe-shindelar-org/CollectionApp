package com.mshindelar.collection.model.card;

import com.mshindelar.collection.dto.card.CardImageDto;
import com.mshindelar.collection.model.DaoConverter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.io.Serializable;

@Entity
@Table(name = "card_image")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardImage implements Serializable, DaoConverter<CardImageDto> {
    @Id
    private int id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private Card card;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "small_url")
    private String smallUrl;

    @Column(name = "cropped_url")
    private String croppedUrl;

    @Override
    public CardImageDto convertToDto(ModelMapper modelMapper) {
        return modelMapper.map(this, CardImageDto.class);
    }
}
