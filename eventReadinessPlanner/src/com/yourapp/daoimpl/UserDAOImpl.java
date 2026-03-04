package com.yourapp.daoimpl;
import com.yourapp.dao.UserDAO;
import com.yourapp.util.ConnectionFactory;
import java.sql.*;

public class UserDAOImpl implements UserDAO {

    Connection conn = ConnectionFactory.getConnection();

    public void register(String username, String password) {
        try {
            String sql = "INSERT INTO users(username,password) VALUES(?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.executeUpdate();
            System.out.println("Registration Successful!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean login(String username, String password) {
        try {
            String sql = "SELECT * FROM users WHERE username=? AND password=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}