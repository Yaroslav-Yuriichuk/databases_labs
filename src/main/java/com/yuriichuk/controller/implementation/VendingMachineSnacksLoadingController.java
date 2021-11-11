package com.yuriichuk.controller.implementation;

import com.yuriichuk.controller.Controller;
import com.yuriichuk.model.VendingMachineMoneyLoading;
import com.yuriichuk.model.VendingMachineSnacksLoading;
import com.yuriichuk.service.Service;
import com.yuriichuk.service.implementation.VendingMachineMoneyLoadingService;
import com.yuriichuk.service.implementation.VendingMachineSnacksLoadingService;

import java.sql.SQLException;
import java.util.List;

public class VendingMachineSnacksLoadingController implements Controller<VendingMachineSnacksLoading> {

    private final Service service = new VendingMachineSnacksLoadingService();

    @Override
    public List<VendingMachineSnacksLoading> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public VendingMachineSnacksLoading findById(Integer id) throws SQLException {
        return (VendingMachineSnacksLoading) service.findById(id);
    }

    @Override
    public void create(VendingMachineSnacksLoading vendingMachineSnacksLoading) throws SQLException {
        service.create(vendingMachineSnacksLoading);
    }

    @Override
    public void update(VendingMachineSnacksLoading vendingMachineSnacksLoading) throws SQLException {
        service.update(vendingMachineSnacksLoading);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}
