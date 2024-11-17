package com.mshindelar.collection.repository;

import com.mshindelar.collection.model.Account;
import com.mshindelar.collection.model.collection.Collection;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CollectionRepository extends CrudRepository<Collection, UUID> {
    Optional<Collection> findByNameAndOwner(String name, Account owner);
}
