package com.yuriichuk.service.implementation;

import com.yuriichuk.DAO.AbsDAO;
import com.yuriichuk.DAO.implementation.VendingMachineMoneyLoadingDAO;
import com.yuriichuk.DAO.implementation.VendingMachineSnacksLoadingDAO;
import com.yuriichuk.model.VendingMachineMoneyLoading;
import com.yuriichuk.model.VendingMachineSnacksLoading;
import com.yuriichuk.service.Service;

import java.sql.SQLException;
import java.util.List;

public class VendingMachineSnacksLoadingService implements Service<VendingMachineSnacksLoading> {

    private final AbsDAO dao = new VendingMachineSnacksLoadingDAO();

    @Override
    public List<VendingMachineSnacksLoading> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public VendingMachineSnacksLoading findById(Integer id) throws SQLException {
        return (VendingMachineSnacksLoading) dao.findById(id);
    }

    @Override
    public void create(VendingMachineSnacksLoading vendingMachineSnacksLoading) throws SQLException {
        dao.create(vendingMachineSnacksLoading);
    }

    @Override
    public void update(VendingMachineSnacksLoading vendingMachineSnacksLoading) throws SQLException {
        dao.update(vendingMachineSnacksLoading);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}
