package com.project1.demo.service;

import com.project1.demo.dto.request.CountryRequest;
import com.project1.demo.dto.response.CountryResponse;
import com.project1.demo.model.CityEntity;
import com.project1.demo.model.CountryEntity;
import com.project1.demo.model.enumeration.CityLocation;
import com.project1.demo.model.enumeration.Currency;
import com.project1.demo.model.enumeration.FilterKey;
import com.project1.demo.model.enumeration.Language;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Map;

public interface CountryService extends GenericService<CountryEntity, Integer> {
    Collection<CountryEntity> findAll(int position, int limit);
    Collection<CountryEntity> findAllByFilter(Map<FilterKey, Object> filter);
    Collection<CountryEntity> findAllByFilter2(Map<FilterKey, Object> filter);
    Collection<CountryEntity> findAllByFilter3(Map<FilterKey, Object> filter);
    Collection<CountryEntity> findAllByFilter4(Map<FilterKey, Object> filter);
    Double getMinCityAreaByCountry(int countryId);

    String getCityWithAreaLocation(int countryId, CityLocation cityLocation, Double area);

    Collection<CityEntity> getAllCitiesByCountry(int countryId);

    Integer getMaxCityPopulationByCountry(int countryId);
    void updateCountryCurrency(int countryId, Currency currency);
    void updateCountryInfo(int countryId, Double countryArea, Integer countryPopulation, Language language, Currency countryCurrency);
    void updateCountryInfo2(int countryId, Double countryArea, Integer countryPopulation, Language countryLanguage, Currency countryCurrency);
    void updateCountryInfo3(int countryId, Double countryArea, Integer countryPopulation, Language countryLanguage, Currency countryCurrency);
    Collection<CountryEntity> findAll(Specification specification);
    Collection<CountryResponse> findAllForRest();
    CountryResponse findByCountryDetails(String language, String currency);
    String getCountryByDetails(Language language, Currency currency);

    CountryRequest deleteByIdRequest(int id);


}

