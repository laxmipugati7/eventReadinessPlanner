package com.yourapp.dao;

public interface UserDAO {
    void register(String username, String password);
    boolean login(String username, String password);
}