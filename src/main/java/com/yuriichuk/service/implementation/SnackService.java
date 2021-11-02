package com.yuriichuk.service.implementation;

import com.yuriichuk.DAO.DAO;
import com.yuriichuk.DAO.implementation.SnackDAO;
import com.yuriichuk.model.Snack;
import com.yuriichuk.service.Service;

import java.sql.SQLException;
import java.util.List;

public class SnackService implements Service<Snack> {

    private final DAO dao = new SnackDAO();

    @Override
    public List<Snack> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Snack findById(Integer id) throws SQLException {
        return (Snack) dao.findById(id);
    }

    @Override
    public void create(Snack snack) throws SQLException {
        dao.create(snack);
    }

    @Override
    public void update(Snack snack) throws SQLException {
        dao.update(snack);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}
