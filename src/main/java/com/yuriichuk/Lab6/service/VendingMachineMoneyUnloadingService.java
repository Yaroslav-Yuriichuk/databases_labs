package com.yuriichuk.Lab6.service;

import com.yuriichuk.Lab6.dto.VendingMachineMoneyLoadingDTO;
import com.yuriichuk.Lab6.dto.VendingMachineMoneyUnloadingDTO;
import com.yuriichuk.Lab6.mapper.VendingMachineMoneyLoadingMapper;
import com.yuriichuk.Lab6.mapper.VendingMachineMoneyUnloadingMapper;
import com.yuriichuk.Lab6.model.VendingMachineMoneyLoading;
import com.yuriichuk.Lab6.model.VendingMachineMoneyUnloading;
import com.yuriichuk.Lab6.repository.VendingMachineMoneyUnloadingRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class VendingMachineMoneyUnloadingService {

    private final VendingMachineMoneyUnloadingRepository vendingMachineMoneyUnloadingRepository;

    public List<VendingMachineMoneyUnloading> getAllVendingMachineMoneyUnloadings() {
        return vendingMachineMoneyUnloadingRepository.findAll();
    }

    public VendingMachineMoneyUnloading getVendingMachineMoneyUnloadingById(Integer id) {
        return vendingMachineMoneyUnloadingRepository.findById(id)
                .orElse(null);
    }

    public VendingMachineMoneyUnloading createVendingMachineMoneyUnloading(
            VendingMachineMoneyUnloadingDTO vendingMachineMoneyUnloadingDTO) {
        return vendingMachineMoneyUnloadingRepository.save(VendingMachineMoneyUnloadingMapper
                .mapDTOToVendingMachineMoneyUnloading(vendingMachineMoneyUnloadingDTO));
    }

    public VendingMachineMoneyUnloading updateVendingMachineMoneyUnloading(
            VendingMachineMoneyUnloadingDTO vendingMachineMoneyUnloadingDTO) {
        if (getVendingMachineMoneyUnloadingById(vendingMachineMoneyUnloadingDTO.getId()) != null) {
            return vendingMachineMoneyUnloadingRepository.save(
                    VendingMachineMoneyUnloadingMapper.mapDTOToVendingMachineMoneyUnloading(
                            vendingMachineMoneyUnloadingDTO));
        }
        return null;
    }

    public VendingMachineMoneyUnloading deleteVendingMachineMoneyUnloadingById(Integer id) {
        VendingMachineMoneyUnloading vendingMachineMoneyUnloading = getVendingMachineMoneyUnloadingById(id);
        if (vendingMachineMoneyUnloading != null) {
            vendingMachineMoneyUnloadingRepository.deleteById(id);
            return vendingMachineMoneyUnloading;
        }
        return null;
    }
}
