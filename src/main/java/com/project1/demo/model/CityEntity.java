package com.project1.demo.model;

import com.project1.demo.model.enumeration.cityLocation;

import javax.persistence.*;
import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TOWN")
public class CityEntity extends CommonInfoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "serialcity")
    @SequenceGenerator(name = "serialcity", sequenceName = "serialcity", allocationSize = 1)
    private Integer id;

    @Column(name = "TOWN_NAME", nullable = false)
    private String name;

    @Column(name = "TOWN_TYPE", nullable = false)
    private String type;
    @Enumerated(EnumType.STRING)
    @Column(name = "LOCATION")
    private cityLocation location;


    public CountryEntity getCountry() {
        return country;
    }

    public void setCountry(CountryEntity country) {
        this.country = country;
    }

    public List<StreetEntity> getStreets() {
        return streets;
    }

    public void setStreets(List<StreetEntity> streets) {
        this.streets = streets;
    }

    @Column(name = "AREA")
    private double area;

    @Column(name = "COUNTRY_ID", insertable = false, updatable = false)
    private int countryId;

    @Transient
    private Data dataCreation;

@ManyToOne(fetch= FetchType.LAZY, cascade = CascadeType.ALL)
@JoinColumn(name="COUNTRY_ID")
private CountryEntity country;

@OneToMany(mappedBy="town", cascade = CascadeType.ALL)
private List<StreetEntity> streets = new ArrayList<StreetEntity>();

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public cityLocation getLocation() {
        return location;
    }

    public void setLocation(cityLocation location) {
        this.location = location;
    }


    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public Data getDataCreation() {
        return dataCreation;
    }

    public void setDataCreation(Data dataCreation) {
        this.dataCreation = dataCreation;
    }

    @Override
    public String toString() {
        return "CityEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", location=" + location +

                ", countryId=" + countryId +
                ", dataCreation=" + dataCreation +
                '}';
    }
}
