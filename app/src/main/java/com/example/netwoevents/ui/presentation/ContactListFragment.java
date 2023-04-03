package com.example.netwoevents.ui.presentation;

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

import com.example.netwoevents.data.repository.ContactRepository;
import com.example.netwoevents.data.repository.UserRepository;
import com.example.netwoevents.domain.models.Item;
import com.example.netwoevents.domain.adapter.MyCustomListAdapter;
import com.example.netwoevents.R;
import com.example.netwoevents.domain.repository.UserRepositoryInterface;
import com.example.netwoevents.domain.usecase.GetContactListUseCase;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ContactListFragment extends Fragment {

    private ListView listView;
    private static final String TAG = "List_1";

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ContactRepository contactRepository = new ContactRepository();
        GetContactListUseCase getContactListUseCase = new GetContactListUseCase(contactRepository);
        ArrayList<Item> items = getContactListUseCase.execute(getContext());

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

            }
        });
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_contact_list, container, false);
    }
}