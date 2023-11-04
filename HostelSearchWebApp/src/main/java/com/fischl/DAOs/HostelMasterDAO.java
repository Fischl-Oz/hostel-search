package com.fischl.DAOs;

import  java.sql.Connection;
import  java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.fischl.DAOs.interfaces.IDao;
import com.fischl.database.DBConnection;
import com.fischl.models.HostelMaster;
import org.postgresql.util.PSQLException;

public class HostelMasterDAO implements IDao<HostelMaster,Integer> {
    private Connection conn = null;

    public HostelMasterDAO() {
        conn = DBConnection.getConnection();
    }

    public HostelMasterDAO(Connection conn) {
        this.conn = conn;
    }

    public boolean add(HostelMaster hostelMaster) {
        String sql = "INSERT INTO hostelmaster (user_id, hm_addr, cccd_front, cccd_back, hbc, status)\n" +
                "VALUES (?, ?, ?, ?, ?, ?);";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, hostelMaster.getUserId());
            ps.setString(2, hostelMaster.getHostelMasterAddress());
            ps.setString(3, hostelMaster.getCccdFront());
            ps.setString(4, hostelMaster.getCccdBack());
            ps.setString(5, hostelMaster.getHbc());
            ps.setString(6, hostelMaster.getStatus());
            int result = ps.executeUpdate();
            return result > 0;
        } catch (PSQLException e) {
            e.printStackTrace();
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean delete(Integer id) {
        String sql = "DELETE FROM hostelmaster WHERE user_id=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            int result = ps.executeUpdate();
            return result > 0;
        } catch (PSQLException e) {
            e.printStackTrace();
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(HostelMaster hm) {
        String sql = "UPDATE hostelmaster SET hm_addr=?, cccd_front=?, cccd_back=?, hbc=?, status=? WHERE user_id=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, hm.getHostelMasterAddress());
            ps.setString(2, hm.getCccdFront());
            ps.setString(3, hm.getCccdBack());
            ps.setString(4, hm.getHbc());
            ps.setString(5, hm.getStatus());
            ps.setInt(6, hm.getUserId());
            int result = ps.executeUpdate();
            return result > 0;
        } catch (PSQLException e) {
            e.printStackTrace();
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<HostelMaster> getAll() {
        ArrayList<HostelMaster> hostelMasters = new ArrayList<>();
        String sql = "SELECT * FROM hostelmaster";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HostelMaster hostelMaster = new HostelMaster();
                hostelMaster.setUserId(rs.getInt("user_id"));
                hostelMaster.setHostelMasterAddress(rs.getString("hm_addr"));
                hostelMaster.setCccdFront(rs.getString("cccd_front"));
                hostelMaster.setCccdBack(rs.getString("cccd_back"));
                hostelMaster.setHbc(rs.getString("hbc"));
                hostelMaster.setStatus(rs.getString("status"));
                hostelMasters.add(hostelMaster);
            }
        } catch (PSQLException e) {
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return hostelMasters;
    }

    public HostelMaster getById(Integer id) {
        HostelMaster hostelMaster = new HostelMaster();
        String sql = "SELECT * FROM hostelmaster WHERE user_id=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                hostelMaster.setUserId(rs.getInt("user_id"));
                hostelMaster.setHostelMasterAddress(rs.getString("hm_addr"));
                hostelMaster.setCccdFront(rs.getString("cccd_front"));
                hostelMaster.setCccdBack(rs.getString("cccd_back"));
                hostelMaster.setHbc(rs.getString("hbc"));
                hostelMaster.setStatus(rs.getString("status"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return hostelMaster;
    }
}
