package com.yuriichuk.controller.implementation;

import com.yuriichuk.controller.Controller;
import com.yuriichuk.model.VendingMachineMoneyUnloading;
import com.yuriichuk.service.Service;
import com.yuriichuk.service.implementation.VendingMachineMoneyUnloadingService;

import java.sql.SQLException;
import java.util.List;

public class VendingMachineMoneyUnloadingController implements Controller<VendingMachineMoneyUnloading> {

    private final Service service = new VendingMachineMoneyUnloadingService();

    @Override
    public List<VendingMachineMoneyUnloading> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public VendingMachineMoneyUnloading findById(Integer id) throws SQLException {
        return (VendingMachineMoneyUnloading) service.findById(id);
    }

    @Override
    public void create(VendingMachineMoneyUnloading vendingMachineMoneyUnloading) throws SQLException {
        service.create(vendingMachineMoneyUnloading);
    }

    @Override
    public void update(VendingMachineMoneyUnloading vendingMachineMoneyUnloading) throws SQLException {
        service.update(vendingMachineMoneyUnloading);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}
