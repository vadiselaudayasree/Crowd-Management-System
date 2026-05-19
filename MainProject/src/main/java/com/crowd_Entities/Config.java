package com.crowd_Entities;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Config {

    private static SessionFactory sessionFactory;

    static {
        // No try-catch, direct initialization
        sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
