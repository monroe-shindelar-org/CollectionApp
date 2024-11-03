package com.mshindelar.collection.repository;

import com.mshindelar.collection.model.card.Card;
import com.mshindelar.collection.model.collection.Collection;
import com.mshindelar.collection.model.collection.CollectionCard;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface CollectionCardRepository extends CrudRepository<CollectionCard, UUID> {
    Optional<CollectionCard> findByCollectionAndCard(Collection collection, Card card);
}
