package com.yuriichuk.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VendingMachineMoneyLoading {
    private Integer id;
    private Integer technicianId;
    private Integer vendingMachineId;
    private String time;
    private Float ammount;

    public VendingMachineMoneyLoading(Integer id, Integer technicianId,
                                      Integer vendingMachineId, String time, Float ammount) {
        this.id = id;
        this.technicianId = technicianId;
        this.vendingMachineId = vendingMachineId;
        this.time = time;
        this.ammount = ammount;
    }

    public VendingMachineMoneyLoading(Integer technicianId,
                                      Integer vendingMachineId, String time, Float ammount) {
        this(null, technicianId, vendingMachineId, time, ammount);
    }

    @Override
    public String toString() {
        return "VendingMachineMoneyLoading {" +
                "id=" + id +
                ", technicianId=" + technicianId +
                ", vendingMachineId=" + vendingMachineId +
                ", time='" + time + '\'' +
                ", ammount=" + ammount +
                '}';
    }
}
