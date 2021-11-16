package com.yuriichuk.Lab6.mapper;


import com.yuriichuk.Lab6.dto.VendingMachineMoneyUnloadingDTO;
import com.yuriichuk.Lab6.model.VendingMachineMoneyUnloading;

public class VendingMachineMoneyUnloadingMapper {

    public static VendingMachineMoneyUnloadingDTO mapVendingMachineMoneyUnloadingToDTO(
            VendingMachineMoneyUnloading vendingMachineMoneyUnloading) {
        return new VendingMachineMoneyUnloadingDTO(
                vendingMachineMoneyUnloading.getId(),
                vendingMachineMoneyUnloading.getTechnicianId(),
                vendingMachineMoneyUnloading.getVendingMachineId(),
                vendingMachineMoneyUnloading.getTime(),
                vendingMachineMoneyUnloading.getAmmount()
        );
    }

    public static VendingMachineMoneyUnloading mapDTOToVendingMachineMoneyUnloading(
            VendingMachineMoneyUnloadingDTO vendingMachineMoneyUnloadingDTO) {
        return new VendingMachineMoneyUnloading(
                vendingMachineMoneyUnloadingDTO.getId(),
                vendingMachineMoneyUnloadingDTO.getTechnicianId(),
                vendingMachineMoneyUnloadingDTO.getVendingMachineId(),
                vendingMachineMoneyUnloadingDTO.getTime(),
                vendingMachineMoneyUnloadingDTO.getAmmount()
        );
    }
}
