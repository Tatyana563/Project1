package com.project1.demo.repository.filter;

import com.project1.demo.model.BuildingEntity;
import com.project1.demo.model.CityEntity;
import com.project1.demo.model.CountryEntity;
import com.project1.demo.model.StreetEntity;
import com.project1.demo.model.enumeration.CityLocation;
import com.project1.demo.model.enumeration.buildingMaterial;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

public class FilterSpecifations {
    private FilterSpecifations() {

    }

    public static Specification<CountryEntity> cityAreaFilter(final Double townArea) {
        Specification specif = new Specification<CountryEntity>() {

            @Override
            public Predicate toPredicate(Root<CountryEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Join<CountryEntity, CityEntity> towns = root.join("cities");
                return criteriaBuilder.lessThan(towns.get("area"), townArea);
            }
        };
        return specif;
    }

    public static Specification<CountryEntity> streetNameFilter(final String streetName) {
        Specification specif = new Specification<CountryEntity>() {
            @Override
            public Predicate toPredicate(Root<CountryEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Join<CountryEntity, CityEntity> towns = root.join("cities");
                Join<CityEntity, StreetEntity> allStreets = towns.join("streets");
                return criteriaBuilder.equal(allStreets.get("name"), streetName);
            }
        };
        return specif;
    }

    public static Specification<CountryEntity> buildingMaterialFilter(buildingMaterial buildingMaterial) {
        Specification specif = new Specification<CountryEntity>() {

            @Override
            public Predicate toPredicate(Root<CountryEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Join<CountryEntity, CityEntity> towns = root.join("cities");
                Join<CityEntity, StreetEntity> allStreets = towns.join("cities");
                Join<StreetEntity, BuildingEntity> allBuildings = allStreets.join("buildings");
                return criteriaBuilder.equal(allBuildings.get("material"), buildingMaterial);
            }
        };
        return specif;
    }

    public static Specification<CountryEntity> cityLocationFilter(CityLocation location) {
        Specification specif = new Specification<CountryEntity>() {

            @Override
            public Predicate toPredicate(Root<CountryEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Join<CountryEntity, CityEntity> towns = root.join("cities");
                return criteriaBuilder.equal(towns.get("location"), location);

            }
        };
        return specif;
    }
    public static Specification<CountryEntity> buildingHeightFilter(double height){
        Specification specif = new Specification<CountryEntity>() {
            @Override
            public Predicate toPredicate(Root<CountryEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Join<CountryEntity, CityEntity> towns = root.join("cities");
                Join<CityEntity, StreetEntity> allStreets = towns.join("cities");
                Join<StreetEntity, BuildingEntity> allBuildings = allStreets.join("buildings");
                return criteriaBuilder.equal(allBuildings.get("height"),height);
            }
        };
        return specif;
        }
    }
    public static Specification<CountryEntity> cityTypeFilter(String type) {
        Specification specif = new Specification<CountryEntity>() {

            @Override
            public Predicate toPredicate(Root<CountryEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Join<CountryEntity, CityEntity> towns = root.join("cities");
                return criteriaBuilder.equal(towns.get("type"), type);

            }
        };
        return specif;
    }
    public static Specification<CountryEntity> streetDescriptionFilter(final String description) {
        Specification specif = new Specification<CountryEntity>() {
            @Override
            public Predicate toPredicate(Root<CountryEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Join<CountryEntity, CityEntity> towns = root.join("cities");
                Join<CityEntity, StreetEntity> allStreets = towns.join("streets");
                return criteriaBuilder.equal(allStreets.get("description"), description);
            }
        };
        return specif;
    }
}