package com.example.netwoevents.domain.usecase;

import com.example.netwoevents.domain.models.Item;
import com.example.netwoevents.domain.repository.EventRepositoryInterface;
import java.util.ArrayList;

public class GetEventListUseCase {

    EventRepositoryInterface er;


    public GetEventListUseCase(EventRepositoryInterface er) {
        this.er = er;
    }

    public ArrayList<Item> execute(){
       return er.getEventList();
    }
}
