package com.yuriichuk.service.implementation;

import com.yuriichuk.DAO.DAO;
import com.yuriichuk.DAO.implementation.VendingMachineMoneyLoadingDAO;
import com.yuriichuk.model.VendingMachineMoneyLoading;
import com.yuriichuk.service.Service;

import java.sql.SQLException;
import java.util.List;

public class VendingMachineMoneyLoadingService implements Service<VendingMachineMoneyLoading> {

    private final DAO dao = new VendingMachineMoneyLoadingDAO();

    @Override
    public List<VendingMachineMoneyLoading> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public VendingMachineMoneyLoading findById(Integer id) throws SQLException {
        return (VendingMachineMoneyLoading) dao.findById(id);
    }

    @Override
    public void create(VendingMachineMoneyLoading vendingMachineMoneyLoading) throws SQLException {
        dao.create(vendingMachineMoneyLoading);
    }

    @Override
    public void update(VendingMachineMoneyLoading vendingMachineMoneyLoading) throws SQLException {
        dao.update(vendingMachineMoneyLoading);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}
