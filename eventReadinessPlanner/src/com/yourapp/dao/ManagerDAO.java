package com.yourapp.dao;

import com.yourapp.bean.Manager;

public interface ManagerDAO {

    void addManager(Manager manager);

    void viewManagers();

    void updateManager(int managerId, String managerName);

    void deleteManager(int managerId);
}