package com.yuriichuk.Lab6.model;

import com.yuriichuk.Lab6.model.composite_key.LoadedSnackPK;
import lombok.AllArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Entity
@AllArgsConstructor
@Table(name = "loaded_snack", schema = "yuriichuk", catalog = "")
@IdClass(LoadedSnackPK.class)
public class LoadedSnack {
    private Integer vendingMachineSnacksLoadingId;
    private Integer snackId;
    private Integer quantity;

    @Id
    @Column(name = "vending_machine_snacks_loading_id")
    public Integer getVendingMachineSnacksLoadingId() {
        return vendingMachineSnacksLoadingId;
    }

    public void setVendingMachineSnacksLoadingId(Integer vendingMachineSnacksLoadingId) {
        this.vendingMachineSnacksLoadingId = vendingMachineSnacksLoadingId;
    }

    @Id
    @Column(name = "snack_id")
    public Integer getSnackId() {
        return snackId;
    }

    public void setSnackId(Integer snackId) {
        this.snackId = snackId;
    }

    @Basic
    @Column(name = "quantity")
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoadedSnack that = (LoadedSnack) o;
        return Objects.equals(vendingMachineSnacksLoadingId, that.vendingMachineSnacksLoadingId) && Objects.equals(snackId, that.snackId) && Objects.equals(quantity, that.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vendingMachineSnacksLoadingId, snackId, quantity);
    }

    public LoadedSnack() {}

    public LoadedSnack(Integer quantity) {
        this.quantity = quantity;
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