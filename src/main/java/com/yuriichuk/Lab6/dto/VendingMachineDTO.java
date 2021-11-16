package com.yuriichuk.Lab6.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class VendingMachineDTO {
    private Integer id;
    private String coordinates;
    private Integer addressId;
}
