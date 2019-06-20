package com.project1.demo.dao;

import com.project1.demo.model.CityEntity;
import com.project1.demo.model.CountryEntity;
import com.project1.demo.model.enumeration.FilterKey;

import java.util.Collection;
import java.util.Map;

public interface CityDao extends GenericDao<CityEntity, Integer> {
void updateCityArea(int townId, double townArea);
void updateCityPopulation(int townId, int townPopulation);
}


