package com.yuriichuk.controller.implementation;

import com.yuriichuk.controller.AbstractController;
import com.yuriichuk.model.VendingMachineMenu;
import com.yuriichuk.service.implementation.VendingMachineMenuService;
import com.yuriichuk.service.implementation.VendingMachineService;

import java.sql.SQLException;
import java.util.List;

public class VendingMachineMenuController implements AbstractController<VendingMachineMenu> {

    private final VendingMachineMenuService service = new VendingMachineMenuService();

    @Override
    public List<VendingMachineMenu> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public VendingMachineMenu findById(Integer firstId, Integer secondId) throws SQLException {
        return service.findById(firstId, secondId);
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
