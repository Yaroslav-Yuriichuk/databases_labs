package com.yuriichuk.Lab6.controller;

import com.yuriichuk.Lab6.dto.AddressDTO;
import com.yuriichuk.Lab6.dto.BrandDTO;
import com.yuriichuk.Lab6.mapper.AddressMapper;
import com.yuriichuk.Lab6.mapper.BrandMapper;
import com.yuriichuk.Lab6.model.Address;
import com.yuriichuk.Lab6.model.Brand;
import com.yuriichuk.Lab6.service.BrandService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/api/brand")
public class BrandController {

    private final BrandService brandService;

    @GetMapping
    public List<BrandDTO> getAllBrands() {
        return brandService.getAllBrands().stream()
                .map(BrandMapper::mapBrandToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BrandDTO> getBrandById(final @PathVariable("id") Integer id) {
        Brand brand = brandService.getBrandById(id);
        if (brand == null) {
            return new ResponseEntity<BrandDTO>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<BrandDTO>(
                BrandMapper.mapBrandToDTO(brand), HttpStatus.OK);
    }

    @PostMapping
    public BrandDTO createBrand(final @RequestBody BrandDTO brandDTO) {
        return BrandMapper.mapBrandToDTO(brandService.createBrand(brandDTO));
    }

    @PutMapping
    public ResponseEntity<BrandDTO> updateBrand(final @RequestBody BrandDTO brandDTO) {
        Brand brand = brandService.getBrandById(brandDTO.getId());
        if (brand == null) {
            return new ResponseEntity<BrandDTO>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<BrandDTO>(
                BrandMapper.mapBrandToDTO(brandService.updateBrand(brandDTO)), HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BrandDTO> deleteBrand(final @PathVariable("id") Integer id) {
        Brand brand = brandService.getBrandById(id);
        if (brand == null) {
            return new ResponseEntity<BrandDTO>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<BrandDTO>(
                BrandMapper.mapBrandToDTO(brandService.deleteBrandById(id)), HttpStatus.OK
        );
    }
}
