package com.yuriichuk.controller.implementation;

import com.yuriichuk.controller.AbstractController;
import com.yuriichuk.model.VendingMachineMoneyLoading;
import com.yuriichuk.model.VendingMachineMoneyUnloading;
import com.yuriichuk.service.implementation.VendingMachineMoneyLoadingService;
import com.yuriichuk.service.implementation.VendingMachineMoneyUnloadingService;
import com.yuriichuk.service.implementation.VendingMachineService;

import java.sql.SQLException;
import java.util.List;

public class VendingMachineMoneyUnloadingController implements AbstractController<VendingMachineMoneyUnloading> {

    private final VendingMachineMoneyUnloadingService service = new VendingMachineMoneyUnloadingService();

    @Override
    public List<VendingMachineMoneyUnloading> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public VendingMachineMoneyUnloading findById(Integer id) throws SQLException {
        return service.findById(id);
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
