package com.yuriichuk.DAO.implementation;

import com.yuriichuk.DAO.DAO;
import com.yuriichuk.model.VendingMachineSoldSnack;
import com.yuriichuk.persistant.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VendingMachineSoldSnackDAO implements DAO<VendingMachineSoldSnack> {

    private static final String GET_ALL = "SELECT * FROM yuriichuk.vending_machine_sold_snack";
    private static final String GET_BY_ID = "SELECT * FROM yuriichuk.vending_machine_sold_snack" +
            " WHERE id=?";
    private static final String CREATE = "INSERT INTO yuriichuk.vending_machine_sold_snack " +
            "(vending_machine_id, snack_id, quantity, date) VALUES (?, ?, ?, ?);";
    private static final String UPDATE = "UPDATE yuriichuk.vending_machine_sold_snack" +
            " SET `vending_machine_id` = ?, `snack_id` = ?, `quantity` = ?, `date` = ?" +
            " WHERE (`id` = ?) and (`vending_machine_id` = ?) and (`snack_id` = ?);";
    private static final String DELETE = "DELETE FROM yuriichuk.vending_machine_sold_snack" +
            " WHERE id=?;";

    @Override
    public List<VendingMachineSoldSnack> findAll() throws SQLException {
        List<VendingMachineSoldSnack> vendingMachineSoldSnacks = new ArrayList<VendingMachineSoldSnack>();

        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                VendingMachineSoldSnack vendingMachineSoldSnack = new VendingMachineSoldSnack(
                        resultSet.getInt("id"),
                        resultSet.getInt("vending_machine_id"),
                        resultSet.getInt("snack_id"),
                        resultSet.getInt("quantity"),
                        resultSet.getString("date")
                );
                vendingMachineSoldSnacks.add(vendingMachineSoldSnack);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return vendingMachineSoldSnacks;
    }

    @Override
    public VendingMachineSoldSnack findById(Integer id) throws SQLException {
        VendingMachineSoldSnack vendingMachineSoldSnack = null;

        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                vendingMachineSoldSnack = new VendingMachineSoldSnack(
                        resultSet.getInt("id"),
                        resultSet.getInt("vending_machine_id"),
                        resultSet.getInt("snack_id"),
                        resultSet.getInt("quantity"),
                        resultSet.getString("date")
                );
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return vendingMachineSoldSnack;
    }

    @Override
    public void create(VendingMachineSoldSnack vendingMachineSoldSnack) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setInt(1, vendingMachineSoldSnack.getVendingMachineId());
            statement.setInt(2, vendingMachineSoldSnack.getSnackId());
            statement.setInt(3, vendingMachineSoldSnack.getQuantity());
            statement.setString(4, vendingMachineSoldSnack.getDate());
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(VendingMachineSoldSnack vendingMachineSoldSnack) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setInt(1, vendingMachineSoldSnack.getVendingMachineId());
            statement.setInt(2, vendingMachineSoldSnack.getSnackId());
            statement.setInt(3, vendingMachineSoldSnack.getQuantity());
            statement.setString(4, vendingMachineSoldSnack.getDate());
            statement.setInt(5, vendingMachineSoldSnack.getId());
            statement.setInt(6, vendingMachineSoldSnack.getVendingMachineId());
            statement.setInt(7, vendingMachineSoldSnack.getSnackId());
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
