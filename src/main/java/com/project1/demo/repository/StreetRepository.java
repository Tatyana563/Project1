package com.project1.demo.repository;

import com.project1.demo.model.StreetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StreetRepository extends JpaRepository<StreetEntity, Integer> {

   // @Query("select c from CountryEntity c join c.cities w where w.population > 100")
   // List<CountryEntity> findAllByCountryPopulation();
//    @Query("select st from StreetEntity st join st.buildings bl where bl.height= ( select max(bl.height) ");
//    Integer getMaxHeightBuildingByStreet(int streetId);
            }
