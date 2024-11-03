package com.mshindelar.collection.model.card;

import com.mshindelar.collection.YGOPROApi.dto.Attribute;
import com.mshindelar.collection.dto.card.YGOCardDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import java.util.List;

@Entity
@Table(name = "card")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("YGO")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class YGOCard extends Card {
    private String type;
    @Column(name = "human_readable_card_type")
    private String humanReadableCardType;
    @Column(name = "frame_type")
    private String frameType;
    private String description;
    private int attack;
    private int defense;
    @Column(name = "lvl")
    private int level;
    private String race;
    private String archetype;
    @Enumerated(EnumType.STRING)
    private Attribute attribute;
    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Print> prints;

    @Override
    public YGOCardDto convertToDto(ModelMapper modelMapper) {
        return modelMapper.map(this, YGOCardDto.class);
    }
}
