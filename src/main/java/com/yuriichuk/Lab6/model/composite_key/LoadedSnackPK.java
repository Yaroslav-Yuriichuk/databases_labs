package com.yuriichuk.Lab6.model.composite_key;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

public class LoadedSnackPK implements Serializable {
    private Integer vendingMachineSnacksLoadingId;
    private Integer snackId;

    @Column(name = "vending_machine_snacks_loading_id")
    @Id
    public Integer getVendingMachineSnacksLoadingId() {
        return vendingMachineSnacksLoadingId;
    }

    public void setVendingMachineSnacksLoadingId(Integer vendingMachineSnacksLoadingId) {
        this.vendingMachineSnacksLoadingId = vendingMachineSnacksLoadingId;
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
        LoadedSnackPK that = (LoadedSnackPK) o;
        return Objects.equals(vendingMachineSnacksLoadingId, that.vendingMachineSnacksLoadingId) && Objects.equals(snackId, that.snackId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vendingMachineSnacksLoadingId, snackId);
    }

    public LoadedSnackPK() {}

    public LoadedSnackPK(Integer vendingMachineSnacksLoadingId, Integer snackId) {
        this.vendingMachineSnacksLoadingId = vendingMachineSnacksLoadingId;
        this.snackId = snackId;
    }
}