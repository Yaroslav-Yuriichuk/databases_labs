package com.yuriichuk.controller.implementation;

import com.yuriichuk.controller.AbstractController;
import com.yuriichuk.model.Address;
import com.yuriichuk.service.implementation.AddressService;

import java.sql.SQLException;
import java.util.List;

public class AddressController implements AbstractController<Address> {

    private final AddressService service = new AddressService();

    @Override
    public List<Address> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public Address findById(Integer id) throws SQLException {
        return service.findById(id);
    }

    @Override
    public void create(Address address) throws SQLException {
        service.create(address);
    }

    @Override
    public void update(Address address) throws SQLException {
        service.update(address);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }

    @Override
    public void delete(Integer firstId, Integer secondId) throws SQLException {
        AbstractController.super.delete(firstId, secondId);
    }
}
