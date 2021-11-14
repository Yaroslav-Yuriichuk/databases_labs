package com.yuriichuk.Lab6.controller;

import com.yuriichuk.Lab6.dto.AddressDTO;
import com.yuriichuk.Lab6.mapper.AddressMapper;
import com.yuriichuk.Lab6.model.Address;
import com.yuriichuk.Lab6.service.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/api/address")
public class AddressController {

    private final AddressService addressService;

    @GetMapping
    public List<AddressDTO> getAllAddresses() {
        return addressService.getAllAddresses().stream()
                .map(AddressMapper::mapAddressToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressDTO> getAddressById(final @PathVariable("id") Integer id) {
        Address address = addressService.getAddressById(id);
        if (address == null) {
            return new ResponseEntity<AddressDTO>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<AddressDTO>(
                AddressMapper.mapAddressToDTO(address), HttpStatus.OK);
    }

    @PostMapping
    public AddressDTO createAddress(final @RequestBody AddressDTO addressDTO) {
        return AddressMapper.mapAddressToDTO(addressService.createAddress(addressDTO));
    }

    @PutMapping
    public ResponseEntity<AddressDTO> updateAddress(final @RequestBody AddressDTO addressDTO) {
        Address address = addressService.getAddressById(addressDTO.getId());
        if (address == null) {
            return new ResponseEntity<AddressDTO>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<AddressDTO>(
                AddressMapper.mapAddressToDTO(addressService.updateAddress(addressDTO)), HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AddressDTO> deleteAddress(final @PathVariable("id") Integer id) {
        Address address = addressService.getAddressById(id);
        if (address == null) {
            return new ResponseEntity<AddressDTO>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<AddressDTO>(
                AddressMapper.mapAddressToDTO(addressService.deleteAddressById(id)), HttpStatus.OK
        );
    }
}
