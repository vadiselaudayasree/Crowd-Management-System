package com.crowdServiceImpl;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.crowdService.VenueService;
import com.crowd_Entities.Venue;

public class VenueServiceImpl implements VenueService {

    Session session;
    Transaction transaction;

    Scanner sc = new Scanner(System.in);

    Venue venue = null;

    // SAVE
    @Override
    public void saveVenue(SessionFactory sessionFactory) {

        session = sessionFactory.openSession();

        transaction = session.beginTransaction();

        venue = new Venue();

        System.out.println("Enter Venue Details");

        System.out.println("Enter Venue Name:");
        String name = sc.nextLine();

        System.out.println("Enter Location:");
        String location = sc.nextLine();

        System.out.println("Enter Total Capacity:");
        int totalCapacity = sc.nextInt();

        sc.nextLine();

//        System.out.println("Enter Venue Type:");
//        String venueType = sc.nextLine();

        System.out.println("Enter Contact Info:");
        String contactInfo = sc.nextLine();

        venue.setName(name);
        venue.setLocation(location);
        venue.setTotalCapacity(totalCapacity);
        //venue.setVenueType(venueType);
        venue.setContactInfo(contactInfo);

        session.persist(venue);

        transaction.commit();

        session.close();

        System.out.println("Venue Saved Successfully");
    }

    // GET SINGLE
    @Override
    public void getVenue(SessionFactory sessionFactory) {

        session = sessionFactory.openSession();

        System.out.println("Enter Venue ID:");

        Integer id = sc.nextInt();

        venue = session.find(Venue.class, id);

        System.out.println(venue);

        session.close();
    }

    // GET ALL
    @Override
    public void getAllVenues(SessionFactory sessionFactory) {

        session = sessionFactory.openSession();

        Query<Venue> query =
                session.createQuery("from Venue", Venue.class);

        List<Venue> venueList = query.getResultList();

        for(Venue v : venueList) {
            System.out.println(v);
        }

        session.close();
    }

    // UPDATE
    @Override
    public void updateVenue(SessionFactory sessionFactory) {

        session = sessionFactory.openSession();

        transaction = session.beginTransaction();

        System.out.println("Enter Venue ID:");

        Integer id = sc.nextInt();

        sc.nextLine();

        venue = session.find(Venue.class, id);

        System.out.println("Choose Option");
        System.out.println("1.Name");
        System.out.println("2.Location");
        System.out.println("3.Total Capacity");
        //System.out.println("4.Venue Type");
        System.out.println("5.Contact Info");

        int choice = sc.nextInt();

        sc.nextLine();

        switch(choice) {

        case 1:

            System.out.println("Enter New Name:");

            venue.setName(sc.nextLine());

            break;

        case 2:

            System.out.println("Enter New Location:");

            venue.setLocation(sc.nextLine());

            break;

        case 3:

            System.out.println("Enter New Capacity:");

            venue.setTotalCapacity(sc.nextInt());

            break;

//        case 4:
//
//            sc.nextLine();
//
//            System.out.println("Enter New Venue Type:");
//
//            //venue.setVenueType(sc.nextLine());
//
//            break;

        case 4:

            System.out.println("Enter New Contact Info:");

            venue.setContactInfo(sc.nextLine());

            break;

        default:

            System.out.println("Choose Valid Option");
        }

        transaction.commit();

        session.close();

        System.out.println("Venue Updated Successfully");
    }

    // DELETE
    @Override
    public void deleteVenue(SessionFactory sessionFactory) {

        session = sessionFactory.openSession();

        transaction = session.beginTransaction();

        System.out.println("Enter Venue ID:");

        Integer id = sc.nextInt();

        venue = session.find(Venue.class, id);

        session.remove(venue);

        transaction.commit();

        session.close();

        System.out.println("Venue Deleted Successfully");
    }
}
