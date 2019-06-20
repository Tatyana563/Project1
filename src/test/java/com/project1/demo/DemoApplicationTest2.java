package com.project1.demo;

import com.project1.demo.model.BuildingEntity;
import com.project1.demo.model.CityEntity;
import com.project1.demo.model.CountryEntity;
import com.project1.demo.model.StreetEntity;
import com.project1.demo.model.enumeration.*;
import com.project1.demo.service.CityService;
import com.project1.demo.service.CountryService;
import com.project1.demo.service.GenericService;
import com.project1.demo.service.StreetServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static com.project1.demo.model.enumeration.buildingMaterial.brick;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTest2 {
    @Autowired
    StreetServiceImpl streetService;
    @Autowired
    CityService cityService;
    @Autowired
    @Qualifier("Building")
    GenericService genericService;
    // BuildingService buildingService;
    @Autowired
    CountryService countryService;

    @Test
    public void testStreet() {
        //CityEntity city = buildStreet(cityService.findById(1).get());
        //streetService.createOrUpdate(streetEntity);
        //cityService.createOrUpdate(city);
    }

    @Test
    public void fullScenarioTest() {
        final CountryEntity country = buildCountry();
        final CityEntity city = buildCity(country);
        final StreetEntity street = buildStreet(city);
        final BuildingEntity building = buildBuilding(street);
        city.getStreets().add(street);
        street.getBuildings().add(building);
        country.getCities().add(city);
        countryService.createOrUpdate(country);
    }

    private CountryEntity buildCountry() {
        final CountryEntity countryEntity = new CountryEntity();
        countryEntity.setCountryName("Test" + System.currentTimeMillis());
        countryEntity.setCurrency(Currency.EUR);
        countryEntity.setLanguage(Language.German);
        return countryEntity;

    }

    private StreetEntity buildStreet(CityEntity city) {
        final StreetEntity streetEntity = new StreetEntity();
        streetEntity.setTown(city);
        streetEntity.setDescription("The main street");
        streetEntity.setStreetName("LongStreet" + System.currentTimeMillis());
        return streetEntity;
    }

    @Test
    public void testCity() {
        final CityEntity cityEntity = buildCity(countryService.findById(1).get());
        cityService.createOrUpdate(cityEntity);
    }

    private CityEntity buildCity(final CountryEntity country) {
        final CityEntity cityEntity = new CityEntity();
        cityEntity.setType("city");
        cityEntity.setLocation(CityLocation.center);
        cityEntity.setName("Drezden");
        cityEntity.setArea(1000D);
        cityEntity.setCountry(country);
        return cityEntity;
    }

    @Test
    public void testBuilding() {
        final BuildingEntity buildingEntity = buildBuilding(streetService.findById(4));
        genericService.createOrUpdate(buildingEntity);

    }

    private BuildingEntity buildBuilding(StreetEntity street) {
        final BuildingEntity buildingEntity = new BuildingEntity();
        buildingEntity.setFloor(2);
        buildingEntity.setHeight(200);
        buildingEntity.setMaterial(brick);
        buildingEntity.setName("Novus" + System.currentTimeMillis());
        buildingEntity.setType(buildingType.supermarket);
        buildingEntity.setStreetEntity(street);
        street.getBuildings().add(buildingEntity);
        return buildingEntity;
    }

    @Test
    public void testFilter() {

        Map<FilterKey, Object> filter = new HashMap<>();
        filter.put(FilterKey.CITY_AREA, 100);

        System.out.println(countryService.findAllByFilter(filter));
    }

    @Test
    public void testFilter2() {
        Map<FilterKey, Object> filter = new HashMap<>();
        filter.put(FilterKey.STREET_NAME, "street5");
        filter.put(FilterKey.BUILDING_MATERIAL, brick);
        System.out.println(countryService.findAllByFilter2(filter));
    }
}


