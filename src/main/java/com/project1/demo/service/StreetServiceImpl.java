package com.project1.demo.service;

import com.project1.demo.dao.CityDao;
import com.project1.demo.model.CityEntity;
import com.project1.demo.model.StreetEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.project1.demo.repository.StreetRepository;

import java.util.Collection;
import java.util.Optional;

@Service
public class StreetServiceImpl {
    @Autowired
    private StreetRepository streetRepository;
@Autowired
private CityDao cityDao;
    @Transactional
    public void createOrUpdate(StreetEntity streetEntity) {
        CityEntity cityEntity= cityDao.findById(streetEntity.getTownId()).get();
        streetEntity.setTown(cityEntity);
        streetRepository.save(streetEntity);

    }

    @Transactional
    public void remove(StreetEntity streetEntity){
      final StreetEntity streetEntity1=
               streetRepository.findById(streetEntity.getId()).get();
       streetRepository.delete(streetEntity1);
    }
    @Transactional
    public StreetEntity findById(int id) {
        Optional<StreetEntity> street = streetRepository.findById(id);
        if (street.isPresent()) {
            street.get().getBuildings().size();
        }
        return street.orElse(new StreetEntity());
    }
    @Transactional
    public Collection<StreetEntity> findAll() {
        return streetRepository.findAll();
    }
}
