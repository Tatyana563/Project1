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

@Service
public class BuildingServiceImpl implements BuildingService {
    @Autowired
    private BuildingRepository buildingRepository;

    @Override
    @Transactional
    public void createOrUpdate(BuildingEntity entity) {
        buildingRepository.save(entity);
    }

    @Override
    @Transactional
    public Collection<BuildingEntity> findAll() {
        buildingRepository.findAll();
        return null;
    }

    @Override
    @Transactional
    public Optional<BuildingEntity> findById(int id) {
        buildingRepository.findById(id);
        return Optional.empty();
    }

    @Override
    @Transactional
    public void remove(int id) {
        BuildingEntity buildingEntity = findById(id).get();
        buildingRepository.delete(buildingEntity);
    }
}