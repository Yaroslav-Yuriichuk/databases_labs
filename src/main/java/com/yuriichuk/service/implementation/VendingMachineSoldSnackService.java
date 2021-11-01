package com.yuriichuk.service.implementation;

import com.yuriichuk.DAO.implementation.VendingMachineDAO;
import com.yuriichuk.DAO.implementation.VendingMachineSoldSnackDAO;
import com.yuriichuk.model.VendingMachine;
import com.yuriichuk.model.VendingMachineSoldSnack;
import com.yuriichuk.service.AbstractService;

import java.sql.SQLException;
import java.util.List;

public class VendingMachineSoldSnackService implements AbstractService<VendingMachineSoldSnack> {

    private final VendingMachineSoldSnackDAO dao = new VendingMachineSoldSnackDAO();

    @Override
    public List<VendingMachineSoldSnack> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public VendingMachineSoldSnack findById(Integer id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void create(VendingMachineSoldSnack vendingMachineSoldSnack) throws SQLException {
        dao.create(vendingMachineSoldSnack);
    }

    @Override
    public void update(VendingMachineSoldSnack vendingMachineSoldSnack) throws SQLException {
        dao.update(vendingMachineSoldSnack);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}
