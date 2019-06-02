package com.project1.demo.service;

import com.project1.demo.dao.CityDao;
import com.project1.demo.dao.GenericDao;
import com.project1.demo.model.CityEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Objects;
import java.util.Optional;

public class CityServiceImpl implements CityService {
    private GenericDao<CityEntity, Integer> cityDao;
    @Override
    public void createOrUpdate(CityEntity entity) {
     cityDao.save(entity);
    }

    @Override
    public Collection<CityEntity> findAll() {
        return cityDao.findAll();
    }

    @Override
    public Optional<CityEntity> findById(int id) {
        Optional<CityEntity> city = cityDao.findById(id);

        return Optional.ofNullable(city.orElse(new CityEntity()));

    }


    @Override
    public void remove(int id) {
CityEntity cityEntity = findById(id).get();
cityDao.delete(cityEntity);
    }
}