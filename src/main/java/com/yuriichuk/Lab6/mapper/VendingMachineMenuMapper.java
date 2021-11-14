package com.yuriichuk.Lab6.mapper;

import com.yuriichuk.Lab6.dto.VendingMachineDTO;
import com.yuriichuk.Lab6.dto.VendingMachineMenuDTO;
import com.yuriichuk.Lab6.model.VendingMachineMenu;

public class VendingMachineMenuMapper {

    public static VendingMachineMenuDTO mapVendingMachineMenuToDTO(VendingMachineMenu vendingMachineMenu) {
        return new VendingMachineMenuDTO(
                vendingMachineMenu.getVendingMachineId(),
                vendingMachineMenu.getSnackId(),
                vendingMachineMenu.getQuantity()
        );
    }

    public static VendingMachineMenu mapDTOToVendingMachineMenu(VendingMachineMenuDTO vendingMachineMenuDTO) {
        return new VendingMachineMenu(
                vendingMachineMenuDTO.getVendingMachineId(),
                vendingMachineMenuDTO.getSnackId(),
                vendingMachineMenuDTO.getQuantity()
        );
    }
}
