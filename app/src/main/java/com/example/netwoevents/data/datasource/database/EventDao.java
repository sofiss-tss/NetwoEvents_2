package com.example.netwoevents.data.datasource.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface EventDao {
    @Insert
    void insert(Event event);

    @Query("SELECT * FROM events")
    LiveData<List<Event>> getAllEvents();

    @Query("SELECT * FROM events WHERE id = :id")
    Event getEventById(int id);

    @Query("DELETE FROM events")
    void deleteAll();
}
