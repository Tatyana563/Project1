package com.project1.demo.service;

import com.project1.demo.dao.CountryDao;
import com.project1.demo.dto.request.CountryRequest;
import com.project1.demo.dto.response.CountryResponse;
import com.project1.demo.model.CityEntity;
import com.project1.demo.model.CountryEntity;
import com.project1.demo.model.enumeration.CityLocation;
import com.project1.demo.model.enumeration.Currency;
import com.project1.demo.model.enumeration.FilterKey;
import com.project1.demo.model.enumeration.Language;
import com.project1.demo.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CountryServiceImpl implements CountryService {
    @Autowired
    private CountryDao countryDao;
    @Autowired
private CountryRepository countryRepository;

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
        Optional<CountryEntity> country = countryDao.findById(id);
        if (country.isPresent()) {
            return Optional.ofNullable(country.get());
        }
        return country;

    }


    @Override// polimorfism
    @Transactional
    public void remove(int id) {
        Optional<CountryEntity> countryEntity = findById(id);
        if (countryEntity.isPresent()) {
            countryDao.delete(countryEntity.get());// get entity from optional
        }

    }


    @Override
    @Transactional
    public Collection<CountryEntity> findAll(int position, int limit) {
        countryDao.findAll(position, limit);
        return null;
    }

    @Override
    public Collection<CountryEntity> findAllByFilter(Map<FilterKey, Object> filter) {
        return countryDao.findAllByFilter(filter);
    }

    @Override
    public Collection<CountryEntity> findAllByFilter2(Map<FilterKey, Object> filter) {
        return countryDao.findAllByFilter2(filter);
    }

    @Override
    public Collection<CountryEntity> findAllByFilter3(Map<FilterKey, Object> filter) {
        return countryDao.findAllByFilter3(filter);
    }

    @Override
    public Collection<CountryEntity> findAllByFilter4(Map<FilterKey, Object> filter) {
        return countryDao.findAllByFilter4(filter);
    }

    @Override
    public Double getMinCityAreaByCountry(int countryId) {
        return countryDao.getMinCityAreaByCountry(countryId);
    }

    @Override
    public String getCityWithAreaLocation(int countryId, CityLocation cityLocation, Double area) {
        return countryDao.getCityWithAreaLocation(countryId, cityLocation, area);
    }

    @Override
    @Transactional
    public Collection<CityEntity> getAllCitiesByCountry(int countryId) {
        return countryDao.getAllCitiesByCountry(countryId);
    }

    @Override
    public Integer getMaxCityPopulationByCountry(int countryId) {
        return countryDao.getMaxCityPopulationByCountry(countryId);
    }

    @Override
    @Transactional
    public void updateCountryCurrency(int countryId, Currency currency) {
        countryDao.updateCountryCurrency(countryId, currency);
    }

    @Override
    @Transactional
    public void updateCountryInfo(int countryId, Double countryArea, Integer countryPopulation, Language countryLanguage, Currency countryCurrency) {
        countryDao.updateCountryInfo(countryId, countryArea, countryPopulation, countryLanguage, countryCurrency);
    }

    @Override
    @Transactional
    public void updateCountryInfo2(int countryId, Double countryArea, Integer countryPopulation, Language countryLanguage, Currency countryCurrency) {
        countryDao.updateCountryInfo2(countryId, countryArea, countryPopulation, countryLanguage, countryCurrency);
    }

    @Override
    @Transactional
    public void updateCountryInfo3(int countryId, Double countryArea, Integer countryPopulation, Language countryLanguage, Currency countryCurrency) {
        countryDao.updateCountryInfo3(countryId, countryArea, countryPopulation, countryLanguage, countryCurrency);
    }

    @Override
    public Collection<CountryEntity> findAll(Specification specification) {
        return countryRepository.findAll(specification);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<CountryResponse> findAllForRest() {
        Collection<CountryEntity> countries = countryDao.findAll();
     if(CollectionUtils.isEmpty(countries))

        return Collections.emptyList();
      return countries.stream().
              map(item->new CountryResponse(item))
              .collect(Collectors.toList());
    }

    @Override
    public CountryResponse findByCountryDetails(String language, String currency) {
        return null;
    }


    @Override
    public String getCountryByDetails(Language language, Currency currency) {
        return countryDao.getCountryByDetails(language,currency);
    }

    @Override
    @Transactional
    public CountryRequest deleteByIdRequest(int id) {
        CountryEntity countryEntity =findById(id).get();
        countryDao.delete(countryEntity);
        return null;
    }


}
