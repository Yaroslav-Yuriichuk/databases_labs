package com.yuriichuk.Lab6.service;

import com.yuriichuk.Lab6.dto.VendingMachineDTO;
import com.yuriichuk.Lab6.dto.VendingMachineSoldSnackDTO;
import com.yuriichuk.Lab6.mapper.VendingMachineMapper;
import com.yuriichuk.Lab6.mapper.VendingMachineSoldSnackMapper;
import com.yuriichuk.Lab6.model.VendingMachine;
import com.yuriichuk.Lab6.model.VendingMachineSoldSnack;
import com.yuriichuk.Lab6.repository.VendingMachineSoldSnackRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class VendingMachineSoldSnackService {

    private final VendingMachineSoldSnackRepository vendingMachineSoldSnackRepository;

    public List<VendingMachineSoldSnack> getAllVendingMachineSoldSnacks() {
        return vendingMachineSoldSnackRepository.findAll();
    }

    public VendingMachineSoldSnack getVendingMachineSoldSnackById(Integer id) {
        return vendingMachineSoldSnackRepository.findById(id)
                .orElse(null);
    }

    public VendingMachineSoldSnack createVendingMachineSoldSnack(
            VendingMachineSoldSnackDTO vendingMachineSoldSnackDTO) {
        return vendingMachineSoldSnackRepository.save(VendingMachineSoldSnackMapper
                .mapDTOToVendingMachineSoldSnack(vendingMachineSoldSnackDTO));
    }

    public VendingMachineSoldSnack updateVendingMachineSoldSnack(
            VendingMachineSoldSnackDTO vendingMachineSoldSnackDTO) {
        if (getVendingMachineSoldSnackById(vendingMachineSoldSnackDTO.getId()) != null) {
            return vendingMachineSoldSnackRepository.save(
                    VendingMachineSoldSnackMapper.mapDTOToVendingMachineSoldSnack(
                            vendingMachineSoldSnackDTO));
        }
        return null;
    }

    public VendingMachineSoldSnack deleteVendingMachineSoldSnackById(Integer id) {
        VendingMachineSoldSnack vendingMachineSoldSnack = getVendingMachineSoldSnackById(id);
        if (vendingMachineSoldSnack != null) {
            vendingMachineSoldSnackRepository.deleteById(id);
            return vendingMachineSoldSnack;
        }
        return null;
    }
}
