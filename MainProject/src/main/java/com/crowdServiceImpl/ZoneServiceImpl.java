package com.crowdServiceImpl;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.crowdService.ZoneService;
import com.crowd_Entities.Venue;
import com.crowd_Entities.Zone;

public class ZoneServiceImpl implements ZoneService {

    Session session;
    Transaction transaction;

    Scanner sc = new Scanner(System.in);

    Zone zone = null;

    // SAVE
    @Override
    public void saveZone(SessionFactory sessionFactory) {

        session = sessionFactory.openSession();

        transaction = session.beginTransaction();

        zone = new Zone();

        System.out.println("Enter Venue ID:");

        Integer venueId = sc.nextInt();

        Venue venue = session.find(Venue.class, venueId);

        sc.nextLine();

        System.out.println("Enter Zone Name:");

        String zoneName = sc.nextLine();

        System.out.println("Enter Max Capacity:");

        int maxCapacity = sc.nextInt();

        System.out.println("Enter Current Count:");

        int currentCount = sc.nextInt();

        sc.nextLine();

        //System.out.println("Enter Zone Type:");

        //String zoneType = sc.nextLine();

        zone.setVenue(venue);
        zone.setZoneName(zoneName);
        zone.setMaxCapacity(maxCapacity);
        zone.setCurrentCount(currentCount);
        //zone.setZoneType(zoneType);

        session.persist(zone);

        transaction.commit();

        session.close();

        System.out.println("Zone Saved Successfully");
    }

    // GET SINGLE
    @Override
    public void getZone(SessionFactory sessionFactory) {

        session = sessionFactory.openSession();

        System.out.println("Enter Zone ID:");

        Integer id = sc.nextInt();

        zone = session.find(Zone.class, id);

        System.out.println(zone);

        session.close();
    }

    // GET ALL
    @Override
    public void getAllZones(SessionFactory sessionFactory) {

        session = sessionFactory.openSession();

        Query<Zone> query =
                session.createQuery("from Zone", Zone.class);

        List<Zone> zoneList = query.getResultList();

        for(Zone z : zoneList) {

            System.out.println(z);
        }

        session.close();
    }

    // UPDATE
    @Override
    public void updateZone(SessionFactory sessionFactory) {

        session = sessionFactory.openSession();

        transaction = session.beginTransaction();

        System.out.println("Enter Zone ID:");

        Integer id = sc.nextInt();

        sc.nextLine();

        zone = session.find(Zone.class, id);

        System.out.println("Choose Option");
        System.out.println("1.Zone Name");
        System.out.println("2.Max Capacity");
        System.out.println("3.Current Count");
        //System.out.println("4.Zone Type");

        int choice = sc.nextInt();

        sc.nextLine();

        switch(choice) {

        case 1:

            System.out.println("Enter New Zone Name:");

            zone.setZoneName(sc.nextLine());

            break;

        case 2:

            System.out.println("Enter New Max Capacity:");

            zone.setMaxCapacity(sc.nextInt());

            break;

        case 3:

            System.out.println("Enter New Current Count:");

            zone.setCurrentCount(sc.nextInt());

            break;

//        case 4:
//
//            sc.nextLine();
//
//            System.out.println("Enter New Zone Type:");
//
//            //zone.setZoneType(sc.nextLine());
//
//            break;

        default:

            System.out.println("Choose Valid Option");
        }

        transaction.commit();

        session.close();

        System.out.println("Zone Updated Successfully");
    }

    // DELETE
    @Override
    public void deleteZone(SessionFactory sessionFactory) {

        session = sessionFactory.openSession();

        transaction = session.beginTransaction();

        System.out.println("Enter Zone ID:");

        Integer id = sc.nextInt();

        zone = session.find(Zone.class, id);

        session.remove(zone);

        transaction.commit();

        session.close();

        System.out.println("Zone Deleted Successfully");
    }
}
