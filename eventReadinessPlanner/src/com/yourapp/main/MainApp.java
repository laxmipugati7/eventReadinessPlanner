//package com.yourapp.main;
//
//import com.yourapp.daoimpl.*;
//import com.yourapp.bean.Event;
//import java.sql.Date;
//import java.util.Scanner;
//
//public class MainApp {
//
//    public static void main(String[] args) {
//
//        Scanner sc = new Scanner(System.in);
//        UserDAOImpl userDAO = new UserDAOImpl();
//        EventDAOImpl eventDAO = new EventDAOImpl();
//
//        int choice;
//
//        do {
//            System.out.println("\n===== Event Readiness Planner =====");
//            System.out.println("1. Register");
//            System.out.println("2. Login");
//            System.out.println("3. Add Event");
//            System.out.println("4. View Events");
//            System.out.println("5. Update Event");
//            System.out.println("6. Delete Event");
//            System.out.println("7. Exit");
//
//            choice = sc.nextInt();
//
//            switch(choice) {
//
//                case 1:
//                    System.out.print("Username: ");
//                    String u = sc.next();
//                    System.out.print("Password: ");
//                    String p = sc.next();
//                    userDAO.register(u,p);
//                    break;
//
//                case 2:
//                    System.out.print("Username: ");
//                    String lu = sc.next();
//                    System.out.print("Password: ");
//                    String lp = sc.next();
//                    if(userDAO.login(lu,lp))
//                        System.out.println("Login Successful!");
//                    else
//                        System.out.println("Invalid Credentials!");
//                    break;
//
//                case 3:
//                    sc.nextLine();
//                    System.out.print("Event Name: ");
//                    String name = sc.nextLine();
//                    System.out.print("Date (yyyy-mm-dd): ");
//                    String date = sc.next();
//                    System.out.print("Location: ");
//                    sc.nextLine();
//                    String loc = sc.nextLine();
//                    System.out.print("User ID: ");
//                    int uid = sc.nextInt();
//
//                    Event event = new Event(name, Date.valueOf(date), loc, uid);
//                    eventDAO.addEvent(event);
//                    break;
//
//                case 4:
//                    eventDAO.viewEvents();
//                    break;
//
//                case 5:
//                    System.out.print("Event ID: ");
//                    int id = sc.nextInt();
//                    sc.nextLine();
//                    System.out.print("New Name: ");
//                    String newName = sc.nextLine();
//                    eventDAO.updateEvent(id,newName);
//                    break;
//
//                case 6:
//                    System.out.print("Event ID: ");
//                    int delId = sc.nextInt();
//                    eventDAO.deleteEvent(delId);
//                    break;
//
//                case 7:
//                    System.out.println("Thank You!");
//                    break;
//            }
//
//        } while(choice != 7);
//    }
//}

package com.yourapp.main;

import com.yourapp.daoimpl.*;
import com.yourapp.bean.*;

import java.sql.Date;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        UserDAOImpl userDAO = new UserDAOImpl();
        EventDAOImpl eventDAO = new EventDAOImpl();
        VenueDAOImpl venueDAO = new VenueDAOImpl();
        ManagerDAOImpl managerDAO = new ManagerDAOImpl();
        CoordinatorDAOImpl coordinatorDAO = new CoordinatorDAOImpl();

        int choice;

        do {
            System.out.println("\n===== Event Readiness Planner =====");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Add Event");
            System.out.println("4. View Events");
            System.out.println("5. Manage Venues");
            System.out.println("6. Manage Managers");
            System.out.println("7. Manage Coordinators");
            System.out.println("8. Update Event");
            System.out.println("9. Delete Event");
            System.out.println("10. Exit");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Username: ");
                    String u = sc.next();
                    System.out.print("Password: ");
                    String p = sc.next();
                    userDAO.register(u, p);
                    break;

                case 2:
                    System.out.print("Username: ");
                    String lu = sc.next();
                    System.out.print("Password: ");
                    String lp = sc.next();
                    if (userDAO.login(lu, lp))
                        System.out.println("Login Successful!");
                    else
                        System.out.println("Invalid Credentials!");
                    break;

                case 3:
                    sc.nextLine();
                    System.out.print("Event Name: ");
                    String name = sc.nextLine();

                    System.out.print("Date (yyyy-mm-dd): ");
                    String date = sc.next();

                    sc.nextLine();
                    System.out.print("Location: ");
                    String loc = sc.nextLine();

                    System.out.print("User ID: ");
                    int uid = sc.nextInt();

                    System.out.print("Venue ID: ");
                    int vid = sc.nextInt();

                    System.out.print("Coordinator ID: ");
                    int cid = sc.nextInt();

                    System.out.print("Manager ID: ");
                    int mid = sc.nextInt();

                    Event event = new Event(
                            name,
                            Date.valueOf(date),
                            loc,
                            uid,
                            vid,
                            cid,
                            mid
                    );

                    eventDAO.addEvent(event);
                    break;

                case 4:
                    eventDAO.viewEvents();
                    break;

                case 5:
                    System.out.println("1. Add Venue");
                    System.out.println("2. View Venues");
                    int vChoice = sc.nextInt();

                    if (vChoice == 1) {
                        sc.nextLine();
                        System.out.print("Venue Name: ");
                        String vName = sc.nextLine();
                        System.out.print("Location: ");
                        String vLoc = sc.nextLine();
                        System.out.print("Capacity: ");
                        int cap = sc.nextInt();

                        venueDAO.addVenue(new Venue(vName, vLoc, cap));
                    } else {
                        venueDAO.viewVenues();
                    }
                    break;

                case 6:
                    System.out.println("1. Add Manager");
                    System.out.println("2. View Managers");
                    int mChoice = sc.nextInt();

                    if (mChoice == 1) {
                        sc.nextLine();
                        System.out.print("Manager Name: ");
                        String mName = sc.nextLine();
                        System.out.print("Contact: ");
                        String mContact = sc.nextLine();

                        managerDAO.addManager(new Manager(mName, mContact));
                    } else {
                        managerDAO.viewManagers();
                    }
                    break;

                case 7:
                    System.out.println("1. Add Coordinator");
                    System.out.println("2. View Coordinators");
                    int cChoice = sc.nextInt();

                    if (cChoice == 1) {
                        sc.nextLine();
                        System.out.print("Coordinator Name: ");
                        String cName = sc.nextLine();
                        System.out.print("Contact: ");
                        String cContact = sc.nextLine();

                        coordinatorDAO.addCoordinator(new Coordinator(cName, cContact));
                    } else {
                        coordinatorDAO.viewCoordinators();
                    }
                    break;

                case 8:
                    System.out.print("Event ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("New Name: ");
                    String newName = sc.nextLine();
                    eventDAO.updateEvent(id, newName);
                    break;

                case 9:
                    System.out.print("Event ID: ");
                    int delId = sc.nextInt();
                    eventDAO.deleteEvent(delId);
                    break;

                case 10:
                    System.out.println("Thank You!");
                    break;
            }

        } while (choice != 10);

        sc.close();
    }
}