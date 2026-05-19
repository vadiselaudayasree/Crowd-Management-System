package com.crowdService;

import org.hibernate.SessionFactory;

public interface IncidentService {

    void saveIncident(SessionFactory sessionFactory);

    void getIncident(SessionFactory sessionFactory);

    void getAllIncidents(SessionFactory sessionFactory);

    void updateIncident(SessionFactory sessionFactory);

    void deleteIncident(SessionFactory sessionFactory);
}
