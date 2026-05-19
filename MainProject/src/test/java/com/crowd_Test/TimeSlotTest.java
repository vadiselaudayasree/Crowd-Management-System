package com.crowd_Test;

import static org.junit.jupiter.api.Assertions.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;

import com.crowd_Entities.*;

public class TimeSlotTest {

	SessionFactory sf = Config.getSessionFactory();

	@Test
	void testSaveTimeSlot() {

	    Session session = sf.openSession();
	    session.beginTransaction();

	    // FIRST create venue
	    Venue venue = new Venue();
	    venue.setName("Slot Venue");
	    venue.setLocation("City");
	    venue.setContactInfo("999");
	    venue.setTotalCapacity(200);
	    //venue.setVenueType("Temple");

	    session.persist(venue);

	    // THEN create time slot
	    Time_slot slot = new Time_slot();
	    slot.setVenue(venue);
	    slot.setBookedCount(0);
	    slot.setMaxCapacity(200);
	    slot.setStatus("Available");

	    session.persist(slot);

	    session.getTransaction().commit();

	    assertNotNull(slot.getId());

	    System.out.println("Time Slot saved: " + slot.getId());

	    session.close();
	}
}
