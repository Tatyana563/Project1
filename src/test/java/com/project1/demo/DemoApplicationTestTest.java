package com.project1.demo;

import com.project1.demo.model.BuildingEntity;
import com.project1.demo.model.CityEntity;
import com.project1.demo.model.CountryEntity;
import com.project1.demo.model.StreetEntity;
import com.project1.demo.model.enumeration.FilterKey;
import com.project1.demo.model.enumeration.buildingMaterial;
import com.project1.demo.model.enumeration.buildingType;
import com.project1.demo.model.enumeration.cityLocation;
import com.project1.demo.repository.BuildingRepository;
import com.project1.demo.service.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTestTest {
    @Autowired
    StreetServiceImpl streetService;
    @Autowired
    CityService cityService;
    @Autowired
   // GenericService genericService;
    BuildingService buildingService;
    @Autowired
    CountryService countryService;

    @Test
    public void testStreet() {
        final StreetEntity streetEntity = new StreetEntity();
        streetEntity.setTownId(1);
        streetEntity.setDescription("The main street");
        streetEntity.setStreetName("LongStreet");

        streetService.createOrUpdate(streetEntity);
    }
    @Test
    public void testCity(){
   final CityEntity cityEntity = new CityEntity();
   cityEntity.setCountryId(2);
   cityEntity.setType("city");
   cityEntity.setLocation(cityLocation.center);
   cityEntity.setName("Drezden");
   cityService.createOrUpdate(cityEntity);
    }
    @Test
    public void testBuilding(){
        final BuildingEntity buildingEntity = new BuildingEntity();
buildingEntity.setFloor(2);
buildingEntity.setHeight(200);
buildingEntity.setMaterial(buildingMaterial.brick);
buildingEntity.setName("Ocean1");
buildingEntity.setType(buildingType.supermarket);
buildingEntity.setStreetId(1);
buildingService.createOrUpdate(buildingEntity);
buildingService.remove(18);

    }
    @Test
    public void testFilter(){

        Map<FilterKey, Object> filter = new HashMap<>();
        filter.put(FilterKey.CITY_AREA, 100);

        System.out.println(countryService.findAllByFilter(filter));
    }
}


