package com.yuriichuk.Lab6.controller;

import com.yuriichuk.Lab6.dto.SnackDTO;
import com.yuriichuk.Lab6.dto.TechnicianDTO;
import com.yuriichuk.Lab6.mapper.SnackMapper;
import com.yuriichuk.Lab6.mapper.TechnicianMapper;
import com.yuriichuk.Lab6.model.Snack;
import com.yuriichuk.Lab6.model.Technician;
import com.yuriichuk.Lab6.service.TechnicianService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/api/technician")
public class TechnicianController {

    private final TechnicianService technicianService;

    @GetMapping
    public List<TechnicianDTO> getAllTechnicians() {
        return technicianService.getAllTechnicians().stream()
                .map(TechnicianMapper::mapTechnicianToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TechnicianDTO> getTechnicianById(final @PathVariable("id") Integer id) {
        Technician technician = technicianService.getTechnicianById(id);
        if (technician == null) {
            return new ResponseEntity<TechnicianDTO>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<TechnicianDTO>(
                TechnicianMapper.mapTechnicianToDTO(technician), HttpStatus.OK);
    }

    @PostMapping
    public TechnicianDTO createTechnician(final @RequestBody TechnicianDTO technicianDTO) {
        return TechnicianMapper.mapTechnicianToDTO(technicianService.createTechnician(technicianDTO));
    }

    @PutMapping
    public ResponseEntity<TechnicianDTO> updateTechnician(final @RequestBody TechnicianDTO technicianDTO) {
        Technician technician = technicianService.getTechnicianById(technicianDTO.getId());
        if (technician == null) {
            return new ResponseEntity<TechnicianDTO>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<TechnicianDTO>(
                TechnicianMapper.mapTechnicianToDTO(technicianService.updateTechnician(technicianDTO)), HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TechnicianDTO> deleteTechnician(final @PathVariable("id") Integer id) {
        Technician technician = technicianService.getTechnicianById(id);
        if (technician == null) {
            return new ResponseEntity<TechnicianDTO>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<TechnicianDTO>(
                TechnicianMapper.mapTechnicianToDTO(technicianService.deleteTechnicianById(id)), HttpStatus.OK
        );
    }
}
