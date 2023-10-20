package com.fischl.DAOs;

import  java.sql.Connection;
import  java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.fischl.DAOs.interfaces.IDao;
import com.fischl.database.DBConnection;
import com.fischl.models.HostelMaster;

public class HostelMasterDAO implements IDao<HostelMaster,Integer> {
    private Connection conn = null;

    public HostelMasterDAO() {
        conn = DBConnection.getConnection();
    }

    public boolean add(HostelMaster hostelMaster) {
        String sql = "INSERT INTO hostel_master (user_id, hm_addr, authenticated)\n" +
                "VALUES (?, ?, ?);";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, hostelMaster.getUserId());
            ps.setString(2, hostelMaster.getHmAddr());
            ps.setBoolean(3, hostelMaster.isAuthenticated());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean delete(Integer id) {
        String sql = "DELETE FROM hostel_master WHERE user_id=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(HostelMaster hm) {
        String sql = "UPDATE hostel_master SET hm_addr=?, authenticated=? WHERE user_id=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, hm.getHmAddr());
            ps.setBoolean(2, hm.isAuthenticated());
            ps.setInt(3, hm.getUserId());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<HostelMaster> getAll() {
        ArrayList<HostelMaster> hostelMasters = new ArrayList<HostelMaster>();
        String sql = "SELECT * FROM hostel_master";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HostelMaster hostelMaster = new HostelMaster();
                hostelMaster.setUserId(rs.getInt("user_id"));
                hostelMaster.setHmAddr(rs.getString("hm_addr"));
                hostelMaster.setAuthenticated(rs.getBoolean("authenticated"));
                hostelMasters.add(hostelMaster);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hostelMasters;
    }

    public HostelMaster getById(Integer id) {
        HostelMaster hostelMaster = new HostelMaster();
        String sql = "SELECT * FROM hostel_master WHERE user_id=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                hostelMaster.setUserId(rs.getInt("user_id"));
                hostelMaster.setHmAddr(rs.getString("hm_addr"));
                hostelMaster.setAuthenticated(rs.getBoolean("authenticated"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hostelMaster;
    }
}
