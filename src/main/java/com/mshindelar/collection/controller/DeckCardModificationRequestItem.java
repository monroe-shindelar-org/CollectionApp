package com.mshindelar.collection.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeckCardModificationRequestItem {
    private String cardId;
    private int quantity;
}
