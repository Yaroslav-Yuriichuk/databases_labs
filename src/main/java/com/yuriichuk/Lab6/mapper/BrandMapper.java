package com.yuriichuk.Lab6.mapper;

import com.yuriichuk.Lab6.dto.BrandDTO;
import com.yuriichuk.Lab6.model.Brand;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class BrandMapper {

    public static BrandDTO mapBrandToDTO(Brand brand) {
        return new BrandDTO(
                brand.getId(),
                brand.getName(),
                brand.getFoundationDate()
        );
    }

    public static Brand mapDTOToBrand(BrandDTO brandDTO) {
        return new Brand(
                brandDTO.getId(),
                brandDTO.getName(),
                brandDTO.getFoundationDate()
        );
    }
}
