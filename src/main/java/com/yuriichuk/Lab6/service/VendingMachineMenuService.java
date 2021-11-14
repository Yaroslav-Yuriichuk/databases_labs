package com.yuriichuk.Lab6.service;


import com.yuriichuk.Lab6.dto.VendingMachineDTO;
import com.yuriichuk.Lab6.dto.VendingMachineMenuDTO;
import com.yuriichuk.Lab6.mapper.VendingMachineMapper;
import com.yuriichuk.Lab6.mapper.VendingMachineMenuMapper;
import com.yuriichuk.Lab6.model.VendingMachine;
import com.yuriichuk.Lab6.model.VendingMachineMenu;
import com.yuriichuk.Lab6.model.composite_key.VendingMachineMenuPK;
import com.yuriichuk.Lab6.repository.VendingMachineMenuRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class VendingMachineMenuService {

    private final VendingMachineMenuRepository vendingMachineMenuRepository;

    public List<VendingMachineMenu> getAllVendingMachineMenus() {
        return vendingMachineMenuRepository.findAll();
    }

    public VendingMachineMenu getVendingMachineMenuById(VendingMachineMenuPK id) {
        return vendingMachineMenuRepository.findById(id).orElse(null);
    }

    public VendingMachineMenu createVendingMachineMenu(VendingMachineMenuDTO vendingMachineMenuDTO) {
        return vendingMachineMenuRepository.save(
                VendingMachineMenuMapper.mapDTOToVendingMachineMenu(vendingMachineMenuDTO));
    }

    public VendingMachineMenu updateVendingMachineMenu(VendingMachineMenuDTO vendingMachineMenuDTO) {
        if (getVendingMachineMenuById(new VendingMachineMenuPK(vendingMachineMenuDTO.getVendingMachineId(),
                        vendingMachineMenuDTO.getSnackId())) != null) {
            return vendingMachineMenuRepository.save(
                    VendingMachineMenuMapper.mapDTOToVendingMachineMenu(vendingMachineMenuDTO));
        }
        return null;
    }

    public VendingMachineMenu deleteVendingMachineMenuById(VendingMachineMenuPK id) {
        VendingMachineMenu vendingMachineMenu = getVendingMachineMenuById(id);
        if (vendingMachineMenu != null) {
            vendingMachineMenuRepository.deleteById(id);
            return vendingMachineMenu;
        }
        return null;
    }
}
