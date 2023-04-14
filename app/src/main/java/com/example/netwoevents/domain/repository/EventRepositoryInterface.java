package com.example.netwoevents.domain.repository;

import com.example.netwoevents.data.datasource.models.Item;

import java.util.ArrayList;

public interface EventRepositoryInterface {

    ArrayList<Item> getEventList ();
}
