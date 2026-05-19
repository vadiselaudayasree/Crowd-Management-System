package com.crowdServiceImpl;

//import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.crowdService.NotificationService;
import com.crowd_Entities.Booking;
import com.crowd_Entities.Notification;
import com.crowd_Entities.Visitor;

public class NotificationServiceImpl implements NotificationService {

    Session session;
    Transaction transaction;

    Scanner sc = new Scanner(System.in);

    Notification notification = null;

    // SAVE
    @Override
    public void saveNotification(SessionFactory sessionFactory) {

        session = sessionFactory.openSession();

        transaction = session.beginTransaction();

        notification = new Notification();

        System.out.println("Enter Visitor ID:");

        Integer visitorId = sc.nextInt();

        Visitor visitor = session.find(Visitor.class, visitorId);

        System.out.println("Enter Booking ID:");

        Integer bookingId = sc.nextInt();

        Booking booking = session.find(Booking.class, bookingId);

        sc.nextLine();

        System.out.println("Enter Notification Type:");

        String type = sc.nextLine();

//        System.out.println("Enter Channel:");
//
//        String channel = sc.nextLine();

        System.out.println("Enter Message:");

        String message = sc.nextLine();

        System.out.println("Enter Status:");

        String status = sc.nextLine();

        notification.setVisitor(visitor);

        notification.setBooking(booking);

        notification.setType(type);

        //notification.setChannel(channel);

        notification.setMessage(message);

        notification.setStatus(status);

        //notification.setSentAt(LocalDateTime.now());

        session.persist(notification);

        transaction.commit();

        session.close();

        System.out.println("Notification Saved Successfully");
    }

    // GET SINGLE
    @Override
    public void getNotification(SessionFactory sessionFactory) {

        session = sessionFactory.openSession();

        System.out.println("Enter Notification ID:");

        Integer id = sc.nextInt();

        notification = session.find(Notification.class, id);

        System.out.println(notification);

        session.close();
    }

    // GET ALL
    @Override
    public void getAllNotifications(SessionFactory sessionFactory) {

        session = sessionFactory.openSession();

        Query<Notification> query =
                session.createQuery("from Notification", Notification.class);

        List<Notification> notificationList = query.getResultList();

        for(Notification n : notificationList) {

            System.out.println(n);
        }

        session.close();
    }

    // UPDATE
    @Override
    public void updateNotification(SessionFactory sessionFactory) {

        session = sessionFactory.openSession();

        transaction = session.beginTransaction();

        System.out.println("Enter Notification ID:");

        Integer id = sc.nextInt();

        sc.nextLine();

        notification = session.find(Notification.class, id);

        System.out.println("Choose Option");
        System.out.println("1.Type");
        System.out.println("2.Channel");
        System.out.println("3.Message");
        System.out.println("4.Status");

        int choice = sc.nextInt();

        sc.nextLine();

        switch(choice) {

        case 1:

            System.out.println("Enter New Type:");

            notification.setType(sc.nextLine());

            break;

        case 2:

            System.out.println("Enter New Channel:");

            //notification.setChannel(sc.nextLine());

            break;

        case 3:

            System.out.println("Enter New Message:");

            notification.setMessage(sc.nextLine());

            break;

        case 4:

            System.out.println("Enter New Status:");

            notification.setStatus(sc.nextLine());

            break;

        default:

            System.out.println("Choose Valid Option");
        }

        transaction.commit();

        session.close();

        System.out.println("Notification Updated Successfully");
    }

    // DELETE
    @Override
    public void deleteNotification(SessionFactory sessionFactory) {

        session = sessionFactory.openSession();

        transaction = session.beginTransaction();

        System.out.println("Enter Notification ID:");

        Integer id = sc.nextInt();

        notification = session.find(Notification.class, id);

        session.remove(notification);

        transaction.commit();

        session.close();

        System.out.println("Notification Deleted Successfully");
    }
}