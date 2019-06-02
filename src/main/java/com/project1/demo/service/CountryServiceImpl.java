package com.project1.demo.service;

import com.project1.demo.dao.CountryDao;
import com.project1.demo.dao.GenericDao;
import com.project1.demo.model.CityEntity;
import com.project1.demo.model.CountryEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;

public class CountryServiceImpl implements CountryService {
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
        Optional<CountryEntity> country= countryDao.findById(id);
        return Optional.ofNullable(country);
    }

    @Override
    @Transactional
    public void remove(int id) {
        CountryEntity countryEntity=findById(id);
countryDao.delete(countryEntity);
    }
}
