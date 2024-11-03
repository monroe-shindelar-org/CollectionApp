package com.mshindelar.collection.repository;

import com.mshindelar.collection.model.card.Card;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CardRepository extends CrudRepository<Card, String> {
}
