package com.yuriichuk.Lab6.model;

import com.yuriichuk.Lab6.model.composite_key.VendingMachineMenuPK;
import lombok.AllArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Entity
@AllArgsConstructor
@Table(name = "vending_machine_menu", schema = "yuriichuk", catalog = "")
@IdClass(VendingMachineMenuPK.class)
public class VendingMachineMenu {
    private Integer vendingMachineId;
    private Integer snackId;
    private Integer quantity;

    @Id
    @Column(name = "vending_machine_id")
    public Integer getVendingMachineId() {
        return vendingMachineId;
    }

    public void setVendingMachineId(Integer vendingMachineId) {
        this.vendingMachineId = vendingMachineId;
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
        VendingMachineMenu that = (VendingMachineMenu) o;
        return vendingMachineId.equals(that.vendingMachineId) && snackId.equals(that.snackId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vendingMachineId, snackId);
    }

    public VendingMachineMenu() {}

    public VendingMachineMenu(Integer quantity) {
        this.quantity = quantity;
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
