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

    @Column(name="TOWN_ID", insertable = false, updatable = false)
    private int townId;

    @Column(name="STREET_ID", insertable = false, updatable = false)
    private int streetId;

    @Transient
    private Date cteationDate;

    @ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="street_id")
    private StreetEntity streetEntity;

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

    public int getTownId() {
        return townId;
    }

    public void setTownId(int townId) {
        this.townId = townId;
    }

    public int getStreetId() {
        return streetId;
    }

    public void setStreetId(int streetId) {
        this.streetId = streetId;
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
                ", townId=" + townId +
                ", streetId=" + streetId +
                ", cteationDate=" + cteationDate +
                '}';
    }
}
