package com.example.netwoevents.ui.presentation;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.netwoevents.data.repository.EventRepository;
import com.example.netwoevents.domain.models.Item;
import com.example.netwoevents.ui.presentation.adapter.MyCustomRecyclerViewAdapter;
import com.example.netwoevents.R;
import com.example.netwoevents.domain.usecase.GetEventListUseCase;
import java.util.ArrayList;


public class EventRecyclerFragment extends Fragment {
    private RecyclerView listView;
    private static final String TAG = "List_2";

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EventRepository eventRepository = new EventRepository();
        GetEventListUseCase getEventListUseCase = new GetEventListUseCase(eventRepository);
        ArrayList<Item> items = getEventListUseCase.execute(getContext());

        listView = (RecyclerView) getView().findViewById(R.id.event_recycler_list);
        MyCustomRecyclerViewAdapter adapter = new MyCustomRecyclerViewAdapter(getContext(), items);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        listView.setLayoutManager(layoutManager);
        listView.setAdapter(adapter);

}
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_event_recycler, container, false);
    }
}