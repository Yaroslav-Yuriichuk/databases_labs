package com.yuriichuk.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "vending_machine_snacks_loading", schema = "yuriichuk", catalog = "")
@IdClass(VendingMachineSnacksLoadingPK.class)
public class VendingMachineSnacksLoading {
    private Integer id;
    private Integer technicianId;
    private Integer vendingMachineId;
    private Timestamp time;

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

}
