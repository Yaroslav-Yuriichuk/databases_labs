package com.yuriichuk.DAO.implementation;

import com.yuriichuk.DAO.AbstractDAO;
import com.yuriichuk.model.VendingMachineMoneyLoading;
import com.yuriichuk.model.VendingMachineSnacksLoading;
import com.yuriichuk.persistant.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VendingMachineSnacksLoadingDAO implements AbstractDAO<VendingMachineSnacksLoading> {

    private static final String GET_ALL = "SELECT * FROM yuriichuk.vending_machine_snacks_loading";
    private static final String GET_BY_ID = "SELECT * FROM yuriichuk.vending_machine_snacks_loading WHERE id=?";
    private static final String CREATE = "INSERT INTO yuriichuk.vending_machine_snacks_loading " +
            "(technician_id, vending_machine_id, time) VALUES (?, ?, ?);";
    private static final String UPDATE = "UPDATE yuriichuk.vending_machine_snacks_loading" +
            " SET `technician_id` = ?, `vending_machine_id` = ?, `time` = ?" +
            " WHERE (`id` = ?);";
    private static final String DELETE = "DELETE FROM yuriichuk.vending_machine_snacks_loading" +
            " WHERE (`id` = ?);";

    @Override
    public List<VendingMachineSnacksLoading> findAll() throws SQLException {
        List<VendingMachineSnacksLoading> vendingMachineSnacksLoadings = new ArrayList<VendingMachineSnacksLoading>();

        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                VendingMachineSnacksLoading vendingMachineSnacksLoading = new VendingMachineSnacksLoading(resultSet.getInt("id"),
                        resultSet.getInt("technician_id"),
                        resultSet.getInt("vending_machine_id"),
                        resultSet.getString("time")
                );
                vendingMachineSnacksLoadings.add(vendingMachineSnacksLoading);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return vendingMachineSnacksLoadings;
    }

    @Override
    public VendingMachineSnacksLoading findById(Integer id) throws SQLException {
        VendingMachineSnacksLoading vendingMachineSnacksLoading = null;

        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                vendingMachineSnacksLoading = new VendingMachineSnacksLoading(resultSet.getInt("id"),
                        resultSet.getInt("technician_id"),
                        resultSet.getInt("vending_machine_id"),
                        resultSet.getString("time")
                );
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return vendingMachineSnacksLoading;
    }

    @Override
    public void create(VendingMachineSnacksLoading vendingMachineSnacksLoading) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setInt(1, vendingMachineSnacksLoading.getTechnicianId());
            statement.setInt(2, vendingMachineSnacksLoading.getVendingMachineId());
            statement.setString(3, vendingMachineSnacksLoading.getTime());
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(VendingMachineSnacksLoading vendingMachineSnacksLoading) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setInt(1, vendingMachineSnacksLoading.getTechnicianId());
            statement.setInt(2, vendingMachineSnacksLoading.getVendingMachineId());
            statement.setString(3, vendingMachineSnacksLoading.getTime());
            statement.setInt(4, vendingMachineSnacksLoading.getId());
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
