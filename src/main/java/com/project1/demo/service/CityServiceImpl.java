package com.project1.demo.service;

import com.project1.demo.dao.CityDao;
import com.project1.demo.dao.CountryDao;
import com.project1.demo.dao.GenericDao;
import com.project1.demo.model.CityEntity;
import com.project1.demo.model.CountryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    @Qualifier("cityDao")
    private CityDao cityDao;
    @Autowired
    private CountryDao countryDao;
    @Override
    @Transactional
    public void createOrUpdate(CityEntity entity) {
        CountryEntity countryEntity = countryDao.findById(entity.getCountry().getId()).get();
        entity.setCountry(countryEntity);
        cityDao.save(entity);
    }

    @Override
    @Transactional
    public Collection<CityEntity> findAll() {
        return cityDao.findAll();
    }

    @Override
    @Transactional
    public Optional<CityEntity> findById(int id) {
        Optional<CityEntity> city = cityDao.findById(id);

        return Optional.ofNullable(city.orElse(new CityEntity()));

    }


    @Override
    @Transactional
    public void remove(int id) {
CityEntity cityEntity = findById(id).get();
cityDao.delete(cityEntity);
    }

    @Override
    @Transactional
    public void updateCityArea(int townId, double townArea) {
     cityDao.updateCityArea(townId, townArea);
    }

    @Override
    @Transactional
    public void updateCityPopulation(int townId, int townPopulation) {
     cityDao.updateCityPopulation(townId, townPopulation);
    }
}