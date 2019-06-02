package com.project1.demo.repository;

import com.project1.demo.model.BuildingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuildingRepository extends JpaRepository<BuildingEntity, Integer> {
}
