package com.project1.demo.controller;

import com.project1.demo.dto.request.CountryRequest;
import com.project1.demo.dto.response.CountryResponse;
import com.project1.demo.model.CountryEntity;
import com.project1.demo.model.enumeration.Currency;
import com.project1.demo.model.enumeration.Language;
import com.project1.demo.service.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/country")
public class CountryController {
    Logger log = LoggerFactory.getLogger(CountryController.class);


    @Autowired
    private CountryService countryService;

    //http://localhost:8080/api/country/add?name="name"&language="language"&
    @GetMapping("/add")
    public CountryResponse createOrUpdate(@RequestParam(value = "id", required = false) Integer id,
                                  @RequestParam("name") String name,
                                  @RequestParam("language") String language,
                                  @RequestParam("currency") String currency,
                                  @RequestParam("population") Integer population,
                                  @RequestParam("area") Double area) {
        final CountryEntity countryEntity = new CountryEntity();

        countryEntity.setCountryName(name);
        countryEntity.setCurrency(Currency.valueOf(currency));
        countryEntity.setLanguage(Language.valueOf(language));
        countryEntity.setPopulation(population);
        countryEntity.setArea(area);
        countryEntity.setId(id);
        countryService.createOrUpdate(countryEntity);
        final CountryEntity country = countryService.findById(countryEntity.getId()).get();
        return new CountryResponse(country);
    }

    //http://localhost:8080/api/country/10
    @GetMapping("/{deleteId}")
    public void delete(@PathVariable("deleteId") int deleteId) {
        countryService.remove(deleteId);
    }
    @GetMapping("/{getId}")
    public void getCountry (@PathVariable("getId") int Id) {
       countryService.findById(Id);
    }




    @PostMapping
    public CountryResponse createFromPost(@RequestBody CountryRequest countryRequest) {
        CountryEntity countryEntity = countryRequest.convert();
        countryService.createOrUpdate(countryEntity);
        final CountryEntity country = countryService.findById(countryEntity.getId()).get();
        return new CountryResponse(country);
    }

    @DeleteMapping("{countryId}")
    public CountryRequest deleteCountryById(@PathVariable("countryId") int countryId) {
        return countryService.deleteByIdRequest(countryId);
    }

}
