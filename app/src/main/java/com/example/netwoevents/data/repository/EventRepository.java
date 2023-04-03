package com.example.netwoevents.data.repository;

import android.content.Context;

import com.example.netwoevents.R;
import com.example.netwoevents.data.datasource.GetEventFromFile;
import com.example.netwoevents.domain.models.Item;
import com.example.netwoevents.domain.repository.EventRepositoryInterface;

import java.io.IOException;
import java.util.ArrayList;

public class EventRepository implements EventRepositoryInterface {


    public ArrayList<Item> getEventList (Context context){
        ArrayList<Integer> image = new ArrayList<>();
        ArrayList<Integer> image200 = new ArrayList<>();
        image.add(R.drawable.e1);
        image.add(R.drawable.e2);
        image.add(R.drawable.e3);
        image.add(R.drawable.e4);
        image.add(R.drawable.e5);
        image.add(R.drawable.e6);
        image.add(R.drawable.e7);
        image.add(R.drawable.e8);
        image.add(R.drawable.e9);
        image.add(R.drawable.e10);

        for (int i = 0; i<20; i++){
            image200.addAll(image);
        }

        GetEventFromFile ds = new GetEventFromFile();

        String [] namesContact ;
        try {
            namesContact = ds.getStringFromAssetFile(context).toArray(new String[ds.getStringFromAssetFile(context).size()]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        ArrayList<Item> items= new ArrayList<>();
        for (int i = 0; i < 200; i++){
            Item item = new Item(image200.get(i),namesContact[i]);
            items.add(item);

        }
        return  items;

    }
}
