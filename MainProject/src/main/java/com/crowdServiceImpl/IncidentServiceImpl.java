package com.crowdServiceImpl;

//import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.crowdService.IncidentService;
import com.crowd_Entities.Incident;
import com.crowd_Entities.Staff;
import com.crowd_Entities.Venue;
import com.crowd_Entities.Zone;

public class IncidentServiceImpl implements IncidentService {

    Session session;
    Transaction transaction;

    Scanner sc = new Scanner(System.in);

    Incident incident = null;

    // SAVE
    @Override
    public void saveIncident(SessionFactory sessionFactory) {

        session = sessionFactory.openSession();

        transaction = session.beginTransaction();

        incident = new Incident();

        System.out.println("Enter Venue ID:");

        Integer venueId = sc.nextInt();

        Venue venue = session.find(Venue.class, venueId);

        System.out.println("Enter Zone ID:");

        Integer zoneId = sc.nextInt();

        Zone zone = session.find(Zone.class, zoneId);

        System.out.println("Enter Staff ID:");

        Integer staffId = sc.nextInt();

        Staff staff = session.find(Staff.class, staffId);

        sc.nextLine();

        System.out.println("Enter Incident Type:");

        String incidentType = sc.nextLine();

//        System.out.println("Enter Severity:");
//
//        String severity = sc.nextLine();
//
//        System.out.println("Enter Description:");
//
//        String description = sc.nextLine();
//
//        System.out.println("Enter Resolution:");
//
//        String resolution = sc.nextLine();

        incident.setVenue(venue);

        incident.setZone(zone);

        incident.setStaff(staff);

        incident.setIncidentType(incidentType);

        //incident.setSeverity(severity);

        //incident.setDescription(description);

        //incident.setResolution(resolution);

        //incident.setReportedAt(LocalDateTime.now());

        session.persist(incident);

        transaction.commit();

        session.close();

        System.out.println("Incident Saved Successfully");
    }

    // GET SINGLE
    @Override
    public void getIncident(SessionFactory sessionFactory) {

        session = sessionFactory.openSession();

        System.out.println("Enter Incident ID:");

        Integer id = sc.nextInt();

        incident = session.find(Incident.class, id);

        System.out.println(incident);

        session.close();
    }

    // GET ALL
    @Override
    public void getAllIncidents(SessionFactory sessionFactory) {

        session = sessionFactory.openSession();

        Query<Incident> query =
                session.createQuery("from Incident", Incident.class);

        List<Incident> incidentList = query.getResultList();

        for(Incident i : incidentList) {

            System.out.println(i);
        }

        session.close();
    }

    // UPDATE
    @Override
    public void updateIncident(SessionFactory sessionFactory) {

        session = sessionFactory.openSession();

        transaction = session.beginTransaction();

        System.out.println("Enter Incident ID:");

        Integer id = sc.nextInt();

        sc.nextLine();

        incident = session.find(Incident.class, id);

        System.out.println("Choose Option");
        System.out.println("1.Incident Type");
//        System.out.println("2.Severity");
//        System.out.println("3.Description");
//        System.out.println("4.Resolution");

        int choice = sc.nextInt();

        sc.nextLine();

        switch(choice) {

        case 1:

            System.out.println("Enter New Incident Type:");

            incident.setIncidentType(sc.nextLine());

            break;

//        case 2:
//
//            //System.out.println("Enter New Severity:");
//
//            //incident.setSeverity(sc.nextLine());
//
//            break;

//        case 2:
//
//            System.out.println("Enter New Description:");
//
//            incident.setDescription(sc.nextLine());
//
//            break;

//        case 4:
//
//            System.out.println("Enter New Resolution:");
//
//            incident.setResolution(sc.nextLine());
//
//            break;

        default:

            System.out.println("Choose Valid Option");
        }

        transaction.commit();

        session.close();

        System.out.println("Incident Updated Successfully");
    }

    // DELETE
    @Override
    public void deleteIncident(SessionFactory sessionFactory) {

        session = sessionFactory.openSession();

        transaction = session.beginTransaction();

        System.out.println("Enter Incident ID:");

        Integer id = sc.nextInt();

        incident = session.find(Incident.class, id);

        session.remove(incident);

        transaction.commit();

        session.close();

        System.out.println("Incident Deleted Successfully");
    }
}