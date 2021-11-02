package com.yuriichuk.DAO.implementation;

import com.yuriichuk.DAO.DAO;
import com.yuriichuk.model.Brand;
import com.yuriichuk.persistant.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BrandDAO implements DAO<Brand> {

    private static final String GET_ALL = "SELECT * FROM yuriichuk.brand";
    private static final String GET_BY_ID = "SELECT * FROM yuriichuk.brand WHERE id=?";
    private static final String CREATE = "INSERT INTO yuriichuk.brand " +
            "(name, foundation_data) VALUES (?, ?);";
    private static final String UPDATE = "UPDATE `yuriichuk`.`brand`" +
            " SET `name` = ?, `foundation_data` = ? WHERE (`id` = ?);";
    private static final String DELETE = "DELETE FROM yuriichuk.brand WHERE (`id` = ?);";

    @Override
    public List<Brand> findAll() throws SQLException {
        List<Brand> brands = new ArrayList<Brand>();

        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Brand brand = new Brand(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("foundation_data")
                );
                brands.add(brand);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return brands;
    }

    @Override
    public Brand findById(Integer id) throws SQLException {
        Brand brand = null;

        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                brand = new Brand(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("foundation_data")
                );
            }
        } catch (Exception e) {

        }

        return brand;
    }

    @Override
    public void create(Brand brand) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, brand.getName());
            statement.setString(2, brand.getDate());
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(Brand brand) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setString(1, brand.getName());
            statement.setString(2, brand.getDate());
            statement.setInt(3, brand.getId());
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
