package com.fischl.DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.fischl.DAOs.interfaces.IDao;
import com.fischl.models.Account;
import com.fischl.database.DBConnection;

public class AccountDAO implements IDao<Account,Integer> {
    private Connection conn = null;

    public AccountDAO() {
        conn = DBConnection.getConnection();
    }

    public void add(Account account) {
        String sql = "INSERT INTO account (user_id, date_signup, full_name, user_name, password, phone, email)\n" +
                    "VALUES (?, ?, ?, ?, ?, ?, ?);";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, account.getUserId());
            ps.setDate(2, account.getDateSignup());
            ps.setString(3, account.getFullName());
            ps.setString(4, account.getUserName());
            ps.setString(5, account.getPassword());
            ps.setString(6, account.getPhone());
            ps.setString(7, account.getEmail());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Integer id) {
        String sql = "DELETE FROM account WHERE user_id=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Account account) {
        String sql = "UPDATE account SET full_name=?, user_name=?, password=?, phone=?, email=? WHERE user_id=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, account.getFullName());
            ps.setString(1, account.getUserName());
            ps.setString(2, account.getPassword());
            ps.setString(3, account.getPhone());
            ps.setString(3, account.getEmail());
            ps.setInt(4, account.getUserId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Account> getAll() {
        ArrayList<Account> accounts = new ArrayList<Account>();
        String sql = "SELECT * FROM account";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Account acc = new Account();
                acc.setUserId(rs.getInt("user_id"));
                acc.setDateSignup(rs.getDate("date_signup"));
                acc.setFullName(rs.getString("full_name"));
                acc.setUserName(rs.getString("user_name"));
                acc.setPassword(rs.getString("password"));
                acc.setPhone(rs.getString("phone"));
                acc.setEmail(rs.getString("email"));
                accounts.add(acc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accounts;
    }

    public Account getById(Integer id) {
        Account account = new Account();
        String sql = "SELECT * FROM account WHERE user_id=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                account.setUserId(rs.getInt("user_id"));
                account.setDateSignup(rs.getDate("date_signup"));
                account.setFullName(rs.getString("full_name"));
                account.setUserName(rs.getString("user_name"));
                account.setPassword(rs.getString("password"));
                account.setPhone(rs.getString("phone"));
                account.setEmail(rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }
}
