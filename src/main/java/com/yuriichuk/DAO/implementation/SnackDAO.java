package com.yuriichuk.DAO.implementation;

import com.yuriichuk.DAO.AbstractDAO;
import com.yuriichuk.model.Brand;
import com.yuriichuk.model.Snack;
import com.yuriichuk.persistant.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SnackDAO implements AbstractDAO<Snack> {

    private static final String GET_ALL = "SELECT * FROM yuriichuk.snack";
    private static final String GET_BY_ID = "SELECT * FROM yuriichuk.snack WHERE id=?";
    private static final String CREATE = "INSERT INTO yuriichuk.snack " +
            "(name, price, weight, callories, brand_id) VALUES (?, ?, ?, ?, ?);";
    private static final String UPDATE = "UPDATE `yuriichuk`.`snack`" +
            " SET `name` = ?, `price` = ?, `weight` = ?, `callories` = ?, `brand_id` = ?" +
            " WHERE (`id` = ?) and (`brand_id` = ?);";
    private static final String DELETE = "DELETE FROM yuriichuk.snack WHERE (`id` = ?);";

    @Override
    public List<Snack> findAll() throws SQLException {
        List<Snack> snacks = new ArrayList<Snack>();

        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Snack snack = new Snack(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getFloat("price"),
                        resultSet.getInt("weight"),
                        resultSet.getInt("callories"),
                        resultSet.getInt("brand_id")
                );
                snacks.add(snack);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return snacks;
    }

    @Override
    public Snack findById(Integer id) throws SQLException {
        Snack snack = null;

        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                snack = new Snack(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getFloat("price"),
                        resultSet.getInt("weight"),
                        resultSet.getInt("callories"),
                        resultSet.getInt("brand_id")
                );
            }
        } catch (Exception e) {

        }

        return snack;
    }

    @Override
    public void create(Snack snack) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, snack.getName());
            statement.setFloat(2, snack.getPrice());
            statement.setInt(3, snack.getWeight());
            statement.setInt(4, snack.getCallories());
            statement.setInt(5, snack.getBrandId());
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(Snack snack) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setString(1, snack.getName());
            statement.setFloat(2, snack.getPrice());
            statement.setInt(3, snack.getWeight());
            statement.setInt(4, snack.getCallories());
            statement.setInt(5, snack.getBrandId());
            statement.setInt(6, snack.getId());
            statement.setInt(7, snack.getBrandId());
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
