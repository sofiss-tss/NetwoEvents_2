package com.example.netwoevents;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


public class LoginFragment extends Fragment {
    private Button btn1;
    private static final String F2 = "Fragment_2";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Log.d(F2, "onCreateView");
        Toast.makeText(getActivity(),
                "onCreateView",
                Toast.LENGTH_LONG).show();

        return inflater.inflate(R.layout.fragment_login, container, false);
    }


    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        Log.d(F2, "onViewCreated");
        Toast.makeText(getActivity(),
                "onViewCreated",
                Toast.LENGTH_LONG).show();

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

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        Log.d(F2,"onAttach" );
        Toast.makeText(getActivity(),
                "onAttach",
                Toast.LENGTH_LONG).show();

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(F2,"onCreate" );
        Toast.makeText(getActivity(),
                "onCreate",
                Toast.LENGTH_LONG).show();
    }


    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);

        Log.d(F2,"onViewStateRestored" );
        Toast.makeText(getActivity(),
                "onViewStateRestored",
                Toast.LENGTH_LONG).show();
    }

    @Override
    public void onStart() {
        super.onStart();

        Log.d(F2,"onStart" );
        Toast.makeText(getActivity(),
                " onStart",
                Toast.LENGTH_LONG).show();
    }

    @Override
    public void onResume() {
        super.onResume();

        Log.d(F2,"onResume" );
        Toast.makeText(getActivity(),
                "onResume",
                Toast.LENGTH_LONG).show();
    }

    @Override
    public void onPause() {
        super.onPause();

        Log.d(F2,"onPause" );
        Toast.makeText(getActivity(),
                "onPause",
                Toast.LENGTH_LONG).show();
    }

    @Override
    public void onStop() {
        super.onStop();

        Log.d(F2,"onStop" );
        Toast.makeText(getActivity(),
                "onStop",
                Toast.LENGTH_LONG).show();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        Log.d(F2,"onSaveInstanceState" );
        Toast.makeText(getActivity(),
                "onSaveInstanceStated",
                Toast.LENGTH_LONG).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        Log.d(F2,"onDestroyView" );
        Toast.makeText(getActivity(),
                "onDestroyView",
                Toast.LENGTH_LONG).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Log.d(F2,"onDestroy" );
        Toast.makeText(getActivity(),
                "onDestroy",
                Toast.LENGTH_LONG).show();
    }

    @Override
    public void onDetach() {
        super.onDetach();

        Log.d(F2,"onDetach" );
        Toast.makeText(getActivity(),
                "onDetach",
                Toast.LENGTH_LONG).show();
    }

}