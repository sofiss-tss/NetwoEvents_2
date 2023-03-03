package com.example.netwoevents;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


public class LoginFragment extends Fragment {
    private Button btn1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }


    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        btn1 =  (Button) getView().findViewById(R.id.button_home);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HomeFragment homeFragment = new HomeFragment();
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.frame_layout, homeFragment);
                ft.addToBackStack(null);
                ft.commit();
            }
        });
    }

}