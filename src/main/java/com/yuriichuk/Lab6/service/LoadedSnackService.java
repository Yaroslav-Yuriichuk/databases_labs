package com.yuriichuk.Lab6.service;

import com.yuriichuk.Lab6.dto.LoadedSnackDTO;
import com.yuriichuk.Lab6.dto.VendingMachineMenuDTO;
import com.yuriichuk.Lab6.mapper.LoadedSnackMapper;
import com.yuriichuk.Lab6.mapper.VendingMachineMenuMapper;
import com.yuriichuk.Lab6.model.LoadedSnack;
import com.yuriichuk.Lab6.model.VendingMachineMenu;
import com.yuriichuk.Lab6.model.composite_key.LoadedSnackPK;
import com.yuriichuk.Lab6.model.composite_key.VendingMachineMenuPK;
import com.yuriichuk.Lab6.repository.LoadedSnackRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LoadedSnackService {

    private final LoadedSnackRepository loadedSnackRepository;

    public List<LoadedSnack> getAllLoadedSnacks() {
        return loadedSnackRepository.findAll();
    }

    public LoadedSnack getLoadedSnackById(LoadedSnackPK id) {
        return loadedSnackRepository.findById(id).orElse(null);
    }

    public LoadedSnack createLoadedSnack(LoadedSnackDTO loadedSnackDTO) {
        return loadedSnackRepository.save(
                LoadedSnackMapper.mapDTOToLoadedSnack(loadedSnackDTO));
    }

    public LoadedSnack updateLoadedSnack(LoadedSnackDTO loadedSnackDTO) {
        if (getLoadedSnackById(new LoadedSnackPK(loadedSnackDTO.getVendingMachineSnacksLoadingId(),
                loadedSnackDTO.getSnackId())) != null) {
            return loadedSnackRepository.save(
                    LoadedSnackMapper.mapDTOToLoadedSnack(loadedSnackDTO));
        }
        return null;
    }

    public LoadedSnack deleteLoadedSnackById(LoadedSnackPK id) {
        LoadedSnack loadedSnack = getLoadedSnackById(id);
        if (loadedSnack != null) {
            loadedSnackRepository.deleteById(id);
            return loadedSnack;
        }
        return null;
    }
}
