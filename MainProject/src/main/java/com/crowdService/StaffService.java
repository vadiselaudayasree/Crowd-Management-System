package com.crowdService;

import org.hibernate.SessionFactory;

public interface StaffService {

    void saveStaff(SessionFactory sessionFactory);

    void getStaff(SessionFactory sessionFactory);

    void getAllStaff(SessionFactory sessionFactory);

    void updateStaff(SessionFactory sessionFactory);

    void deleteStaff(SessionFactory sessionFactory);
}