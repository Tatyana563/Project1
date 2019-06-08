package com.project1.demo.dao;

import com.project1.demo.model.CountryEntity;
import com.project1.demo.model.enumeration.FilterKey;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.*;

@Repository
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

    @Override
    public Collection<CountryEntity> findAll(int position, int limit) {

        return entityManager.createQuery("select c from country c")
                .setFirstResult(position)
                .setMaxResults(limit)
                .getResultList();
    }

    @Override
    public Collection<CountryEntity> findAllByFilter(Map<FilterKey, Object> filter) {

            final StringBuilder sql = new StringBuilder("select c from CountryEntity c");
            final StringBuilder where = new StringBuilder("where 1=1");

            if (filter.containsKey(FilterKey.CITY_AREA)) {
                sql.append("inner join c.cities cc");
                where.append("and cc.area<=:cityArea");
            }
            Query query = entityManager.createQuery(sql.toString());
           if (filter.containsKey(FilterKey.CITY_AREA)) {
                query.setParameter("cityArea", filter.get(FilterKey.CITY_AREA));
            }


            return query.getResultList();
        }

    @Override
    public Collection<CountryEntity> findAllByFilter2(Map<FilterKey, Object> filter) {
       final StringBuilder sql=new StringBuilder("select c from CountryEntity c");
       final StringBuilder where = new StringBuilder("where 1=1");
       if(filter.containsKey(FilterKey.CITY_AREA)){
           sql.append("inner join c.cities cc");
           where.append("and cc.area>=50");
       }
       if(filter.containsKey(FilterKey.STREET_NAME)) {
           sql.append("inner join cc.streets st");
           where.append("st.name=:streetName");
       }
       if(filter.containsKey(FilterKey.BUILDING_MATERIAL)){
           sql.append("inner join st.buildings bl");
           where.append("and bl.material=:material");
       }
       Query query = entityManager.createQuery(sql.toString());
       if((filter.containsKey(FilterKey.STREET_NAME))&&(filter.containsKey(FilterKey.BUILDING_MATERIAL))){
           query.setParameter("streetName", filter.get(FilterKey.STREET_NAME))&((query.setParameter("material", filter.get(FilterKey.BUILDING_MATERIAL)));
       }
       return query.getResultList();
        }

    }




