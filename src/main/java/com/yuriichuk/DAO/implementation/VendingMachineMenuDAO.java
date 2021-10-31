package com.yuriichuk.DAO.implementation;

import com.yuriichuk.DAO.AbstractDAO;
import com.yuriichuk.model.VendingMachine;
import com.yuriichuk.model.VendingMachineMenu;
import com.yuriichuk.persistant.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VendingMachineMenuDAO implements AbstractDAO<VendingMachineMenu> {

    private static final String GET_ALL = "SELECT * FROM yuriichuk.vending_machine_menu";
    private static final String GET_BY_ID = "SELECT * FROM yuriichuk.vending_machine_menu" +
            " WHERE vending_machine_id=? and snack_id=?";
    private static final String CREATE = "INSERT INTO yuriichuk.vending_machine_menu " +
            "(vending_machine_id, snack_id) VALUES (?, ?);";
    private static final String DELETE = "DELETE FROM yuriichuk.vending_machine_menu" +
            " WHERE vending_machine_id=? and snack_id=?;";

    @Override
    public List<VendingMachineMenu> findAll() throws SQLException {
        List<VendingMachineMenu> vendingMachineMenus = new ArrayList<VendingMachineMenu>();

        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                VendingMachineMenu vendingMachineMenu = new VendingMachineMenu(
                        resultSet.getInt("vending_machine_id"),
                        resultSet.getInt("snack_id")
                );
                vendingMachineMenus.add(vendingMachineMenu);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return vendingMachineMenus;
    }

    @Override
    public VendingMachineMenu findById(Integer firstId, Integer secondId) throws SQLException {
        VendingMachineMenu vendingMachineMenu = null;

        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, firstId);
            statement.setInt(2, secondId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                vendingMachineMenu = new VendingMachineMenu(
                        resultSet.getInt("vending_machine_id"),
                        resultSet.getInt("snack_id")
                );
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return vendingMachineMenu;
    }

    @Override
    public void create(VendingMachineMenu vendingMachineMenu) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setInt(1, vendingMachineMenu.getVendingMachineId());
            statement.setInt(2, vendingMachineMenu.getSnackId());
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(Integer firstId, Integer secondId) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(DELETE)) {
            statement.setInt(1, firstId);
            statement.setInt(2, secondId);
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
