package com.yuriichuk.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VendingMachineMenu {
    private Integer vendingMachineId;
    private Integer snackId;
    private Integer quantity;

    public VendingMachineMenu(Integer vendingMachineId, Integer snackId, Integer quantity) {
        this.vendingMachineId = vendingMachineId;
        this.snackId = snackId;
        this.quantity = quantity;
    }

    public VendingMachineMenu(Integer quantity) {
        this(null, null, quantity);
    }

    @Override
    public String toString() {
        return "VendingMachineMenu {" +
                "vendingMachineId=" + vendingMachineId +
                ", snackId=" + snackId +
                ", quantity=" + quantity +
                '}';
    }
}
