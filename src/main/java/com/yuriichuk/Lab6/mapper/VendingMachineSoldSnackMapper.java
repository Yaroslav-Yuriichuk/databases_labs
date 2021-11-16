package com.yuriichuk.Lab6.mapper;

import com.yuriichuk.Lab6.dto.VendingMachineSoldSnackDTO;
import com.yuriichuk.Lab6.model.VendingMachineSoldSnack;

public class VendingMachineSoldSnackMapper {

    public static VendingMachineSoldSnackDTO mapVendingMachineSoldSnackToDTO(
            VendingMachineSoldSnack vendingMachineSoldSnack) {
        return new VendingMachineSoldSnackDTO(
                vendingMachineSoldSnack.getId(),
                vendingMachineSoldSnack.getVendingMachineId(),
                vendingMachineSoldSnack.getSnackId(),
                vendingMachineSoldSnack.getQuantity(),
                vendingMachineSoldSnack.getDate()
        );
    }

    public static VendingMachineSoldSnack mapDTOToVendingMachineSoldSnack(
            VendingMachineSoldSnackDTO vendingMachineSoldSnackDTO) {
        return new VendingMachineSoldSnack(
                vendingMachineSoldSnackDTO.getId(),
                vendingMachineSoldSnackDTO.getVendingMachineId(),
                vendingMachineSoldSnackDTO.getSnackId(),
                vendingMachineSoldSnackDTO.getQuantity(),
                vendingMachineSoldSnackDTO.getDate()
        );
    }
}
