package com.yuriichuk.Lab6.service;

import com.yuriichuk.Lab6.dto.VendingMachineDTO;
import com.yuriichuk.Lab6.dto.VendingMachineMoneyLoadingDTO;
import com.yuriichuk.Lab6.mapper.VendingMachineMapper;
import com.yuriichuk.Lab6.mapper.VendingMachineMoneyLoadingMapper;
import com.yuriichuk.Lab6.model.VendingMachine;
import com.yuriichuk.Lab6.model.VendingMachineMoneyLoading;
import com.yuriichuk.Lab6.repository.VendingMachineMoneyLoadingRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class VendingMachineMoneyLoadingService {

    private final VendingMachineMoneyLoadingRepository vendingMachineMoneyLoadingRepository;

    public List<VendingMachineMoneyLoading> getAllVendingMachineMoneyLoadings() {
        return vendingMachineMoneyLoadingRepository.findAll();
    }

    public VendingMachineMoneyLoading getVendingMachineMoneyLoadingById(Integer id) {
        return vendingMachineMoneyLoadingRepository.findById(id)
                .orElse(null);
    }

    public VendingMachineMoneyLoading createVendingMachineMoneyLoading(
            VendingMachineMoneyLoadingDTO vendingMachineMoneyLoadingDTO) {
        return vendingMachineMoneyLoadingRepository.save(VendingMachineMoneyLoadingMapper
                .mapDTOToVendingMachineMoneyLoading(vendingMachineMoneyLoadingDTO));
    }

    public VendingMachineMoneyLoading updateVendingMachineMoneyLoading(
            VendingMachineMoneyLoadingDTO vendingMachineMoneyLoadingDTO) {
        if (getVendingMachineMoneyLoadingById(vendingMachineMoneyLoadingDTO.getId()) != null) {
            return vendingMachineMoneyLoadingRepository.save(
                    VendingMachineMoneyLoadingMapper.mapDTOToVendingMachineMoneyLoading(vendingMachineMoneyLoadingDTO));
        }
        return null;
    }

    public VendingMachineMoneyLoading deleteVendingMachineMoneyLoadingById(Integer id) {
        VendingMachineMoneyLoading vendingMachineMoneyLoading = getVendingMachineMoneyLoadingById(id);
        if (vendingMachineMoneyLoading != null) {
            vendingMachineMoneyLoadingRepository.deleteById(id);
            return vendingMachineMoneyLoading;
        }
        return null;
    }
}
