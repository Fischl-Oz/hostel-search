//  tag_id  | character varying(7) |           | not null |
//  post_id | bigint               |           | not null |


package com.fischl.DAOs;

import com.fischl.database.DBConnection;
import com.fischl.models.PostTag;
import org.postgresql.util.PSQLException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PostTagDAO {
    private Connection conn = null;

    public PostTagDAO() {
        conn = DBConnection.getConnection();
    }

    public boolean add(PostTag ptag) {
        String sql = "INSERT INTO posttag (tag_id, post_id) VALUES (?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ptag.getTagId());
            ps.setInt(2, ptag.getPostId());
            int result = ps.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(PostTag ptag) {
        String sql = "UPDATE posttag SET tag_id=? WHERE post_id=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ptag.getTagId());
            ps.setInt(2, ptag.getPostId());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean delete(String tag_id, int post_id) {
        String sql = "DELETE FROM posttag WHERE tag_id=? AND post_id=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tag_id);
            ps.setInt(2, post_id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(int post_id) {
        String sql = "DELETE FROM posttag WHERE post_id=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, post_id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(String tag_id) {
        String sql = "DELETE FROM posttag WHERE tag_id=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tag_id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<String> getAllTagIdByPostId(int post_id) {
        String sql = "SELECT tag_id FROM posttag WHERE post_id=?";
        ArrayList<String> tagIds = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, post_id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tagIds.add(rs.getString("tag_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tagIds;
    }

    public ArrayList<Integer> getAllPostIdByTagId(String tag_id) {
        String sql = "SELECT post_id FROM posttag WHERE tag_id=?";
        ArrayList<Integer> postIds = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tag_id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                postIds.add(rs.getInt("post_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return postIds;
    }

    public ArrayList<PostTag> getAll() {
        String sql = "SELECT * FROM posttag";
        ArrayList<PostTag> postTags = new ArrayList<PostTag>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                PostTag postTag = new PostTag();
                postTag.setTagId(rs.getString("tag_id"));
                postTag.setPostId(rs.getInt("post_id"));
                postTags.add(postTag);
            }
        } catch (PSQLException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return postTags;
    }
}
