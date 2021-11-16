package com.yuriichuk.Lab6.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class VendingMachineSoldSnackDTO {
    private Integer id;
    private Integer vendingMachineId;
    private Integer snackId;
    private Integer quantity;
    private String date;
}
