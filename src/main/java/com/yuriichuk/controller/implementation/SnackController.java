package com.yuriichuk.controller.implementation;

import com.yuriichuk.controller.Controller;
import com.yuriichuk.model.Snack;
import com.yuriichuk.service.Service;
import com.yuriichuk.service.implementation.SnackService;

import java.sql.SQLException;
import java.util.List;

public class SnackController implements Controller<Snack> {

    private final Service service = new SnackService();

    @Override
    public List<Snack> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public Snack findById(Integer id) throws SQLException {
        return (Snack) service.findById(id);
    }

    @Override
    public void create(Snack snack) throws SQLException {
        service.create(snack);
    }

    @Override
    public void update(Snack snack) throws SQLException {
        service.update(snack);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}
