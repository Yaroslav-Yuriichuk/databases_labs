package com.yuriichuk.controller.implementation;

import com.yuriichuk.controller.Controller;
import com.yuriichuk.model.VendingMachine;
import com.yuriichuk.service.Service;
import com.yuriichuk.service.implementation.VendingMachineService;

import java.sql.SQLException;
import java.util.List;

public class VendingMachineController implements Controller<VendingMachine> {

    private final Service service = new VendingMachineService();

    @Override
    public List<VendingMachine> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public VendingMachine findById(Integer id) throws SQLException {
        return (VendingMachine) service.findById(id);
    }

    @Override
    public void create(VendingMachine vendingMachine) throws SQLException {
        service.create(vendingMachine);
    }

    @Override
    public void update(VendingMachine vendingMachine) throws SQLException {
        service.update(vendingMachine);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}
