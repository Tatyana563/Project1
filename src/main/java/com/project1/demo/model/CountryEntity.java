package com.project1.demo.model;

import com.project1.demo.model.enumeration.Currency;
import com.project1.demo.model.enumeration.Language;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@NamedStoredProcedureQueries(
        @NamedStoredProcedureQuery(
                name="updateCurrency",
                procedureName = "update_country_currency",
                parameters = {
                        @StoredProcedureParameter(name = "p_country_id",type=Integer.class,
                        mode=ParameterMode.IN),
                        @StoredProcedureParameter(name="p_currency", type=Currency.class,
                        mode=ParameterMode.IN)
                }

        )
)
@Entity
@Table(name="COUNTRY")
public class CountryEntity extends CommonInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "serialcountry")
    @SequenceGenerator(name="serialcountry", sequenceName = "serialcountry", allocationSize = 1)
    private Integer id;

    @Column (name="COUNTRY_NAME", nullable=false)
    private String countryName;

    @Enumerated(EnumType.STRING)
    @Column (name="CURRENCY")
    private Currency currency;

    @Column (name="POPULATION")
    private Integer population;
    @Enumerated(EnumType.STRING)
    @Column (name="LANGUAGE", nullable=false)
    private Language language;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "country")
    private List<CityEntity> cities = new ArrayList<CityEntity>();

    public List<CityEntity> getCities() {
        return cities;
    }

    public void setCities(List<CityEntity> cities) {
        this.cities = cities;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "CountryEntity{" +
                "id=" + id +
                ", countryName='" + countryName + '\'' +
                ", currency=" + currency +
                ", population='" + population + '\'' +
                ", language=" + language +
                '}';
    }
}
