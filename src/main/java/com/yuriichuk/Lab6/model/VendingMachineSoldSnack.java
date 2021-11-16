package com.yuriichuk.Lab6.model;

import lombok.AllArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Entity
@AllArgsConstructor
@Table(name = "vending_machine_sold_snack", schema = "yuriichuk", catalog = "")
public class VendingMachineSoldSnack {
    private Integer id;
    private Integer vendingMachineId;
    private Integer snackId;
    private Integer quantity;
    private String date;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "vending_machine_id")
    public Integer getVendingMachineId() {
        return vendingMachineId;
    }

    public void setVendingMachineId(Integer vendingMachineId) {
        this.vendingMachineId = vendingMachineId;
    }

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
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
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

    public VendingMachineSoldSnack() {}

    public VendingMachineSoldSnack(Integer vendingMachineId,
                                   Integer snackId, Integer quantity, String date) {
        this.vendingMachineId = vendingMachineId;
        this.snackId = snackId;
        this.quantity = quantity;
        this.date = date;
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