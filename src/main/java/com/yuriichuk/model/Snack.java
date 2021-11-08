package com.yuriichuk.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;

@Entity
@IdClass(SnackPK.class)
public class Snack {
    private Integer id;
    private String name;
    private BigDecimal price;
    private Integer weight;
    private Integer callories;
    private Integer brandId;

    @Id
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
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
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

    @Id
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

}
