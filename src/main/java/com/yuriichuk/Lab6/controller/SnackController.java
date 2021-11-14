package com.yuriichuk.Lab6.controller;

import com.yuriichuk.Lab6.dto.BrandDTO;
import com.yuriichuk.Lab6.dto.SnackDTO;
import com.yuriichuk.Lab6.mapper.BrandMapper;
import com.yuriichuk.Lab6.mapper.SnackMapper;
import com.yuriichuk.Lab6.model.Brand;
import com.yuriichuk.Lab6.model.Snack;
import com.yuriichuk.Lab6.service.SnackService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/api/snack")
public class SnackController {

    private final SnackService snackService;

    @GetMapping
    public List<SnackDTO> getAllSnacks() {
        return snackService.getAllSnacks().stream()
                .map(SnackMapper::mapSnackToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SnackDTO> getSnackById(final @PathVariable("id") Integer id) {
        Snack snack = snackService.getSnackById(id);
        if (snack == null) {
            return new ResponseEntity<SnackDTO>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<SnackDTO>(
                SnackMapper.mapSnackToDTO(snack), HttpStatus.OK);
    }

    @PostMapping
    public SnackDTO createSnack(final @RequestBody SnackDTO snackDTO) {
        return SnackMapper.mapSnackToDTO(snackService.createSnack(snackDTO));
    }

    @PutMapping
    public ResponseEntity<SnackDTO> updateSnack(final @RequestBody SnackDTO snackDTO) {
        Snack snack = snackService.getSnackById(snackDTO.getId());
        if (snack == null) {
            return new ResponseEntity<SnackDTO>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<SnackDTO>(
                SnackMapper.mapSnackToDTO(snackService.updateSnack(snackDTO)), HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SnackDTO> deleteSnack(final @PathVariable("id") Integer id) {
        Snack snack = snackService.getSnackById(id);
        if (snack == null) {
            return new ResponseEntity<SnackDTO>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<SnackDTO>(
                SnackMapper.mapSnackToDTO(snackService.deleteSnackById(id)), HttpStatus.OK
        );
    }
}
