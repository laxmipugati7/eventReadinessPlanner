package com.yourapp.main;

import com.yourapp.daoimpl.*;
import com.yourapp.bean.Event;
import java.sql.Date;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        UserDAOImpl userDAO = new UserDAOImpl();
        EventDAOImpl eventDAO = new EventDAOImpl();

        int choice;

        do {
            System.out.println("\n===== Event Readiness Planner =====");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Add Event");
            System.out.println("4. View Events");
            System.out.println("5. Update Event");
            System.out.println("6. Delete Event");
            System.out.println("7. Exit");

            choice = sc.nextInt();

            switch(choice) {

                case 1:
                    System.out.print("Username: ");
                    String u = sc.next();
                    System.out.print("Password: ");
                    String p = sc.next();
                    userDAO.register(u,p);
                    break;

                case 2:
                    System.out.print("Username: ");
                    String lu = sc.next();
                    System.out.print("Password: ");
                    String lp = sc.next();
                    if(userDAO.login(lu,lp))
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
                    System.out.print("Location: ");
                    sc.nextLine();
                    String loc = sc.nextLine();
                    System.out.print("User ID: ");
                    int uid = sc.nextInt();

                    Event event = new Event(name, Date.valueOf(date), loc, uid);
                    eventDAO.addEvent(event);
                    break;

                case 4:
                    eventDAO.viewEvents();
                    break;

                case 5:
                    System.out.print("Event ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("New Name: ");
                    String newName = sc.nextLine();
                    eventDAO.updateEvent(id,newName);
                    break;

                case 6:
                    System.out.print("Event ID: ");
                    int delId = sc.nextInt();
                    eventDAO.deleteEvent(delId);
                    break;

                case 7:
                    System.out.println("Thank You!");
                    break;
            }

        } while(choice != 7);
    }
}