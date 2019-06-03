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

public class BuildingServiceImpl implements GenericService<BuildingEntity,Integer> {
    @Autowired
    private BuildingRepository buildingRepository;

    @Override
    public void createOrUpdate(BuildingEntity entity) {
        buildingRepository.save(entity);
    }

    @Override
    public Collection<BuildingEntity> findAll() {
        buildingRepository.findAll();
        return null;
    }

    @Override
    public Optional<BuildingEntity> findById(int id) {
        buildingRepository.findById(id);
        return Optional.empty();
    }

    @Override
    public void remove(int id) {
        BuildingEntity buildingEntity = findById(id).get();
        buildingRepository.delete(buildingEntity);
    }
}