package com.yourapp.daoimpl;

import com.yourapp.bean.Manager;
import com.yourapp.dao.ManagerDAO;
import com.yourapp.util.ConnectionFactory;

import java.sql.*;

public class ManagerDAOImpl implements ManagerDAO {

    private Connection conn;

    public ManagerDAOImpl() {
        try {
            conn = ConnectionFactory.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addManager(Manager manager) {

        String sql = "INSERT INTO managers(manager_name, contact) VALUES(?,?)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, manager.getManagerName());
            ps.setString(2, manager.getContact());

            ps.executeUpdate();
            System.out.println("Manager Added Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void viewManagers() {

        String sql = "SELECT * FROM managers";

        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(
                        rs.getInt("manager_id") + " | " +
                                rs.getString("manager_name") + " | " +
                                rs.getString("contact")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateManager(int managerId, String managerName) {

        String sql = "UPDATE managers SET manager_name=? WHERE manager_id=?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, managerName);
            ps.setInt(2, managerId);
            ps.executeUpdate();

            System.out.println("Manager Updated Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteManager(int managerId) {

        String sql = "DELETE FROM managers WHERE manager_id=?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, managerId);
            ps.executeUpdate();

            System.out.println("Manager Deleted Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}