package com.fischl.tools;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * This class generates unique IDs for different entities in the application.
 */
public class IdGenerator {
    private Connection conn = null;

    /**
     * Constructor for IdGenerator class.
     * @param conn The database connection object.
     */
    public IdGenerator(Connection conn) {
        this.conn = conn;
    }
    
    /**
     * Generates a new unique user ID.
     * @return The new user ID.
     */
    public int getNewUserId() {
        int maxId = 0;
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT MAX(user_id) FROM account");
            if (rs.next()) {
                maxId = rs.getInt(1);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maxId + 1;
    }

    /**
     * Generates a new unique hostel ID.
     * @return The new hostel ID.
     */
    public int getNewHostelId() {
        int maxId = 0;
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT MAX(hostel_id) FROM hostel");
            if (rs.next()) {
                maxId = rs.getInt(1);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maxId + 1;
    }

    /**
     * Generates a new unique image ID.
     * @return The new image ID.
     */
    public int getNewImgId() {
        int maxId = 0;
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT MAX(img_id) FROM imginventory");
            if (rs.next()) {
                maxId = rs.getInt(1);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maxId + 1;
    }

    /**
     * Generates a new unique post ID.
     * @return The new post ID.
     */
    public int getNewPostId() {
        int maxId = 0;
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT MAX(post_id) FROM post");
            if (rs.next()) {
                maxId = rs.getInt(1);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maxId + 1;
    }

    public String getNewTagId() {
        String maxId = null;
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT MAX(tag_id) FROM tag");
            if (rs.next()) {
                maxId = rs.getString(1);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        int digit = Integer.parseInt(maxId.split("-")[1]);
        String newId = String.valueOf(digit + 1);
        while (newId.length() < 3) newId = "0" + newId;
        return "TAG-" + newId;
    }
}
