package com.yuriichuk.Lab6.controller;

import com.yuriichuk.Lab6.dto.LoadedSnackDTO;
import com.yuriichuk.Lab6.dto.VendingMachineMenuDTO;
import com.yuriichuk.Lab6.mapper.LoadedSnackMapper;
import com.yuriichuk.Lab6.mapper.VendingMachineMenuMapper;
import com.yuriichuk.Lab6.model.LoadedSnack;
import com.yuriichuk.Lab6.model.VendingMachineMenu;
import com.yuriichuk.Lab6.model.composite_key.LoadedSnackPK;
import com.yuriichuk.Lab6.model.composite_key.VendingMachineMenuPK;
import com.yuriichuk.Lab6.service.LoadedSnackService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/api/loaded_snack")
public class LoadedSnackController {

    private final LoadedSnackService loadedSnackService;

    @GetMapping
    public List<LoadedSnackDTO> getAllLoadedSnacks() {
        return loadedSnackService.getAllLoadedSnacks().stream()
                .map(LoadedSnackMapper::mapLoadedSnackToDTO)
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
    public LoadedSnackDTO createLoadedSnack(final @RequestBody LoadedSnackDTO loadedSnackDTO) {
        return LoadedSnackMapper.mapLoadedSnackToDTO(
                loadedSnackService.createLoadedSnack(loadedSnackDTO));
    }

    @PutMapping
    public ResponseEntity<LoadedSnackDTO> updateLoadedSnack(final @RequestBody LoadedSnackDTO loadedSnackDTO) {
        LoadedSnack loadedSnack = loadedSnackService.getLoadedSnackById(
                new LoadedSnackPK(loadedSnackDTO.getVendingMachineSnacksLoadingId(),
                        loadedSnackDTO.getSnackId())
        );
        if (loadedSnack == null) {
            return new ResponseEntity<LoadedSnackDTO>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<LoadedSnackDTO>(
                LoadedSnackMapper.mapLoadedSnackToDTO(
                        loadedSnackService.updateLoadedSnack(loadedSnackDTO)), HttpStatus.OK
        );
    }

    @DeleteMapping
    public ResponseEntity<LoadedSnackDTO> deleteLoadedSnack(final @RequestParam("vendingMachineSnacksLoadingId") Integer vendingMachineSnacksLoadingId,
                                                                          final @RequestParam("snackId") Integer snackId) {
        LoadedSnackPK id = new LoadedSnackPK(vendingMachineSnacksLoadingId, snackId);
        LoadedSnack loadedSnack = loadedSnackService.getLoadedSnackById(id);
        if (loadedSnack == null) {
            return new ResponseEntity<LoadedSnackDTO>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<LoadedSnackDTO>(
                LoadedSnackMapper.mapLoadedSnackToDTO(loadedSnackService.deleteLoadedSnackById(id)), HttpStatus.OK);
    }
}
