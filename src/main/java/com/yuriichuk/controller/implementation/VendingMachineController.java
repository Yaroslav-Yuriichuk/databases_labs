package com.yuriichuk.controller.implementation;

import com.yuriichuk.controller.AbstractController;
import com.yuriichuk.model.VendingMachine;
import com.yuriichuk.service.implementation.VendingMachineService;

import java.sql.SQLException;
import java.util.List;

public class VendingMachineController implements AbstractController<VendingMachine> {

    private final VendingMachineService service = new VendingMachineService();

    @Override
    public List<VendingMachine> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public VendingMachine findById(Integer id) throws SQLException {
        return service.findById(id);
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
