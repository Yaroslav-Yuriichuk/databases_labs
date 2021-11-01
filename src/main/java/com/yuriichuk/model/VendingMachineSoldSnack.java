package com.yuriichuk.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VendingMachineSoldSnack {
    private Integer id;
    private Integer vendingMachineId;
    private Integer snackId;
    private Integer quantity;
    private String date;

    public VendingMachineSoldSnack(Integer id, Integer vendingMachineId,
                                   Integer snackId, Integer quantity, String date) {
        this.id = id;
        this.vendingMachineId = vendingMachineId;
        this.snackId = snackId;
        this.quantity = quantity;
        this.date = date;
    }

    public VendingMachineSoldSnack(Integer vendingMachineId,
                                   Integer snackId, Integer quantity, String date) {
        this(null, vendingMachineId, snackId, quantity, date);
    }

    @Override
    public String toString() {
        return "VendingMachineSoldSnack {" +
                "id=" + id +
                ", vendingMachineId=" + vendingMachineId +
                ", snackId=" + snackId +
                ", quantity=" + quantity +
                ", date='" + date + '\'' +
                '}';
    }
}
