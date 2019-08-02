package com.project1.demo.dto.request;

import com.project1.demo.model.CountryEntity;
import com.project1.demo.model.enumeration.Currency;
import com.project1.demo.model.enumeration.Language;

public class CountryRequest {
    private String name;
    private String language;
    private String currency;
    private Integer population;
    private Double area;
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public CountryEntity convert() {
        final CountryEntity countryEntity = new CountryEntity();
        countryEntity.setCountryName(this.getName());
        countryEntity.setPopulation(this.getPopulation());
        countryEntity.setLanguage(Language.valueOf(this.getLanguage()));
        countryEntity.setCurrency(Currency.valueOf(this.getCurrency()));
        countryEntity.setArea(this.getArea());
        countryEntity.setId(this.getId());
        return countryEntity;
    }
}
