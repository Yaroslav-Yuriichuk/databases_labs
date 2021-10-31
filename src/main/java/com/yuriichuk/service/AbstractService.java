package com.yuriichuk.service;

import java.sql.SQLException;
import java.util.List;

public interface AbstractService<E> {

    List<E> findAll() throws SQLException;

    default E findById(Integer id) throws SQLException {
        return null;
    }

    default E findById(Integer firstId, Integer secondId) throws SQLException {
        return null;
    }

    default void create(E entity) throws SQLException {}

    default void update(E entity) throws SQLException {}

    default void delete(Integer id) throws SQLException {}

    default void delete(Integer firstId, Integer secondId) throws SQLException {}

}
