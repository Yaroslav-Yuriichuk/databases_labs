package com.yuriichuk.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "vending_machine", schema = "yuriichuk", catalog = "")
public class VendingMachine {
    private Integer id;
    private String coordinates;
    private Integer addressId;

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
    @Column(name = "coordinates")
    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    @Basic
    @Column(name = "address_id")
    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VendingMachine that = (VendingMachine) o;
        return Objects.equals(id, that.id) && Objects.equals(coordinates, that.coordinates) && Objects.equals(addressId, that.addressId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, coordinates, addressId);
    }

    public VendingMachine() {}

    public VendingMachine(String coordinates, Integer addressId) {
        this.coordinates = coordinates;
        this.addressId = addressId;
    }

    @Override
    public String toString() {
        return "VendingMachine {" +
                "id=" + id +
                ", coordinates='" + coordinates + '\'' +
                ", addressId=" + addressId +
                '}';
    }
}
