package com.yourapp.dao;

import com.yourapp.bean.Coordinator;

public interface CoordinatorDAO {

    void addCoordinator(Coordinator coordinator);

    void viewCoordinators();

    void updateCoordinator(int coordinatorId, String coordinatorName);

    void deleteCoordinator(int coordinatorId);
}