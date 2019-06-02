package com.project1.demo.dao;

import com.project1.demo.model.CountryEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.*;

public class CountryDaoImpl implements CountryDao {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void save(CountryEntity entity) {
        if (Objects.isNull(entity)) throw new IllegalArgumentException("Country must be set");
        if (Objects.isNull(entity.getId())) {
            entityManager.persist(entity);

        } else {
            entityManager.merge(entity);
        }
    }
    @Override
    public Collection<CountryEntity> findAll() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<CountryEntity> query = cb.createQuery(CountryEntity.class);
        Root<CountryEntity> root = query.from(CountryEntity.class);
        query.select(root);
        List<CountryEntity> countryEntityList =
                entityManager.createQuery(query).getResultList();
        for(CountryEntity country: countryEntityList){
            System.out.println(country);
        }
        return countryEntityList.size()==0? Collections.emptyList():countryEntityList;
}

    @Override
    public Optional<CountryEntity> findById(Integer id) {
        final CountryEntity countryEntity = entityManager.find(CountryEntity.class, id);
        if(Objects.isNull(countryEntity)) throw new IllegalArgumentException("Country was not found");

        return Optional.ofNullable(countryEntity);
    }

    @Override
    public void delete(CountryEntity entity) {
if(Objects.isNull(entity)) throw new IllegalArgumentException("Entity must be set");
entityManager.remove(entity);
    }
}
