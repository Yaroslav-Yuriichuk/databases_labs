package com.yuriichuk.Lab6.controller;

import com.yuriichuk.Lab6.dto.SnackDTO;
import com.yuriichuk.Lab6.dto.VendingMachineDTO;
import com.yuriichuk.Lab6.mapper.SnackMapper;
import com.yuriichuk.Lab6.mapper.VendingMachineMapper;
import com.yuriichuk.Lab6.model.Snack;
import com.yuriichuk.Lab6.model.VendingMachine;
import com.yuriichuk.Lab6.service.VendingMachineService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/api/vending_machine")
public class VendingMachineController {

    private final VendingMachineService vendingMachineService;

    @GetMapping
    public List<VendingMachineDTO> getAllVendingMachines() {
        return vendingMachineService.getAllVendingMachines().stream()
                .map(VendingMachineMapper::mapVendingMachineToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VendingMachineDTO> getVendingMachineById(final @PathVariable("id") Integer id) {
        VendingMachine vendingMachine = vendingMachineService.getVendingMachineById(id);
        if (vendingMachine == null) {
            return new ResponseEntity<VendingMachineDTO>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<VendingMachineDTO>(
                VendingMachineMapper.mapVendingMachineToDTO(vendingMachine), HttpStatus.OK);
    }

    @PostMapping
    public VendingMachineDTO createVendingMachine(final @RequestBody VendingMachineDTO vendingMachineDTO) {
        return VendingMachineMapper.mapVendingMachineToDTO(vendingMachineService.createVendingMachine(vendingMachineDTO));
    }

    @PutMapping
    public ResponseEntity<VendingMachineDTO> updateVendingMachine(final @RequestBody VendingMachineDTO vendingMachineDTO) {
        VendingMachine vendingMachine = vendingMachineService.getVendingMachineById(vendingMachineDTO.getId());
        if (vendingMachine == null) {
            return new ResponseEntity<VendingMachineDTO>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<VendingMachineDTO>(
                VendingMachineMapper.mapVendingMachineToDTO(
                        vendingMachineService.updateVendingMachine(vendingMachineDTO)), HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<VendingMachineDTO> deleteVendingMachine(final @PathVariable("id") Integer id) {
        VendingMachine vendingMachine = vendingMachineService.getVendingMachineById(id);
        if (vendingMachine == null) {
            return new ResponseEntity<VendingMachineDTO>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<VendingMachineDTO>(
                VendingMachineMapper.mapVendingMachineToDTO(vendingMachineService.deleteVendingMachineById(id)), HttpStatus.OK
        );
    }
}
