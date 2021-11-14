package com.yuriichuk.Lab6.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class VendingMachineMoneyLoadingDTO {
    private Integer id;
    private Integer technicianId;
    private Integer vendingMachineId;
    private String time;
    private Float ammount;
}
