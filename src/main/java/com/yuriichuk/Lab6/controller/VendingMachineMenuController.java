package com.yuriichuk.Lab6.controller;

import com.yuriichuk.Lab6.dto.VendingMachineDTO;
import com.yuriichuk.Lab6.dto.VendingMachineMenuDTO;
import com.yuriichuk.Lab6.mapper.VendingMachineMapper;
import com.yuriichuk.Lab6.mapper.VendingMachineMenuMapper;
import com.yuriichuk.Lab6.model.VendingMachine;
import com.yuriichuk.Lab6.model.VendingMachineMenu;
import com.yuriichuk.Lab6.model.composite_key.VendingMachineMenuPK;
import com.yuriichuk.Lab6.service.VendingMachineMenuService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/api/vending_machine_menu")
public class VendingMachineMenuController {

    private final VendingMachineMenuService vendingMachineMenuService;

    @GetMapping
    public List<VendingMachineMenuDTO> getAllVendingMachineMenus() {
        return vendingMachineMenuService.getAllVendingMachineMenus().stream()
                .map(VendingMachineMenuMapper::mapVendingMachineMenuToDTO)
                .collect(Collectors.toList());
    }

    /*@GetMapping
    public ResponseEntity<VendingMachineMenuDTO> getVendingMachineMenuById(final @RequestParam("vendingMachineId") Integer vendingMachineId,
                                                                           final @RequestParam("snackId") Integer snackId) {
        VendingMachineMenu vendingMachineMenu = vendingMachineMenuService.getVendingMachineMenuById(
                new VendingMachineMenuPK(vendingMachineId, snackId));
        if (vendingMachineMenu == null) {
            return new ResponseEntity<VendingMachineMenuDTO>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<VendingMachineMenuDTO>(
                VendingMachineMenuMapper.mapVendingMachineMenuToDTO(vendingMachineMenu), HttpStatus.OK);
    }*/

    @PostMapping
    public VendingMachineMenuDTO createVendingMachineMenu(final @RequestBody VendingMachineMenuDTO vendingMachineMenuDTO) {
        return VendingMachineMenuMapper.mapVendingMachineMenuToDTO(vendingMachineMenuService.createVendingMachineMenu(vendingMachineMenuDTO));
    }

    @PutMapping
    public ResponseEntity<VendingMachineMenuDTO> updateVendingMachineMenu(final @RequestBody VendingMachineMenuDTO vendingMachineMenuDTO) {
        VendingMachineMenu vendingMachineMenu = vendingMachineMenuService.getVendingMachineMenuById(
                new VendingMachineMenuPK(vendingMachineMenuDTO.getVendingMachineId(),
                        vendingMachineMenuDTO.getSnackId())
        );
        if (vendingMachineMenu == null) {
            return new ResponseEntity<VendingMachineMenuDTO>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<VendingMachineMenuDTO>(
                VendingMachineMenuMapper.mapVendingMachineMenuToDTO(
                        vendingMachineMenuService.updateVendingMachineMenu(vendingMachineMenuDTO)), HttpStatus.OK
        );
    }

    @DeleteMapping
    public ResponseEntity<VendingMachineMenuDTO> deleteVendingMachineMenu(final @RequestParam("vendingMachineId") Integer vendingMachineId,
                                                                          final @RequestParam("snackId") Integer snackId) {
        VendingMachineMenuPK id = new VendingMachineMenuPK(vendingMachineId, snackId);
        VendingMachineMenu vendingMachineMenu = vendingMachineMenuService.getVendingMachineMenuById(id);
        if (vendingMachineMenu == null) {
            return new ResponseEntity<VendingMachineMenuDTO>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<VendingMachineMenuDTO>(
                VendingMachineMenuMapper.mapVendingMachineMenuToDTO(vendingMachineMenuService.deleteVendingMachineMenuById(id)), HttpStatus.OK);
    }
}
