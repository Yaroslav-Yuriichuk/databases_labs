package com.yuriichuk.Lab6.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class LoadedSnackDTO {
    private Integer vendingMachineSnacksLoadingId;
    private Integer snackId;
    private Integer quantity;
}
