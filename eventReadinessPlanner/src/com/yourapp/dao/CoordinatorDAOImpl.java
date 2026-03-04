package com.yourapp.daoimpl;

import com.yourapp.bean.Coordinator;
import com.yourapp.dao.CoordinatorDAO;
import com.yourapp.util.ConnectionFactory;

import java.sql.*;

public class CoordinatorDAOImpl implements CoordinatorDAO {

    private Connection conn;

    public CoordinatorDAOImpl() {
        try {
            conn = ConnectionFactory.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addCoordinator(Coordinator coordinator) {

        String sql = "INSERT INTO coordinators(coordinator_name, contact) VALUES(?,?)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, coordinator.getCoordinatorName());
            ps.setString(2, coordinator.getContact());

            ps.executeUpdate();
            System.out.println("Coordinator Added Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void viewCoordinators() {

        String sql = "SELECT * FROM coordinators";

        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(
                        rs.getInt("coordinator_id") + " | " +
                                rs.getString("coordinator_name") + " | " +
                                rs.getString("contact")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCoordinator(int coordinatorId, String coordinatorName) {

        String sql = "UPDATE coordinators SET coordinator_name=? WHERE coordinator_id=?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, coordinatorName);
            ps.setInt(2, coordinatorId);
            ps.executeUpdate();

            System.out.println("Coordinator Updated Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCoordinator(int coordinatorId) {

        String sql = "DELETE FROM coordinators WHERE coordinator_id=?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, coordinatorId);
            ps.executeUpdate();

            System.out.println("Coordinator Deleted Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}