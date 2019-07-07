package com.project1.demo.repository;

import com.project1.demo.model.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CityRepository extends JpaRepository<CityEntity, Integer>, JpaSpecificationExecutor<CityEntity> {
}
