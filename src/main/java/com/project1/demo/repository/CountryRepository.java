package com.project1.demo.repository;

import com.project1.demo.model.CountryEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CountryRepository extends JpaSpecificationExecutor<CountryEntity> {
}
