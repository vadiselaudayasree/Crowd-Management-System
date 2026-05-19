package com.crowdService;

import org.hibernate.SessionFactory;

public interface VenueService {

    void saveVenue(SessionFactory sessionFactory);

    void getVenue(SessionFactory sessionFactory);

    void getAllVenues(SessionFactory sessionFactory);

    void updateVenue(SessionFactory sessionFactory);

    void deleteVenue(SessionFactory sessionFactory);
}
