package com.yourapp.bean;

public class Manager {

    private int managerId;
    private String managerName;
    private String contact;

    public Manager() {}

    public Manager(String managerName, String contact) {
        this.managerName = managerName;
        this.contact = contact;
    }

    public int getManagerId() { return managerId; }
    public void setManagerId(int managerId) { this.managerId = managerId; }

    public String getManagerName() { return managerName; }
    public void setManagerName(String managerName) { this.managerName = managerName; }

    public String getContact() { return contact; }
    public void setContact(String contact) { this.contact = contact; }
}