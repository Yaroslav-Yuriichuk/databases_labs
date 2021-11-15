package com.yuriichuk.DAO.implementation;

import com.yuriichuk.DAO.DAO;
import com.yuriichuk.model.VendingMachine;
import com.yuriichuk.persistant.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VendingMachineDAO implements DAO<VendingMachine> {

    private static final String GET_ALL = "SELECT * FROM yuriichuk.vending_machine";
    private static final String GET_BY_ID = "SELECT * FROM yuriichuk.vending_machine WHERE id=?";
    private static final String CREATE = "INSERT INTO yuriichuk.vending_machine " +
            "(coordinates, address_id) VALUES (?, ?);";
    private static final String UPDATE = "UPDATE yuriichuk.vending_machine" +
            " SET `coordinates` = ?, `address_id` = ? WHERE (`id` = ?);";
    private static final String DELETE = "DELETE FROM yuriichuk.vending_machine WHERE (`id` = ?);";

    @Override
    public List<VendingMachine> findAll() throws SQLException {
        List<VendingMachine> vendingMachines = new ArrayList<VendingMachine>();

        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                VendingMachine vendingMachine = new VendingMachine(resultSet.getInt("id"),
                        resultSet.getString("coordinates"),
                        resultSet.getInt("address_id")
                );
                vendingMachines.add(vendingMachine);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return vendingMachines;
    }

    @Override
    public VendingMachine findById(Integer id) throws SQLException {
        VendingMachine vendingMachine = null;

        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                vendingMachine = new VendingMachine(resultSet.getInt("id"),
                        resultSet.getString("coordinates"),
                        resultSet.getInt("address_id")
                );
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return vendingMachine;
    }

    @Override
    public void create(VendingMachine vendingMachine) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, vendingMachine.getCoordinates());
            statement.setInt(2, vendingMachine.getAddressId());
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(VendingMachine vendingMachine) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setString(1, vendingMachine.getCoordinates());
            statement.setInt(2, vendingMachine.getAddressId());
            statement.setInt(3, vendingMachine.getId());
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
