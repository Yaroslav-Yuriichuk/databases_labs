package com.yuriichuk.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Snack {
    private Integer id;
    private String name;
    private Float price;
    private Integer weight;
    private Integer callories;
    private Integer brandId;

    public Snack(Integer id, String name, Float price, Integer weight, Integer callories, Integer brandId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.callories = callories;
        this.brandId = brandId;
    }

    public Snack(String name, Float price, Integer weight, Integer callories, Integer brandId) {
        this(null, name, price, weight, callories, brandId);
    }

    @Override
    public String toString() {
        return "Snack{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", weight=" + weight +
                ", callories=" + callories +
                ", brandId=" + brandId +
                '}';
    }
}
