package com.yuriichuk.Lab6.mapper;

import com.yuriichuk.Lab6.dto.VendingMachineSnacksLoadingDTO;
import com.yuriichuk.Lab6.model.VendingMachineSnacksLoading;

public class VendingMachineSnacksLoadingMapper {

    public static VendingMachineSnacksLoadingDTO mapVendingMachineSnacksLoadingToDTO(
            VendingMachineSnacksLoading vendingMachineSnacksLoading
    ) {
        return new VendingMachineSnacksLoadingDTO(
                vendingMachineSnacksLoading.getId(),
                vendingMachineSnacksLoading.getTechnicianId(),
                vendingMachineSnacksLoading.getVendingMachineId(),
                vendingMachineSnacksLoading.getTime()
        );
    }

    public static VendingMachineSnacksLoading mapDTOToVendingMachineSnacksLoading(
            VendingMachineSnacksLoadingDTO vendingMachineSnacksLoadingDTO
    ) {
        return new VendingMachineSnacksLoading(
                vendingMachineSnacksLoadingDTO.getId(),
                vendingMachineSnacksLoadingDTO.getTechnicianId(),
                vendingMachineSnacksLoadingDTO.getVendingMachineId(),
                vendingMachineSnacksLoadingDTO.getTime()
        );
    }
}
