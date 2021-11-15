package com.yuriichuk.service.implementation;

import com.yuriichuk.DAO.DAO;
import com.yuriichuk.DAO.implementation.VendingMachineMenuDAO;
import com.yuriichuk.model.VendingMachineMenu;
import com.yuriichuk.service.Service;

import java.sql.SQLException;
import java.util.List;

public class VendingMachineMenuService implements Service<VendingMachineMenu> {

    private final DAO dao = new VendingMachineMenuDAO();

    @Override
    public List<VendingMachineMenu> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public VendingMachineMenu findById(Integer firstId, Integer secondId) throws SQLException {
        return (VendingMachineMenu) dao.findById(firstId, secondId);
    }

    @Override
    public void create(VendingMachineMenu vendingMachineMenu) throws SQLException {
        dao.create(vendingMachineMenu);
    }

    @Override
    public void update(VendingMachineMenu vendingMachineMenu) throws SQLException {
        dao.update(vendingMachineMenu);
    }

    @Override
    public void delete(Integer firstId, Integer secondId) throws SQLException {
        dao.delete(firstId, secondId);
    }
}
