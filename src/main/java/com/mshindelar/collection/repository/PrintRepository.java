package com.mshindelar.collection.repository;

import com.mshindelar.collection.model.card.Print;
import org.springframework.data.repository.CrudRepository;

public interface PrintRepository extends CrudRepository<Print, Print.PrintId> { }
