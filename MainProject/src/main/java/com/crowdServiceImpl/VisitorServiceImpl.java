package com.crowdServiceImpl;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.crowdService.VisitorService;
import com.crowd_Entities.Visitor;
import com.crowd_Exception.VisitorNotFoundException;

public class VisitorServiceImpl
        implements VisitorService {

    Session session;

    Transaction transaction;

    // SAVE
    @Override
    public int saveVisitor(SessionFactory sessionFactory,
                           Visitor visitor) {

        session = sessionFactory.openSession();

        transaction = session.beginTransaction();

        // SET CURRENT DATE
        visitor.setRegisteredOn(LocalDate.now());

        session.persist(visitor);

        transaction.commit();

        session.close();

        System.out.println(
                "Visitor Saved Successfully");

        return 1;
    }

    // GET SINGLE
    @Override
    public Visitor getVisitor(SessionFactory sessionFactory,
                              int id) {

        session = sessionFactory.openSession();

        Visitor visitor =
                session.find(Visitor.class, id);

        if(visitor == null) {

            session.close();

            throw new VisitorNotFoundException(
                    "Visitor ID " + id + " Not Found");
        }

        session.close();

        return visitor;
    }

    // GET ALL
    @Override
    public List<Visitor> getAllVisitors(
            SessionFactory sessionFactory) {

        session = sessionFactory.openSession();

        Query<Visitor> query =
                session.createQuery(
                        "from Visitor",
                        Visitor.class);

        List<Visitor> visitorList =
                query.getResultList();

        session.close();

        return visitorList;
    }

    // UPDATE
    @Override
    public int updateVisitor(SessionFactory sessionFactory,
                             int id,
                             String newName) {

        session = sessionFactory.openSession();

        transaction = session.beginTransaction();

        Visitor visitor =
                session.find(Visitor.class, id);

        if(visitor == null) {

            session.close();

            throw new VisitorNotFoundException(
                    "Visitor ID " + id + " Not Found");
        }

        visitor.setFullName(newName);

        transaction.commit();

        session.close();

        System.out.println(
                "Visitor Updated Successfully");

        return 1;
    }

    // DELETE
    @Override
    public int deleteVisitor(SessionFactory sessionFactory,
                             int id) {

        session = sessionFactory.openSession();

        transaction = session.beginTransaction();

        Visitor visitor =
                session.find(Visitor.class, id);

        if(visitor == null) {

            session.close();

            throw new VisitorNotFoundException(
                    "Visitor ID " + id + " Not Found");
        }

        session.remove(visitor);

        transaction.commit();

        session.close();

        System.out.println(
                "Visitor Deleted Successfully");

        return 1;
    }
}