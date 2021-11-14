package com.yuriichuk.Lab6.mapper;

import com.yuriichuk.Lab6.dto.SnackDTO;
import com.yuriichuk.Lab6.model.Snack;

public class SnackMapper {

    public static SnackDTO mapSnackToDTO(Snack snack) {
        return new SnackDTO(
                snack.getId(),
                snack.getName(),
                snack.getPrice(),
                snack.getWeight(),
                snack.getCallories(),
                snack.getBrandId()
        );
    }

    public static Snack mapDTOToSnack(SnackDTO snackDTO) {
        return new Snack(
                snackDTO.getId(),
                snackDTO.getName(),
                snackDTO.getPrice(),
                snackDTO.getWeight(),
                snackDTO.getCallories(),
                snackDTO.getBrandId()
        );
    }
}
