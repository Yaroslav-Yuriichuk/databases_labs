package com.yuriichuk.service.implementation;

import com.yuriichuk.DAO.AbsDAO;
import com.yuriichuk.DAO.implementation.VendingMachineMoneyLoadingDAO;
import com.yuriichuk.DAO.implementation.VendingMachineMoneyUnloadingDAO;
import com.yuriichuk.model.VendingMachineMoneyLoading;
import com.yuriichuk.model.VendingMachineMoneyUnloading;
import com.yuriichuk.service.Service;

import java.sql.SQLException;
import java.util.List;

public class VendingMachineMoneyUnloadingService implements Service<VendingMachineMoneyUnloading> {

    private final AbsDAO dao = new VendingMachineMoneyUnloadingDAO();

    @Override
    public List<VendingMachineMoneyUnloading> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public VendingMachineMoneyUnloading findById(Integer id) throws SQLException {
        return (VendingMachineMoneyUnloading) dao.findById(id);
    }

    @Override
    public void create(VendingMachineMoneyUnloading vendingMachineMoneyUnloading) throws SQLException {
        dao.create(vendingMachineMoneyUnloading);
    }

    @Override
    public void update(VendingMachineMoneyUnloading vendingMachineMoneyUnloading) throws SQLException {
        dao.update(vendingMachineMoneyUnloading);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}
