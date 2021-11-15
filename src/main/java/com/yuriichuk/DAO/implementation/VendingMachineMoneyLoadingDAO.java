package com.yuriichuk.DAO.implementation;

import com.yuriichuk.DAO.DAO;
import com.yuriichuk.model.VendingMachineMoneyLoading;
import com.yuriichuk.persistant.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VendingMachineMoneyLoadingDAO implements DAO<VendingMachineMoneyLoading> {

    private static final String GET_ALL = "SELECT * FROM yuriichuk.vending_machine_money_loading";
    private static final String GET_BY_ID = "SELECT * FROM yuriichuk.vending_machine_money_loading WHERE id=?";
    private static final String CREATE = "INSERT INTO yuriichuk.vending_machine_money_loading " +
            "(technician_id, vending_machine_id, time, ammount) VALUES (?, ?, ?, ?);";
    private static final String UPDATE = "UPDATE yuriichuk.vending_machine_money_loading" +
            " SET `technician_id` = ?, `vending_machine_id` = ?, `time` = ?, `ammount` = ?" +
            " WHERE (`id` = ?);";
    private static final String DELETE = "DELETE FROM yuriichuk.vending_machine_money_loading" +
            " WHERE (`id` = ?);";

    @Override
    public List<VendingMachineMoneyLoading> findAll() throws SQLException {
        List<VendingMachineMoneyLoading> vendingMachineMoneyLoadings = new ArrayList<VendingMachineMoneyLoading>();

        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                VendingMachineMoneyLoading vendingMachineMoneyLoading = new VendingMachineMoneyLoading(resultSet.getInt("id"),
                        resultSet.getInt("technician_id"),
                        resultSet.getInt("vending_machine_id"),
                        resultSet.getString("time"),
                        resultSet.getFloat("ammount")
                );
                vendingMachineMoneyLoadings.add(vendingMachineMoneyLoading);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return vendingMachineMoneyLoadings;
    }

    @Override
    public VendingMachineMoneyLoading findById(Integer id) throws SQLException {
        VendingMachineMoneyLoading vendingMachineMoneyLoading = null;

        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                vendingMachineMoneyLoading = new VendingMachineMoneyLoading(resultSet.getInt("id"),
                        resultSet.getInt("technician_id"),
                        resultSet.getInt("vending_machine_id"),
                        resultSet.getString("time"),
                        resultSet.getFloat("ammount")
                );
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return vendingMachineMoneyLoading;
    }

    @Override
    public void create(VendingMachineMoneyLoading vendingMachineMoneyLoading) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setInt(1, vendingMachineMoneyLoading.getTechnicianId());
            statement.setInt(2, vendingMachineMoneyLoading.getVendingMachineId());
            statement.setString(3, vendingMachineMoneyLoading.getTime());
            statement.setFloat(4, vendingMachineMoneyLoading.getAmmount());
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(VendingMachineMoneyLoading vendingMachineMoneyLoading) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setInt(1, vendingMachineMoneyLoading.getTechnicianId());
            statement.setInt(2, vendingMachineMoneyLoading.getVendingMachineId());
            statement.setString(3, vendingMachineMoneyLoading.getTime());
            statement.setFloat(4, vendingMachineMoneyLoading.getAmmount());
            statement.setInt(5, vendingMachineMoneyLoading.getId());
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
