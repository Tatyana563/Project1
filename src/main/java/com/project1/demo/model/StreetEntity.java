package com.project1.demo.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="STREET")
public class StreetEntity {
   @Id
   @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "serialstreet")
   @SequenceGenerator(name="serialstreet",sequenceName = "serialstreet", allocationSize = 1)
   private Integer id;

   @Column(name="TOWN_ID", nullable=false, insertable = false, updatable = false)
    private int townId;

    @Column(name="STREET_NAME", nullable=false)
    private String streetName;

    @Column(name="description")
    private String description;

    @ManyToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="TOWN_ID")
    private CityEntity town;

    public CityEntity getTown() {
        return town;
    }

    public void setTown(CityEntity town) {
        this.town = town;
    }

    public List<BuildingEntity> getBuildings() {
        return buildings;
    }

    public void setBuildings(List<BuildingEntity> buildings) {
        this.buildings = buildings;
    }

    @OneToMany(mappedBy = "streetEntity", cascade =CascadeType.ALL)
private List<BuildingEntity> buildings = new ArrayList<BuildingEntity>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getTownId() {
        return townId;
    }

    public void setTownId(int townId) {
        this.townId = townId;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "StreetEntity{" +
                "id=" + id +
                ", townId='" + townId + '\'' +
                ", streetName='" + streetName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
