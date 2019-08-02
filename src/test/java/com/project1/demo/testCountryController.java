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
        ResponseEntity<CountryResponse> responseEntity =
                restTemplate.getForEntity(URI.create("http://localhost:" + port + "/api/country/2"), CountryResponse.class);
        System.out.println("status code:" + responseEntity.getStatusCode());
        System.out.println("country response:" + responseEntity.getBody());



        CountryRequest request = new CountryRequest();

        request.setName("Portugal");
        request.setCurrency(Currency.USD.name());
        request.setLanguage(Language.Spanish.name());
        // request.getArea(53D);???
        request.setPopulation(269);
        ResponseEntity response =
                restTemplate.postForEntity(URI.create("http:localhost:" + port + "/api/country"), request, CountryResponse.class);
        System.out.println("new status is:" + response.getStatusCode());
        System.out.println("new country response" + response.getBody());

        restTemplate.delete(URI.create("http://localhost:"+ port + "/api/country/"+response.getBody().getId()),CountryResponse.class);
        System.out.println("status is:" + response.getStatusCode());







        restTemplate.delete(URI.create("http://localhost:"+port+"/api/country/"),CountryResponse.class);
    }
}

