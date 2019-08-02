package com.project1.demo.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.project1.demo.model.CountryEntity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CountryResponse {
        private Integer id;
        private String name;
        private String language;
        private String currency;
        private Integer population;
        private Double area;

    public CountryResponse() {
    }
        private Collection<CityResponse> cities = new ArrayList<>();

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

    public Collection<CityResponse> getCities() {
        return cities;
    }

    public void setCities(Collection<CityResponse> cities) {
        this.cities = cities;
    }

    public CountryResponse (CountryEntity countryEntity){
           if(Objects.isNull(countryEntity)) return;
           this.id = countryEntity.getId();
           this.name = countryEntity.getCountryName();
           this.language=countryEntity.getLanguage().name();
           this.currency=countryEntity.getCurrency().name();
           this.area=countryEntity.getArea();
           this.population= countryEntity.getPopulation();

            if (countryEntity.getCities() != null && !countryEntity.getCities().isEmpty())
            countryEntity.getCities().forEach(item->this.cities.add(new CityResponse(item)));{
            }
            }

    @Override
    public String toString() {
        return "CountryResponse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", language='" + language + '\'' +
                ", currency='" + currency + '\'' +
                ", population=" + population +
                ", area=" + area +
                ", cities=" + cities +
                '}';
    }


}

