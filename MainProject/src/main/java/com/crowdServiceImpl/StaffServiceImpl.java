package com.crowdServiceImpl;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.crowdService.StaffService;
import com.crowd_Entities.Staff;
import com.crowd_Entities.Venue;

public class StaffServiceImpl implements StaffService {

    Session session;
    Transaction transaction;

    Scanner sc = new Scanner(System.in);

    Staff staff = null;

    // SAVE
    @Override
    public void saveStaff(SessionFactory sessionFactory) {

        session = sessionFactory.openSession();

        transaction = session.beginTransaction();

        staff = new Staff();

        System.out.println("Enter Venue ID:");

        Integer venueId = sc.nextInt();

        Venue venue = session.find(Venue.class, venueId);

        sc.nextLine();

        System.out.println("Enter Full Name:");

        String fullName = sc.nextLine();

        System.out.println("Enter Role:");

        String role = sc.nextLine();

        System.out.println("Enter Contact:");

        String contact = sc.nextLine();

        System.out.println("Enter Shift:");

        String shift = sc.nextLine();

        staff.setVenue(venue);

        staff.setFullName(fullName);

        staff.setRole(role);

        staff.setContact(contact);

        staff.setShift(shift);

        session.persist(staff);

        transaction.commit();

        session.close();

        System.out.println("Staff Saved Successfully");
    }

    // GET SINGLE
    @Override
    public void getStaff(SessionFactory sessionFactory) {

        session = sessionFactory.openSession();

        System.out.println("Enter Staff ID:");

        Integer id = sc.nextInt();

        staff = session.find(Staff.class, id);

        System.out.println(staff);

        session.close();
    }

    // GET ALL
    @Override
    public void getAllStaff(SessionFactory sessionFactory) {

        session = sessionFactory.openSession();

        Query<Staff> query =
                session.createQuery("from Staff", Staff.class);

        List<Staff> staffList = query.getResultList();

        for(Staff s : staffList) {

            System.out.println(s);
        }

        session.close();
    }

    // UPDATE
    @Override
    public void updateStaff(SessionFactory sessionFactory) {

        session = sessionFactory.openSession();

        transaction = session.beginTransaction();

        System.out.println("Enter Staff ID:");

        Integer id = sc.nextInt();

        sc.nextLine();

        staff = session.find(Staff.class, id);

        System.out.println("Choose Option");
        System.out.println("1.Full Name");
        System.out.println("2.Role");
        System.out.println("3.Contact");
        System.out.println("4.Shift");

        int choice = sc.nextInt();

        sc.nextLine();

        switch(choice) {

        case 1:

            System.out.println("Enter New Full Name:");

            staff.setFullName(sc.nextLine());

            break;

        case 2:

            System.out.println("Enter New Role:");

            staff.setRole(sc.nextLine());

            break;

        case 3:

            System.out.println("Enter New Contact:");

            staff.setContact(sc.nextLine());

            break;

        case 4:

            System.out.println("Enter New Shift:");

            staff.setShift(sc.nextLine());

            break;

        default:

            System.out.println("Choose Valid Option");
        }

        transaction.commit();

        session.close();

        System.out.println("Staff Updated Successfully");
    }

    // DELETE
    @Override
    public void deleteStaff(SessionFactory sessionFactory) {

        session = sessionFactory.openSession();

        transaction = session.beginTransaction();

        System.out.println("Enter Staff ID:");

        Integer id = sc.nextInt();

        staff = session.find(Staff.class, id);

        session.remove(staff);

        transaction.commit();

        session.close();

        System.out.println("Staff Deleted Successfully");
    }
}