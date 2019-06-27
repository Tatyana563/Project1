package com.project1.demo.dao;

import com.project1.demo.model.CityEntity;
import com.project1.demo.model.CountryEntity;
import com.project1.demo.model.enumeration.FilterKey;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.*;

@Repository
@Qualifier("cityDao")

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
                entityManager.createNativeQuery("SELECT TOWN_NAME AS TOWN_NAME,"+
                        "TOWN_TYPE as TOWN_TYPE,"+
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
        return Optional.of(cityEntity);
    }

    @Override
    public void delete(final CityEntity entity) {
if(Objects.isNull(entity)) throw new IllegalArgumentException("entity must be set");
entityManager.remove(entity);
    }

    @Override
    public void updateCityArea(int townId, double townArea) {
        entityManager.createStoredProcedureQuery("update_town_area")
                .registerStoredProcedureParameter("p_town_id", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("p_area", BigDecimal.class, ParameterMode.IN)
                .setParameter("p_town_id",townId)
                .setParameter("p_area", new BigDecimal(townArea)).execute();
    }

    @Override
    public void updateCityPopulation(int townId, int townPopulation) {
        entityManager.createNamedStoredProcedureQuery("changePopulation")
                .setParameter("p_city_id", townId)
                .setParameter("p_population", townPopulation).execute();
    }


}
