package com.crowdService;

import java.util.List;

import org.hibernate.SessionFactory;

import com.crowd_Entities.Booking;

public interface BookingService {

    void saveBooking(SessionFactory sessionFactory);

    //void getBooking(SessionFactory sessionFactory,int id);

    List<Booking> getAllBookings(SessionFactory sessionFactory); 

    //void updateBooking(SessionFactory sessionFactory);

    int deleteBooking(SessionFactory sessionFactory,int id);

	Booking getBooking(SessionFactory sessionFactory, int id);

	int updateBooking(SessionFactory sessionFactory, int id);
}
