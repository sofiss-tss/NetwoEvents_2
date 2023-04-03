package com.example.netwoevents.domain.repository;

import android.content.Context;

import com.example.netwoevents.domain.models.Item;

import java.util.ArrayList;

public interface EventRepositoryInterface {

    ArrayList<Item> getEventList (Context context);
}
