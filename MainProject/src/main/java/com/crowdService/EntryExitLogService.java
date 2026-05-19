package com.crowdService;

import org.hibernate.SessionFactory;

public interface EntryExitLogService {

    void saveEntryExitLog(SessionFactory sessionFactory);

    void getEntryExitLog(SessionFactory sessionFactory);

    void getAllEntryExitLogs(SessionFactory sessionFactory);

    void updateEntryExitLog(SessionFactory sessionFactory);

    void deleteEntryExitLog(SessionFactory sessionFactory);
}
