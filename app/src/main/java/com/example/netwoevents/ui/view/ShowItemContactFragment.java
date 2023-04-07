package com.example.netwoevents.ui.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.netwoevents.R;


public class ShowItemContactFragment extends Fragment {

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageView imageView = (ImageView) getView().findViewById(R.id.contact_image);
        TextView textView = (TextView) getView().findViewById(R.id.contact_text);

        if (getArguments() != null) {
            String text = getArguments().getString("bundleText");
            int image = getArguments().getInt("bundleImage");

            imageView.setImageResource(image);
            textView.setText(text);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_show_item_contact, container, false);
    }
}