package com.crowd_Test;

import static org.junit.jupiter.api.Assertions.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;

import com.crowd_Entities.Config;
import com.crowd_Entities.Visitor;

public class VisitorTest {

	SessionFactory sf = Config.getSessionFactory();

	@Test
	void testSaveVisitor() {

	    Session session = sf.openSession();
	    session.beginTransaction();

	    Visitor v = new Visitor();

	    v.setFullName("Test User");
	    v.setEmail("test" + System.currentTimeMillis() + "@gmail.com");
	    v.setPhone("9999999999");
	    v.setIdProofType("Aadhaar");
	    v.setIdProofNumber(String.valueOf(System.currentTimeMillis()));

	    session.persist(v);
	    session.getTransaction().commit();

	    assertNotNull(v.getId());

	    System.out.println("Visitor saved: " + v.getId());

	    session.close();
	}
	}