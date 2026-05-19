package com.crowdService;

import java.util.List;

import org.hibernate.SessionFactory;

import com.crowd_Entities.Visitor;

public interface VisitorService {

    // SAVE
    int saveVisitor(SessionFactory sessionFactory,
                    Visitor visitor);

    // GET SINGLE
    Visitor getVisitor(SessionFactory sessionFactory,
                       int id);

    // GET ALL
    List<Visitor> getAllVisitors(
            SessionFactory sessionFactory);

    // UPDATE
    int updateVisitor(SessionFactory sessionFactory,
                      int id,
                      String newName);

    // DELETE
    int deleteVisitor(SessionFactory sessionFactory,
                      int id);
}