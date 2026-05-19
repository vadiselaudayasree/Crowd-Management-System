package com.crowd_Test;

import static org.junit.jupiter.api.Assertions.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;

import com.crowd_Entities.*;

public class ZoneTest {

	SessionFactory sf = Config.getSessionFactory();

	@Test
	void testSaveZone() {

	    Session session = sf.openSession();
	    session.beginTransaction();

	    // FIRST create venue
	    Venue venue = new Venue();
	    venue.setName("Zone Venue");
	    venue.setLocation("City");
	    venue.setContactInfo("999");
	    venue.setTotalCapacity(500);
	   // venue.setVenueType("Mall");

	    session.persist(venue);

	    // THEN create zone
	    Zone z = new Zone();
	    z.setVenue(venue);
	    z.setZoneName("Main Hall");
	    z.setMaxCapacity(1000);
	    z.setCurrentCount(0);
	    //z.setZoneType("VIP");

	    session.persist(z);

	    session.getTransaction().commit();

	    assertNotNull(z.getId());

	    System.out.println("Zone saved: " + z.getId());

	    session.close();
	}
}