package com.project1.demo.dao;

import com.project1.demo.model.CityEntity;
import org.springframework.util.CollectionUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.Optional;

public class CityDaoImpl implements CityDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(CityEntity entity) {
       if(Objects.isNull(entity)) throw new IllegalArgumentException("Please set a city");
       if(Objects.isNull(entity.getId())){
           entityManager.persist(entity);
       }
       else{
           entityManager.merge(entity);
       }
    }

    @Override
    public Collection<CityEntity> findAll() {
        Collection<CityEntity> cityEntities=
                entityManager.createNativeQuery("SELECT CITY_NAME AS CITY_NAME,"+
                        "CITY_TYPE as CITY_TYPE,"+
                        "LOCATION AS LOCATION,"+
                        "AREA AS AREA,"+
                        "COUNTRY_ID AS COUNTRY_ID "+
                        "FROM TOWN",
                        CityEntity.class).getResultList();
        return CollectionUtils.isEmpty(cityEntities)? Collections.emptyList():cityEntities;
    }

    @Override
    public Optional<CityEntity> findById(Integer id) {
        final CityEntity cityEntity =
                entityManager.find(CityEntity.class, id);
        if(Objects.isNull(cityEntity)) throw new NullPointerException("City was not found");
        return Optional.empty();
    }

    @Override
    public void delete(final CityEntity entity) {
if(Objects.isNull(entity)) throw new IllegalArgumentException("entity must be set");
entityManager.remove(entity);
    }
}
