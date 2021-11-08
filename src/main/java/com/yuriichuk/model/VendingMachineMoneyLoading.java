package com.yuriichuk.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "vending_machine_money_loading", schema = "yuriichuk", catalog = "")
@IdClass(VendingMachineMoneyLoadingPK.class)
public class VendingMachineMoneyLoading {
    private Integer id;
    private Integer technicianId;
    private Integer vendingMachineId;
    private Timestamp time;
    private BigDecimal ammount;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Id
    @Column(name = "technician_id")
    public Integer getTechnicianId() {
        return technicianId;
    }

    public void setTechnicianId(Integer technicianId) {
        this.technicianId = technicianId;
    }

    @Id
    @Column(name = "vending_machine_id")
    public Integer getVendingMachineId() {
        return vendingMachineId;
    }

    public void setVendingMachineId(Integer vendingMachineId) {
        this.vendingMachineId = vendingMachineId;
    }

    @Basic
    @Column(name = "time")
    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Basic
    @Column(name = "ammount")
    public BigDecimal getAmmount() {
        return ammount;
    }

    public void setAmmount(BigDecimal ammount) {
        this.ammount = ammount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VendingMachineMoneyLoading that = (VendingMachineMoneyLoading) o;
        return Objects.equals(id, that.id) && Objects.equals(technicianId, that.technicianId) && Objects.equals(vendingMachineId, that.vendingMachineId) && Objects.equals(time, that.time) && Objects.equals(ammount, that.ammount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, technicianId, vendingMachineId, time, ammount);
    }
}
