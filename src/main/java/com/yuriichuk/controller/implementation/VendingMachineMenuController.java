package com.yuriichuk.controller.implementation;

import com.yuriichuk.controller.Controller;
import com.yuriichuk.model.VendingMachineMenu;
import com.yuriichuk.service.Service;
import com.yuriichuk.service.implementation.VendingMachineMenuService;

import java.sql.SQLException;
import java.util.List;

public class VendingMachineMenuController implements Controller<VendingMachineMenu> {

    private final Service service = new VendingMachineMenuService();

    @Override
    public List<VendingMachineMenu> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public VendingMachineMenu findById(Integer firstId, Integer secondId) throws SQLException {
        return (VendingMachineMenu) service.findById(firstId, secondId);
    }

    @Override
    public void create(VendingMachineMenu vendingMachineMenu) throws SQLException {
        service.create(vendingMachineMenu);
    }

    @Override
    public void update(VendingMachineMenu vendingMachineMenu) throws  SQLException {
        service.update(vendingMachineMenu);
    }

    @Override
    public void delete(Integer firstId, Integer secondId) throws SQLException {
        service.delete(firstId, secondId);
    }
}
