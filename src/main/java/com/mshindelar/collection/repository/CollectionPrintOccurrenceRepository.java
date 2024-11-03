package com.mshindelar.collection.repository;

import com.mshindelar.collection.model.collection.CollectionPrintOccurrence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CollectionPrintOccurrenceRepository
        extends JpaRepository<CollectionPrintOccurrence, CollectionPrintOccurrence.CollectionPrintOccurrenceId> { }
