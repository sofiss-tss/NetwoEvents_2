package com.example.netwoevents;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class EventRecyclerFragment extends Fragment {
    private RecyclerView listView;
    private static final String TAG = "MyTag";


    public ArrayList<String> getStringFromAssetFile(Context context) throws IOException
    {
        ArrayList<String> arr = new ArrayList<>();
        try {
            String line;
            AssetManager assetManager = context.getAssets();
            InputStreamReader istream = new InputStreamReader(assetManager.open("events.txt"));
            BufferedReader in = new BufferedReader(istream);
            while ((line = in.readLine()) != null){
                arr.add(line);
            }
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return arr;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

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

        String [] namesContact ;
        try {
            namesContact = getStringFromAssetFile(getContext()).toArray(new String[getStringFromAssetFile(getContext()).size()]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        ArrayList<Item> items= new ArrayList<>();
        for (int i = 0; i < 200; i++){
            Item item = new Item(image200.get(i),namesContact[i]);
            items.add(item);

        }


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