package com.yuriichuk.Lab6.service;

import com.yuriichuk.Lab6.dto.AddressDTO;
import com.yuriichuk.Lab6.mapper.AddressMapper;
import com.yuriichuk.Lab6.model.Address;
import com.yuriichuk.Lab6.repository.AddressRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;

    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    public Address getAddressById(Integer id) {
        return addressRepository.findById(id)
                .orElse(null);
    }

    public Address createAddress(AddressDTO addressDTO) {
        return addressRepository.save(AddressMapper.mapDTOToAddress(addressDTO));
    }

    public Address updateAddress(AddressDTO addressDTO) {
        if (getAddressById(addressDTO.getId()) != null) {
            return addressRepository.save(AddressMapper.mapDTOToAddress(addressDTO));
        }
        return null;
    }

    public Address deleteAddressById(Integer id) {
        Address address = getAddressById(id);
        if (address != null) {
            addressRepository.deleteById(id);
            return address;
        }
        return null;
    }
}
