package com.yuriichuk.Lab6.service;

import com.yuriichuk.Lab6.dto.SnackDTO;
import com.yuriichuk.Lab6.dto.TechnicianDTO;
import com.yuriichuk.Lab6.mapper.SnackMapper;
import com.yuriichuk.Lab6.mapper.TechnicianMapper;
import com.yuriichuk.Lab6.model.Snack;
import com.yuriichuk.Lab6.model.Technician;
import com.yuriichuk.Lab6.repository.TechnicianRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TechnicianService {

    private final TechnicianRepository technicianRepository;

    public List<Technician> getAllTechnicians() {
        return technicianRepository.findAll();
    }

    public Technician getTechnicianById(Integer id) {
        return technicianRepository.findById(id)
                .orElse(null);
    }

    public Technician createTechnician(TechnicianDTO technicianDTO) {
        return technicianRepository.save(TechnicianMapper.mapDTOToTechnician(technicianDTO));
    }

    public Technician updateTechnician(TechnicianDTO technicianDTO) {
        if (getTechnicianById(technicianDTO.getId()) != null) {
            return technicianRepository.save(TechnicianMapper.mapDTOToTechnician(technicianDTO));
        }
        return null;
    }

    public Technician deleteTechnicianById(Integer id) {
        Technician technician = getTechnicianById(id);
        if (technician != null) {
            technicianRepository.deleteById(id);
            return technician;
        }
        return null;
    }
}
