package com.example.netwoevents.ui.view;

import android.media.Image;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.netwoevents.R;
import com.example.netwoevents.ui.viewmodel.ContactViewModel;
import com.example.netwoevents.ui.viewmodel.HomeViewModel;


public class ShowItemContactFragment extends Fragment {

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageView imageView = (ImageView) getView().findViewById(R.id.contact_image);
        TextView textView = (TextView) getView().findViewById(R.id.contact_text);


        ContactViewModel contactViewModel = new ViewModelProvider(this).get(ContactViewModel.class);
        contactViewModel.getResultLiveName().observe(getViewLifecycleOwner(),resultLiveName ->{

            textView.setText((String) resultLiveName);

        });

        contactViewModel.getResultLiveImage().observe(getViewLifecycleOwner(),resultLiveImage ->{

            imageView.setImageResource((int)resultLiveImage);

        });

      contactViewModel.getDataFromContactList(getArguments());

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_show_item_contact, container, false);
    }
}