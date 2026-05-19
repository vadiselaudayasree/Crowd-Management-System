package com.crowd_Test;

import static org.junit.jupiter.api.Assertions.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;

import com.crowd_Entities.Config;
import com.crowd_Entities.Venue;

public class VenueTest {

	SessionFactory sf = Config.getSessionFactory();

	@Test
	void testSaveVenue() {

	    Session session = sf.openSession();
	    session.beginTransaction();

	    Venue v = new Venue();
	    v.setName("Test Venue");
	    v.setLocation("Tirupathi");
	    v.setContactInfo("8309765468");
	    v.setTotalCapacity(100);
	    //v.setVenueType("Temple");

	    session.persist(v);
	    session.getTransaction().commit();

	    assertNotNull(v.getId());

	    System.out.println("Venue saved: " + v.getId());

	    session.close();
	}
	}