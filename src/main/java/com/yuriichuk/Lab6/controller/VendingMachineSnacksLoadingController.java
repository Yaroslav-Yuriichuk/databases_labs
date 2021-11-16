package com.yuriichuk.Lab6.controller;

import com.yuriichuk.Lab6.dto.VendingMachineDTO;
import com.yuriichuk.Lab6.dto.VendingMachineSnacksLoadingDTO;
import com.yuriichuk.Lab6.mapper.VendingMachineMapper;
import com.yuriichuk.Lab6.mapper.VendingMachineSnacksLoadingMapper;
import com.yuriichuk.Lab6.model.VendingMachine;
import com.yuriichuk.Lab6.model.VendingMachineSnacksLoading;
import com.yuriichuk.Lab6.service.VendingMachineSnacksLoadingService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/api/vending_machine_snacks_loading")
public class VendingMachineSnacksLoadingController {

    private final VendingMachineSnacksLoadingService vendingMachineSnacksLoadingService;

    @GetMapping
    public List<VendingMachineSnacksLoadingDTO> getAllVendingMachineSnacksLoadings() {
        return vendingMachineSnacksLoadingService.getAllVendingMachineSnacksLoadings().stream()
                .map(VendingMachineSnacksLoadingMapper::mapVendingMachineSnacksLoadingToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VendingMachineSnacksLoadingDTO> getVendingMachineSnacksLoadingById(
            final @PathVariable("id") Integer id) {
        VendingMachineSnacksLoading vendingMachineSnacksLoading
                = vendingMachineSnacksLoadingService.getVendingMachineSnacksLoadingById(id);
        if (vendingMachineSnacksLoading == null) {
            return new ResponseEntity<VendingMachineSnacksLoadingDTO>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<VendingMachineSnacksLoadingDTO>(
                VendingMachineSnacksLoadingMapper.mapVendingMachineSnacksLoadingToDTO(
                        vendingMachineSnacksLoading), HttpStatus.OK);
    }

    @PostMapping
    public VendingMachineSnacksLoadingDTO createVendingMachineSnacksLoading(
            final @RequestBody VendingMachineSnacksLoadingDTO vendingMachineSnacksLoadingDTO) {
        return VendingMachineSnacksLoadingMapper.mapVendingMachineSnacksLoadingToDTO(
                vendingMachineSnacksLoadingService.createVendingMachineSnacksLoading(vendingMachineSnacksLoadingDTO));
    }

    @PutMapping
    public ResponseEntity<VendingMachineSnacksLoadingDTO> updateVendingMachineSnacksLoading(
            final @RequestBody VendingMachineSnacksLoadingDTO vendingMachineSnacksLoadingDTO) {
        VendingMachineSnacksLoading vendingMachineSnacksLoading
                = vendingMachineSnacksLoadingService.getVendingMachineSnacksLoadingById(
                        vendingMachineSnacksLoadingDTO.getId());
        if (vendingMachineSnacksLoading == null) {
            return new ResponseEntity<VendingMachineSnacksLoadingDTO>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<VendingMachineSnacksLoadingDTO>(
                VendingMachineSnacksLoadingMapper.mapVendingMachineSnacksLoadingToDTO(
                        vendingMachineSnacksLoadingService.updateVendingMachineSnacksLoading(
                                vendingMachineSnacksLoadingDTO)), HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<VendingMachineSnacksLoadingDTO> deleteVendingMachineSnacksLoading(
            final @PathVariable("id") Integer id) {
        VendingMachineSnacksLoading vendingMachineSnacksLoading
                = vendingMachineSnacksLoadingService.getVendingMachineSnacksLoadingById(id);
        if (vendingMachineSnacksLoading == null) {
            return new ResponseEntity<VendingMachineSnacksLoadingDTO>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<VendingMachineSnacksLoadingDTO>(
                VendingMachineSnacksLoadingMapper.mapVendingMachineSnacksLoadingToDTO(
                        vendingMachineSnacksLoadingService.deleteVendingMachineSnacksLoadingById(id)), HttpStatus.OK
        );
    }
}
