package com.example.netwoevents;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ContactListFtagment extends Fragment {

    private ListView listView;
    private static final String TAG = "List_1";

    public ArrayList<String> getStringFromAssetFile(Context context) throws IOException
    {
        ArrayList<String> arr = new ArrayList<>();
        try {
            String line;
            AssetManager assetManager = context.getAssets();
            InputStreamReader istream = new InputStreamReader(assetManager.open("names.txt"));
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

        String [] namesContact ;
        try {
            namesContact = getStringFromAssetFile(getContext()).toArray(new
                    String[getStringFromAssetFile(getContext()).size()]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ArrayList<Item> items= new ArrayList<>();
        for (int i = 0; i < 200; i++){
            Item item = new Item(image200.get(i),namesContact[i]);
            items.add(item);
        }


        listView = (ListView) getView().findViewById(R.id.contact_list);
        MyCustomListAdapter adapter = new MyCustomListAdapter(getContext(),
                R.layout.list_view_layout, items);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                TextView textView = (TextView)v.findViewById(R.id.item_text);
                String value = (String) textView .getText();
                Toast.makeText(getActivity(),
                        "Здравствуйте, " + value +"!",
                        Toast.LENGTH_SHORT).show();
                Log.i(TAG,"Вход: "+ value);

            }
        });


//        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), R.layout.list_view_layout,R.id.item_text,namesContact);

    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_contact_list, container, false);
    }
}