package com.yuriichuk.DAO.implementation;

import com.yuriichuk.DAO.DAO;
import com.yuriichuk.model.Technician;
import com.yuriichuk.persistant.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TechnicianDAO implements DAO<Technician> {

    private static final String GET_ALL = "SELECT * FROM yuriichuk.technician";
    private static final String GET_BY_ID = "SELECT * FROM yuriichuk.technician WHERE id=?";
    private static final String CREATE = "INSERT INTO yuriichuk.technician " +
            "(first_name, last_name, age, work_entry_date) VALUES (?, ?, ?, ?);";
    private static final String UPDATE = "UPDATE yuriichuk.technician" +
            " SET `first_name` = ?, `last_name` = ?, `age` = ?, `work_entry_date` = ?" +
            " WHERE (`id` = ?);";
    private static final String DELETE = "DELETE FROM yuriichuk.technician WHERE (`id` = ?);";


    @Override
    public List<Technician> findAll() throws SQLException {
        List<Technician> technicians = new ArrayList<Technician>();

        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Technician technician = new Technician(resultSet.getInt("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getInt("age"),
                        resultSet.getString("work_entry_date")
                );
                technicians.add(technician);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return technicians;
    }

    @Override
    public Technician findById(Integer id) throws SQLException {
        Technician technician = null;

        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                technician = new Technician(resultSet.getInt("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getInt("age"),
                        resultSet.getString("work_entry_date")
                );
            }
        } catch (Exception e) {

        }

        return technician;
    }

    @Override
    public void create(Technician technician) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, technician.getFirstName());
            statement.setString(2, technician.getLastName());
            statement.setInt(3, technician.getAge());
            statement.setString(4, technician.getWorkEntryDate());
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(Technician technician) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setString(1, technician.getFirstName());
            statement.setString(2, technician.getLastName());
            statement.setInt(3, technician.getAge());
            statement.setString(4, technician.getWorkEntryDate());
            statement.setInt(5, technician.getId());
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(DELETE)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
