package com.fischl.DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.fischl.DAOs.interfaces.IDao;
import com.fischl.models.Account;
import com.fischl.database.DBConnection;
import com.fischl.tools.MD5;

public class AccountDAO implements IDao<Account,Integer> {
    private Connection conn = null;

    public AccountDAO() {
        conn = DBConnection.getConnection();
    }

    public boolean add(Account account) {
        String sql = "INSERT INTO account (user_id, date_signup, full_name, user_name, password, phone, email, user_type)\n" +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, account.getUserId());
            ps.setDate(2, account.getDateSignup());
            ps.setString(3, account.getFullName());
            ps.setString(4, account.getUserName());
            ps.setString(5, account.getPassword());
            ps.setString(6, account.getPhone());
            ps.setString(7, account.getEmail());
            ps.setString(8, account.getUserType());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(Integer id) {
        String sql = "DELETE FROM account WHERE user_id=?";
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

    public boolean update(Account account) {
        String sql = "UPDATE account SET full_name=?, user_name=?, password=?, phone=?, email=?, user_type=? WHERE user_id=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, account.getFullName());
            ps.setString(2, account.getUserName());
            ps.setString(3, account.getPassword());
            ps.setString(4, account.getPhone());
            ps.setString(5, account.getEmail());
            ps.setString(6, account.getUserType());
            ps.setInt(7, account.getUserId());
            int result = ps.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
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
                acc.setUserType(rs.getString("user_type"));
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
                account.setUserType(rs.getString("user_type"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }

    public Account getByUsernamePassword(String user_name, String password) {
        password = MD5.getMd5(password);
        Account account = null;
        String sql = "SELECT * FROM account WHERE user_name = ? AND password = ?";
        ResultSet rs = null;
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user_name);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if (rs.next()){
                account = new Account();
                account.setUserId(rs.getInt("user_id"));
                account.setDateSignup(rs.getDate("date_signup"));
                account.setFullName(rs.getString("full_name"));
                account.setUserName(rs.getString("user_name"));
                account.setPassword(rs.getString("password"));
                account.setPhone(rs.getString("phone"));
                account.setEmail(rs.getString("email"));
                account.setUserType(rs.getString("user_type"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }
    public Account getUserByUsername(String username) {
       Account account = null;
        String query = "SELECT * FROM account WHERE user_name = ?";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                  account = new Account();
                account.setUserId(rs.getInt("user_id"));
                account.setDateSignup(rs.getDate("date_signup"));
                account.setFullName(rs.getString("full_name"));
                account.setUserName(rs.getString("user_name"));
                account.setPassword(rs.getString("password"));
                account.setPhone(rs.getString("phone"));
                account.setEmail(rs.getString("email"));
                account.setUserType(rs.getString("user_type"));

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return account;
    }
    public boolean isUsernameExists(String username) {
        boolean usernameExists = false;
        String sql = "SELECT COUNT(*) FROM account WHERE user_name = ?";

        try (PreparedStatement st = conn.prepareStatement(sql)) {
            st.setString(1, username);
            try ( ResultSet resultSet = st.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    // Nếu count > 0, `username` đã tồn tại trong cơ sở dữ liệu
                    usernameExists = count > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Xử lý các ngoại lệ nếu cần thiết
        }

        return usernameExists;
    }
    //mới thêm 1/11

    public boolean isPhonenumberExists(String phonenumber) {
        boolean phonenumberExists = false;
        String sql = "SELECT COUNT(*) FROM account WHERE phone = ?";

        try (
                PreparedStatement st = conn.prepareStatement(sql)) {
            st.setString(1, phonenumber);
            try ( ResultSet resultSet = st.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    // Nếu count > 0, `username` đã tồn tại trong cơ sở dữ liệu
                    phonenumberExists = count > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Xử lý các ngoại lệ nếu cần thiết
        }

        return phonenumberExists;
    }
    //mới thêm 1/11

    public boolean isEmailExists(String email) {
        boolean emailExists = false;
        String sql = "SELECT COUNT(*) FROM account WHERE email = ?";

        try (
                PreparedStatement st = conn.prepareStatement(sql)) {
            st.setString(1, email);
            try ( ResultSet resultSet = st.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    // Nếu count > 0, `username` đã tồn tại trong cơ sở dữ liệu
                    emailExists = count > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Xử lý các ngoại lệ nếu cần thiết
        }

        return emailExists;
    }
    //dem so luong account trong data 3/11

    public int getTotalAccount() {
        String sql = "SELECT COUNT(*) FROM account";

        try ( PreparedStatement ps = conn.prepareStatement(sql);
              ResultSet rs = ps.executeQuery()){

            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Xử lý các ngoại lệ nếu cần thiết
        }

        return 0;
    }
    //dem so luong hostel trong data 3/11
    //phan trang cho account 3/11
    public ArrayList<Account> pagingAccounts(int index){
        ArrayList<Account> list = new ArrayList<Account>();
        String sql = "Select * from account order by user_id desc offset ? rows fetch next 5 rows only;";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,(index -1)*5);
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
                acc.setUserType(rs.getString("user_type"));
                list.add(acc);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
