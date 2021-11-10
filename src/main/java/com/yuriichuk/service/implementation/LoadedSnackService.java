package com.yuriichuk.service.implementation;

import com.yuriichuk.DAO.AbsDAO;
import com.yuriichuk.DAO.implementation.BrandDAO;
import com.yuriichuk.DAO.implementation.LoadedSnackDAO;
import com.yuriichuk.model.Brand;
import com.yuriichuk.model.LoadedSnack;
import com.yuriichuk.service.Service;

import java.sql.SQLException;
import java.util.List;

public class LoadedSnackService implements Service<LoadedSnack> {

    private final AbsDAO dao = new LoadedSnackDAO();

    @Override
    public List<LoadedSnack> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public LoadedSnack findById(Integer firstId, Integer secondId) throws SQLException {
        return (LoadedSnack) dao.findById(firstId, secondId);
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
