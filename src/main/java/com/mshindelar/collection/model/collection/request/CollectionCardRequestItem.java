package com.mshindelar.collection.model.collection.request;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mshindelar.collection.model.card.Condition;
import com.mshindelar.collection.model.card.Edition;
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
public class CollectionCardRequestItem implements Serializable {
    private String setCode;
    private String setRarityCode;
    private Condition condition;
    private Edition edition;
    private int quantity;
    private int grade;
}
