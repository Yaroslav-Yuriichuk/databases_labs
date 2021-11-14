package com.yuriichuk.Lab6.service;

import com.yuriichuk.Lab6.dto.BrandDTO;
import com.yuriichuk.Lab6.dto.SnackDTO;
import com.yuriichuk.Lab6.mapper.BrandMapper;
import com.yuriichuk.Lab6.mapper.SnackMapper;
import com.yuriichuk.Lab6.model.Brand;
import com.yuriichuk.Lab6.model.Snack;
import com.yuriichuk.Lab6.repository.SnackRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SnackService {

    private final SnackRepository snackRepository;

    public List<Snack> getAllSnacks() {
        return snackRepository.findAll();
    }

    public Snack getSnackById(Integer id) {
        return snackRepository.findById(id)
                .orElse(null);
    }

    public Snack createSnack(SnackDTO snackDTO) {
        return snackRepository.save(SnackMapper.mapDTOToSnack(snackDTO));
    }

    public Snack updateSnack(SnackDTO snackDTO) {
        if (getSnackById(snackDTO.getId()) != null) {
            return snackRepository.save(SnackMapper.mapDTOToSnack(snackDTO));
        }
        return null;
    }

    public Snack deleteSnackById(Integer id) {
        Snack snack = getSnackById(id);
        if (snack != null) {
            snackRepository.deleteById(id);
            return snack;
        }
        return null;
    }
}
