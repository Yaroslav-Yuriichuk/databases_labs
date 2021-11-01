package com.yuriichuk.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VendingMachineSnacksLoading {
    private Integer id;
    private Integer technicianId;
    private Integer vendingMachineId;
    private String time;

    public VendingMachineSnacksLoading(Integer id, Integer technicianId,
                                       Integer vendingMachineId, String time) {
        this.id = id;
        this.technicianId = technicianId;
        this.vendingMachineId = vendingMachineId;
        this.time = time;
    }

    public VendingMachineSnacksLoading(Integer technicianId, Integer vendingMachineId, String time) {
        this(null, technicianId, vendingMachineId, time);
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
