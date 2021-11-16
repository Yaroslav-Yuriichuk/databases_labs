package com.yuriichuk.Lab6.mapper;

import com.yuriichuk.Lab6.dto.SnackDTO;
import com.yuriichuk.Lab6.dto.VendingMachineDTO;
import com.yuriichuk.Lab6.model.Snack;
import com.yuriichuk.Lab6.model.VendingMachine;

public class VendingMachineMapper {

    public static VendingMachineDTO mapVendingMachineToDTO(VendingMachine vendingMachine) {
        return new VendingMachineDTO(
                vendingMachine.getId(),
                vendingMachine.getCoordinates(),
                vendingMachine.getAddressId()
        );
    }

    public static VendingMachine mapDTOToVendingMachine(VendingMachineDTO vendingMachineDTO) {
        return new VendingMachine(
                vendingMachineDTO.getId(),
                vendingMachineDTO.getCoordinates(),
                vendingMachineDTO.getAddressId()
        );
    }
}
