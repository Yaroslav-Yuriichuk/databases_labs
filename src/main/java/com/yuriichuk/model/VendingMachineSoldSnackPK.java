package com.yuriichuk.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class VendingMachineSoldSnackPK implements Serializable {
    private Integer id;
    private Integer vendingMachineId;
    private Integer snackId;

    @Column(name = "id")
    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "vending_machine_id")
    @Id
    public Integer getVendingMachineId() {
        return vendingMachineId;
    }

    public void setVendingMachineId(Integer vendingMachineId) {
        this.vendingMachineId = vendingMachineId;
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
        VendingMachineSoldSnackPK that = (VendingMachineSoldSnackPK) o;
        return Objects.equals(id, that.id) && Objects.equals(vendingMachineId, that.vendingMachineId) && Objects.equals(snackId, that.snackId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, vendingMachineId, snackId);
    }
}
