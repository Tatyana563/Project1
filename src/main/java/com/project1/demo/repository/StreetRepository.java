package com.project1.demo.repository;

import com.project1.demo.model.StreetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StreetRepository extends JpaRepository<StreetEntity, Integer> {
}
