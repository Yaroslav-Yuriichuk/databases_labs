package com.yuriichuk.Lab6.service;

import com.yuriichuk.Lab6.dto.AddressDTO;
import com.yuriichuk.Lab6.dto.BrandDTO;
import com.yuriichuk.Lab6.mapper.AddressMapper;
import com.yuriichuk.Lab6.mapper.BrandMapper;
import com.yuriichuk.Lab6.model.Address;
import com.yuriichuk.Lab6.model.Brand;
import com.yuriichuk.Lab6.repository.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BrandService {

    private final BrandRepository brandRepository;

    public List<Brand> getAllBrands() {
        return brandRepository.findAll();
    }

    public Brand getBrandById(Integer id) {
        return brandRepository.findById(id)
                .orElse(null);
    }

    public Brand createBrand(BrandDTO brandDTO) {
        return brandRepository.save(BrandMapper.mapDTOToBrand(brandDTO));
    }

    public Brand updateBrand(BrandDTO brandDTO) {
        if (getBrandById(brandDTO.getId()) != null) {
            return brandRepository.save(BrandMapper.mapDTOToBrand(brandDTO));
        }
        return null;
    }

    public Brand deleteBrandById(Integer id) {
        Brand brand = getBrandById(id);
        if (brand != null) {
            brandRepository.deleteById(id);
            return brand;
        }
        return null;
    }
}
