package com.yuriichuk.service.implementation;

import com.yuriichuk.DAO.implementation.AddressDAO;
import com.yuriichuk.DAO.implementation.BrandDAO;
import com.yuriichuk.controller.AbstractController;
import com.yuriichuk.model.Brand;

import java.sql.SQLException;
import java.util.List;

public class BrandService implements AbstractController<Brand> {

    private final BrandDAO dao = new BrandDAO();

    @Override
    public List<Brand> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Brand findById(Integer id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void create(Brand brand) throws SQLException {
        dao.create(brand);
    }

    @Override
    public void update(Brand brand) throws SQLException {
        dao.update(brand);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}
