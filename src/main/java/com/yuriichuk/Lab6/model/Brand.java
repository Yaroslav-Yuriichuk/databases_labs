package com.yuriichuk.Lab6.model;

import lombok.AllArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Entity
@AllArgsConstructor
public class Brand {
    private Integer id;
    private String name;
    private String foundationDate;

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
    @Column(name = "foundation_data")
    public String getFoundationDate() {
        return foundationDate;
    }

    public void setFoundationDate(String foundationDate) {
        this.foundationDate = foundationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Brand brand = (Brand) o;
        return Objects.equals(id, brand.id) && Objects.equals(name, brand.name) && Objects.equals(foundationDate, brand.foundationDate);
    }

    public Brand() {}

    public Brand(String name, String foundationDate) {
        this.name = name;
        this.foundationDate = foundationDate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, foundationDate);
    }

    @Override
    public String toString() {
        return "Brand {" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", foundationDate='" + foundationDate + '\'' +
                '}';
    }
}
