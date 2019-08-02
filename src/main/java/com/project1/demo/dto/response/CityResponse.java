package com.project1.demo.dto.response;

import com.project1.demo.model.CityEntity;

import java.util.Objects;

public class CityResponse {
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CityResponse(CityEntity city){
        if(Objects.isNull(city)) return;
        this.id = city.getId();
        this.name=city.getName();
    }
}
