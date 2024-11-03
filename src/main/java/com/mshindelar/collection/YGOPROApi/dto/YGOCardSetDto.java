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
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class YGOCardSetDto implements Serializable {
    @JsonProperty("set_name")
    private String setName;
    @JsonProperty("set_code")
    private String setCode;
    @JsonProperty("set_rarity")
    private String setRarity;
    @JsonProperty("set_rarity_code")
    private String setRarityCode;
}
