package com.project1.demo.service;

import com.project1.demo.model.CityEntity;

import java.util.Collection;

public interface CityService extends GenericService<CityEntity, Integer> {
    void updateCityArea(int townId, double townArea);
    void updateCityPopulation(int townId, int townPopulation);
}
