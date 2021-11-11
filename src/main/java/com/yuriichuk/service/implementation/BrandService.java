package com.yuriichuk.service.implementation;

import com.yuriichuk.DAO.AbsDAO;
import com.yuriichuk.DAO.implementation.BrandDAO;
import com.yuriichuk.model.Brand;
import com.yuriichuk.service.Service;

import java.sql.SQLException;
import java.util.List;

public class BrandService implements Service<Brand> {

    private final AbsDAO dao = new BrandDAO();

    @Override
    public List<Brand> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Brand findById(Integer id) throws SQLException {
        return (Brand) dao.findById(id);
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
