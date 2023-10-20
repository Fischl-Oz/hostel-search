package com.fischl.DAOs;

import com.fischl.DAOs.interfaces.IDao;
import com.fischl.database.DBConnection;
import com.fischl.models.Hostel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class HostelDAO implements IDao<Hostel,Integer> {
    private Connection conn = null;

    public HostelDAO() {
        this.conn = DBConnection.getConnection();
    }

    public boolean add(Hostel hostel) {
        String sql = "INSERT INTO hostel (hostel_id, hostel_name, hostel_addr, hostel_desc, price, area, total_room, available_room, district_id, user_id) "
                +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, hostel.getHostelId());
            ps.setString(2, hostel.getHostelName());
            ps.setString(3, hostel.getHostelAddr());
            ps.setString(4, hostel.getHostelDesc());
            ps.setFloat(5, hostel.getPrice());
            ps.setDouble(6, hostel.getArea());
            ps.setInt(7, hostel.getTotalRoom());
            ps.setInt(8, hostel.getAvailableRoom());
            ps.setString(9, hostel.getDistrictId());
            ps.setInt(10, hostel.getUserId());
            int result = ps.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(Integer id) {
        String sql = "DELETE FROM hostel WHERE hostel_id=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            int result = ps.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(Hostel hostel) {
        String sql = "UPDATE hostel SET hostel_name=?, hostel_addr=?, hostel_desc=?, price=?, area=?, total_room=?, available_room=?, district_id=?, user_id=? WHERE hostel_id=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, hostel.getHostelName());
            ps.setString(2, hostel.getHostelAddr());
            ps.setString(3, hostel.getHostelDesc());
            ps.setFloat(4, hostel.getPrice());
            ps.setDouble(5, hostel.getArea());
            ps.setInt(6, hostel.getTotalRoom());
            ps.setInt(7, hostel.getAvailableRoom());
            ps.setString(8, hostel.getDistrictId());
            ps.setInt(9, hostel.getUserId());
            ps.setInt(10, hostel.getHostelId());
            int result = ps.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<Hostel> getAll() {
        ArrayList<Hostel> hostels = new ArrayList<Hostel>();
        String sql = "SELECT * FROM hostel";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Hostel hostel = new Hostel();
                hostel.setHostelId(rs.getInt("hostel_id"));
                hostel.setHostelName(rs.getString("hostel_name"));
                hostel.setHostelAddr(rs.getString("hostel_addr"));
                hostel.setHostelDesc(rs.getString("hostel_desc"));
                hostel.setPrice(rs.getByte("price"));
                hostel.setArea(rs.getDouble("area"));
                hostel.setTotalRoom(rs.getByte("total_room"));
                hostel.setAvailableRoom(rs.getByte("available_room"));
                hostel.setDistrictId(rs.getString("district_id"));
                hostel.setUserId(rs.getInt("user_id"));
                hostels.add(hostel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hostels;
    }

    public Hostel getById(Integer id) {
        Hostel hostel = new Hostel();
        String sql = "SELECT * FROM hostel WHERE hostel_id=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                hostel.setHostelId(rs.getInt("hostel_id"));
                hostel.setHostelName(rs.getString("hostel_name"));
                hostel.setHostelAddr(rs.getString("hostel_addr"));
                hostel.setHostelDesc(rs.getString("hostel_desc"));
                hostel.setPrice(rs.getByte("price"));
                hostel.setArea(rs.getDouble("area"));
                hostel.setTotalRoom(rs.getByte("total_room"));
                hostel.setAvailableRoom(rs.getByte("available_room"));
                hostel.setDistrictId(rs.getString("district_id"));
                hostel.setUserId(rs.getInt("user_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hostel;
    }
}
