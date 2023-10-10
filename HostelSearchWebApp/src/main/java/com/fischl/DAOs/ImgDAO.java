//  img_id   | bigint                 |           | not null | nextval('imginventory_img_id_seq'::regclass)
//  img_name | character varying(250) |           | not null |
//  img_uri  | character varying(200) |           | not null |
//  img_desc | character varying(350) |           |          |
//  user_id  | bigint                 |           | not null |


package com.fischl.DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.fischl.DAOs.interfaces.IDao;
import com.fischl.database.DBConnection;
import com.fischl.models.Img;

public class ImgDAO implements IDao<Img,Integer> {
    private Connection conn = null;

    public ImgDAO() {
        this.conn = DBConnection.getConnection();
    }

    public void add(Img img) {
        String sql = "INSERT INTO img (img_id, img_name, img_uri, img_desc, user_id, hostel_id) "
                + "VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, img.getImgId());
            ps.setString(2, img.getImgName());
            ps.setString(3, img.getImgUri());
            ps.setString(4, img.getImgDesc());
            ps.setInt(5, img.getUserId());
            ps.setInt(6, img.getHostelId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Img img) {
        String sql = "UPDATE img SET img_name=?, img_uri=?, img_desc=?, user_id=?, hostel_id=? WHERE img_id=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, img.getImgName());
            ps.setString(2, img.getImgUri());
            ps.setString(3, img.getImgDesc());
            ps.setInt(4, img.getUserId());
            ps.setInt(5, img.getHostelId());
            ps.setInt(6, img.getImgId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Integer id) {
        String sql = "DELETE FROM img WHERE img_id=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Img> getAll() {
        String sql = "SELECT * FROM img";
        ArrayList<Img> imgs = new ArrayList<Img>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Img img = new Img();
                img.setImgId(rs.getInt("img_id"));
                img.setImgName(rs.getString("img_name"));
                img.setImgUri(rs.getString("img_uri"));
                img.setImgDesc(rs.getString("img_desc"));
                img.setUserId(rs.getInt("user_id"));
                imgs.add(img);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return imgs;
    }

    public Img getById(Integer img_id) {
        String sql = "SELECT * FROM img WHERE img_id=?";
        Img img = new Img();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, img_id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                img.setImgId(rs.getInt("img_id"));
                img.setImgName(rs.getString("img_name"));
                img.setImgUri(rs.getString("img_uri"));
                img.setImgDesc(rs.getString("img_desc"));
                img.setUserId(rs.getInt("user_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return img;
    }
}
