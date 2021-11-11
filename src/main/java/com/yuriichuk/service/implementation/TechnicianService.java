package com.yuriichuk.service.implementation;

import com.yuriichuk.DAO.AbsDAO;
import com.yuriichuk.DAO.implementation.TechnicianDAO;
import com.yuriichuk.model.Technician;
import com.yuriichuk.service.Service;

import java.sql.SQLException;
import java.util.List;

public class TechnicianService implements Service<Technician> {

    private final AbsDAO dao = new TechnicianDAO();

    @Override
    public List<Technician> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Technician findById(Integer id) throws SQLException {
        return (Technician) dao.findById(id);
    }

    @Override
    public void create(Technician technician) throws SQLException {
        dao.create(technician);
    }

    @Override
    public void update(Technician technician) throws SQLException {
        dao.update(technician);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}
