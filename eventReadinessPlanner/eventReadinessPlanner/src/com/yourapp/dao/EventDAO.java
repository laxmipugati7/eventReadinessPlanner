package com.yourapp.dao;
import com.yourapp.bean.Event;
import java.util.List;

public interface EventDAO {
    void addEvent(Event event);
    void viewEvents();
    void updateEvent(int id, String name);
    void deleteEvent(int id);
}