package com.yuriichuk.controller.implementation;

import com.yuriichuk.controller.AbstractController;
import com.yuriichuk.model.Technician;
import com.yuriichuk.service.implementation.TechnicianService;

import java.sql.SQLException;
import java.util.List;

public class TechnicianController implements AbstractController<Technician> {

    private final TechnicianService service = new TechnicianService();

    @Override
    public List<Technician> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public Technician findById(Integer id) throws SQLException {
        return service.findById(id);
    }

    @Override
    public void create(Technician technician) throws SQLException {
        service.create(technician);
    }

    @Override
    public void update(Technician technician) throws SQLException {
        service.update(technician);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}
