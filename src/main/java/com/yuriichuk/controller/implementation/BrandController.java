package com.yuriichuk.controller.implementation;

import com.yuriichuk.controller.AbstractController;
import com.yuriichuk.model.Brand;
import com.yuriichuk.service.implementation.AddressService;
import com.yuriichuk.service.implementation.BrandService;

import java.sql.SQLException;
import java.util.List;

public class BrandController implements AbstractController<Brand> {

    private final BrandService service = new BrandService();

    @Override
    public List<Brand> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public Brand findById(Integer id) throws SQLException {
        return service.findById(id);
    }

    @Override
    public void create(Brand brand) throws SQLException {
        service.create(brand);
    }

    @Override
    public void update(Brand brand) throws SQLException {
        service.update(brand);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}
