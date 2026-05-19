package com.crowdServiceImpl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.crowdService.TimeSlotService;
import com.crowd_Entities.Time_slot;
import com.crowd_Entities.Venue;

public class TimeSlotServiceImpl implements TimeSlotService {

    Session session;
    Transaction transaction;

    Scanner sc = new Scanner(System.in);

    Time_slot timeSlot = null;

    // SAVE
    @Override
    public void saveTimeSlot(SessionFactory sessionFactory) {

        session = sessionFactory.openSession();

        transaction = session.beginTransaction();

        timeSlot = new Time_slot();

        System.out.println("Enter Venue ID:");

        Integer venueId = sc.nextInt();

        Venue venue = session.find(Venue.class, venueId);

        sc.nextLine();

        System.out.println("Enter Slot Date (YYYY-MM-DD):");

        LocalDate slotDate = LocalDate.parse(sc.nextLine());

        System.out.println("Enter Start Time (HH:MM):");

        LocalTime startTime = LocalTime.parse(sc.nextLine());

        System.out.println("Enter End Time (HH:MM):");

        LocalTime endTime = LocalTime.parse(sc.nextLine());

        System.out.println("Enter Max Capacity:");

        int maxCapacity = sc.nextInt();

        System.out.println("Enter Booked Count:");

        int bookedCount = sc.nextInt();

        sc.nextLine();

        System.out.println("Enter Status:");

        String status = sc.nextLine();

        timeSlot.setVenue(venue);
        timeSlot.setSlotDate(slotDate);
        timeSlot.setStartTime(startTime);
        timeSlot.setEndTime(endTime);
        timeSlot.setMaxCapacity(maxCapacity);
        timeSlot.setBookedCount(bookedCount);
        timeSlot.setStatus(status);

        session.persist(timeSlot);

        transaction.commit();

        session.close();

        System.out.println("Time Slot Saved Successfully");
    }

    // GET SINGLE
    @Override
    public void getTimeSlot(SessionFactory sessionFactory) {

        session = sessionFactory.openSession();

        System.out.println("Enter Time Slot ID:");

        Integer id = sc.nextInt();

        timeSlot = session.find(Time_slot.class, id);

        System.out.println(timeSlot);

        session.close();
    }

    // GET ALL
    @Override
    public void getAllTimeSlots(SessionFactory sessionFactory) {

        session = sessionFactory.openSession();

        Query<Time_slot> query =
                session.createQuery("from Time_slot", Time_slot.class);

        List<Time_slot> slotList = query.getResultList();

        for(Time_slot t : slotList) {

            System.out.println(t);
        }

        session.close();
    }

    // UPDATE
    @Override
    public void updateTimeSlot(SessionFactory sessionFactory) {

        session = sessionFactory.openSession();

        transaction = session.beginTransaction();

        System.out.println("Enter Time Slot ID:");

        Integer id = sc.nextInt();

        sc.nextLine();

        timeSlot = session.find(Time_slot.class, id);

        System.out.println("Choose Option");
        System.out.println("1.Max Capacity");
        System.out.println("2.Booked Count");
        System.out.println("3.Status");

        int choice = sc.nextInt();

        sc.nextLine();

        switch(choice) {

        case 1:

            System.out.println("Enter New Max Capacity:");

            timeSlot.setMaxCapacity(sc.nextInt());

            break;

        case 2:

            System.out.println("Enter New Booked Count:");

            timeSlot.setBookedCount(sc.nextInt());

            break;

        case 3:

            sc.nextLine();

            System.out.println("Enter New Status:");

            timeSlot.setStatus(sc.nextLine());

            break;

        default:

            System.out.println("Choose Valid Option");
        }

        transaction.commit();

        session.close();

        System.out.println("Time Slot Updated Successfully");
    }

    // DELETE
    @Override
    public void deleteTimeSlot(SessionFactory sessionFactory) {

        session = sessionFactory.openSession();

        transaction = session.beginTransaction();

        System.out.println("Enter Time Slot ID:");

        Integer id = sc.nextInt();

        timeSlot = session.find(Time_slot.class, id);

        session.remove(timeSlot);

        transaction.commit();

        session.close();

        System.out.println("Time Slot Deleted Successfully");
    }
}