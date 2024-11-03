package com.mshindelar.collection.dto.collection;

import com.mshindelar.collection.model.collection.CollectionSettings;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CollectionDto {
    private UUID id;
    private UUID ownerId;
    private String name;
    private CollectionSettings collectionSettings;
    private List<CollectionCardDto> collectionItems;
}
