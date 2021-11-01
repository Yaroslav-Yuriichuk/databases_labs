package com.yuriichuk.DAO.implementation;

import com.yuriichuk.DAO.AbstractDAO;
import com.yuriichuk.model.VendingMachineMoneyUnloading;
import com.yuriichuk.persistant.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VendingMachineMoneyUnloadingDAO implements AbstractDAO<VendingMachineMoneyUnloading> {

    private static final String GET_ALL = "SELECT * FROM yuriichuk.vending_machine_money_unloading";
    private static final String GET_BY_ID = "SELECT * FROM yuriichuk.vending_machine_money_unloading WHERE id=?";
    private static final String CREATE = "INSERT INTO yuriichuk.vending_machine_money_unloading " +
            "(technician_id, vending_machine_id, time, ammount) VALUES (?, ?, ?, ?);";
    private static final String UPDATE = "UPDATE yuriichuk.vending_machine_money_unloading" +
            " SET `technician_id` = ?, `vending_machine_id` = ?, `time` = ?, `ammount` = ?" +
            " WHERE (`id` = ?);";
    private static final String DELETE = "DELETE FROM yuriichuk.vending_machine_money_unloading" +
            " WHERE (`id` = ?);";

    @Override
    public List<VendingMachineMoneyUnloading> findAll() throws SQLException {
        List<VendingMachineMoneyUnloading> vendingMachineMoneyUnloadings = new ArrayList<VendingMachineMoneyUnloading>();

        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                VendingMachineMoneyUnloading vendingMachineMoneyUnloading = new VendingMachineMoneyUnloading(resultSet.getInt("id"),
                        resultSet.getInt("technician_id"),
                        resultSet.getInt("vending_machine_id"),
                        resultSet.getString("time"),
                        resultSet.getFloat("ammount")
                );
                vendingMachineMoneyUnloadings.add(vendingMachineMoneyUnloading);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return vendingMachineMoneyUnloadings;
    }

    @Override
    public VendingMachineMoneyUnloading findById(Integer id) throws SQLException {
        VendingMachineMoneyUnloading vendingMachineMoneyUnloading = null;

        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                vendingMachineMoneyUnloading = new VendingMachineMoneyUnloading(resultSet.getInt("id"),
                        resultSet.getInt("technician_id"),
                        resultSet.getInt("vending_machine_id"),
                        resultSet.getString("time"),
                        resultSet.getFloat("ammount")
                );
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return vendingMachineMoneyUnloading;
    }

    @Override
    public void create(VendingMachineMoneyUnloading vendingMachineMoneyUnloading) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setInt(1, vendingMachineMoneyUnloading.getTechnicianId());
            statement.setInt(2, vendingMachineMoneyUnloading.getVendingMachineId());
            statement.setString(3, vendingMachineMoneyUnloading.getTime());
            statement.setFloat(4, vendingMachineMoneyUnloading.getAmmount());
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(VendingMachineMoneyUnloading vendingMachineMoneyUnloading) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setInt(1, vendingMachineMoneyUnloading.getTechnicianId());
            statement.setInt(2, vendingMachineMoneyUnloading.getVendingMachineId());
            statement.setString(3, vendingMachineMoneyUnloading.getTime());
            statement.setFloat(4, vendingMachineMoneyUnloading.getAmmount());
            statement.setInt(5, vendingMachineMoneyUnloading.getId());
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