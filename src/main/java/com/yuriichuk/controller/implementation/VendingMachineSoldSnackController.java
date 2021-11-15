package com.yuriichuk.controller.implementation;

import com.yuriichuk.controller.Controller;
import com.yuriichuk.model.VendingMachineSoldSnack;
import com.yuriichuk.service.Service;
import com.yuriichuk.service.implementation.VendingMachineSoldSnackService;

import java.sql.SQLException;
import java.util.List;

public class VendingMachineSoldSnackController implements Controller<VendingMachineSoldSnack> {

    private final Service service = new VendingMachineSoldSnackService();

    @Override
    public List<VendingMachineSoldSnack> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public VendingMachineSoldSnack findById(Integer id) throws SQLException {
        return (VendingMachineSoldSnack) service.findById(id);
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
