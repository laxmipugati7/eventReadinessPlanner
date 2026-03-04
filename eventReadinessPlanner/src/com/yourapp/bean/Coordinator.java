//package com.yourapp.bean;
//
//public class Coordinator {
//
//    private int coordinatorId;
//    private String coordinatorName;
//    private String phone;
//
//    public int getCoordinatorId() { return coordinatorId; }
//    public void setCoordinatorId(int coordinatorId) { this.coordinatorId = coordinatorId; }
//
//    public String getCoordinatorName() { return coordinatorName; }
//    public void setCoordinatorName(String coordinatorName) { this.coordinatorName = coordinatorName; }
//
//    public String getPhone() { return phone; }
//    public void setPhone(String phone) { this.phone = phone; }
//}

package com.yourapp.bean;

public class Coordinator {

    private int coordinatorId;
    private String coordinatorName;
    private String contact;

    // Default Constructor
    public Coordinator() {}

    // Parameterized Constructor
    public Coordinator(String coordinatorName, String contact) {
        this.coordinatorName = coordinatorName;
        this.contact = contact;
    }

    // Getters and Setters

    public int getCoordinatorId() {
        return coordinatorId;
    }

    public void setCoordinatorId(int coordinatorId) {
        this.coordinatorId = coordinatorId;
    }

    public String getCoordinatorName() {
        return coordinatorName;
    }

    public void setCoordinatorName(String coordinatorName) {
        this.coordinatorName = coordinatorName;
    }

    // ⭐ THIS WAS MISSING
    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}