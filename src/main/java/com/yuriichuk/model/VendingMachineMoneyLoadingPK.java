package com.yuriichuk.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class VendingMachineMoneyLoadingPK implements Serializable {
    private Integer id;
    private Integer technicianId;
    private Integer vendingMachineId;

    @Column(name = "id")
    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "technician_id")
    @Id
    public Integer getTechnicianId() {
        return technicianId;
    }

    public void setTechnicianId(Integer technicianId) {
        this.technicianId = technicianId;
    }

    @Column(name = "vending_machine_id")
    @Id
    public Integer getVendingMachineId() {
        return vendingMachineId;
    }

    public void setVendingMachineId(Integer vendingMachineId) {
        this.vendingMachineId = vendingMachineId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VendingMachineMoneyLoadingPK that = (VendingMachineMoneyLoadingPK) o;
        return Objects.equals(id, that.id) && Objects.equals(technicianId, that.technicianId) && Objects.equals(vendingMachineId, that.vendingMachineId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, technicianId, vendingMachineId);
    }
}
