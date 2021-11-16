package com.yuriichuk.Lab6.mapper;

import com.yuriichuk.Lab6.dto.AddressDTO;
import com.yuriichuk.Lab6.model.Address;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AddressMapper {

    public static AddressDTO mapAddressToDTO(Address address) {
        return new AddressDTO(
                address.getId(),
                address.getRegion(),
                address.getCityVillage(),
                address.getStreet(),
                address.getBuilding()
        );
    }

    public static Address mapDTOToAddress(AddressDTO addressDTO) {
        return new Address(
                addressDTO.getId(),
                addressDTO.getRegion(),
                addressDTO.getCityVillage(),
                addressDTO.getStreet(),
                addressDTO.getBuilding()
        );
    }
}
