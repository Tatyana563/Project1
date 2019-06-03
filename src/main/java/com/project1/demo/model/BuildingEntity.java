package com.project1.demo.model;
import com.project1.demo.model.enumeration.buildingMaterial;
import com.project1.demo.model.enumeration.buildingType;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="BUILDING")
public class BuildingEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="serial")
    @SequenceGenerator(name="serial",sequenceName="serial", allocationSize = 1)
    private Integer id;

    @Column(name="BUILDING_NAME", nullable=false, unique=true)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name="BUILDING_TYPE", nullable=false)
    private buildingType type;

    @Column(name="STREET")
    private String street;

    @Column(name="FLOOR")
    private int floor;

    @Enumerated(EnumType.STRING)
    @Column(name="MATERIAL")
    private buildingMaterial material;

    @Column(name="HEIGHT")
    private double height;

    @Column(name="TOWN_ID")
    private int town_id;

    @Column(name="STREET_ID")
    private int street_id;

    @Transient
    private Date cteationDate;

    @ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="street_id")
    private StreetEntity street11;

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

    public buildingType getType() {
        return type;
    }

    public void setType(buildingType type) {
        this.type = type;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public buildingMaterial getMaterial() {
        return material;
    }

    public void setMaterial(buildingMaterial material) {
        this.material = material;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public int getTown_id() {
        return town_id;
    }

    public void setTown_id(int town_id) {
        this.town_id = town_id;
    }

    public int getStreet_id() {
        return street_id;
    }

    public void setStreet_id(int street_id) {
        this.street_id = street_id;
    }

    public Date getCteationDate() {
        return cteationDate;
    }

    public void setCteationDate(Date cteationDate) {
        this.cteationDate = cteationDate;
    }

    @Override
    public String toString() {
        return "BuildingEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", street='" + street + '\'' +
                ", floor=" + floor +
                ", material=" + material +
                ", height=" + height +
                ", town_id=" + town_id +
                ", street_id=" + street_id +
                ", cteationDate=" + cteationDate +
                '}';
    }
}
