package com.project1.demo.repository;

import com.project1.demo.model.BuildingEntity;
import com.project1.demo.model.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingRepository extends JpaRepository<BuildingEntity, Integer>, JpaSpecificationExecutor<BuildingEntity> {
}
