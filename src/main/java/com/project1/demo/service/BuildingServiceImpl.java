package com.project1.demo.service;

import com.project1.demo.model.BuildingEntity;
import com.project1.demo.model.StreetEntity;
import com.project1.demo.repository.BuildingRepository;
import com.project1.demo.repository.StreetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;

public class BuildingServiceImpl {

    @Autowired
    private BuildingRepository buildingRepository;

    @Transactional
    public void createOrUpdate(BuildingEntity buildingEntity) {
        buildingRepository.save(buildingEntity);
    }

    @Transactional
    public void remove(BuildingEntity buildingEntity){
        final BuildingEntity buildingEntity1=
                buildingRepository.findById(buildingEntity.getId()).get();
        buildingRepository.delete(buildingEntity1);
    }

    public BuildingEntity findById(int id) {
        Optional<BuildingEntity> building = buildingRepository.findById(id);
        return building.orElse(new  BuildingEntity());
    }

    public Collection<BuildingEntity> findAll() {
        return buildingRepository.findAll();
    }
}
