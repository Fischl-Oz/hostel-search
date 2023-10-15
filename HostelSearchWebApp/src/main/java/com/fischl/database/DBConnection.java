package com.fischl.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/maindb";
    private static final String DB_REMOTE_URL = "jdbc:postgresql://26.226.51.225:5432/maindb";
    private static final String USER = "postgres";
    private static final String PASS = "admin@00";
    private static Connection conn = null;

    public static Connection getConnection() {
        if (conn == null) {
            try {
                Class.forName("org.postgresql.Driver");
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
            } catch (SQLException e) {
                System.out.println("Failed to connect with DB_URL: " + e.getMessage());
                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, e);
            } catch (ClassNotFoundException ce) {
                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ce);
            }
        }
            
        if (conn == null) {
            try {
                Class.forName("org.postgresql.Driver");
                conn = DriverManager.getConnection(DB_REMOTE_URL, USER, PASS);
            } catch (SQLException e) {
                System.out.println("Failed to connect with DB_REMOTE_URL: " + e.getMessage());
                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, e);
            } catch (ClassNotFoundException ce) {
                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ce);
            }
        }

        return conn;
    }
}