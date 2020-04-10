package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Database {

    private static Database instance;
    private Connection connection;
    private String url = "jdbc:mysql://localhost:3306/musicalbums";
    private String username = "dba";
    private String password = "sql1";

    private Database() throws SQLException {
        this.connection = DriverManager.getConnection(url, username, password);
    }

    public Connection getConnection() {
        return connection;
    }

    public static Database getInstance() throws SQLException {
        if (instance == null) {
            instance = new Database();
        } else if (instance.getConnection().isClosed()) {
            instance = new Database();
        }

        return instance;
    }
}