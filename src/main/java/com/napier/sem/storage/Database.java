package com.napier.sem.storage;

import java.sql.*;

public class Database {

    private Connection con = null;

    public Database(String connectionString, String user, String password) {
        try {
            // Load Database driver
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        System.out.println("Connecting to database...");
        try {
            // Connect to database
            con = DriverManager.getConnection("jdbc:" + connectionString + "?useSSL=false", user, password);
            System.out.println("Successfully connected");
        } catch (SQLException e) {
            System.out.println("Failed to connect to database");
            System.out.println(e.getMessage());
        }
    }

    public ResultSet query(String sql) {
        try {
            Statement stmt = con.createStatement();
            return stmt.executeQuery(sql);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to fetch query: " + sql);
            return null;
        }
    }

    public void disconnect() {
        if (con != null) {
            try {
                // Close connection
                con.close();
            } catch (Exception e) {
                System.out.println("Error closing connection to database");
            }
        }
    }

}
