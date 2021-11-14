package com.yuriichuk.Lab6.mapper;

import com.yuriichuk.Lab6.dto.VendingMachineMoneyLoadingDTO;
import com.yuriichuk.Lab6.model.VendingMachineMoneyLoading;

public class VendingMachineMoneyLoadingMapper {

    public static VendingMachineMoneyLoadingDTO mapVendingMachineMoneyLoadingToDTO(
            VendingMachineMoneyLoading vendingMachineMoneyLoading) {
        return new VendingMachineMoneyLoadingDTO(
                vendingMachineMoneyLoading.getId(),
                vendingMachineMoneyLoading.getTechnicianId(),
                vendingMachineMoneyLoading.getVendingMachineId(),
                vendingMachineMoneyLoading.getTime(),
                vendingMachineMoneyLoading.getAmmount()
        );
    }

    public static VendingMachineMoneyLoading mapDTOToVendingMachineMoneyLoading(
            VendingMachineMoneyLoadingDTO vendingMachineMoneyLoadingDTO) {
        return new VendingMachineMoneyLoading(
                vendingMachineMoneyLoadingDTO.getId(),
                vendingMachineMoneyLoadingDTO.getTechnicianId(),
                vendingMachineMoneyLoadingDTO.getVendingMachineId(),
                vendingMachineMoneyLoadingDTO.getTime(),
                vendingMachineMoneyLoadingDTO.getAmmount()
        );
    }
}
