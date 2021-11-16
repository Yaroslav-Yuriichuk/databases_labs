package com.yuriichuk.Lab6.controller;

import com.yuriichuk.Lab6.dto.VendingMachineDTO;
import com.yuriichuk.Lab6.dto.VendingMachineMoneyLoadingDTO;
import com.yuriichuk.Lab6.mapper.VendingMachineMapper;
import com.yuriichuk.Lab6.mapper.VendingMachineMoneyLoadingMapper;
import com.yuriichuk.Lab6.model.VendingMachine;
import com.yuriichuk.Lab6.model.VendingMachineMoneyLoading;
import com.yuriichuk.Lab6.service.VendingMachineMoneyLoadingService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/api/vending_machine_money_loading")
public class VendingMachineMoneyLoadingController {

    private final VendingMachineMoneyLoadingService vendingMachineMoneyLoadingService;

    @GetMapping
    public List<VendingMachineMoneyLoadingDTO> getAllVendingMachineMoneyLoadings() {
        return vendingMachineMoneyLoadingService.getAllVendingMachineMoneyLoadings().stream()
                .map(VendingMachineMoneyLoadingMapper::mapVendingMachineMoneyLoadingToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VendingMachineMoneyLoadingDTO> getVendingMachineMoneyLoadingById(
            final @PathVariable("id") Integer id) {
        VendingMachineMoneyLoading vendingMachineMoneyLoading
                = vendingMachineMoneyLoadingService.getVendingMachineMoneyLoadingById(id);
        if (vendingMachineMoneyLoading == null) {
            return new ResponseEntity<VendingMachineMoneyLoadingDTO>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<VendingMachineMoneyLoadingDTO>(
                VendingMachineMoneyLoadingMapper.mapVendingMachineMoneyLoadingToDTO(vendingMachineMoneyLoading), HttpStatus.OK);
    }

    @PostMapping
    public VendingMachineMoneyLoadingDTO createVendingMachineMoneyLoading(
            final @RequestBody VendingMachineMoneyLoadingDTO vendingMachineMoneyLoadingDTO) {
        return VendingMachineMoneyLoadingMapper.mapVendingMachineMoneyLoadingToDTO(
                vendingMachineMoneyLoadingService.createVendingMachineMoneyLoading(vendingMachineMoneyLoadingDTO));
    }

    @PutMapping
    public ResponseEntity<VendingMachineMoneyLoadingDTO> updateVendingMachineMoneyLoading(
            final @RequestBody VendingMachineMoneyLoadingDTO vendingMachineMoneyLoadingDTO) {
        VendingMachineMoneyLoading vendingMachineMoneyLoading
                = vendingMachineMoneyLoadingService.getVendingMachineMoneyLoadingById(vendingMachineMoneyLoadingDTO.getId());
        if (vendingMachineMoneyLoading == null) {
            return new ResponseEntity<VendingMachineMoneyLoadingDTO>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<VendingMachineMoneyLoadingDTO>(
                VendingMachineMoneyLoadingMapper.mapVendingMachineMoneyLoadingToDTO(
                        vendingMachineMoneyLoadingService.updateVendingMachineMoneyLoading(vendingMachineMoneyLoadingDTO)), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<VendingMachineMoneyLoadingDTO> deleteVendingMachineMoneyLoading(
            final @PathVariable("id") Integer id) {
        VendingMachineMoneyLoading vendingMachineMoneyLoading
                = vendingMachineMoneyLoadingService.getVendingMachineMoneyLoadingById(id);
        if (vendingMachineMoneyLoading == null) {
            return new ResponseEntity<VendingMachineMoneyLoadingDTO>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<VendingMachineMoneyLoadingDTO>(
                VendingMachineMoneyLoadingMapper.mapVendingMachineMoneyLoadingToDTO(
                        vendingMachineMoneyLoadingService.deleteVendingMachineMoneyLoadingById(id)), HttpStatus.OK);
    }
}
