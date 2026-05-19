package com.crowdService;

import org.hibernate.SessionFactory;

public interface CrowdAnalyticsService {

    void saveCrowdAnalytics(SessionFactory sessionFactory);

    void getCrowdAnalytics(SessionFactory sessionFactory);

    void getAllCrowdAnalytics(SessionFactory sessionFactory);

    void updateCrowdAnalytics(SessionFactory sessionFactory);

    void deleteCrowdAnalytics(SessionFactory sessionFactory);
}