package com.yuriichuk.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoadedSnack {
    private Integer vendingMachineSnacksLoadingId;
    private Integer snackId;
    private Integer quantity;

    public LoadedSnack(Integer vendingMachineSnacksLoadingId, Integer snackId, Integer quantity) {
        this.vendingMachineSnacksLoadingId = vendingMachineSnacksLoadingId;
        this.snackId = snackId;
        this.quantity = quantity;
    }

    public LoadedSnack(Integer quantity) {
        this(null, null, quantity);
    }

    @Override
    public String toString() {
        return "LoadedSnack {" +
                "vendingMachineSnacksLoadingId=" + vendingMachineSnacksLoadingId +
                ", snackId=" + snackId +
                ", quantity=" + quantity +
                '}';
    }
}