package com.example.netwoevents.data.repository;

import android.content.Context;

import com.example.netwoevents.data.datasource.contact.GetContactFromFile;
import com.example.netwoevents.domain.models.Item;
import com.example.netwoevents.domain.repository.ContactRepositoryInterface;

import java.util.ArrayList;

public class ContactRepository implements ContactRepositoryInterface {

    private Context context;
    private ArrayList<Item> items ;

    public ContactRepository(Context context) {
        this.context = context;
    }


    public ArrayList<Item> getContactList (){


        GetContactFromFile getContactFromFile = new GetContactFromFile(context);
        items = getContactFromFile.getItemContact();
        return items;
    }
}
