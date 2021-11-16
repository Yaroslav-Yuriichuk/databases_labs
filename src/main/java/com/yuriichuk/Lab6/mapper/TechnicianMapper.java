package com.yuriichuk.Lab6.mapper;

import com.yuriichuk.Lab6.dto.TechnicianDTO;
import com.yuriichuk.Lab6.model.Technician;

public class TechnicianMapper {

    public static TechnicianDTO mapTechnicianToDTO(Technician technician) {
        return new TechnicianDTO(
                technician.getId(),
                technician.getFirstName(),
                technician.getLastName(),
                technician.getAge(),
                technician.getWorkEntryDate()
        );
    }

    public static Technician mapDTOToTechnician(TechnicianDTO technicianDTO) {
        return new Technician(
                technicianDTO.getId(),
                technicianDTO.getFirstName(),
                technicianDTO.getLastName(),
                technicianDTO.getAge(),
                technicianDTO.getWorkEntryDate()
        );
    }
}
