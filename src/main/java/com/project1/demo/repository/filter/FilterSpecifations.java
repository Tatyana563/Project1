package com.project1.demo.repository.filter;

import com.project1.demo.model.CityEntity;
import com.project1.demo.model.CountryEntity;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

public class FilterSpecifations {
    private FilterSpecifations(){

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
}
