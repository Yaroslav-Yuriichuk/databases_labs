package com.yuriichuk.DAO.implementation;

import com.yuriichuk.DAO.DAO;
import com.yuriichuk.model.Address;
import com.yuriichuk.persistant.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddressDAO implements DAO<Address> {
    private static final String GET_ALL = "SELECT * FROM yuriichuk.address";
    private static final String GET_BY_ID = "SELECT * FROM yuriichuk.address WHERE id=?";
    private static final String CREATE = "INSERT INTO yuriichuk.address " +
            "(region, city_village, street, building) VALUES (?, ?, ?, ?);";
    private static final String UPDATE = "UPDATE yuriichuk.address" +
            " SET `region` = ?, `city_village` = ?, `street` = ?, `building` = ? WHERE (`id` = ?);";
    private static final String DELETE = "DELETE FROM yuriichuk.address WHERE (`id` = ?);";

    @Override
    public List<Address> findAll() throws SQLException {
        List<Address> addresses = new ArrayList<Address>();

        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Address address = new Address(resultSet.getInt("id"),
                        resultSet.getString("region"),
                        resultSet.getString("city_village"),
                        resultSet.getString("street"),
                        resultSet.getString("building")
                );
                addresses.add(address);
            }
        } catch (Exception e) {

        }

        return addresses;
    }

    @Override
    public Address findById(Integer id) throws SQLException {
        Address address = null;

        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                address = new Address(resultSet.getInt("id"),
                        resultSet.getString("region"),
                        resultSet.getString("city_village"),
                        resultSet.getString("street"),
                        resultSet.getString("building")
                );
            }
        } catch (Exception e) {

        }

        return address;
    }

    @Override
    public void create(Address address) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, address.getRegion());
            statement.setString(2, address.getCityVillage());
            statement.setString(3, address.getStreet());
            statement.setString(4, address.getBuilding());
            statement.executeUpdate();
        } catch (Exception e) {

        }
    }

    @Override
    public void update(Address address) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setString(1, address.getRegion());
            statement.setString(2, address.getCityVillage());
            statement.setString(3, address.getStreet());
            statement.setString(4, address.getBuilding());
            statement.setInt(5, address.getId());
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
