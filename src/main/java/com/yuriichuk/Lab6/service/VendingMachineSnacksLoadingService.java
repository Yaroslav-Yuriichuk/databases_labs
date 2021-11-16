package com.yuriichuk.Lab6.service;

import com.yuriichuk.Lab6.dto.VendingMachineDTO;
import com.yuriichuk.Lab6.dto.VendingMachineSnacksLoadingDTO;
import com.yuriichuk.Lab6.mapper.VendingMachineMapper;
import com.yuriichuk.Lab6.mapper.VendingMachineSnacksLoadingMapper;
import com.yuriichuk.Lab6.model.VendingMachine;
import com.yuriichuk.Lab6.model.VendingMachineSnacksLoading;
import com.yuriichuk.Lab6.repository.VendingMachineSnacksLoadingRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class VendingMachineSnacksLoadingService {

    private final VendingMachineSnacksLoadingRepository vendingMachineSnacksLoadingRepository;

    public List<VendingMachineSnacksLoading> getAllVendingMachineSnacksLoadings() {
        return vendingMachineSnacksLoadingRepository.findAll();
    }

    public VendingMachineSnacksLoading getVendingMachineSnacksLoadingById(Integer id) {
        return vendingMachineSnacksLoadingRepository.findById(id)
                .orElse(null);
    }

    public VendingMachineSnacksLoading createVendingMachineSnacksLoading(
            VendingMachineSnacksLoadingDTO vendingMachineSnacksLoadingDTO) {
        return vendingMachineSnacksLoadingRepository.save(
                VendingMachineSnacksLoadingMapper.mapDTOToVendingMachineSnacksLoading(
                        vendingMachineSnacksLoadingDTO));
    }

    public VendingMachineSnacksLoading updateVendingMachineSnacksLoading(
            VendingMachineSnacksLoadingDTO vendingMachineSnacksLoadingDTO) {
        if (getVendingMachineSnacksLoadingById(vendingMachineSnacksLoadingDTO.getId()) != null) {
            return vendingMachineSnacksLoadingRepository.save(
                    VendingMachineSnacksLoadingMapper.mapDTOToVendingMachineSnacksLoading(
                            vendingMachineSnacksLoadingDTO));
        }
        return null;
    }

    public VendingMachineSnacksLoading deleteVendingMachineSnacksLoadingById(Integer id) {
        VendingMachineSnacksLoading vendingMachineSnacksLoading = getVendingMachineSnacksLoadingById(id);
        if (vendingMachineSnacksLoading != null) {
            vendingMachineSnacksLoadingRepository.deleteById(id);
            return vendingMachineSnacksLoading;
        }
        return null;
    }
}
