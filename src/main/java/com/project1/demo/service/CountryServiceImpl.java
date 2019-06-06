package com.project1.demo.service;

import com.project1.demo.dao.CountryDao;
import com.project1.demo.model.CountryEntity;
import com.project1.demo.model.enumeration.FilterKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {
    @Autowired
    private CountryDao countryDao;

    @Override
    @Transactional
    public void createOrUpdate(CountryEntity entity) {
        countryDao.save(entity);
    }

    @Override
    @Transactional
    public Collection<CountryEntity> findAll() {
        return countryDao.findAll();
    }


    @Override
    @Transactional
    public Optional<CountryEntity> findById(int id) {
        Optional<CountryEntity> country = countryDao.findById(id);
        if (country.isPresent()) {
            return Optional.ofNullable(country.get());
        }
        return country;

    }


    @Override// polimorfism
    @Transactional
    public void remove(int id) {
        Optional<CountryEntity> countryEntity = findById(id);
        if (countryEntity.isPresent()) {
            countryDao.delete(countryEntity.get());// get entity from optional
        }

    }


    @Override
    @Transactional
    public Collection<CountryEntity> findAll(int position, int limit) {
        countryDao.findAll(position, limit);
        return null;
    }

    @Override
    public Collection<CountryEntity> findAllByFilter(Map<FilterKey, Object> filter) {
        return countryDao.findAllByFilter(filter);
    }
}
