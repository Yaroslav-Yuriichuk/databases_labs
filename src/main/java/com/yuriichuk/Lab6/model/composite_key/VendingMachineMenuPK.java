package com.yuriichuk.Lab6.model.composite_key;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

public class VendingMachineMenuPK implements Serializable {
    private Integer vendingMachineId;
    private Integer snackId;

    @Column(name = "vending_machine_id")
    @Id
    public Integer getVendingMachineId() {
        return vendingMachineId;
    }

    public void setVendingMachineId(Integer vendingMachineSnacksLoadingId) {
        this.vendingMachineId = vendingMachineSnacksLoadingId;
    }

    @Column(name = "snack_id")
    @Id
    public Integer getSnackId() {
        return snackId;
    }

    public void setSnackId(Integer snackId) {
        this.snackId = snackId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VendingMachineMenuPK that = (VendingMachineMenuPK) o;
        return vendingMachineId.equals(that.vendingMachineId) && snackId.equals(that.snackId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vendingMachineId, snackId);
    }

    public VendingMachineMenuPK() {}

    public VendingMachineMenuPK(Integer vendingMachineId, Integer snackId) {
        this.vendingMachineId = vendingMachineId;
        this.snackId = snackId;
    }
}
