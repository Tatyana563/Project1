package com.project1.demo;

import com.project1.demo.model.BuildingEntity;
import com.project1.demo.model.CityEntity;
import com.project1.demo.model.CountryEntity;
import com.project1.demo.model.StreetEntity;
import com.project1.demo.model.enumeration.*;
import com.project1.demo.repository.filter.FilterSpecifications;
import com.project1.demo.service.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static com.project1.demo.model.enumeration.buildingMaterial.brick;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("postgres")
public class DemoApplicationTestTest {
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
        final StreetEntity streetEntity = new StreetEntity();
        CityEntity city = cityService.findById(1).get();
        streetEntity.setTown(city);
        streetEntity.setDescription("The main street");
        streetEntity.setStreetName("LongStreet");
        city.getStreets().add(streetEntity);
        //streetService.createOrUpdate(streetEntity);
        cityService.createOrUpdate(city);
    }

    @Test
    public void testCity() {
        final CityEntity cityEntity = new CityEntity();
        final CountryEntity countryEntity = new CountryEntity();
        countryEntity.setId(1);
        cityEntity.setType("city");
        cityEntity.setLocation(CityLocation.center);
        cityEntity.setName("Drezden");
        cityEntity.setArea(1000D);
        cityEntity.setCountry(countryEntity);
        cityService.createOrUpdate(cityEntity);
    }

    @Test
    public void testBuilding() {
        final BuildingEntity buildingEntity = new BuildingEntity();
        final StreetEntity streetEntity = streetService.findById(4);
        buildingEntity.setFloor(2);
        buildingEntity.setHeight(200);
        buildingEntity.setMaterial(brick);
        buildingEntity.setName("Novus1");
        buildingEntity.setType(buildingType.supermarket);
        streetEntity.getBuildings().add(buildingEntity);
        genericService.createOrUpdate(buildingEntity);

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
    @Test
    public void testFilter3(){
        Map<FilterKey, Object> filter = new HashMap<>();
        filter.put(FilterKey.CITY_LOCATION,CityLocation.south);
        filter.put(FilterKey.BUILDING_HEIGH,201.3);
        System.out.println(countryService.findAllByFilter3(filter));
    }

    @Test
    public void testFilter4(){
        Map<FilterKey, Object> filter = new HashMap<>();
        filter.put(FilterKey.CITY_TYPE, "city");
        filter.put(FilterKey.STREET_DESCRIPTION,"green and lovely");
        filter.put(FilterKey.BUILDING_MATERIAL, buildingMaterial.brick);
        System.out.println(countryService.findAllByFilter4(filter));
    }

    @Test
    public void testFilter4_1(){
        Map<FilterKey, Object> filter = new HashMap<>();
        filter.put(FilterKey.CURRENCY, Currency.EUR);
        System.out.println(countryService.findAllByFilter4(filter));
    }
 //System.out.println(countryService.getMaxCityPopulationByCountry(2));
   @Test
   public void testFunction(){
       System.out.println(countryService.getMinCityAreaByCountry(1));
   }
   @Test
    public void testFunction2(){
       System.out.println(countryService.getCityWithAreaLocation(1, CityLocation.north, 20.0));
   }
   @Test
    public void testJDBC(){
       System.out.println(countryService.getMaxCityPopulationByCountry(1));
   }
   @Test
    public void testUpdateTownArea(){
        cityService.updateCityArea(1,65.78);
   }
   @Test
    public void testUpdateTownPopulation(){
        cityService.updateCityPopulation(1,800);
   }
   @Test
    public void testUpdateCountryCurrency(){
        countryService.updateCountryCurrency(1, Currency.DM);
   }
   @Test
    public void testUpdateCountryInfo(){
        countryService.updateCountryInfo(5,152.98,787,Language.Italian,Currency.EUR);
   }
   @Test
    public void testUpdateCountryInfo2(){
        countryService.updateCountryInfo2(5,203.5,266,Language.Italian,Currency.USD);
   }

   @Test
    public void testUpdateCountryInfo3(){
        countryService.updateCountryInfo3(5,203.5,266,Language.Italian,Currency.USD);
   }
   @Test
    public  void testJPAfilter(){
       System.out.println(countryService.findAll(
        FilterSpecifications.cityAreaFilter(100d)));
   }
   @Test
    public void testJPAfilter2(){
       System.out.println(countryService.findAll(
               FilterSpecifications.streetNameFilter("street5")
               .and(FilterSpecifications.buildingMaterialFilter(buildingMaterial.brick))
       ));
   }
   @Test
    public void testJPAfilter3(){
       System.out.println(countryService.findAll(
               FilterSpecifications.cityLocationFilter(CityLocation.south)
               .and(FilterSpecifications.buildingHeightFilter(201.3))
       ));
   }
   @Test
    public void testJPAfilter4(){
       System.out.println(countryService.findAll(
               FilterSpecifications.cityTypeFilter("city")
               .and(FilterSpecifications.streetDescriptionFilter("green and lovely")
               .and(FilterSpecifications.buildingMaterialFilter(buildingMaterial.brick)))
       ));
   }
   @Test
    public void testFindCountryByDetails(){
       System.out.println(countryService.
               getCountryByDetails(Language.German,Currency.DM));
   }
}
