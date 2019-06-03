package com.project1.demo;

import com.project1.demo.model.BuildingEntity;
import com.project1.demo.model.CityEntity;
import com.project1.demo.model.StreetEntity;
import com.project1.demo.model.enumeration.buildingMaterial;
import com.project1.demo.model.enumeration.buildingType;
import com.project1.demo.model.enumeration.cityLocation;
import com.project1.demo.service.BuildingServiceImpl;
import com.project1.demo.service.CityService;
import com.project1.demo.service.GenericService;
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
    GenericService genericService;

    @Test
    public void testStreet() {
        final StreetEntity streetEntity = new StreetEntity();
        streetEntity.setDescription("The main street");
        streetEntity.setStreetName("LongStreet");
        streetEntity.setTownId(3);
        streetService.createOrUpdate(streetEntity);
    }
    public void contexLoads(){
   final CityEntity cityEntity = new CityEntity();
   cityEntity.setCountryId(1);
   cityEntity.setType("city");
   cityEntity.setLocation(cityLocation.center);
   cityEntity.setName("Drezden");
   cityService.createOrUpdate(cityEntity);
    }
    public void testBuilding(){
        final BuildingEntity buildingEntity = new BuildingEntity();
buildingEntity.setFloor(2);
buildingEntity.setHeight(200);
buildingEntity.setMaterial(buildingMaterial.brick);
buildingEntity.setName("Ocean");
buildingEntity.setType(buildingType.supermarket);
buildingEntity.setStreet_id(0);
genericService.createOrUpdate(buildingEntity);

    }
}
