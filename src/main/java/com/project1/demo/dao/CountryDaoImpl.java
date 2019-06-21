package com.project1.demo.dao;

import com.project1.demo.model.CountryEntity;
import com.project1.demo.model.enumeration.CityLocation;
import com.project1.demo.model.enumeration.Currency;
import com.project1.demo.model.enumeration.FilterKey;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.ResultSet;
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
        for (CountryEntity country : countryEntityList) {
            System.out.println(country);
        }
        return countryEntityList.size() == 0 ? Collections.emptyList() : countryEntityList;
    }

    @Override
    public Optional<CountryEntity> findById(Integer id) {
        final CountryEntity countryEntity = entityManager.find(CountryEntity.class, id);
        if (Objects.isNull(countryEntity)) throw new IllegalArgumentException("Country was not found");

        return Optional.ofNullable(countryEntity);
    }

    @Override
    public void delete(CountryEntity entity) {
        if (Objects.isNull(entity)) throw new IllegalArgumentException("Entity must be set");
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
        final StringBuilder sql = new StringBuilder("select c from CountryEntity c ");
        final StringBuilder where = new StringBuilder(" where 1=1 ");
        if (filter.containsKey(FilterKey.CITY_AREA)) {
            sql.append(" inner join c.cities cc ");
            where.append(" ").append("and cc.area>=50");
        }
        if (filter.containsKey(FilterKey.STREET_NAME)) {
            if (!filter.containsKey(FilterKey.CITY_AREA)) {
                sql.append(" inner join c.cities cc ");
            }
            sql.append(" inner join cc.streets st ");
            where.append(" and st.streetName=:streetName");
        }
        if (filter.containsKey(FilterKey.BUILDING_MATERIAL)) {
            sql.append(" inner join st.buildings bl ");
            where.append(" ").append("and bl.material=:material");
        }

        Query query = entityManager.createQuery(sql.append(where).toString());
        if (filter.containsKey(FilterKey.STREET_NAME)) {
            query.setParameter("streetName", filter.get(FilterKey.STREET_NAME));

        }
        if (filter.containsKey(FilterKey.BUILDING_MATERIAL)) {
            query.setParameter("material", filter.get(FilterKey.BUILDING_MATERIAL));
        }
        return query.getResultList();
    }
    public Collection<CountryEntity> findAllByFilter3(Map<FilterKey, Object> filter) {
        final StringBuilder sql = new StringBuilder(" select c from CountryEntity c ");
        final StringBuilder where = new StringBuilder(" where 1=1 ");
        if (filter.containsKey(FilterKey.CITY_LOCATION)) {
            sql.append(" inner join c.cities cc ");
         where.append(" and cc.location=:cityLocation ");
        }
        if(filter.containsKey(FilterKey.BUILDING_HEIGH)) {
            if (!filter.containsKey(FilterKey.CITY_LOCATION)) {
                System.out.println("No city from this location");
            } else {
                sql.append(" inner join cc.streets st ");
                sql.append(" inner join st.buildings bl ");
                where.append(" and bl.height=:buildingHeight ");
            }
        }

        Query query = entityManager.createQuery(sql.append(where).toString());
        if(filter.containsKey(FilterKey.CITY_LOCATION)){
            query.setParameter("cityLocation", filter.get(FilterKey.CITY_LOCATION));
        }
        if(filter.containsKey(FilterKey.BUILDING_HEIGH)){
          query.setParameter("buildingHeight",filter.get(FilterKey.BUILDING_HEIGH));
        }
        return query.getResultList();
    }

    @Override
    public Collection<CountryEntity> findAllByFilter4(Map<FilterKey, Object> filter) {
       final StringBuilder sql = new StringBuilder(" select c from CountryEntity c ");
       final StringBuilder where =new StringBuilder(" where 1=1 ");
       if(filter.containsKey(FilterKey.CITY_TYPE)){
           sql.append(" inner join c.cities cc ");
           where.append(" and cc.type=:cityType ");
       }
       if(filter.containsKey(FilterKey.STREET_DESCRIPTION)) {
           if (!filter.containsKey(FilterKey.CITY_TYPE)) {
               System.out.println("No city of that type");
           }
       }
           else{
               sql.append(" inner join cc.streets st ");
              where.append(" and st.description=:streetDescription ");
           }
           if(filter.containsKey(FilterKey.BUILDING_MATERIAL)) {
               if (!filter.containsKey(FilterKey.STREET_DESCRIPTION)) {
                   System.out.println("No street matches the description");
               }
           }
           else{
           sql.append(" inner join st.buildings bl ");
           where.append(" and bl.material=:buildingMaterial");
           }

           Query query = entityManager.createQuery(sql.append(where).toString());
           if(filter.containsKey(FilterKey.CITY_TYPE)){
               query.setParameter("cityType", filter.get(FilterKey.CITY_TYPE));
       }
       if(filter.containsKey(FilterKey.STREET_DESCRIPTION)){
       query.setParameter("streetDescription", filter.get(FilterKey.STREET_DESCRIPTION));
       }
       if(filter.containsKey(FilterKey.BUILDING_MATERIAL)){
           query.setParameter("buildingMaterial", filter.get(FilterKey.BUILDING_MATERIAL));
       }
       return query.getResultList();
       }



    @Override
    public Double getMinCityAreaByCountry(int countryId) {
        return((Number) entityManager.createStoredProcedureQuery("get_min_city_area")
        .registerStoredProcedureParameter("p_country_id", Integer.class, ParameterMode.IN)
                .setParameter("p_country_id", countryId)
                .getSingleResult()).doubleValue();
    }

    @Override
    public String getCityWithAreaLocation(int countryId, CityLocation cityLocation, Double area) {
        //"call get_city_with_area_location(?)"
        return (String) entityManager.createStoredProcedureQuery("get_city_with_area_location")
                .registerStoredProcedureParameter("p_country_id", Integer.class,ParameterMode.IN)
                .registerStoredProcedureParameter("p_location", String.class,ParameterMode.IN)
                .registerStoredProcedureParameter("p_area", BigDecimal.class,ParameterMode.IN)
                .setParameter("p_country_id", countryId )
                .setParameter("p_location", cityLocation.name() )
                .setParameter("p_area", new BigDecimal(area) )
                .getSingleResult();
    }
//JDBC - function, not procedure
    @Transactional
    @Override
    public Integer getMaxCityPopulationByCountry(int countryId) {
        Session session = entityManager.unwrap(Session.class);
        final Integer[] maxValue = new Integer[1];
        session.doWork(connection ->
        {try(CallableStatement function=connection.prepareCall("{call get_max_city_population(?)}")){
            function.setInt(1, countryId);
           ResultSet rs = function.getResultSet();
            if(rs!= null &&rs.next()){
                maxValue[0]= rs.getInt(1);
            };
        }});
        return maxValue[0];
    }

    @Override
    public void updateCountryCurrency(int countryId, Currency currency) {
        entityManager.createNamedStoredProcedureQuery("updateCurrency")
                .setParameter("p_country_id", countryId)
                .setParameter("p_currency", currency).execute();
    }
}




