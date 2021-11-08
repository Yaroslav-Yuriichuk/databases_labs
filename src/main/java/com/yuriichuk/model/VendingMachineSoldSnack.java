package com.yuriichuk.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "vending_machine_sold_snack", schema = "yuriichuk", catalog = "")
@IdClass(VendingMachineSoldSnackPK.class)
public class VendingMachineSoldSnack {
    private Integer id;
    private Integer vendingMachineId;
    private Integer snackId;
    private Integer quantity;
    private Date date;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    @Basic
    @Column(name = "date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VendingMachineSoldSnack that = (VendingMachineSoldSnack) o;
        return Objects.equals(id, that.id) && Objects.equals(vendingMachineId, that.vendingMachineId) && Objects.equals(snackId, that.snackId) && Objects.equals(quantity, that.quantity) && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, vendingMachineId, snackId, quantity, date);
    }

}
