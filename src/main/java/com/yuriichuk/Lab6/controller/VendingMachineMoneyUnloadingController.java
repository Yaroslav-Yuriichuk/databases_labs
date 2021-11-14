package com.yuriichuk.Lab6.controller;

import com.yuriichuk.Lab6.dto.VendingMachineMoneyLoadingDTO;
import com.yuriichuk.Lab6.dto.VendingMachineMoneyUnloadingDTO;
import com.yuriichuk.Lab6.mapper.VendingMachineMoneyLoadingMapper;
import com.yuriichuk.Lab6.mapper.VendingMachineMoneyUnloadingMapper;
import com.yuriichuk.Lab6.model.VendingMachineMoneyLoading;
import com.yuriichuk.Lab6.model.VendingMachineMoneyUnloading;
import com.yuriichuk.Lab6.service.VendingMachineMoneyUnloadingService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/api/vending_machine_money_unloading")
public class VendingMachineMoneyUnloadingController {

    private VendingMachineMoneyUnloadingService vendingMachineMoneyUnloadingService;

    @GetMapping
    public List<VendingMachineMoneyUnloadingDTO> getAllVendingMachineMoneyUnloadings() {
        return vendingMachineMoneyUnloadingService.getAllVendingMachineMoneyUnloadings().stream()
                .map(VendingMachineMoneyUnloadingMapper::mapVendingMachineMoneyUnloadingToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VendingMachineMoneyUnloadingDTO> getVendingMachineMoneyUnloadingById(
            final @PathVariable("id") Integer id) {
        VendingMachineMoneyUnloading vendingMachineMoneyUnloading
                = vendingMachineMoneyUnloadingService.getVendingMachineMoneyUnloadingById(id);
        if (vendingMachineMoneyUnloading == null) {
            return new ResponseEntity<VendingMachineMoneyUnloadingDTO>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<VendingMachineMoneyUnloadingDTO>(
                VendingMachineMoneyUnloadingMapper.mapVendingMachineMoneyUnloadingToDTO(
                        vendingMachineMoneyUnloading), HttpStatus.OK);
    }

    @PostMapping
    public VendingMachineMoneyUnloadingDTO createVendingMachineMoneyUnloading(
            final @RequestBody VendingMachineMoneyUnloadingDTO vendingMachineMoneyUnloadingDTO) {
        return VendingMachineMoneyUnloadingMapper.mapVendingMachineMoneyUnloadingToDTO(
                vendingMachineMoneyUnloadingService.createVendingMachineMoneyUnloading(vendingMachineMoneyUnloadingDTO));
    }

    @PutMapping
    public ResponseEntity<VendingMachineMoneyUnloadingDTO> updateVendingMachineMoneyUnloading(
            final @RequestBody VendingMachineMoneyUnloadingDTO vendingMachineMoneyUnloadingDTO) {
        VendingMachineMoneyUnloading vendingMachineMoneyUnloading
                = vendingMachineMoneyUnloadingService.getVendingMachineMoneyUnloadingById(vendingMachineMoneyUnloadingDTO.getId());
        if (vendingMachineMoneyUnloading == null) {
            return new ResponseEntity<VendingMachineMoneyUnloadingDTO>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<VendingMachineMoneyUnloadingDTO>(
                VendingMachineMoneyUnloadingMapper.mapVendingMachineMoneyUnloadingToDTO(
                        vendingMachineMoneyUnloadingService.updateVendingMachineMoneyUnloading(
                                vendingMachineMoneyUnloadingDTO)), HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<VendingMachineMoneyUnloadingDTO> deleteVendingMachineMoneyUnloading(
            final @PathVariable("id") Integer id) {
        VendingMachineMoneyUnloading vendingMachineMoneyUnloading
                = vendingMachineMoneyUnloadingService.getVendingMachineMoneyUnloadingById(id);
        if (vendingMachineMoneyUnloading == null) {
            return new ResponseEntity<VendingMachineMoneyUnloadingDTO>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<VendingMachineMoneyUnloadingDTO>(
                VendingMachineMoneyUnloadingMapper.mapVendingMachineMoneyUnloadingToDTO(
                        vendingMachineMoneyUnloadingService.deleteVendingMachineMoneyUnloadingById(id)), HttpStatus.OK);
    }
}
