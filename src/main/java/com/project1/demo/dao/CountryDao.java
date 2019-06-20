package com.project1.demo.dao;

import com.project1.demo.model.CountryEntity;
import com.project1.demo.model.enumeration.CityLocation;
import com.project1.demo.model.enumeration.Currency;
import com.project1.demo.model.enumeration.FilterKey;

import java.util.Collection;
import java.util.Map;

public interface CountryDao extends GenericDao<CountryEntity, Integer> {
    Collection<CountryEntity> findAll(int position, int limit);
    Collection<CountryEntity> findAllByFilter(Map<FilterKey, Object> filter);
    Collection<CountryEntity> findAllByFilter2(Map<FilterKey, Object> filter);

    Collection<CountryEntity> findAllByFilter3(Map<FilterKey, Object> filter);
    Collection<CountryEntity> findAllByFilter4(Map<FilterKey, Object> filter);
Double getMinCityAreaByCountry(int countryId);

    String getCityWithAreaLocation(int countryId, CityLocation cityLocation, Double area);
Integer getMaxCityPopulationByCountry(int countryId);
void updateCountryCurrency(int countryId, Currency currency);
}
