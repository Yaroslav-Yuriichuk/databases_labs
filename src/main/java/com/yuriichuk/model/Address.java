package com.yuriichuk.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address {
    private Integer id;
    private String region;
    private String cityVillage;
    private String street;
    private String building;

    public Address(Integer id, String region, String cityVillage, String street, String building) {
        this.id = id;
        this.region = region;
        this.cityVillage = cityVillage;
        this.street = street;
        this.building = building;
    }

    public Address(String region, String cityVillage, String street, String building) {
        this(null, region, cityVillage, street, building);
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
