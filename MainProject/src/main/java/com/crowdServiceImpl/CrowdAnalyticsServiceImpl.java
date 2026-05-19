package com.crowdServiceImpl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.crowdService.CrowdAnalyticsService;
import com.crowd_Entities.Crowd_analytics;
import com.crowd_Entities.Venue;
import com.crowd_Entities.Zone;

public class CrowdAnalyticsServiceImpl implements CrowdAnalyticsService {

    Session session;
    Transaction transaction;

    Scanner sc = new Scanner(System.in);

    Crowd_analytics analytics = null;

    // SAVE
    @Override
    public void saveCrowdAnalytics(SessionFactory sessionFactory) {

        session = sessionFactory.openSession();

        transaction = session.beginTransaction();

        analytics = new Crowd_analytics();

        System.out.println("Enter Venue ID:");

        Integer venueId = sc.nextInt();

        Venue venue = session.find(Venue.class, venueId);

        System.out.println("Enter Zone ID:");

        Integer zoneId = sc.nextInt();

        Zone zone = session.find(Zone.class, zoneId);

        sc.nextLine();

        System.out.println("Enter Record Date (YYYY-MM-DD):");

        LocalDate recordDate = LocalDate.parse(sc.nextLine());

        System.out.println("Enter Peak Hour Start (HH:MM):");

        LocalTime peakStart = LocalTime.parse(sc.nextLine());

        System.out.println("Enter Peak Hour End (HH:MM):");

        LocalTime peakEnd = LocalTime.parse(sc.nextLine());

        System.out.println("Enter Peak Count:");

        Integer peakCount = sc.nextInt();

        System.out.println("Enter Average Occupancy Percentage:");

        Double avgOccupancy = sc.nextDouble();

        analytics.setVenue(venue);

        analytics.setZone(zone);

        analytics.setRecordDate(recordDate);

        analytics.setPeakHourStart(peakStart);

        analytics.setPeakHourEnd(peakEnd);

        analytics.setPeakCount(peakCount);

        analytics.setAvgOccupancyPct(avgOccupancy);

        session.persist(analytics);

        transaction.commit();

        session.close();

        System.out.println("Crowd Analytics Saved Successfully");
    }

    // GET SINGLE
    @Override
    public void getCrowdAnalytics(SessionFactory sessionFactory) {

        session = sessionFactory.openSession();

        System.out.println("Enter Analytics ID:");

        Integer id = sc.nextInt();

        analytics = session.find(Crowd_analytics.class, id);

        System.out.println(analytics);

        session.close();
    }

    // GET ALL
    @Override
    public void getAllCrowdAnalytics(SessionFactory sessionFactory) {

        session = sessionFactory.openSession();

        Query<Crowd_analytics> query =
                session.createQuery("from Crowd_analytics", Crowd_analytics.class);

        List<Crowd_analytics> analyticsList = query.getResultList();

        for(Crowd_analytics c : analyticsList) {

            System.out.println(c);
        }

        session.close();
    }

    // UPDATE
    @Override
    public void updateCrowdAnalytics(SessionFactory sessionFactory) {

        session = sessionFactory.openSession();

        transaction = session.beginTransaction();

        System.out.println("Enter Analytics ID:");

        Integer id = sc.nextInt();

        analytics = session.find(Crowd_analytics.class, id);

        System.out.println("Choose Option");
        System.out.println("1.Peak Count");
        System.out.println("2.Average Occupancy Percentage");

        int choice = sc.nextInt();

        switch(choice) {

        case 1:

            System.out.println("Enter New Peak Count:");

            analytics.setPeakCount(sc.nextInt());

            break;

        case 2:

            System.out.println("Enter New Average Occupancy:");

            analytics.setAvgOccupancyPct(sc.nextDouble());

            break;

        default:

            System.out.println("Choose Valid Option");
        }

        transaction.commit();

        session.close();

        System.out.println("Crowd Analytics Updated Successfully");
    }

    // DELETE
    @Override
    public void deleteCrowdAnalytics(SessionFactory sessionFactory) {

        session = sessionFactory.openSession();

        transaction = session.beginTransaction();

        System.out.println("Enter Analytics ID:");

        Integer id = sc.nextInt();

        analytics = session.find(Crowd_analytics.class, id);

        session.remove(analytics);

        transaction.commit();

        session.close();

        System.out.println("Crowd Analytics Deleted Successfully");
    }
}