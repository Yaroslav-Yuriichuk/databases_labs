package com.yuriichuk.service.implementation;

import com.yuriichuk.DAO.implementation.LoadedSnackDAO;
import com.yuriichuk.DAO.implementation.VendingMachineMenuDAO;
import com.yuriichuk.model.LoadedSnack;
import com.yuriichuk.model.VendingMachineMenu;
import com.yuriichuk.service.AbstractService;

import java.sql.SQLException;
import java.util.List;

public class LoadedSnackService implements AbstractService<LoadedSnack> {

    private final LoadedSnackDAO dao = new LoadedSnackDAO();

    @Override
    public List<LoadedSnack> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public LoadedSnack findById(Integer firstId, Integer secondId) throws SQLException {
        return dao.findById(firstId, secondId);
    }

    @Override
    public void create(LoadedSnack loadedSnack) throws SQLException {
        dao.create(loadedSnack);
    }

    @Override
    public void update(LoadedSnack loadedSnack) throws SQLException {
        dao.update(loadedSnack);
    }

    @Override
    public void delete(Integer firstId, Integer secondId) throws SQLException {
        dao.delete(firstId, secondId);
    }
}
