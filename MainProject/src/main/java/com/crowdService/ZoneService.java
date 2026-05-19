package com.crowdService;

import org.hibernate.SessionFactory;

public interface ZoneService {

    void saveZone(SessionFactory sessionFactory);

    void getZone(SessionFactory sessionFactory);

    void getAllZones(SessionFactory sessionFactory);

    void updateZone(SessionFactory sessionFactory);

    void deleteZone(SessionFactory sessionFactory);
}
