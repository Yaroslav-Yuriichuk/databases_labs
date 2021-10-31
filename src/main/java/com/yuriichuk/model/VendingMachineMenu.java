package com.yuriichuk.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VendingMachineMenu {
    private Integer vendingMachineId;
    private  Integer snackId;

    public VendingMachineMenu(Integer vendingMachineId, Integer snackId) {
        this.vendingMachineId = vendingMachineId;
        this.snackId = snackId;
    }

    @Override
    public String toString() {
        return "VendingMachineMenu {" +
                "vendingMachineId=" + vendingMachineId +
                ", snackId=" + snackId +
                '}';
    }
}
