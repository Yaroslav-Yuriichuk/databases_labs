package com.yuriichuk.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "vending_machine_snacks_loading", schema = "yuriichuk", catalog = "")
public class VendingMachineSnacksLoading {
    private Integer id;
    private Integer technicianId;
    private Integer vendingMachineId;
    private String time;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VendingMachineSnacksLoading that = (VendingMachineSnacksLoading) o;
        return Objects.equals(id, that.id) && Objects.equals(technicianId, that.technicianId) && Objects.equals(vendingMachineId, that.vendingMachineId) && Objects.equals(time, that.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, technicianId, vendingMachineId, time);
    }

    public VendingMachineSnacksLoading() {}

    public VendingMachineSnacksLoading(Integer technicianId,
                                       Integer vendingMachineId, String time) {
        this.technicianId = technicianId;
        this.vendingMachineId = vendingMachineId;
        this.time = time;
    }

    @Override
    public String toString() {
        return "VendingMachineSnacksLoading {" +
                "id=" + id +
                ", technicianId=" + technicianId +
                ", vendingMachineId=" + vendingMachineId +
                ", time='" + time + '\'' +
                '}';
    }
}
