package com.project1.demo.service;

import com.project1.demo.model.CountryEntity;
import com.project1.demo.model.enumeration.FilterKey;

import java.util.Collection;
import java.util.Map;

public interface CountryService extends GenericService<CountryEntity, Integer> {
    Collection<CountryEntity> findAll(int position, int limit);
    Collection<CountryEntity> findAllByFilter(Map<FilterKey, Object> filter);
}
