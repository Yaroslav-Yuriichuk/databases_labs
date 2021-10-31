package com.yuriichuk.service.implementation;

import com.yuriichuk.DAO.implementation.AddressDAO;
import com.yuriichuk.model.Address;
import com.yuriichuk.service.AbstractService;

import java.sql.SQLException;
import java.util.List;

public class AddressService implements AbstractService<Address> {

    private final AddressDAO dao = new AddressDAO();

    @Override
    public List<Address> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Address findById(Integer id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void create(Address address) throws SQLException {
        dao.create(address);
    }

    @Override
    public void update(Address address) throws SQLException {
        dao.update(address);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }

    @Override
    public void delete(Integer firstId, Integer secondId) throws SQLException {
        AbstractService.super.delete(firstId, secondId);
    }
}