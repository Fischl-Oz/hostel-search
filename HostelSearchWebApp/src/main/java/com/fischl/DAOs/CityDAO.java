//  city_id   | character varying(7)  |           | not null |
//  city_name | character varying(30) |           | not null |


package com.fischl.DAOs;

import com.fischl.DAOs.interfaces.IDao;
import com.fischl.database.DBConnection;
import com.fischl.models.City;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CityDAO implements IDao<City,String> {
    private Connection conn = null;

    public CityDAO(){
        conn = DBConnection.getConnection();
    }

    public boolean add(City ct) {
        String sql = "INSERT INTO city (city_id, city_name) VALUES (?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ct.getCityId());
            ps.setString(2, ct.getCityName());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(City ct) {
        String sql = "UPDATE city SET city_name=? WHERE city_id=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ct.getCityName());
            ps.setString(2, ct.getCityId());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(String id) {
        String sql = "DELETE FROM city WHERE city_id=?";
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

    public ArrayList<City> getAll() {
        ArrayList<City> cities = new ArrayList<City>();
        String sql = "SELECT * FROM city";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                City ct = new City();
                ct.setCityId(rs.getString("city_id"));
                ct.setCityName(rs.getString("city_name"));
                cities.add(ct);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cities;
    }

    public City getById(String id) {
        String sql = "SELECT * FROM city WHERE city_id=?";
        City ct = new City();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ct.setCityId(rs.getString("city_id"));
                ct.setCityName(rs.getString("city_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ct;
    }
}
