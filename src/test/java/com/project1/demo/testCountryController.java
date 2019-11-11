package com.project1.demo;

import com.project1.demo.dto.request.CountryRequest;
import com.project1.demo.dto.response.CountryResponse;
import com.project1.demo.model.enumeration.Currency;
import com.project1.demo.model.enumeration.Language;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@ActiveProfiles("postgres")
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class testCountryController {
    @Autowired
    private RestTemplate restTemplate;
    @LocalServerPort
    private int port;

    @Test
    public void testGetCountry() {

        CountryRequest request = new CountryRequest();

        request.setName("Portuga8");
        request.setCurrency(Currency.USD.name());
        request.setLanguage(Language.Spanish.name());
         request.setArea(53D);
        request.setPopulation(269);
        ResponseEntity<CountryResponse> response =
                restTemplate.postForEntity(URI.create("http://localhost:" + port + "/api/country"), request, CountryResponse.class);


        System.out.println("new status is:" + response.getStatusCode());
        System.out.println("new country response" + response.getBody());

        ResponseEntity<CountryResponse> responseEntity =
                restTemplate.getForEntity(URI.create("http://localhost:" + port + "/api/country/"+request.getId()), CountryResponse.class);
        System.out.println("status code:" + responseEntity.getStatusCode());
        System.out.println("country response:" + responseEntity.getBody());


//        restTemplate.delete(URI.create("http://localhost:"+ port + "/api/country/"+response.getBody().getId()));
//        System.out.println("status is:" + response.getStatusCode());

    }
}

