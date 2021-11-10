package com.yuriichuk.controller.implementation;

import com.yuriichuk.controller.Controller;
import com.yuriichuk.model.VendingMachine;
import com.yuriichuk.model.VendingMachineMoneyLoading;
import com.yuriichuk.service.Service;
import com.yuriichuk.service.implementation.VendingMachineMoneyLoadingService;
import com.yuriichuk.service.implementation.VendingMachineService;

import java.sql.SQLException;
import java.util.List;

public class VendingMachineMoneyLoadingController implements Controller<VendingMachineMoneyLoading> {

    private final Service service = new VendingMachineMoneyLoadingService();

    @Override
    public List<VendingMachineMoneyLoading> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public VendingMachineMoneyLoading findById(Integer id) throws SQLException {
        return (VendingMachineMoneyLoading) service.findById(id);
    }

    @Override
    public void create(VendingMachineMoneyLoading vendingMachineMoneyLoading) throws SQLException {
        service.create(vendingMachineMoneyLoading);
    }

    @Override
    public void update(VendingMachineMoneyLoading vendingMachineMoneyLoading) throws SQLException {
        service.update(vendingMachineMoneyLoading);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}
