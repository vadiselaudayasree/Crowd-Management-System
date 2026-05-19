package com.crowdService;

import org.hibernate.SessionFactory;

public interface TimeSlotService {

    void saveTimeSlot(SessionFactory sessionFactory);

    void getTimeSlot(SessionFactory sessionFactory);

    void getAllTimeSlots(SessionFactory sessionFactory);

    void updateTimeSlot(SessionFactory sessionFactory);

    void deleteTimeSlot(SessionFactory sessionFactory);
}
