package com.yuriichuk.Lab6.service;

import com.yuriichuk.Lab6.dto.SnackDTO;
import com.yuriichuk.Lab6.dto.VendingMachineDTO;
import com.yuriichuk.Lab6.mapper.SnackMapper;
import com.yuriichuk.Lab6.mapper.VendingMachineMapper;
import com.yuriichuk.Lab6.model.Snack;
import com.yuriichuk.Lab6.model.VendingMachine;
import com.yuriichuk.Lab6.repository.VendingMachineRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class VendingMachineService {

    private final VendingMachineRepository vendingMachineRepository;

    public List<VendingMachine> getAllVendingMachines() {
        return vendingMachineRepository.findAll();
    }

    public VendingMachine getVendingMachineById(Integer id) {
        return vendingMachineRepository.findById(id)
                .orElse(null);
    }

    public VendingMachine createVendingMachine(VendingMachineDTO vendingMachineDTO) {
        return vendingMachineRepository.save(VendingMachineMapper.mapDTOToVendingMachine(vendingMachineDTO));
    }

    public VendingMachine updateVendingMachine(VendingMachineDTO vendingMachineDTO) {
        if (getVendingMachineById(vendingMachineDTO.getId()) != null) {
            return vendingMachineRepository.save(
                    VendingMachineMapper.mapDTOToVendingMachine(vendingMachineDTO));
        }
        return null;
    }

    public VendingMachine deleteVendingMachineById(Integer id) {
        VendingMachine vendingMachine = getVendingMachineById(id);
        if (vendingMachine != null) {
            vendingMachineRepository.deleteById(id);
            return vendingMachine;
        }
        return null;
    }
}
