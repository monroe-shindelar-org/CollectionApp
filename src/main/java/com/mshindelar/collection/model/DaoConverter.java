package com.mshindelar.collection.model;

import org.modelmapper.ModelMapper;

import java.io.Serializable;

public interface DaoConverter<T> {
    T convertToDto(ModelMapper modelMapper);
}
