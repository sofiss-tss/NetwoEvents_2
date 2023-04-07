package com.example.netwoevents.data.repository;

import android.content.Context;

import com.example.netwoevents.R;
import com.example.netwoevents.data.datasource.GetContactFromFile;
import com.example.netwoevents.data.datasource.GetEventFromFile;
import com.example.netwoevents.domain.models.Item;
import com.example.netwoevents.domain.repository.EventRepositoryInterface;

import java.io.IOException;
import java.util.ArrayList;

public class EventRepository implements EventRepositoryInterface {

    private Context context;
    private ArrayList<Item> items ;

    public EventRepository(Context context) {
        this.context = context;
    }


    @Override
    public ArrayList<Item> getEventList() {

       GetEventFromFile getEventFromFile = new GetEventFromFile(context);
       items = getEventFromFile.getItemEvent();
       return items;

    }
}
