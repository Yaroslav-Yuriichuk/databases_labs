package com.yuriichuk.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VendingMachine {
    private Integer id;
    private String coordinates;
    private Integer addressId;

    public VendingMachine(Integer id, String coordinates, Integer addressId) {
        this.id = id;
        this.coordinates = coordinates;
        this.addressId = addressId;
    }

    public VendingMachine(String coordinates, Integer addressId) {
        this(null, coordinates, addressId);
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
