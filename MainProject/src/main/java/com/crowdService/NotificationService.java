package com.crowdService;

import org.hibernate.SessionFactory;

public interface NotificationService {

    void saveNotification(SessionFactory sessionFactory);

    void getNotification(SessionFactory sessionFactory);

    void getAllNotifications(SessionFactory sessionFactory);

    void updateNotification(SessionFactory sessionFactory);

    void deleteNotification(SessionFactory sessionFactory);
}
