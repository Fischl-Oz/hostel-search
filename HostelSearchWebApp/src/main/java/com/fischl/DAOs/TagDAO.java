//  tag_id  | character varying(7)  |           | not null |
//  tag_txt | character varying(50) |           | not null |


package com.fischl.DAOs;

import com.fischl.DAOs.interfaces.IDao;
import com.fischl.database.DBConnection;
import com.fischl.models.Tag;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TagDAO implements IDao<Tag,String> {
    private Connection conn = null;

    public TagDAO(){
        conn = DBConnection.getConnection();
    }

    public boolean add(Tag t) {
        String sql = "INSERT INTO tag (tag_id, tag_txt) VALUES (?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, t.getTagId());
            ps.setString(2, t.getTagTxt());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean update(Tag t) {
        String sql = "UPDATE tag SET tag_txt=? WHERE tag_id=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, t.getTagTxt());
            ps.setString(2, t.getTagId());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(String id) {
        String sql = "DELETE FROM tag WHERE tag_id=?";
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

    public ArrayList<Tag> getAll() {
        ArrayList<Tag> tags = new ArrayList<Tag>();
        String sql = "SELECT * FROM tag";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Tag t = new Tag();
                t.setTagId(rs.getString("tag_id"));
                t.setTagTxt(rs.getString("tag_txt"));
                tags.add(t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tags;
    }

    public Tag getById(String id) {
        String sql = "SELECT * FROM tag WHERE tag_id=?";
        Tag t = new Tag();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                t.setTagId(rs.getString("tag_id"));
                t.setTagTxt(rs.getString("tag_txt"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return t;
    }
}
