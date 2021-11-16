package com.yuriichuk.Lab6.controller;

import com.yuriichuk.Lab6.dto.VendingMachineSoldSnackDTO;
import com.yuriichuk.Lab6.mapper.VendingMachineSoldSnackMapper;
import com.yuriichuk.Lab6.model.VendingMachineSoldSnack;
import com.yuriichuk.Lab6.service.VendingMachineSoldSnackService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/api/vending_machine_sold_snack")
public class VendingMachineSoldSnackController {

    private final VendingMachineSoldSnackService vendingMachineSoldSnackService;

    @GetMapping
    public List<VendingMachineSoldSnackDTO> getAllVendingMachineSoldSnacks() {
        return vendingMachineSoldSnackService.getAllVendingMachineSoldSnacks().stream()
                .map(VendingMachineSoldSnackMapper::mapVendingMachineSoldSnackToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VendingMachineSoldSnackDTO> getVendingMachineSoldSnackById(
            final @PathVariable("id") Integer id) {
        VendingMachineSoldSnack vendingMachineSoldSnack
                = vendingMachineSoldSnackService.getVendingMachineSoldSnackById(id);
        if (vendingMachineSoldSnack == null) {
            return new ResponseEntity<VendingMachineSoldSnackDTO>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<VendingMachineSoldSnackDTO>(
                VendingMachineSoldSnackMapper.mapVendingMachineSoldSnackToDTO(vendingMachineSoldSnack), HttpStatus.OK);
    }

    @PostMapping
    public VendingMachineSoldSnackDTO createVendingMachineSoldSnack(
            final @RequestBody VendingMachineSoldSnackDTO vendingMachineSoldSnackDTO) {
        return VendingMachineSoldSnackMapper.mapVendingMachineSoldSnackToDTO(
                vendingMachineSoldSnackService.createVendingMachineSoldSnack(vendingMachineSoldSnackDTO));
    }

    @PutMapping
    public ResponseEntity<VendingMachineSoldSnackDTO> updateVendingMachineSoldSnack(
            final @RequestBody VendingMachineSoldSnackDTO vendingMachineSoldSnackDTO) {
        VendingMachineSoldSnack vendingMachineSoldSnack
                = vendingMachineSoldSnackService.getVendingMachineSoldSnackById(vendingMachineSoldSnackDTO.getId());
        if (vendingMachineSoldSnack == null) {
            return new ResponseEntity<VendingMachineSoldSnackDTO>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<VendingMachineSoldSnackDTO>(
                VendingMachineSoldSnackMapper.mapVendingMachineSoldSnackToDTO(
                        vendingMachineSoldSnackService.updateVendingMachineSoldSnack(
                                vendingMachineSoldSnackDTO)), HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<VendingMachineSoldSnackDTO> deleteVendingMachineSoldSnack(
            final @PathVariable("id") Integer id) {
        VendingMachineSoldSnack vendingMachineSoldSnack
                = vendingMachineSoldSnackService.getVendingMachineSoldSnackById(id);
        if (vendingMachineSoldSnack == null) {
            return new ResponseEntity<VendingMachineSoldSnackDTO>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<VendingMachineSoldSnackDTO>(
                VendingMachineSoldSnackMapper.mapVendingMachineSoldSnackToDTO(
                        vendingMachineSoldSnackService.deleteVendingMachineSoldSnackById(id)), HttpStatus.OK
        );
    }
}
