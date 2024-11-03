package com.mshindelar.collection.dto.card;

import com.mshindelar.collection.YGOPROApi.dto.Attribute;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class YGOCardDto extends CardDto {
    private String type;
    private int level;
    private String race;
    private String archetype;
    private Attribute attribute;
    private String description;
    private int attack;
    private int defense;
}
