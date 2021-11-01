package com.yuriichuk.controller.implementation;

import com.yuriichuk.controller.AbstractController;
import com.yuriichuk.model.VendingMachine;
import com.yuriichuk.model.VendingMachineMenu;
import com.yuriichuk.model.VendingMachineSoldSnack;
import com.yuriichuk.service.implementation.VendingMachineMenuService;
import com.yuriichuk.service.implementation.VendingMachineService;
import com.yuriichuk.service.implementation.VendingMachineSoldSnackService;

import java.sql.SQLException;
import java.util.List;

public class VendingMachineSoldSnackController implements AbstractController<VendingMachineSoldSnack> {

    private final VendingMachineSoldSnackService service = new VendingMachineSoldSnackService();

    @Override
    public List<VendingMachineSoldSnack> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public VendingMachineSoldSnack findById(Integer id) throws SQLException {
        return service.findById(id);
    }

    @Override
    public void create(VendingMachineSoldSnack vendingMachineSoldSnack) throws SQLException {
        service.create(vendingMachineSoldSnack);
    }

    @Override
    public void update(VendingMachineSoldSnack vendingMachineSoldSnack) throws SQLException {
        service.update(vendingMachineSoldSnack);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}
