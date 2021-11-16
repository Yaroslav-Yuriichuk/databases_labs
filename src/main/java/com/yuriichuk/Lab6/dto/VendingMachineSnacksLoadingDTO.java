package com.yuriichuk.Lab6.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class VendingMachineSnacksLoadingDTO {
    private Integer id;
    private Integer technicianId;
    private Integer vendingMachineId;
    private String time;
}
