package com.mshindelar.collection.repository;

import com.mshindelar.collection.model.card.Print;
import com.mshindelar.collection.model.collection.CollectionCard;
import com.mshindelar.collection.model.collection.CollectionPrint;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface CollectionPrintRepository extends CrudRepository<CollectionPrint, UUID> {
    Optional<CollectionPrint> findByCollectionCardAndPrint(CollectionCard collectionCard, Print print);
}
