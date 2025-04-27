package com.mshindelar.collection.dto.card;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CardImageDto {
    private String imageUrl;
    private String smallUrl;
    private String croppedUrl;
}
