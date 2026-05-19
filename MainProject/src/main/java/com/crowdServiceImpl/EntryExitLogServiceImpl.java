package com.crowdServiceImpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.crowdService.EntryExitLogService;
import com.crowd_Entities.Entry_exit_log;
import com.crowd_Entities.Venue;
import com.crowd_Entities.Visitor;
import com.crowd_Entities.Zone;

public class EntryExitLogServiceImpl implements EntryExitLogService {

    Session session;
    Transaction transaction;

    Scanner sc = new Scanner(System.in);

    Entry_exit_log entryLog = null;

    // SAVE
    @Override
    public void saveEntryExitLog(SessionFactory sessionFactory) {

        session = sessionFactory.openSession();

        transaction = session.beginTransaction();

        entryLog = new Entry_exit_log();

        System.out.println("Enter Visitor ID:");

        Integer visitorId = sc.nextInt();

        Visitor visitor = session.find(Visitor.class, visitorId);

        System.out.println("Enter Venue ID:");

        Integer venueId = sc.nextInt();

        Venue venue = session.find(Venue.class, venueId);

        System.out.println("Enter Zone ID:");

        Integer zoneId = sc.nextInt();

        Zone zone = session.find(Zone.class, zoneId);

        sc.nextLine();

        System.out.println("Enter Entry Method:");

        String entryMethod = sc.nextLine();

        entryLog.setVisitor(visitor);

        entryLog.setVenue(venue);

        entryLog.setZone(zone);

        entryLog.setEntryMethod(entryMethod);

        entryLog.setEntryTime(LocalDateTime.now());

        entryLog.setExitTime(null);

        session.persist(entryLog);

        transaction.commit();

        session.close();

        System.out.println("Entry Log Saved Successfully");
    }

    // GET SINGLE
    @Override
    public void getEntryExitLog(SessionFactory sessionFactory) {

        session = sessionFactory.openSession();

        System.out.println("Enter Entry Log ID:");

        Integer id = sc.nextInt();

        entryLog = session.find(Entry_exit_log.class, id);

        System.out.println(entryLog);

        session.close();
    }

    // GET ALL
    @Override
    public void getAllEntryExitLogs(SessionFactory sessionFactory) {

        session = sessionFactory.openSession();

        Query<Entry_exit_log> query =
                session.createQuery("from Entry_exit_log", Entry_exit_log.class);

        List<Entry_exit_log> logList = query.getResultList();

        for(Entry_exit_log e : logList) {

            System.out.println(e);
        }

        session.close();
    }

    // UPDATE
    @Override
    public void updateEntryExitLog(SessionFactory sessionFactory) {

        session = sessionFactory.openSession();

        transaction = session.beginTransaction();

        System.out.println("Enter Entry Log ID:");

        Integer id = sc.nextInt();

        sc.nextLine();

        entryLog = session.find(Entry_exit_log.class, id);

        System.out.println("Choose Option");
        System.out.println("1.Exit Time");
        System.out.println("2.Entry Method");

        int choice = sc.nextInt();

        sc.nextLine();

        switch(choice) {

        case 1:

            entryLog.setExitTime(LocalDateTime.now());

            break;

        case 2:

            System.out.println("Enter New Entry Method:");

            entryLog.setEntryMethod(sc.nextLine());

            break;

        default:

            System.out.println("Choose Valid Option");
        }

        transaction.commit();

        session.close();

        System.out.println("Entry Log Updated Successfully");
    }

    // DELETE
    @Override
    public void deleteEntryExitLog(SessionFactory sessionFactory) {

        session = sessionFactory.openSession();

        transaction = session.beginTransaction();

        System.out.println("Enter Entry Log ID:");

        Integer id = sc.nextInt();

        entryLog = session.find(Entry_exit_log.class, id);

        session.remove(entryLog);

        transaction.commit();

        session.close();

        System.out.println("Entry Log Deleted Successfully");
    }
}
