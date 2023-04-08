package com.example.netwoevents.data.repository;

import android.app.Application;
import androidx.lifecycle.LiveData;
import androidx.room.Room;

import com.example.netwoevents.data.datasource.database.AppDatabase;
import com.example.netwoevents.data.datasource.database.Event;
import com.example.netwoevents.data.datasource.database.EventDao;
import java.util.List;

public class EventRepository  {
    private EventDao eventDao;
    private LiveData<List<Event>> allEvents;

    public EventRepository(Application application) {

        AppDatabase db = AppDatabase.getDatabase(application);
        eventDao = db.eventDao();
        allEvents = eventDao.getAllEvents();
    }
    public LiveData<List<Event>> getAllEvents() {
        return allEvents;
    }
    public void insert(Event event) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            eventDao.insert(event);
        });
    }
}
