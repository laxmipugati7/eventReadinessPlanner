package com.yourapp.daoimpl;

import com.yourapp.bean.Venue;
import com.yourapp.dao.VenueDAO;
import com.yourapp.util.ConnectionFactory;

import java.sql.*;

public class VenueDAOImpl implements VenueDAO {

    private Connection conn;

    // Constructor
    public VenueDAOImpl() {
        try {
            conn = ConnectionFactory.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ================= ADD VENUE =================
    @Override
    public void addVenue(Venue venue) {

        String sql = "INSERT INTO venues(venue_name, location, capacity) VALUES(?,?,?)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, venue.getVenueName());
            ps.setString(2, venue.getLocation());
            ps.setInt(3, venue.getCapacity());

            ps.executeUpdate();
            System.out.println("Venue Added Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ================= VIEW VENUES =================
    @Override
    public void viewVenues() {

        String sql = "SELECT * FROM venues";

        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            System.out.println("\n---- Venue List ----");

            while (rs.next()) {
                System.out.println(
                        "ID: " + rs.getInt("venue_id") +
                                " | Name: " + rs.getString("venue_name") +
                                " | Location: " + rs.getString("location") +
                                " | Capacity: " + rs.getInt("capacity")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ================= UPDATE VENUE =================
    @Override
    public void updateVenue(int venueId, String venueName) {

        String sql = "UPDATE venues SET venue_name=? WHERE venue_id=?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, venueName);
            ps.setInt(2, venueId);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Venue Updated Successfully!");
            else
                System.out.println("Venue Not Found!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ================= DELETE VENUE =================
    @Override
    public void deleteVenue(int venueId) {

        String sql = "DELETE FROM venues WHERE venue_id=?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, venueId);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Venue Deleted Successfully!");
            else
                System.out.println("Venue Not Found!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ================= GET VENUE BY ID =================
    @Override
    public Venue getVenueById(int venueId) {

        String sql = "SELECT * FROM venues WHERE venue_id=?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, venueId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Venue venue = new Venue();
                venue.setVenueId(rs.getInt("venue_id"));
                venue.setVenueName(rs.getString("venue_name"));
                venue.setLocation(rs.getString("location"));
                venue.setCapacity(rs.getInt("capacity"));
                return venue;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}