//package com.yourapp.bean;
//import java.sql.Date;
//
//public class Event {
//    private int eventId;
//    private String eventName;
//    private Date eventDate;
//    private String location;
//    private int userId;
//
//    public Event() {}
//
//    public Event(String eventName, Date eventDate, String location, int userId) {
//        this.eventName = eventName;
//        this.eventDate = eventDate;
//        this.location = location;
//        this.userId = userId;
//    }
//
//    public int getEventId() { return eventId; }
//    public void setEventId(int eventId) { this.eventId = eventId; }
//
//    public String getEventName() { return eventName; }
//    public void setEventName(String eventName) { this.eventName = eventName; }
//
//    public Date getEventDate() { return eventDate; }
//    public void setEventDate(Date eventDate) { this.eventDate = eventDate; }
//
//    public String getLocation() { return location; }
//    public void setLocation(String location) { this.location = location; }
//
//    public int getUserId() { return userId; }
//    public void setUserId(int userId) { this.userId = userId; }
//}

package com.yourapp.bean;

import java.sql.Date;

public class Event {

    private int eventId;
    private String eventName;
    private Date eventDate;
    private String location;
    private int userId;

    // NEW FIELDS
    private int managerId;
    private int venueId;
    private int coordinatorId;

    // Default Constructor
    public Event() {}

    // Constructor with all fields
    public Event(String eventName, Date eventDate, String location,
                 int userId, int managerId, int venueId, int coordinatorId) {

        this.eventName = eventName;
        this.eventDate = eventDate;
        this.location = location;
        this.userId = userId;
        this.managerId = managerId;
        this.venueId = venueId;
        this.coordinatorId = coordinatorId;
    }

    // GETTERS AND SETTERS

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    // NEW GETTERS & SETTERS

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public int getVenueId() {
        return venueId;
    }

    public void setVenueId(int venueId) {
        this.venueId = venueId;
    }

    public int getCoordinatorId() {
        return coordinatorId;
    }

    public void setCoordinatorId(int coordinatorId) {
        this.coordinatorId = coordinatorId;
    }
}