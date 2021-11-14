package com.yuriichuk.Lab6.model;

import lombok.AllArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Entity
@AllArgsConstructor
public class Snack {
    private Integer id;
    private String name;
    private Float price;
    private Integer weight;
    private Integer callories;
    private Integer brandId;

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
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "price")
    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Basic
    @Column(name = "weight")
    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Basic
    @Column(name = "callories")
    public Integer getCallories() {
        return callories;
    }

    public void setCallories(Integer callories) {
        this.callories = callories;
    }

    @Column(name = "brand_id")
    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Snack snack = (Snack) o;
        return Objects.equals(id, snack.id) && Objects.equals(name, snack.name) && Objects.equals(price, snack.price) && Objects.equals(weight, snack.weight) && Objects.equals(callories, snack.callories) && Objects.equals(brandId, snack.brandId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, weight, callories, brandId);
    }

    public Snack() {}

    public Snack(String name, Float price, Integer weight, Integer callories, Integer brandId) {
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.callories = callories;
        this.brandId = brandId;
    }

    @Override
    public String toString() {
        return "Snack {" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", weight=" + weight +
                ", callories=" + callories +
                ", brandId=" + brandId +
                '}';
    }
}
