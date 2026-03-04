//package com.yourapp.daoimpl;
//import java.sql.Connection;
//import com.yourapp.bean.Event;
//import com.yourapp.dao.EventDAO;
//import com.yourapp.util.ConnectionFactory;
//import java.sql.*;
//
//public class EventDAOImpl implements EventDAO {
//
//    Connection conn = ConnectionFactory.getConnection();
//
//    public class EventDAOImpl implements EventDAO {
//
//        private Connection connection;   // ✅ VERY IMPORTANT
//
//        public EventDAOImpl()  {
//            try {
//                connection = ConnectionFactory.getConnection();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//
//    public void addEvent(Event event) {
//        try {
//            String sql = "INSERT INTO events(event_name,event_date,location,user_id) VALUES(?,?,?,?)";
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setString(1, event.getEventName());
//            ps.setDate(2, event.getEventDate());
//            ps.setString(3, event.getLocation());
//            ps.setInt(4, event.getUserId());
//            ps.executeUpdate();
//            System.out.println("Event Added!");
//        } catch (Exception e) { e.printStackTrace(); }
//    }
//
//    public void viewEvents() {
//        try {
//            String sql = "SELECT e.event_id,e.event_name,e.event_date,e.location,u.username FROM events e JOIN users u ON e.user_id=u.user_id";
//            Statement st = conn.createStatement();
//            ResultSet rs = st.executeQuery(sql);
//
//            while(rs.next()) {
//                System.out.println(rs.getInt(1)+" | "+rs.getString(2)+" | "+rs.getDate(3)+" | "+rs.getString(4)+" | Created By: "+rs.getString(5));
//            }
//        } catch (Exception e) { e.printStackTrace(); }
//    }
//
//    public void updateEvent(int id, String name) {
//        try {
//            String sql = "UPDATE events SET event_name=? WHERE event_id=?";
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setString(1, name);
//            ps.setInt(2, id);
//            ps.executeUpdate();
//            System.out.println("Event Updated!");
//        } catch (Exception e) { e.printStackTrace(); }
//    }
//
//    public void deleteEvent(int id) {
//        try {
//            String sql = "DELETE FROM events WHERE event_id=?";
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setInt(1, id);
//            ps.executeUpdate();
//            System.out.println("Event Deleted!");
//        } catch (Exception e) { e.printStackTrace(); }
//    }
//}

package com.yourapp.daoimpl;

import java.sql.*;
import com.yourapp.bean.Event;
import com.yourapp.dao.EventDAO;
import com.yourapp.util.ConnectionFactory;

public class EventDAOImpl implements EventDAO {

    private Connection conn;

    // Constructor
    public EventDAOImpl() {
        try {
            conn = ConnectionFactory.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ADD EVENT
    @Override
    public void addEvent(Event event) {
        try {
            String sql = "INSERT INTO events(event_name,event_date,location,user_id) VALUES(?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, event.getEventName());
            ps.setDate(2, event.getEventDate());
            ps.setString(3, event.getLocation());
            ps.setInt(4, event.getUserId());
            ps.executeUpdate();
            System.out.println("Event Added Successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // VIEW EVENTS (JOIN QUERY)
    @Override
    public void viewEvents() {
        try {
            String sql = "SELECT e.event_id, e.event_name, e.event_date, e.location, u.username " +
                    "FROM events e JOIN users u ON e.user_id = u.user_id";

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                System.out.println(
                        rs.getInt("event_id") + " | " +
                                rs.getString("event_name") + " | " +
                                rs.getDate("event_date") + " | " +
                                rs.getString("location") + " | Created By: " +
                                rs.getString("username")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // UPDATE EVENT
    @Override
    public void updateEvent(int id, String name) {
        try {
            String sql = "UPDATE events SET event_name=? WHERE event_id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setInt(2, id);
            ps.executeUpdate();
            System.out.println("Event Updated Successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DELETE EVENT
    @Override
    public void deleteEvent(int id) {
        try {
            String sql = "DELETE FROM events WHERE event_id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Event Deleted Successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}