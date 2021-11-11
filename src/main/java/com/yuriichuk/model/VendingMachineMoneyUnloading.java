package com.yuriichuk.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "vending_machine_money_unloading", schema = "yuriichuk", catalog = "")
public class VendingMachineMoneyUnloading {
    private Integer id;
    private Integer technicianId;
    private Integer vendingMachineId;
    private String time;
    private Float ammount;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "technician_id")
    public Integer getTechnicianId() {
        return technicianId;
    }

    public void setTechnicianId(Integer technicianId) {
        this.technicianId = technicianId;
    }

    @Column(name = "vending_machine_id")
    public Integer getVendingMachineId() {
        return vendingMachineId;
    }

    public void setVendingMachineId(Integer vendingMachineId) {
        this.vendingMachineId = vendingMachineId;
    }

    @Basic
    @Column(name = "time")
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Basic
    @Column(name = "ammount")
    public Float getAmmount() {
        return ammount;
    }

    public void setAmmount(Float ammount) {
        this.ammount = ammount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VendingMachineMoneyUnloading that = (VendingMachineMoneyUnloading) o;
        return Objects.equals(id, that.id) && Objects.equals(technicianId, that.technicianId) && Objects.equals(vendingMachineId, that.vendingMachineId) && Objects.equals(time, that.time) && Objects.equals(ammount, that.ammount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, technicianId, vendingMachineId, time, ammount);
    }

    public VendingMachineMoneyUnloading() {}

    public VendingMachineMoneyUnloading(Integer technicianId,
                                        Integer vendingMachineId, String time, Float ammount) {
        this.technicianId = technicianId;
        this.vendingMachineId = vendingMachineId;
        this.time = time;
        this.ammount = ammount;
    }

    @Override
    public String toString() {
        return "VendingMachineMoneyUnloading {" +
                "id=" + id +
                ", technicianId=" + technicianId +
                ", vendingMachineId=" + vendingMachineId +
                ", time='" + time + '\'' +
                ", ammount=" + ammount +
                '}';
    }
}
