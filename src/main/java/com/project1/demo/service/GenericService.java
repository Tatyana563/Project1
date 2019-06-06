package com.project1.demo.service;

import com.project1.demo.model.CityEntity;
import com.project1.demo.model.CountryEntity;

import java.util.Collection;
import java.util.Optional;

public interface GenericService<T,P> {
    void createOrUpdate(T entity);
    Collection<T> findAll();
    Optional<T> findById(int id);
    void remove (int id);

}
