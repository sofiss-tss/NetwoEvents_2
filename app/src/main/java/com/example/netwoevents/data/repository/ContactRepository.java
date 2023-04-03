package com.example.netwoevents.data.repository;

import android.content.Context;

import com.example.netwoevents.R;
import com.example.netwoevents.data.datasource.GetContactFromFile;
import com.example.netwoevents.domain.models.Item;
import com.example.netwoevents.domain.repository.ContactRepositoryInterface;

import java.io.IOException;
import java.util.ArrayList;

public class ContactRepository implements ContactRepositoryInterface {

    public ArrayList<Item> getContactList (Context context){
        ArrayList<Integer> image = new ArrayList<>();
        ArrayList<Integer> image200 = new ArrayList<>();

        image.add(R.drawable.a);
        image.add(R.drawable.b);
        image.add(R.drawable.c);
        image.add(R.drawable.d);
        image.add(R.drawable.e);
        image.add(R.drawable.f);
        image.add(R.drawable.g);
        image.add(R.drawable.h);
        image.add(R.drawable.i);
        image.add(R.drawable.k);

        for (int i = 0; i<20; i++){
            image200.addAll(image);
        }

        GetContactFromFile ds = new GetContactFromFile();

        String [] namesContact ;
        try {
            namesContact = ds.getStringFromAssetFile(context).toArray(new
                    String[ds.getStringFromAssetFile(context).size()]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ArrayList<Item> items= new ArrayList<>();
        for (int i = 0; i < 200; i++){
            Item item = new Item(image200.get(i),namesContact[i]);
            items.add(item);
        }

        return items;

    }
}
