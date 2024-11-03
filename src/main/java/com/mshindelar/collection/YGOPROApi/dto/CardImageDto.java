package com.mshindelar.collection.YGOPROApi.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CardImageDto implements Serializable {
    private int id;
    @JsonProperty("image_url")
    private String imageUrl;
    @JsonProperty("image_url_small")
    private String smallUrl;
    @JsonProperty("image_url_cropped")
    private String croppedUrl;
}
