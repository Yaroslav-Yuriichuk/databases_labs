package com.yuriichuk.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Address {
    private Integer id;
    private String region;
    private String cityVillage;
    private String street;
    private String building;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "region")
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Basic
    @Column(name = "city_village")
    public String getCityVillage() {
        return cityVillage;
    }

    public void setCityVillage(String cityVillage) {
        this.cityVillage = cityVillage;
    }

    @Basic
    @Column(name = "street")
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Basic
    @Column(name = "building")
    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(id, address.id) && Objects.equals(region, address.region) && Objects.equals(cityVillage, address.cityVillage) && Objects.equals(street, address.street) && Objects.equals(building, address.building);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, region, cityVillage, street, building);
    }

    public Address() {}

    public Address(String region, String cityVillage, String street, String building) {
        this.region = region;
        this.cityVillage = cityVillage;
        this.street = street;
        this.building = building;
    }

    @Override
    public String toString() {
        return "Address {" +
                "id=" + id +
                ", region='" + region + '\'' +
                ", cityVillage='" + cityVillage + '\'' +
                ", street='" + street + '\'' +
                ", building='" + building + '\'' +
                '}';
    }
}
