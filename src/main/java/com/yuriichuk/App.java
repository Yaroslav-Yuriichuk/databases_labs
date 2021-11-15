package com.yuriichuk;

import com.yuriichuk.persistant.ConnectionManager;
import com.yuriichuk.view.View;

import java.sql.Connection;
import java.sql.SQLException;

public class App {

    public static void main(String[] args) throws SQLException {
        new View().show();
    }
}
