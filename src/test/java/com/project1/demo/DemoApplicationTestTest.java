package com.project1.demo;

import com.project1.demo.model.BuildingEntity;
import com.project1.demo.model.CityEntity;
import com.project1.demo.model.StreetEntity;
import com.project1.demo.model.enumeration.cityLocation;
import com.project1.demo.service.CityService;
import com.project1.demo.service.StreetServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.project1.demo.repository.StreetRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTestTest {
    @Autowired
    StreetServiceImpl streetService;
    @Autowired
    CityService cityService;
    @Autowired


    @Test
    public void contexLoads() {
        final StreetEntity streetEntity = new StreetEntity();
        streetEntity.setDescription("The main street");
        streetEntity.setStreetName("AppleStreet");
        streetEntity.setTownId(2);
        streetService.createOrUpdate(streetEntity);
    }
    public void testCity(){
   final CityEntity cityEntity = new CityEntity();
   cityEntity.setCountryId(1);
   cityEntity.setType("city");
   cityEntity.setLocation(cityLocation.center);
   cityEntity.setName("Drezden");
   cityService.createOrUpdate(cityEntity);
    }
    public void testBuilding(){
        final BuildingEntity buildingEntity = new BuildingEntity();

    }
}
