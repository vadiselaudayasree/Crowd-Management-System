package com.crowd_Test;

import static org.mockito.Mockito.when;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.crowdServiceImpl.VisitorServiceImpl;
import com.crowd_Entities.Visitor;


public class VisitorServiceImplTest {

    @Mock
    SessionFactory mockSessionFactory;

    @Mock
    Session session;

    @Mock
    Transaction transaction;

    @InjectMocks
    VisitorServiceImpl visitorService;

    public VisitorServiceImplTest() {

        MockitoAnnotations.openMocks(this);
    }

    // DELETE TEST
    @Test
    void deleteVisitorTest() {

        Visitor visitor = new Visitor();

        visitor.setId(1);
        visitor.setFullName("Udaya");

        when(mockSessionFactory.openSession()).thenReturn(session);

        when(session.beginTransaction()).thenReturn(transaction);

        when(session.find(Visitor.class, 1)).thenReturn(visitor);

        int result =
                visitorService.deleteVisitor(mockSessionFactory, 1);

        Assertions.assertEquals(1, result);
    }

    @Test
    void getVisitorTest() {

        Visitor visitor = new Visitor();

        visitor.setId(1);
        visitor.setFullName("Test User");

        when(mockSessionFactory.openSession()).thenReturn(session);

        when(session.find(Visitor.class, 1)).thenReturn(visitor);

        Visitor result =
                visitorService.getVisitor(mockSessionFactory, 1);

        Assertions.assertNotNull(result);

        Assertions.assertEquals("Test User",
                result.getFullName());
    }
}