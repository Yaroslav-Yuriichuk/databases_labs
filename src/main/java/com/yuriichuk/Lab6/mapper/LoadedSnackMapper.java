package com.yuriichuk.Lab6.mapper;

import com.yuriichuk.Lab6.dto.LoadedSnackDTO;
import com.yuriichuk.Lab6.model.LoadedSnack;

public class LoadedSnackMapper {

    public static LoadedSnackDTO mapLoadedSnackToDTO(LoadedSnack loadedSnack) {
        return new LoadedSnackDTO(
                loadedSnack.getVendingMachineSnacksLoadingId(),
                loadedSnack.getSnackId(),
                loadedSnack.getQuantity()
        );
    }

    public static LoadedSnack mapDTOToLoadedSnack(LoadedSnackDTO loadedSnackDTO) {
        return new LoadedSnack(
                loadedSnackDTO.getVendingMachineSnacksLoadingId(),
                loadedSnackDTO.getSnackId(),
                loadedSnackDTO.getQuantity()
        );
    }
}
