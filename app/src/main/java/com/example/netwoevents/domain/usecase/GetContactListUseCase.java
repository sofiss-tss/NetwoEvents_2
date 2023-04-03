package com.example.netwoevents.domain.usecase;

import android.content.Context;
import com.example.netwoevents.domain.models.Item;
import com.example.netwoevents.domain.repository.ContactRepositoryInterface;

import java.util.ArrayList;

public class GetContactListUseCase {
    ContactRepositoryInterface cr;

    public GetContactListUseCase(ContactRepositoryInterface cr) {
        this.cr = cr;
    }

    public ArrayList<Item> execute(Context context){
        return cr.getContactList(context);
    }


}
