package com.yuriichuk.service.implementation;

import com.yuriichuk.DAO.DAO;
import com.yuriichuk.DAO.implementation.VendingMachineDAO;
import com.yuriichuk.model.VendingMachine;
import com.yuriichuk.service.Service;

import java.sql.SQLException;
import java.util.List;

public class VendingMachineService implements Service<VendingMachine> {

    private final DAO dao = new VendingMachineDAO();

    @Override
    public List<VendingMachine> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public VendingMachine findById(Integer id) throws SQLException {
        return (VendingMachine) dao.findById(id);
    }

    @Override
    public void create(VendingMachine vendingMachine) throws SQLException {
        dao.create(vendingMachine);
    }

    @Override
    public void update(VendingMachine vendingMachine) throws SQLException {
        dao.update(vendingMachine);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}
