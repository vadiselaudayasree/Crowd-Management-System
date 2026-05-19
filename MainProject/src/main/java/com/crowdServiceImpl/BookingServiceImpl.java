package com.crowdServiceImpl;

import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.List;

import org.hibernate.query.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.crowdBusiness.BookingBusinessLogic;
import com.crowdService.BookingService;

import com.crowd_Entities.Booking;
import com.crowd_Entities.Time_slot;
import com.crowd_Entities.Visitor;
import com.crowd_Entities.Zone;

public class BookingServiceImpl
        implements BookingService {

    Session session;

    Transaction transaction;

    Scanner sc = new Scanner(System.in);

    @Override
    public void saveBooking(SessionFactory sessionFactory) {

        session = sessionFactory.openSession();

        transaction = session.beginTransaction();

        Booking booking = new Booking();

        // VISITOR
        System.out.println("Enter Visitor ID:");

        int visitorId = sc.nextInt();

        Visitor visitor =
                session.find(Visitor.class, visitorId);

        if(visitor == null) {

            System.out.println(
                    "Visitor ID Not Found");

            session.close();

            return;
        }

        // SLOT
        System.out.println("Enter Slot ID:");

        int slotId = sc.nextInt();

        Time_slot slot =
                session.find(Time_slot.class, slotId);

        if(slot == null) {

            System.out.println(
                    "Slot ID Not Found");

            session.close();

            return;
        }

        // ZONE
        System.out.println("Enter Zone ID:");

        int zoneId = sc.nextInt();

        Zone zone =
                session.find(Zone.class, zoneId);

        if(zone == null) {

            System.out.println(
                    "Zone ID Not Found");

            session.close();

            return;
        }

        sc.nextLine();

        System.out.println("Enter Status:");

        String status = sc.nextLine();

        System.out.println(
                "Enter Booking Reference:");

        String ref = sc.nextLine();

        // SET VALUES
        booking.setVisitor(visitor);

        booking.setTimeSlot(slot);

        booking.setZone(zone);

        booking.setStatus(status);

        booking.setBookingRef(ref);

        booking.setBookedAt(
                LocalDateTime.now());

        // BUSINESS LOGIC
        if(!BookingBusinessLogic
                .isSlotAvailable(slot)) {

            System.out.println(
                    "Slot Full");

            session.close();

            return;
        }

        if(!BookingBusinessLogic
                .isZoneAvailable(zone)) {

            System.out.println(
                    "Zone Full");

            session.close();

            return;
        }

        BookingBusinessLogic
                .updateCounts(slot, zone);

        // SAVE
        session.persist(booking);

        transaction.commit();

        session.close();

        System.out.println(
                "Booking Saved Successfully");
    }

    @Override
    public Booking getBooking(SessionFactory sessionFactory,
                              int id) {

        session = sessionFactory.openSession();

        Booking booking =
                session.find(Booking.class, id);

        session.close();

        return booking;
    }

    @Override
    public List<Booking> getAllBookings(
            SessionFactory sessionFactory) {

        session = sessionFactory.openSession();

        Query<Booking> query =
                session.createQuery(
                        "from Booking",
                        Booking.class);

        List<Booking> list =
                query.getResultList();

        session.close();

        return list;
    }

    @Override
    public int updateBooking(SessionFactory sessionFactory,
                             int id) {

        return 1;
    }

    @Override
    public int deleteBooking(SessionFactory sessionFactory,
                             int id) {

        session = sessionFactory.openSession();

        transaction = session.beginTransaction();

        Booking booking =
                session.find(Booking.class, id);

        session.remove(booking);

        transaction.commit();

        session.close();

        return 1;
    }
}