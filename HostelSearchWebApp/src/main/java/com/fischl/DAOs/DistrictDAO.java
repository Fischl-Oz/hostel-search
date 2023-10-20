//  district_id   | character varying(7)  |           | not null |
//  district_name | character varying(30) |           | not null |
//  city_id       | character varying(7)  |           | not null |


package com.fischl.DAOs;

import com.fischl.DAOs.interfaces.IDao;
import com.fischl.database.DBConnection;
import com.fischl.models.District;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DistrictDAO implements IDao<District,String> {
    private Connection conn = null;

    public DistrictDAO(){
        conn = DBConnection.getConnection();
    }

    public boolean add(District dt) {
        String sql = "INSERT INTO district (district_id, district_name, city_id) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, dt.getDistrictId());
            ps.setString(2, dt.getDistrictName());
            ps.setString(3, dt.getCityId());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(District dt) {
        String sql = "UPDATE district SET district_name=?, city_id=? WHERE district_id=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, dt.getDistrictName());
            ps.setString(2, dt.getCityId());
            ps.setString(3, dt.getDistrictId());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(String id) {
        String sql = "DELETE FROM district WHERE district_id=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<District> getAll() {
        String sql = "SELECT * FROM district";
        ArrayList<District> districts = new ArrayList<District>();
        try {
            ResultSet rs = conn.prepareStatement(sql).executeQuery();
            while (rs.next()) {
                District dt = new District();
                dt.setDistrictId(rs.getString("district_id"));
                dt.setDistrictName(rs.getString("district_name"));
                dt.setCityId(rs.getString("city_id"));
                districts.add(dt);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return districts;
    }

    public District getById(String id) {
        String sql = "SELECT * FROM district WHERE district_id=?";
        District dt = new District();
        try {
            ResultSet rs = conn.prepareStatement(sql).executeQuery();
            if (rs.next()) {
                dt.setDistrictId(rs.getString("district_id"));
                dt.setDistrictName(rs.getString("district_name"));
                dt.setCityId(rs.getString("city_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dt;
    }
}
