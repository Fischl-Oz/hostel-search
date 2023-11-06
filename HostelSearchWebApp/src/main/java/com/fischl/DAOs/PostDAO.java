//  post_id      | bigint                      |           | not null |
//  post_title   | character varying(100)      |           | not null |
//  post_date    | timestamp without time zone |           | not null |
//  post_content | text                        |           | not null |
//  post_status  | character varying(20)       |           | not null | 'active'::character varying
//  hostel_id    | bigint                      |           | not null |
//  district_id  | character varying(7)        |           | not null |


package com.fischl.DAOs;

import com.fischl.DAOs.interfaces.IDao;
import com.fischl.database.DBConnection;
import com.fischl.models.Post;
import org.postgresql.util.PSQLException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PostDAO implements IDao<Post,Integer> {
    private Connection conn = null;

    public PostDAO(){
        conn = DBConnection.getConnection();
    }

    public boolean add(Post p) {
        String sql = "INSERT INTO post (post_id, post_title, post_date, post_content, post_status, hostel_id) "
                + "VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, p.getPostId());
            ps.setString(2, p.getPostTitle());
            ps.setTimestamp(3, p.getPostDate());
            ps.setString(4, p.getPostContent());
            ps.setString(5, p.getPostStatus());
            ps.setInt(6, p.getHostelId());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(Post p) {
        String sql = "UPDATE post SET post_title=?, post_date=?, post_content=?, post_status=?, hostel_id=? WHERE post_id=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, p.getPostTitle());
            ps.setTimestamp(2, p.getPostDate());
            ps.setString(3, p.getPostContent());
            ps.setString(4, p.getPostStatus());
            ps.setInt(5, p.getHostelId());
            ps.setInt(6, p.getPostId());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(Integer id) {
        String sql = "DELETE FROM post WHERE post_id=?";
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

    public ArrayList<Post> getAll() {
        String sql = "SELECT * FROM post";
        ArrayList<Post> posts = new ArrayList<Post>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Post p = new Post();
                p.setPostId(rs.getInt("post_id"));
                p.setPostTitle(rs.getString("post_title"));
                p.setPostDate(rs.getTimestamp("post_date"));
                p.setPostContent(rs.getString("post_content"));
                p.setPostStatus(rs.getString("post_status"));
                p.setHostelId(rs.getInt("hostel_id"));
                posts.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return posts;
    }

    public Post getById(Integer id) {
        String sql = "SELECT * FROM post WHERE post_id=?";
        Post p = new Post();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                p.setPostId(rs.getInt("post_id"));
                p.setPostTitle(rs.getString("post_title"));
                p.setPostDate(rs.getTimestamp("post_date"));
                p.setPostContent(rs.getString("post_content"));
                p.setPostStatus(rs.getString("post_status"));
                p.setHostelId(rs.getInt("hostel_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }

    public ArrayList<Post> getPostByCityId(String cityId) {
        ArrayList<Post> posts = new ArrayList<Post>();
        String sql = "SELECT p.post_id FROM post p\n" +
                "JOIN city_post cp ON p.post_id = cp.post_id\n" +
                "JOIN city c ON cp.city_id = c.city_id\n" +
                "where c.city_id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cityId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Post p = new Post();
                int postId = rs.getInt("post_id");
                Post post = this.getById(postId);
                if (post != null)
                    posts.add(post);
            }
        } catch (PSQLException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return posts;
    }
}
