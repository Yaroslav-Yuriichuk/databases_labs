package com.yuriichuk.DAO.implementation;

import com.yuriichuk.DAO.AbstractDAO;
import com.yuriichuk.model.LoadedSnack;
import com.yuriichuk.model.VendingMachineMenu;
import com.yuriichuk.persistant.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoadedSnackDAO implements AbstractDAO<LoadedSnack> {

    private static final String GET_ALL = "SELECT * FROM yuriichuk.loaded_snack";
    private static final String GET_BY_ID = "SELECT * FROM yuriichuk.loaded_snack" +
            " WHERE vending_machine_snacks_loading_id=? and snack_id=?";
    private static final String CREATE = "INSERT INTO yuriichuk.loaded_snack " +
            "(vending_machine_snacks_loading_id, snack_id, quantity) VALUES (?, ?, ?);";
    private static final String UPDATE = "UPDATE yuriichuk.loaded_snack" +
            " SET `quantity` = ?" +
            " WHERE (`vending_machine_snacks_loading_id` = ?) and (`snack_id` = ?);";
    private static final String DELETE = "DELETE FROM yuriichuk.loaded_snack" +
            " WHERE vending_machine_snacks_loading_id=? and snack_id=?;";

    @Override
    public List<LoadedSnack> findAll() throws SQLException {
        List<LoadedSnack> loadedSnacks = new ArrayList<LoadedSnack>();

        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                LoadedSnack loadedSnack = new LoadedSnack(
                        resultSet.getInt("vending_machine_snacks_loading_id"),
                        resultSet.getInt("snack_id"),
                        resultSet.getInt("quantity")
                );
                loadedSnacks.add(loadedSnack);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return loadedSnacks;
    }

    @Override
    public LoadedSnack findById(Integer firstId, Integer secondId) throws SQLException {
        LoadedSnack loadedSnack = null;

        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, firstId);
            statement.setInt(2, secondId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                loadedSnack = new LoadedSnack(
                        resultSet.getInt("vending_machine_snacks_loading_id"),
                        resultSet.getInt("snack_id"),
                        resultSet.getInt("quantity")
                );
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return loadedSnack;
    }

    @Override
    public void create(LoadedSnack loadedSnack) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setInt(1, loadedSnack.getVendingMachineSnacksLoadingId());
            statement.setInt(2, loadedSnack.getSnackId());
            statement.setInt(3, loadedSnack.getQuantity());
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(LoadedSnack loadedSnack) throws  SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setInt(1, loadedSnack.getQuantity());
            statement.setInt(2, loadedSnack.getVendingMachineSnacksLoadingId());
            statement.setInt(3, loadedSnack.getSnackId());
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
