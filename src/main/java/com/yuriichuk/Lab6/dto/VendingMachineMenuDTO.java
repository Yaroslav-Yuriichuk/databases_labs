package com.yuriichuk.Lab6.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class VendingMachineMenuDTO {
    private Integer vendingMachineId;
    private Integer snackId;
    private Integer quantity;
}
